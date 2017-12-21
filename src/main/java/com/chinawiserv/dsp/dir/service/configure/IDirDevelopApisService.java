package com.chinawiserv.dsp.dir.service.configure;

import com.chinawiserv.dsp.dir.entity.po.configure.DirDevelopApis;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirDevelopApisVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirHomeVo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 开发者工具 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface IDirDevelopApisService extends ICommonService<DirDevelopApis, DirDevelopApisVo> {
	
	List<DirDevelopApis> getDirApiZtree();
	void DeleteByFlag(String id);
	String fileUpload(DirDevelopApisVo entity, MultipartFile file, HttpServletRequest request) throws Exception;
	String fileUpdate(DirDevelopApisVo entity, MultipartFile file,HttpServletRequest request) throws Exception;

}
