package com.chinawiserv.dsp.dir.schema;

import com.chinawiserv.dsp.base.common.util.DesUtil;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/12/4
 * Time:16:09
 * Chinawiserv Technologies Co., Ltd.
 */
@PropertySource("${config.location:classpath:}conf/schedule.properties")
@Component
public class SyncUsersAndDepsTaskSX {

    private final String CHENG_DU_REGION_CODE = "510100";

    @Autowired
    private SyncToLoacalService service;

    /**
     * 同步开关
     */
    @Value("${synchronize.switch}")
    private String sw;

    /**
     * 用户表
     */
    @Value("${synchronize.db.view.user}")
    private String viewUserTableName;

    /**
     * 部门表
     */
    @Value("${synchronize.db.view.department}")
    private String viewDeptTableName;

    /**
     * 用户表的字段===================================================================
     * */
    /**
     * id
     */
    @Value("${user.id}")
    private String userId;

    /**
     * 区域编码
     */
    @Value("${user.regionCode}")
    private String userRegionCode;

    /**
     * 用户名
     */
    @Value("${user.userName}")
    private String userName;
    /**
     * 用户真实姓名
     */
    @Value("${user.realName}")
    private String userRealName;
    /**
     * 密码
     */
    @Value("${user.password}")
    private String userPassword;
    /**
     * 电话号码
     */
    @Value("${user.telephoneNumber}")
    private String userTelephoneNumber;
    /**
     * 手机号码
     */
    @Value("${user.cellPhoneNumber}")
    private String userCellPhoneNumber;
    /**
     * 邮箱
     */
    @Value("${user.email}")
    private String userEmail;
    /**
     * 用户头像
     */
    @Value("${user.userImg}")
    private String userImg;
    /**
     * 用户描述
     */
    @Value("${user.userDesc}")
    private String userDesc;
    /**
     * 所属组织机构
     */
    @Value("${user.deptId}")
    private String userDeptId;
    /**
     * 状态
     */
    @Value("${user.status}")
    private String userStatus;
    /**
     * 创建人
     */
    @Value("${user.createUserId}")
    private String userCreateUserId;
    /**
     * 创建时间
     */
    @Value("${user.createTime}")
    private String userCreateTime;
    /**
     * 更新人
     */
    @Value("${user.updateUserId}")
    private String userUpdateUserId;
    /**
     * 更新时间
     */
    @Value("${user.updateTime}")
    private String userUpdateTime;
    /**
     * 逻辑删除标识
     */
    @Value("${user.deleteFlag}")
    private String userDeleteFlag;
    /**
     * 用户接口验证码
     */
    @Value("${user.token}")
    private String userToken;


    /**
     * 部门表的字段===================================================================
     * */
    /**
     * id
     */
    @Value("${dept.id}")
    private String deptId;
    /**
     * 所属行政区域
     */
    @Value("${dept.regionCode}")
    private String deptRegionCode;
    /**
     * 组织机构类型
     */
    @Value("${dept.deptType}")
    private String deptType;
    /**
     * 组织机构编码
     */
    @Value("${dept.deptCode}")
    private String deptCode;
    /**
     * 组织机构名称
     */
    @Value("${dept.deptName}")
    private String deptName;
    /**
     * 组织机构简称
     */
    @Value("${dept.deptShortName}")
    private String deptShortName;
    /**
     * 组织机构别名
     */
    @Value("${dept.deptAlias}")
    private String deptAlias;
    /**
     * 组织机构挂牌名
     */
    @Value("${dept.deptListingName}")
    private String deptListingName;
    /**
     * 组织机构描述
     */
    @Value("${dept.deptDesc}")
    private String deptDesc;
    /**
     * 职能关键字
     */
    @Value("${dept.functionKeyword}")
    private String deptFunctionKeyword;
    /**
     * 组织机构职能
     */
    @Value("${dept.deptFunction}")
    private String deptFunction;

    /**
     * 父组织机构ID
     */
    @Value("${dept.fid}")
    private String deptFid;

    /**
     * 父组织机构编码
     */
    @Value("${dept.fcode}")
    private String deptFcode;

