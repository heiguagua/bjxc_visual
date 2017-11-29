package com.chinawiserv.dsp.dir.controller.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.dir.service.sys.ISysDeptSynService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 组织同步到目录，非公共模块
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/deptSyn")
public class SysDeptSynController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysDeptSynService sysDeptSynService;


    @RequiresPermissions("system:deptSyn:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "dir/sys/deptSyn/deptSynList";
    }


    /**
     * 分页查询组织机构
     */
    @RequiresPermissions("system:deptSyn:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            paramMap.put("excludeRoot", "1");
            Page<SysDeptVo> page = sysDeptSynService.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询组织机构出错");
            logger.error("分页查询组织机构出错", e);
        }
        return pageResult;
    }


    /**
     * 同步组织机构到目录
     */
    @RequiresPermissions("system:deptSyn:list")
    @Log("同步组织机构到目录")
    @RequestMapping("/doSycn")
    @ResponseBody
    public  HandleResult doSycn(@RequestParam String dcmIds){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String,Object> params = new HashMap<>();
            params.put("dcmIds",dcmIds);
            
/*          params.put("publishType", Dataset.PublishType.ToAll.getKey());*/
            String releaseResult = sysDeptSynService.insertIntoDir(params);
            if(releaseResult.equals("0")){
            	handleResult.success("同步完成,但存在已同步部门,请重新选择");            
            }else if(releaseResult.equals("1")) {
            	handleResult.success("同步完成,但存在没有对应区域目录部门库分类部门，无法同步到目录");
            }else if(releaseResult.equals("2")) {
            	handleResult.success("同步完成,但存在父级未同步部门，无法同步到目录");
            }else if(releaseResult.equals("3")) {
            	handleResult.success("同步完成,但存在不能同步部委到目录");
            }else if(releaseResult.equals("4")) {
            	 handleResult.success("同步成功");
            }
        } catch (Exception e) {
            handleResult.error("部门同步到目录失败");
            logger.error("部门同步到目录失败", e);
        }
        return handleResult;
    }
    
    
    




}
