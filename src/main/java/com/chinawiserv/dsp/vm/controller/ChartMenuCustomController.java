package com.chinawiserv.dsp.vm.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.vm.entity.vo.ChartMenuCustomVo;
import com.chinawiserv.dsp.vm.service.IChartMenuCustomService;

/**
 * <p>
 * 图表与菜单自定义关系 前端控制器
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@Controller
@RequestMapping("/chartMenuCustom")
// todo 将所有的XXX修改为真实值
public class ChartMenuCustomController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IChartMenuCustomService service;

	// @RequiresPermissions("XXX:XXX:list")
	@RequestMapping("/index")
	public String init(@RequestParam Map<String, Object> paramMap) {
		setCurrentMenuInfo(paramMap);
		return "vm/indexForCharTemplet";
	}

	/**
	 * 分页查询图表与菜单自定义关系
	 */
	@RequiresPermissions("XXX:XXX:list")
	@RequestMapping("/list")
	@ResponseBody
	public PageResult list(@RequestParam Map<String, Object> paramMap) {
		PageResult pageResult = new PageResult();
		try {
			Page<ChartMenuCustomVo> page = service.selectVoPage(paramMap);
			pageResult.setPage(page);
		} catch (Exception e) {
			pageResult.error("分页查询图表与菜单自定义关系出错");
			logger.error("分页查询图表与菜单自定义关系出错", e);
		}
		return pageResult;
	}

	/**
	 * 新增图表与菜单自定义关系
	 */
	@RequiresPermissions("XXX:XXX:add")
	@RequestMapping("/add")
	public String add() {
		return "XXX/XXX/XXXAdd";
	}

	/**
	 * 执行新增
	 */
	@RequiresPermissions("XXX:XXX:add")
	@Log("创建图表与菜单自定义关系")
	@RequestMapping("/doAdd")
	@ResponseBody
	public HandleResult doAdd(ChartMenuCustomVo entity) {
		HandleResult handleResult = new HandleResult();
		try {
			service.insertVO(entity);
			handleResult.success("创建图表与菜单自定义关系成功");
		} catch (Exception e) {
			handleResult.error("创建图表与菜单自定义关系失败");
			logger.error("创建图表与菜单自定义关系失败", e);
		}
		return handleResult;
	}

	/**
	 * 删除图表与菜单自定义关系
	 */
	@RequiresPermissions("XXX:XXX:delete")
	@Log("删除图表与菜单自定义关系")
	@RequestMapping("/delete")
	@ResponseBody
	public HandleResult delete(@RequestParam String id) {
		// todo 逻辑删除
		// service.deleteById(id);
		return new HandleResult().success("删除图表与菜单自定义关系成功");
	}

	/**
	 * 编辑图表与菜单自定义关系
	 */
	@RequiresPermissions("XXX:XXX:edit")
	@RequestMapping("/edit")
	public String edit(@RequestParam String id, Model model) {
		model.addAttribute("id", id);
		return "XXX/XXX/XXXEdit";
	}

	@RequiresPermissions("XXX:XXX:edit")
	@RequestMapping("/editLoad")
	@ResponseBody
	public HandleResult editLoad(@RequestParam String id) {
		HandleResult handleResult = new HandleResult();
		try {
			ChartMenuCustomVo vo = service.selectVoById(id);
			handleResult.put("vo", vo);
		} catch (Exception e) {
			handleResult.error("获取图表与菜单自定义关系信息失败");
			logger.error("获取图表与菜单自定义关系信息失败", e);
		}
		return handleResult;
	}

	/**
	 * 执行编辑
	 */
	@RequiresPermissions("XXX:XXX:edit")
	@Log("编辑图表与菜单自定义关系")
	@RequestMapping("/doEdit")
	@ResponseBody
	public HandleResult doEdit(ChartMenuCustomVo entity, Model model) {
		HandleResult handleResult = new HandleResult();
		try {
			service.updateVO(entity);
			handleResult.success("编辑图表与菜单自定义关系成功");
		} catch (Exception e) {
			handleResult.error("编辑图表与菜单自定义关系失败");
			logger.error("编辑图表与菜单自定义关系失败", e);
		}
		return handleResult;
	}
}
