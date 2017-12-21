package com.chinawiserv.dsp.dir.service.catalog;

import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetAttachment;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetAttachmentVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tx
 * @since 2017-11-28
 */
public interface IDirDatasetAttachmentService extends ICommonService<DirDatasetAttachment, DirDatasetAttachmentVo> {
	boolean batchInsertVo(List<DirDatasetAttachmentVo> voList) throws Exception;
}
