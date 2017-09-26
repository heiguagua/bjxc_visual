package com.chinawiserv.dsp.dir.schema;

import com.chinawiserv.dsp.base.common.util.Props;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.google.common.collect.Lists;
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
                ResultSet rsUser = stmt.executeQuery("SELECT * FROM " + viewUserTableName);
                SysUser sysUser= null;

                while(rsUser.next()){
                    sysUser = new SysUser();

                    sysUser.setRealName(rsUser.getString("user_name"));
                    sysUser.setUserName(rsUser.getString("login_time"));
                    sysUser.setCreateTime(rsUser.getDate("register_time"));
                    sysUser.setUpdateTime(rsUser.getDate("updatetime"));
                    sysUser.setStatus(rsUser.getInt("status"));
                    sysUser.setEmail(rsUser.getString("email"));
                    sysUser.setCellPhoneNumber(rsUser.getString("mobile"));
                    sysUser.setPassword(rsUser.getString("password"));
                    sysUser.setId(rsUser.getString("uuid"));
                    sysUser.setUserImg(rsUser.getString("head_img"));
                    sysUser.setDeptId(rsUser.getString("organize_code"));
                    sysUser.setUpdateTime(rsUser.getDate("last_update_time"));

                    users.add(sysUser);
                }

                ResultSet rsDept = stmt.executeQuery("SELECT a.*,b.uuid AS fuuid FROM "+ viewDeptTableName +" a\n" +
                        "LEFT JOIN "+ viewDeptTableName +" b ON b.org_code = a.org_fcode");
                SysDept sysDept= null;
                while (rsDept.next()){
                    sysDept = new SysDept();

                    sysDept.setId(rsDept.getString("uuid"));
                    sysDept.setStatus( rsDept.getInt("org_status"));
                    sysDept.setOrderNumber(rsDept.getInt("order_number"));
                    sysDept.setOrgLatitude(rsDept.getString("org_latitude"));
                    sysDept.setOrgLongitude(rsDept.getString("org_longitude"));
                    sysDept.setFunctionKeyword(rsDept.getString("function_keyword"));
                    sysDept.setDeptAddress(rsDept.getString("org_address"));
                    sysDept.setRegionCode(rsDept.getString("region_code"));
                    sysDept.setCreateTime(rsDept.getDate("create_time"));
                    sysDept.setDeptContactPhone(rsDept.getString("landline_telephone"));
                    sysDept.setDeptListingName(rsDept.getString("listing_name"));
                    sysDept.setDeptContactFixedPhone(rsDept.getString("othter_connact"));
                    sysDept.setDeptShortName(rsDept.getString("org_shortname"));
                    sysDept.setDeptContactEmail(rsDept.getString("contact_email"));
                    sysDept.setDeptContactMan(rsDept.getString("contact_person"));
                    sysDept.setDeptContactPhone(rsDept.getString("contact_phone"));
                    sysDept.setCreateUserId(rsDept.getString("create_user"));
                    sysDept.setDeptAlias(rsDept.getString("org_alias"));
                    sysDept.setDeptType(rsDept.getString("org_category"));
                    sysDept.setDeptCode(rsDept.getString("org_code"));
                    sysDept.setDeptContactDept(rsDept.getString("org_extend_code"));
                    sysDept.setFid(rsDept.getString("fuuid"));
                    sysDept.setFname(rsDept.getString("org_fname"));
                    sysDept.setDeptName(rsDept.getString("org_fullname"));
                    sysDept.setDeptResponseMan(rsDept.getString("org_response_person"));
                    sysDept.setRegionCode(rsDept.getString("region"));
                    sysDept.setDeptResponseEmail(rsDept.getString("response_email"));
                    sysDept.setDeptResponsePhone(rsDept.getString("response_phone"));
                    sysDept.setDeptFunction(rsDept.getString("org_function"));
                    sysDept.setUpdateTime(rsDept.getDate("last_update_time"));
                    sysDept.setDeptLevel(rsDept.getInt("org_level"));

                    depts.add(sysDept);
                }
                /**
                 * 更新用户表
                 * */
                try{
                    syncToLoacalService.insertOrUpdateSysUser(users);
                }catch (Exception e){
                    e.printStackTrace();
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
