package com.chinawiserv.dsp.dir.service.sys.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.mapper.system.SysDeptMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDeptMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDeptMapMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;
import com.chinawiserv.dsp.dir.service.sys.ISysDeptSynService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by tangxiong on 2017/10/31.
 */
@Service
public class SysDeptSynServiceImpl extends CommonServiceImpl<SysDeptMapper, SysDept, SysDeptVo> implements ISysDeptSynService {

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private DirClassifyMapper dirClassifyMapper;


    @Autowired
    private IDirClassifyService dirService;

    @Autowired
    private DirDeptMapMapper dirDeptMapMapper;

    @Override
    public boolean insertVO(SysDeptVo sysDeptVo) throws Exception {
        return false;
    }

    @Override
    public String insertIntoDir(Map<String, Object> params) {
        String Ids = (String) params.get("dcmIds");
        String [] dcmIdArray = Ids.split(",");
        List<String> dcmIds = Arrays.asList(dcmIdArray);

        String messageInfo = "";
        for (Iterator iterator = dcmIds.iterator(); iterator.hasNext();) {

            String dcmId = (String) iterator.next();

            if(dirClassifyMapper.selectMapByDeptId(dcmId)!= null){

                messageInfo= "0";
                break;

            }else if(dirClassifyMapper.selectBy23Region(sysDeptMapper.selectById(dcmId).getRegionCode())==null){

                messageInfo= "1";
                break;

            }else if(dirClassifyMapper.selectMapByDeptId(dirClassifyMapper.selectFidById(dcmId))==null && !dirClassifyMapper.selectFidById(dcmId).equals("root") && !dirClassifyMapper.selectFidById(dirClassifyMapper.selectFidById(dcmId)).equals("root") ){
                messageInfo= "2";
                break;

            }else if(dirClassifyMapper.selectFidById(dcmId).equals("root")){
                messageInfo= "3";
                break;

            }else{
//					dirService.
                String fid = "";
                if(dirClassifyMapper.selectMapByDeptId(dirClassifyMapper.selectFidById(dcmId))!=null){
                    fid = dirClassifyMapper.selectMapByDeptId(dirClassifyMapper.selectFidById(dcmId)).getClassifyId();
                }else{
                    fid = dirClassifyMapper.selectBy3Region(sysDeptMapper.selectById(dcmId).getRegionCode()).getId();
                }
                SysDept sysDept = dirClassifyMapper.selectDeptById(dcmId);
//					DirNationalClassifyVo dirNationalClassifyVo = mapper2.selectFclassify(fcode);
                DirClassifyVo dirclassifyVo = new DirClassifyVo();

                dirclassifyVo.setClassifyName(sysDept.getDeptName());
                dirclassifyVo.setFid(fid);

                DirClassifyVo vo = dirService.prepareClassifyVo(dirclassifyVo);
//				  		if(type.equals("2-1")){
//				  			vo.setClassifyType("5");
//				  		}else if(type.equals("2-2")){
//				  			vo.setClassifyType("6");
//				  		}else if(type.equals("3")){
//				  			vo.setClassifyType("7");
//				  		}
                vo.setClassifyType("7");

                dirClassifyMapper.baseInsert(vo);

                DirDeptMap d = new DirDeptMap();
                d.setClassifyId(vo.getId());
                d.setDeptId(dcmId);
                d.setId(CommonUtil.get32UUID());
                dirDeptMapMapper.baseInsert(d);

                messageInfo = "4";

            }

        }

        return messageInfo;
    }

    @Override
    public boolean updateVO(SysDeptVo sysDeptVo) throws Exception {
        return false;
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public SysDeptVo selectVoById(String id) throws Exception {
        return null;
    }

    @Override
    public Page<SysDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Map<String, Object> param = sysDeptService.getDeptCondition(null);
        if (param != null && !param.isEmpty()) {
            paramMap.putAll(param);
            Page<SysDeptVo> page = getPage(paramMap);
            page.setOrderByField("update_time");
            page.setAsc(false);
            List<SysDeptVo> sysDeptVos = sysDeptMapper.selectSynVoPage(page, paramMap);
            page.setTotal(sysDeptMapper.selectBaseVoCount(paramMap));
            page.setRecords(sysDeptVos);
            return page;
        }
        return getPage(paramMap);
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return 0;
    }
}