    /**
     * 父组织机构名称
     */
    @Value("${dept.fname}")
    private String deptFname;
    /**
     * 组织机构结构名称
     */
    @Value("${dept.deptStructureName}")
    private String deptStructureName;
    /**
     * 部门级别
     */
    @Value("${dept.deptLevel}")
    private String deptLevel;
    /**
     * 部门负责人
     */
    @Value("${dept.deptResponseMan}")
    private String deptResponseMan;
    /**
     * 部门负责人电话
     */
    @Value("${dept.deptResponsePhone}")
    private String deptResponsePhone;
    /**
     * 部门负责人邮箱
     */
    @Value("${dept.deptResponseEmail}")
    private String deptResponseEmail;
    /**
     * 联系人
     */
    @Value("${dept.deptContactMan}")
    private String deptContactMan;
    /**
     * 联系人所属部门
     */
    @Value("${dept.deptContactDept}")
    private String deptContactDept;
    /**
     * 联系人职务
     */
    @Value("${dept.deptContactPost}")
    private String deptContactPost;
    /**
     * 联系人手机
     */
    @Value("${dept.deptContactPhone}")
    private String deptContactPhone;
    /**
     * 联系人座机
     */
    @Value("${dept.deptContactFixedPhone}")
    private String deptContactFixedPhone;
    /**
     * 联系人邮箱
     */
    @Value("${dept.deptContactEmail}")
    private String deptContactEmail;
    /**
     * 组织机构地址
     */
    @Value("${dept.deptAddress}")
    private String deptAddress;
    /**
     * 组织位置经度
     */
    @Value("${dept.orgLongitude}")
    private String deptOrgLongitude;
    /**
     * 组织位置纬度
     */
    @Value("${dept.orgLatitude}")
    private String deptOrgLatitude;
    /**
     * 图标
     */
    @Value("${dept.icon}")
    private String deptIcon;
    /**
     * 排序
     */
    @Value("${dept.orderNumber}")
    private String deptOrderNumber;
    /**
     * 组织启用时间
     */
    @Value("${dept.validateFrom}")
    private String deptValidateFrom;
    /**
     * 组织停用时间
     */
    @Value("${dept.validateTo}")
    private String deptValidateTo;
    /**
     * 状态
     */
    @Value("${dept.status}")
    private String deptStatus;
    /**
     * 创建人
     */
    @Value("${dept.createUserId}")
    private String deptCreateUserId;
    /**
     * 创建时间
     */
    @Value("${dept.createTime}")
    private String deptCreateTime;
    /**
     * 更新人
     */
    @Value("${dept.updateUserId}")
    private String deptUpdateUserId;
    /**
     * 更新时间
     */
    @Value("${dept.updateTime}")
    private String deptUpdateTime;
    /**
     * 逻辑删除标识
     */
    @Value("${dept.deleteFlag}")
    private String deptDeleteFlag;
    /**
     * 树索引
     */
    @Value("${dept.treeIndex}")
    private String deptTreeIndex;
    /**
     * 树编码
     */
    @Value("${dept.treeCode}")
    private String deptTreeCode;

