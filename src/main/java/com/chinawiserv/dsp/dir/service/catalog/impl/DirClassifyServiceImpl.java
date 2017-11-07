package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirNationalClassify;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirNationalClassifyVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyAuthorityMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirNationalClassifyMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Striped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.locks.Lock;


/**
 * <p>
 * 目录分类表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirClassifyServiceImpl extends CommonServiceImpl<DirClassifyMapper, DirClassify , DirClassifyVo> implements IDirClassifyService {

    @Autowired
    private DirClassifyMapper mapper;
    
    @Autowired
    private DirNationalClassifyMapper mapper2;

    @Autowired
    private ISysRegionService sysRegionService;

    @Autowired
    private DirClassifyAuthorityMapper authorityMapper;

    private Striped<Lock> locks = Striped.lazyWeakLock(100);


    @Override
    public boolean insertVO(DirClassifyVo vo) throws Exception {
    	
    	mapper.baseInsert(this.prepareClassifyVo(vo));    	
		return true;
    }
    
    @Override
    public DirClassifyVo prepareClassifyVo(DirClassifyVo vo){
    	
    	vo.setId(CommonUtil.get32UUID());
    	vo.setCreateTime(new Date());
    	String loginUserId = ShiroUtils.getLoginUserId();
    	vo.setCreateUserId(loginUserId);
    	vo.setDeleteFlag(0);
    	vo.setClassifyIndex(0);
    	vo.setDcmIndex(0);
    	DirClassify fclassify = mapper.selectFclassify(vo.getFid());
    	String fclassifyStructureName = fclassify.getClassifyStructureName();
    	String fcode = fclassify.getClassifyCode();
    	String regionCode = fclassify.getRegionCode();
//    	String fid = fclassify.getId();
    	String ftreecode = fclassify.getTreeCode();
    	String Ftype = fclassify.getClassifyType();
    	
    	if(Ftype.equals("2-1") || Ftype.equals("5")){
  			vo.setClassifyType("5");
  		}else if(Ftype.equals("2-2") || Ftype.equals("6")){
  			vo.setClassifyType("6");	
  		}else if(Ftype.equals("3") || Ftype.equals("7")){
  			vo.setClassifyType("7");
  		}
    	
    	int flevel = fclassify.getClassifyLevel();
    	int fclassifyIndex = 0;
    	if(mapper.selectMaxIndexByFcode(fclassify.getId())!=null){
    		 fclassifyIndex = (int) mapper.selectMaxIndexByFcode(fclassify.getId()); 
    	}else{
    		
    		 fclassifyIndex = 0;
    	}
    	int level = flevel+1;
    	
    	if(!vo.getFid().equals("root")){
    		
    	if(level == 2){
    		 vo.setClassifyLevel(2);
    		 if(fclassifyIndex<9){
    			 
    			vo.setClassifyCode(fcode.substring(0,1)+0+(fclassifyIndex+1));
    			vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			vo.setClassifyIndex(fclassifyIndex+1);
    			vo.setRegionCode(regionCode);
    			
    		 }else{
    			 
    			vo.setClassifyCode(fcode.substring(0,1)+(fclassifyIndex+1));
    			vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			vo.setClassifyIndex(fclassifyIndex+1);
    			vo.setRegionCode(regionCode);
    			
    		 }
    		 
    		  
    	}else if(level >= 3 ){
    		vo.setClassifyLevel(flevel+1);
    		if(fclassifyIndex<9){
   			 
    			vo.setClassifyCode(fcode+0+0+(fclassifyIndex+1));
    			vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			vo.setClassifyIndex(fclassifyIndex+1);
    			vo.setRegionCode(regionCode);
    			
    		 }else if(fclassifyIndex < 99 && fclassifyIndex >= 9 ){
    			 
    			 vo.setClassifyCode(fcode+0+(fclassifyIndex+1));
    			 vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			 vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			 mapper.updateClassifyIndexbyFid(vo.getFid());
    			 vo.setClassifyIndex(fclassifyIndex+1);
    			 vo.setRegionCode(regionCode);
    			 
    		 }
    		 else{
    			 
    			vo.setClassifyLevel(flevel+1); 
    			vo.setClassifyCode(fcode+(fclassifyIndex+1));
    			vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			vo.setClassifyIndex(fclassifyIndex+1);
    			vo.setRegionCode(regionCode);
    			   			
    		 }
    		
    	}
    			
    	}else{
    		
    		vo.setClassifyLevel(1);
    		vo.setClassifyStructureName(vo.getClassifyName());
    		vo.setClassifyCode(""+(mapper.selectCountLevel1()+1));
    		vo.setTreeCode(""+(mapper.selectCountLevel1()+1));
    		vo.setClassifyIndex((int)mapper.selectMaxIndexByFcode("root")+1);
    		vo.setRegionCode(regionCode);
    		
    	}
    	
		return vo;
    	
    }

    @Override
    public boolean updateVO(DirClassifyVo vo) throws Exception {
    	vo.setUpdateTime(new Date());
    	String loginUserId = ShiroUtils.getLoginUserId();
    	vo.setUpdateUserId(loginUserId);
    	mapper.baseUpdate(vo);
    	return true;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}
    
	@Override
	public void DeleteByFlag(String id) {
		mapper.updateDeleteFlag(id);
		
	}

    @Override
    public DirClassifyVo selectVoById(String id) throws Exception {
//    	DirClassifyVo s = mapper.selectVoById(id);
		return mapper.selectVoById(id);
	}

    @Override
    public Page<DirClassifyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public List<DirClassifyVo> selectVoList(Map<String, Object> paramMap) throws Exception {
    	
//    	List<String> listClassifyIds  = getFdir_codes((String)paramMap.get("dir_code"));
//    	paramMap.put("listClassifyIds", listClassifyIds);
    	return mapper.selectVoListForTreeData(paramMap);
    	
    }

    @Override
    public List<DirClassifyVo> selectSubVoList(Map<String, Object> paramMap) throws Exception {
        String userId = ShiroUtils.getLoginUserId();
        //获取当前登录用户的最大权限角色(-1：超级管理员,0:区域管理员)
        int minRoleLevl  = ShiroUtils.getLoginUser().getMinRoleLevel();
        //非超管和区域管理员，则要做权限过滤
        if(minRoleLevl>0){
            //查询有权限的目录分类
            String chooseClassifyTreeCode = (String) paramMap.get("treeCode");
            String authorityNode = (String) paramMap.get("authorityNode");
            List<String> authorityClassifyTreeCodeList = authorityMapper.selectAuthorityIdForLoginUser(userId);
            if(!ObjectUtils.isEmpty(authorityClassifyTreeCodeList)){
                if(!StringUtils.isEmpty(chooseClassifyTreeCode)){ //第一层节点不用过滤
                    if("n".equals(authorityNode)){ //如果是n，表示未明确是否是授权或授权下级节点，需要去验证是否授权节点
                        boolean hasThisNodeAuthority = false;
                        for(String authorityClassifyTreeCode : authorityClassifyTreeCodeList){
                            if(chooseClassifyTreeCode.equals(authorityClassifyTreeCode)){
                                hasThisNodeAuthority = true;
                                break;
                            }
                        }
                        if(hasThisNodeAuthority){ //如果该点击节点被授权了，则后面所有节点都可以显示
                            paramMap.put("authorityNode","y");
                        }else{ //如果该节点没有授权,则下级节点只是去验证是否在授权节点的父级节点路线上
                            Map<String,String> parentCodesMap = new HashMap<>();
                            for(String treeCode : authorityClassifyTreeCodeList){
                                getAllParentTreecodes(treeCode, parentCodesMap);
                            }
                            Set<String> keySet = parentCodesMap.keySet();
                            StringBuffer parentCodesBuffer = new StringBuffer();
                            for(String code : keySet){
                                parentCodesBuffer.append("'").append(code).append("',");
                            }
                            String allParentTreeCodes = parentCodesBuffer.toString();
                            if(!StringUtils.isEmpty(allParentTreeCodes)){
                                allParentTreeCodes = allParentTreeCodes.substring(0,allParentTreeCodes.length()-1);
                            }
                            paramMap.put("allParentTreeCodes",allParentTreeCodes);
                            paramMap.put("authorityNode","n");
                        }
                    }else{ //该点击节点被授权了，后面所有节点都可以显示
                        paramMap.put("authorityNode","y");
                    }
                }else{
                    paramMap.put("authorityNode","n");
                }
            }else{
                return null;
            }
        }
        return mapper.selectSubVoListForTreeData(paramMap);
    }

    /**
     * 解析某个节点的treecode的，得到其所有父级节点,最终用于拼成一个可供sql直接查询的字符串
     * @param treeCode
     * @return
     */
    private static void getAllParentTreecodes(String treeCode,Map<String,String> parentCodesMap){
        if(!StringUtils.isEmpty(treeCode) && treeCode.indexOf(";")!=-1){
            if(!parentCodesMap.containsKey(treeCode)){
                parentCodesMap.put(treeCode, "1");
            }
            String prentTreeCode = treeCode.substring(0,treeCode.lastIndexOf(";"));
            getAllParentTreecodes(prentTreeCode, parentCodesMap);
        }
    }
    
