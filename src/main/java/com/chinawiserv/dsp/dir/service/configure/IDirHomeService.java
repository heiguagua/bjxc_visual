package com.chinawiserv.dsp.dir.service.configure;

import com.chinawiserv.dsp.dir.entity.po.configure.DirHome;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirHomeVo;
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
public interface IDirHomeService extends ICommonService<DirHome, DirHomeVo> {
	
	void DeleteByFlag(String id);	
	String fileUpload(DirHomeVo entity, MultipartFile file,HttpServletRequest request) throws Exception;
	void updateStatus(String id,String status);
	String fileUpdate(DirHomeVo entity, MultipartFile file,HttpServletRequest request) throws Exception;
}
