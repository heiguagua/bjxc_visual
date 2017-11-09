package com.chinawiserv.dsp.base.schema;

import com.alibaba.fastjson.JSONObject;
import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.base.service.system.ISysLogService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Created by tangxiong on 2017/11/8.
 */
@Component
public class BaseSynTask extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysUserService sysUserService;

    @Scheduled(cron = "0 0 12 * * ?")  //每天中午12点执行一次
    public void  synDeptTable(){
        if (!isMaster()){
            logger.debug("记录日志:部门同步开启");
            try {
                String result =getDataFromMaster(ISysDeptService.synUrl);
                HandleResult jsb= JSONObject.parseObject(result,HandleResult.class);
                HashMap<String, Object> map= jsb.getContent();
                List<SysDept> list= JSONObject.parseArray(map.get("list").toString(),SysDept.class) ;
                if(sysDeptService.insertOrUpdate(list)){
                    logger.debug("记录日志:同步部门成功");
                }else{
                    logger.error("记录日志:同步部门失败");
                }

            }catch (ErrorInfoException e){
                logger.error(e.getMessage(), e);
            } catch (Exception e) {
                logger.error("获取sys_dept表数据失败", e);
            }
        }else{
            logger.debug("记录日志:部门同步未开启");
        }

    }

    @Scheduled(cron = "0 0 12 * * ?")  //每天中午12点执行一次
    public void  synUserTable(){

        if (!isMaster()){
            logger.debug("记录日志:用户同步开启");
            try {
                String result = getDataFromMaster(ISysUserService.synUrl);
                HandleResult jsb = JSONObject.parseObject(result, HandleResult.class);
                HashMap<String, Object> map = jsb.getContent();
                List<SysUser> list = JSONObject.parseArray(map.get("list").toString(), SysUser.class);
                if (sysUserService.insertOrUpdate(list)) {
                    logger.debug("记录日志:同步用户成功");
                } else {
                    logger.error("记录日志:同步用户失败");
                }
            }catch (ErrorInfoException e){
                logger.error(e.getMessage(), e);
            } catch (Exception e) {
                logger.error("获取sys_user表数据失败", e);
            }
        }else{
            logger.debug("记录日志:用户同步未开启");
        }
    }
}