//    public List<String> getFdir_codes(String dir_code){
//	  	List<String> listfdir = Lists.newArrayList();
//        listfdir.add(dir_code);
//      	 
//      	 if(!(mapper.selectDirectoryByFcode(dir_code).equals("root"))){
//      		      		
//      		listfdir.addAll(getFdir_codes(mapper.selectDirectoryByFcode(dir_code)));      		 
//      		      		 
//      	 }      		
//      	return listfdir;
//      }
    
    //批量插入
    @Override
    public void insertbatchNational(DirClassifyVo vo) throws Exception{
    	
    	String fid = vo.getFid();   
    	String type = vo.getClassifyType();
    	List<DirNationalClassifyVo>  listClassifies = mapper2.selectSonClassify(vo.getNationalCode());
    	if(listClassifies.isEmpty()){
    		
    		throw new Exception("此目录下无可导入内容，请从新选择");
    		
    	}
    	for (Iterator iterator = listClassifies.iterator(); iterator.hasNext();) {
    		
			DirNationalClassifyVo dirNationalClassifyVo = (DirNationalClassifyVo) iterator.next();
			getSClassifies(dirNationalClassifyVo.getClassifyCode(),fid,type);
			
		}
    
    }
    
    
    
    
     public void getSClassifies(String fcode, String fid,String type){
    	
//	  		List<String> listsClassifies = Lists.newArrayList();
//	  	  		
//		  	listsClassifies.add(fcode);
	   
	  		DirNationalClassifyVo dirNationalClassifyVo = mapper2.selectFclassify(fcode);
	  		DirClassifyVo dirclassifyVo = new DirClassifyVo();
	  		
	  		dirclassifyVo.setClassifyName(dirNationalClassifyVo.getClassifyName());
	  		dirclassifyVo.setFid(fid);
	  		
	  		DirClassifyVo vo = prepareClassifyVo(dirclassifyVo);
		  		if(type.equals("2-1") || type.equals("5")){
		  			vo.setClassifyType("5");
		  		}else if(type.equals("2-2") || type.equals("6")){
		  			vo.setClassifyType("6");	
		  		}else if(type.equals("3") || type.equals("7")){
		  			vo.setClassifyType("7");
		  		}
	  		
	  		
	  		mapper.baseInsert(vo);

	  		String pid = vo.getId();
	  		
	  		if(mapper2.selectSonClassify(fcode)!=null){
      		 
	      		 List<DirNationalClassifyVo> list = mapper2.selectSonClassify(fcode); 
	      		 
	      		 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
	      			 
					DirNationalClassifyVo dirNationalClassifyVo2 = (DirNationalClassifyVo) iterator.next();
					getSClassifies(dirNationalClassifyVo2.getClassifyCode(),pid,type);
				 
	      		 }    		 
	      		 
//	      		 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//	      			 
//				 	String string = (String) iterator.next();
//				 	listsClassifies.addAll(getSClassifies(string,pid));
//				 	
//				}      		      		 
      	 }    	
       }


    @Override
    public String generateDatasetCode(String classifyId){
        Lock lock =  locks.get(classifyId);
        lock.lock();
        try{
            int newDcmIndex = 0;
            String datasetCode = null;
            DirClassifyVo classifyVo =  mapper.selectVoById(classifyId);
            String classifyCode = classifyVo.getClassifyCode();
            int dcmIndex = classifyVo.getDcmIndex();
            newDcmIndex = dcmIndex + 1;
            classifyVo.setDcmIndex(newDcmIndex);
            int updateResult = mapper.baseUpdate(classifyVo);
            if(updateResult > 0){
                datasetCode = classifyCode+"/"+newDcmIndex;
            }
            return datasetCode;
        }finally {
            lock.unlock();
        }
    }

}
