package com.chinawiserv.dsp.dir.service.configure;

import com.chinawiserv.dsp.dir.entity.po.configure.DirNews;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirNewsVo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 新闻表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface IDirNewsService extends ICommonService<DirNews, DirNewsVo> {
	
	void DeleteByFlag(String id);	
	String fileUpload(DirNewsVo entity, MultipartFile file,HttpServletRequest request) throws Exception;
	void updateStatus(String id,String status);
	String fileUpdate(DirNewsVo entity, MultipartFile file,HttpServletRequest request) throws Exception;
}