    @Scheduled(cron = "${synchronize.time.interval}")  //每5分钟执行一次
    private void syncUsersAndDeptsFromSX() {

        if (!"on".equalsIgnoreCase(sw) || (StringUtils.isAllBlank(viewUserTableName, viewDeptTableName))) return;

        System.out.println("++++++++++同步开始++++++++++");

        Connection conn = DBConnUtil.getConnection();
        try {
            if (null == conn || conn.isClosed()) {
                System.out.println("++++++++++数据库未连接成功或已关闭，等待下次连接++++++++++");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        boolean b = this.syncUsers(conn);

        if(b) System.out.println("++++++++++同步用户成功++++++++++");

        if(StringUtils.isBlank(viewDeptTableName)) try {
            conn.close();
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        boolean c = this.syncDepts(conn);

        if(c) System.out.println("++++++++++同步部门成功++++++++++");

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * 同步用户的方法
     */
    private boolean syncUsers(Connection conn) {
        List<SysUser> users = Lists.newArrayList();
        Statement stmt;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        StringBuffer sql = new StringBuffer("select * from " + viewUserTableName);
        if (StringUtils.isNotBlank(viewDeptTableName)) {
            sql.setLength(0);
            sql.append("select u.*,d.")
                    .append(deptId)
                    .append(" as deptId,d.")
                    .append(deptRegionCode)
                    .append(" as regionCode from ")
                    .append(viewUserTableName)
                    .append(" u left join ")
                    .append(viewDeptTableName)
                    .append(" d on u.")
                    .append(userDeptId)
                    .append(" = d.")
                    .append(deptCode);
        }
        try {
            ResultSet rs = stmt.executeQuery(sql.toString());

            while (rs.next()) {
                SysUser sysUser = new SysUser();
                sysUser.setRealName(rs.getString(userRealName));
                sysUser.setCreateTime(rs.getTimestamp(userCreateTime));
                String userNameString = rs.getString(userName);
                sysUser.setUserName(userNameString);
                String token = DesUtil.encrypt(userNameString);
                sysUser.setToken(token);
                sysUser.setUpdateTime(rs.getTimestamp(userUpdateTime));
                sysUser.setStatus(rs.getInt(userStatus));
                sysUser.setEmail(rs.getString(userEmail));
                sysUser.setCellPhoneNumber(rs.getString(userCellPhoneNumber));
                sysUser.setPassword(rs.getString(userPassword));
                sysUser.setId(rs.getString(userId));
                sysUser.setUserImg(rs.getString(userImg));
                String deptId;
                String regionCode;
                if (StringUtils.isBlank(viewDeptTableName)) {
                    deptId = rs.getString(userDeptId);
                    regionCode = CHENG_DU_REGION_CODE;
                } else {
                    deptId = rs.getString("deptId");
                    regionCode = rs.getString("regionCode");
                    if (StringUtils.isBlank(regionCode)) {
                        regionCode = CHENG_DU_REGION_CODE;
                    }
                }
                sysUser.setDeptId(deptId);
                sysUser.setRegionCode(regionCode);
                sysUser.setUserType(1);
                users.add(sysUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            this.service.insertOrUpdateSysUser(users);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /**
     * 同步部门的方法
     */
    private boolean syncDepts(Connection conn) {
        List<SysDept> depts = Lists.newArrayList();
        Statement stmt;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        StringBuffer sql = new StringBuffer()
                .append("select a.*,b.")
                .append(deptId)
                .append(" as fuuid from ")
                .append(viewDeptTableName)
                .append(" a left join ")
                .append(viewDeptTableName)
                .append(" b on b.")
                .append(deptCode)
                .append(" = a.")
                .append(deptFcode);

        try {
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()){
                SysDept sysDept = new SysDept();

                sysDept.setId(rs.getString(deptId));
                sysDept.setStatus( rs.getInt(deptStatus));
                sysDept.setOrderNumber(rs.getInt(deptOrderNumber));
                sysDept.setOrgLatitude(rs.getString(deptOrgLatitude));
                sysDept.setOrgLongitude(rs.getString(deptOrgLongitude));
                sysDept.setFunctionKeyword(rs.getString(deptFunctionKeyword));
                sysDept.setDeptAddress(rs.getString(deptAddress));
                /**
                 * 地区码,没有的话默认为成都的地区码
                 * */
                String regionCode = rs.getString(deptRegionCode);
                if(StringUtils.isBlank(regionCode)){
                    regionCode = CHENG_DU_REGION_CODE;
                }
                sysDept.setRegionCode(regionCode);
                sysDept.setCreateTime(rs.getTimestamp(deptCreateTime));
                sysDept.setDeptContactPhone(rs.getString(deptContactPhone));
                sysDept.setDeptListingName(rs.getString(deptListingName));
                sysDept.setDeptContactFixedPhone(rs.getString(deptContactFixedPhone));
                sysDept.setDeptShortName(rs.getString(deptShortName));
                sysDept.setDeptContactEmail(rs.getString(deptContactEmail));
                sysDept.setDeptContactMan(rs.getString(deptContactMan));
                sysDept.setDeptContactPhone(rs.getString(deptContactPhone));
                sysDept.setCreateUserId(rs.getString(deptCreateUserId));
                sysDept.setDeptAlias(rs.getString(deptAlias));
                sysDept.setDeptType(rs.getString(deptType));
                sysDept.setDeptCode(rs.getString(deptCode));
                sysDept.setDeptContactDept(rs.getString(deptContactDept));
                sysDept.setFid(rs.getString("fuuid"));
                sysDept.setFname(rs.getString(deptFname));
                sysDept.setDeptName(rs.getString(deptName));
                sysDept.setDeptResponseMan(rs.getString(deptResponseMan));
                sysDept.setDeptResponseEmail(rs.getString(deptResponseEmail));
                sysDept.setDeptResponsePhone(rs.getString(deptResponsePhone));
                sysDept.setDeptFunction(rs.getString(deptFunction));
                sysDept.setUpdateTime(rs.getTimestamp(deptUpdateTime));
                sysDept.setDeptLevel(rs.getInt(deptLevel));
                depts.add(sysDept);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            this.service.insertOrUpdateSysDept(depts);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
