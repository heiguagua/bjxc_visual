package com.chinawiserv.dsp.dir.schema;

import com.chinawiserv.dsp.base.common.util.DesUtil;
import com.chinawiserv.dsp.base.common.util.Props;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:同步神马用户数据及部门数据
 * Author:GongJun
 * Date:2017/9/22
 * Time:10:42
 * Chinawiserv Technologies Co., Ltd.
 */
@Component
public class SyncUserInfoTaskSchema {

    @Autowired
    private SyncToLoacalService syncToLoacalService;

    private Props props = Props.of("conf/schedule.properties");
    @Scheduled(cron = "0 0/5 * * * ?")  //每5分钟执行一次
    public void syncUserFromShenma(){
        String sw = props.get("synchronize.switch");
        String viewUserTableName = props.get("synchronize.db.view.user");
        String viewDeptTableName = props.get("synchronize.db.view.department");
        List<SysUser> users = Lists.newArrayList();//用户的List
        List<SysDept> depts = Lists.newArrayList();//部门的List
        boolean flag = false;
        if("on".equals(sw)){
            System.out.println("====================================轮询数据库开始=======================================");
            Connection conn = DBConnUtil.getConnection();
            try {
                if(null == conn || conn.isClosed()){
                    System.out.println("连接数据库失败,等待下次连接");
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Statement stmt;
            try{
                stmt = conn.createStatement();
                String sql = "";
                if(StringUtils.isBlank(viewDeptTableName)){
                    sql = "SELECT * FROM "+ viewUserTableName;
                }else{
                    flag = true;
                    sql = "SELECT u.*,d." + props.get("user.id") + " AS deptId FROM " +
                           viewUserTableName + " u LEFT JOIN " + viewDeptTableName +
                           " d ON u." + props.get("user.deptId") + " = d." +
                           props.get("dept.deptCode");
                }
                ResultSet rsUser = stmt.executeQuery(sql);
                SysUser sysUser= null;

                while(rsUser.next()){
                    sysUser = new SysUser();

                    sysUser.setRealName(rsUser.getString(props.get("user.realName")));
                    sysUser.setCreateTime(rsUser.getTimestamp(props.get("user.createTime")));
                    String userName = rsUser.getString(props.get("user.userName"));
                    sysUser.setUserName(userName);
                    String token = DesUtil.encrypt(userName);
                    sysUser.setToken(token);
                    sysUser.setUpdateTime(rsUser.getTimestamp(props.get("user.updateTime")));
                    sysUser.setStatus(rsUser.getInt(props.get("user.status")));
                    sysUser.setEmail(rsUser.getString(props.get("user.email")));
                    sysUser.setCellPhoneNumber(rsUser.getString(props.get("user.cellPhoneNumber")));
                    sysUser.setPassword(rsUser.getString(props.get("user.password")));
                    sysUser.setId(rsUser.getString(props.get("user.id")));
                    sysUser.setUserImg(rsUser.getString(props.get("user.userImg")));
                    if(flag){
                        sysUser.setDeptId(rsUser.getString("deptId"));
                    }else{
                        sysUser.setDeptId(rsUser.getString(props.get("user.deptId")));
                    }
                    sysUser.setDeptId(rsUser.getString("deptId"));
                    sysUser.setUserType(1);
                    users.add(sysUser);
                }

                /**
                 * 更新用户表
                 * */
                try{
                    syncToLoacalService.insertOrUpdateSysUser(users);
                }catch (Exception e){
                    e.printStackTrace();
                }

                if(StringUtils.isBlank(viewDeptTableName)){
                    conn.close();
                    System.out.println("====================================轮询数据库结束=======================================");
                    return;
                }

                ResultSet rsDept = stmt.executeQuery("SELECT a.*,b." + props.get("dept.id") + " AS fuuid FROM "+ viewDeptTableName +" a\n" +
                        "LEFT JOIN "+ viewDeptTableName +" b ON b." + props.get("dept.deptCode") + " = a."+props.get("dept.fcode"));
                SysDept sysDept= null;
                while (rsDept.next()){
                    sysDept = new SysDept();

                    sysDept.setId(rsDept.getString(props.get("dept.id")));
                    sysDept.setStatus( rsDept.getInt(props.get("dept.status")));
                    sysDept.setOrderNumber(rsDept.getInt(props.get("dept.orderNumber")));
                    sysDept.setOrgLatitude(rsDept.getString(props.get("dept.orgLatitude")));
                    sysDept.setOrgLongitude(rsDept.getString(props.get("dept.orgLongitude")));
                    sysDept.setFunctionKeyword(rsDept.getString(props.get("dept.functionKeyword")));
                    sysDept.setDeptAddress(rsDept.getString(props.get("dept.deptAddress")));
                    sysDept.setRegionCode(rsDept.getString(props.get("dept.regionCode")));
                    sysDept.setCreateTime(rsDept.getTimestamp(props.get("dept.createTime")));
                    sysDept.setDeptContactPhone(rsDept.getString(props.get("dept.deptContactPhone")));
                    sysDept.setDeptListingName(rsDept.getString(props.get("dept.deptListingName")));
                    sysDept.setDeptContactFixedPhone(rsDept.getString(props.get("dept.deptContactFixedPhone")));
                    sysDept.setDeptShortName(rsDept.getString(props.get("dept.deptShortName")));
                    sysDept.setDeptContactEmail(rsDept.getString(props.get("dept.eeptContactEmail")));
                    sysDept.setDeptContactMan(rsDept.getString(props.get("dept.deptContactMan")));
                    sysDept.setDeptContactPhone(rsDept.getString(props.get("dept.deptContactPhone")));
                    sysDept.setCreateUserId(rsDept.getString(props.get("dept.createUserId")));
                    sysDept.setDeptAlias(rsDept.getString(props.get("dept.deptAlias")));
                    sysDept.setDeptType(rsDept.getString(props.get("dept.deptType")));
                    sysDept.setDeptCode(rsDept.getString(props.get("dept.deptCode")));
                    sysDept.setDeptContactDept(rsDept.getString(props.get("dept.deptContactDept")));
                    sysDept.setFid(rsDept.getString("fuuid"));
                    sysDept.setFname(rsDept.getString(props.get("dept.fname")));
                    sysDept.setDeptName(rsDept.getString(props.get("dept.deptName")));
                    sysDept.setDeptResponseMan(rsDept.getString(props.get("dept.deptResponseMan")));
                    sysDept.setRegionCode(rsDept.getString(props.get("dept.regionCode")));
                    sysDept.setDeptResponseEmail(rsDept.getString(props.get("dept.deptResponseEmail")));
                    sysDept.setDeptResponsePhone(rsDept.getString(props.get("dept.deptResponsePhone")));
                    sysDept.setDeptFunction(rsDept.getString(props.get("dept.deptFunction")));
                    sysDept.setUpdateTime(rsDept.getTimestamp(props.get("dept.updateTime")));
                    sysDept.setDeptLevel(rsDept.getInt(props.get("dept.deptLevel")));
                    depts.add(sysDept);
                }

                /**
                 * 更新部门表
                 * */
                try{
                    syncToLoacalService.insertOrUpdateSysDept(depts);
                }catch (Exception e){
                    e.printStackTrace();
                }
                conn.close();

            }catch (Exception e){
                 e.printStackTrace();
            }
            System.out.println("====================================轮询数据库结束=======================================");

        }
    }


}
