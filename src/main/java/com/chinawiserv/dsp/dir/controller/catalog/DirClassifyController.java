package com.chinawiserv.dsp.dir.controller.catalog;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDeptMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDeptMapMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <p>
 * 目录分类表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Controller
@RequestMapping("/dirClassify")
// todo 将所有的XXX修改为真实值
public class DirClassifyController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IDirClassifyService service;
	
	@Autowired
	private DirClassifyMapper mapper;
	
	@Autowired
	private DirDeptMapMapper mapper2;
	
	@Autowired
	private ISysRegionService sysRegionService;
	
//	@RequiresPermissions("XXX:XXX:list")
	@RequestMapping("")
	public String init(@RequestParam Map<String, Object> paramMap) {
		setCurrentMenuInfo(paramMap);
		return "catalog/classify/classifyList";
	}

//	/**
//     * 分页查询开发者工具
//     */
////  @RequiresPermissions("XXX:XXX:list")
//    @RequestMapping("/list")
//    @ResponseBody
//    public JSONObject loadZtree(@RequestParam Map<String , Object> paramMap){
//    	Map<String, Object> params = new HashMap<>();
//    	List<DirClassifyVo> listTree = null;
//    	JSONObject jsonObject = new JSONObject();
//		try {			
//			listTree = service.getClassifyZtree();			
////			actionResponse.setCode(ActionResponseCode.OK);
//            jsonObject.put("data", listTree);
////		    Page<DirDevelopApisVo> page = service.selectVoPage(paramMap);
////		    pageResult.setPage(page);
//		} catch (Exception e) {
////		    pageResult.error("分页查询开发者工具出错");
//		    logger.error("分页查询开发者工具出错", e);
//		}
//		return jsonObject;
//    }

	/**
	 * 新增目录分类表
	 */
//	@RequiresPermissions("XXX:XXX:add")
	@RequestMapping("/add")
	public String add(@RequestParam String fid, Model model) {		 
		model.addAttribute("fid",fid);
		return "catalog/classify/classifyAdd";
	}

	/**
	 * 执行新增
	 */
//	@RequiresPermissions("XXX:XXX:add")
	@Log("创建目录分类表")
	@RequestMapping("/doAdd")
	@ResponseBody
	public HandleResult doAdd(DirClassifyVo entity) {
		HandleResult handleResult = new HandleResult();
		
		try {
			if(!entity.getFid().equals("root")){
				service.insertVO(entity);
				String deptId = entity.getDeptId();
				String classifyId = entity.getId();
				DirDeptMap ddmap = new DirDeptMap();
				ddmap.setClassifyId(classifyId);
				ddmap.setDeptId(deptId);
				ddmap.setId(CommonUtil.get32UUID());
				mapper2.baseInsert(ddmap);
				handleResult.success("创建目录分类表成功");
			}else{
				handleResult.error("无权限添加初始目录类别，请联系管理员");
			}
			
			
		} catch (Exception e) {
			handleResult.error("创建目录分类表失败");
			logger.error("创建目录分类表失败", e);
		}
		return handleResult;
	}
	
	/**
     * 验证ordernumber为数字
     */
    @RequestMapping("/CheckOrderNumber")
    @ResponseBody
    public JSONObject insertCheckName(String orderNumber){
        JSONObject resultJson = new JSONObject();
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");		
		Boolean b = pattern.matcher(orderNumber).matches(); 
        if(!b){
            resultJson.put("error" , "排序号必须为数字，请重新输入" );
        } else {
            resultJson.put("ok" , "");
        }
        return resultJson;
    }

	/**
	 * 删除目录分类表
	 */
//	@RequiresPermissions("XXX:XXX:delete")
	@Log("删除目录分类表")
	@RequestMapping("/delete")
	@ResponseBody
	public HandleResult delete(@RequestParam String id) {
		// todo 逻辑删除
		// service.deleteById(id);
		
    	List<DirClassifyVo> list = null;
    	list = mapper.getCatelogByParentCode(id);
    	if(!list.isEmpty() && list!=null ){
    		return new HandleResult().error("此节点下有子集，无法删除");   
    	}
    	service.DeleteByFlag(id);
    	return new HandleResult().success("删除目录分类表成功");
		
	}

	/**
	 * 编辑目录分类表
	 */
//	@RequiresPermissions("XXX:XXX:edit")
	@RequestMapping("/edit")
	public String edit(@RequestParam String id, Model model) {
		model.addAttribute("id", id);
		return "catalog/classify/classifyEdit";
	}

	// @RequiresPermissions("XXX:XXX:edit")
	@RequestMapping("/editLoad")
	@ResponseBody
	public HandleResult editLoad(@RequestParam String id) {
		HandleResult handleResult = new HandleResult();
		try {
			
			DirClassifyVo vo = service.selectVoById(id);
			handleResult.put("vo", vo);
		} catch (Exception e) {
			handleResult.error("获取目录分类表信息失败");
			logger.error("获取目录分类表信息失败", e);
		}
		return handleResult;
	}

	/**
	 * 执行编辑
	 */
//	@RequiresPermissions("XXX:XXX:edit")
	@Log("编辑目录分类表")
	@RequestMapping("/doEdit")
	@ResponseBody
	public HandleResult doEdit(DirClassifyVo entity, Model model) {
		HandleResult handleResult = new HandleResult();
		try {
			service.updateVO(entity);
			handleResult.success("编辑目录分类表成功");
		} catch (Exception e) {
			handleResult.error("编辑目录分类表失败");
			logger.error("编辑目录分类表失败", e);
		}
		return handleResult;
	}

	/**
	 * 根据登录用户的权限获取目录类别树结构的数据
	 */
	@RequiresPermissions("catalog:classify:list")
	@RequestMapping("/authorityList")
	@ResponseBody
	public HandleResult getClassifyListForLoginUser(@RequestParam Map<String, Object> paramMap) {
		HandleResult handleResult = new HandleResult();
		try {
			String fid = (String) paramMap.get("fid");
			if (StringUtils.isEmpty(fid)) {
				paramMap.put("fid", "root");
			}
//			String regionCode = ShiroUtils.getLoginUser().getRegionCode();
//			List<SysRegionVo> SysRegionVoList = sysRegionService.selectAllRegionByRegionCode(regionCode);
//			paramMap.put("regionCodes", SysRegionVoList);
			List<DirClassifyVo> dirClassifyVoList = service.selectVoList(paramMap);
			handleResult.put("vo", dirClassifyVoList);
		} catch (Exception e) {
			handleResult.error("根据登录用户的权限获取目录分类表信息失败");
			logger.error("根据登录用户的权限获取目录分类表信息失败", e);
		}
		return handleResult;
	}
}
