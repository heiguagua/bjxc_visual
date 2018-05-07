/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     18/4/24 19:21:20                             */
/*==============================================================*/


drop table if exists sys_dept;

drop table if exists sys_dept_authority;

drop table if exists sys_dept_authority_apply;

drop table if exists sys_dept_category_template;

drop table if exists sys_dept_contacts;

drop table if exists sys_dict;

drop table if exists sys_dict_category;

drop table if exists sys_guid_dept;

drop table if exists sys_icon_category;

drop table if exists sys_icon_lib;

drop table if exists sys_log;

drop table if exists sys_menu;

drop table if exists sys_product_dept_map;

drop table if exists sys_product_dict_map;

drop table if exists sys_product_icon_map;

drop table if exists sys_product_integrate;

drop table if exists sys_product_user_map;

drop table if exists sys_region;

drop table if exists sys_region_level;

drop table if exists sys_region_version;

drop table if exists sys_role;

drop table if exists sys_role_menu;

drop table if exists sys_setting;

drop table if exists sys_setting_category;

drop table if exists sys_user;

drop table if exists sys_user_role;

drop table if exists vm_chart_classify;

drop table if exists vm_chart_conf;

drop table if exists vm_chart_desc_indictor_map;

drop table if exists vm_chart_description;

drop table if exists vm_chart_menu_custom;

drop table if exists vm_chart_menu_template;

drop table if exists vm_classify_indictor_map;

/*==============================================================*/
/* Table: sys_dept                                              */
/*==============================================================*/
create table sys_dept
(
   id                   varchar(36) not null comment 'id',
   region_code          varchar(6) comment '所属行政区域',
   dept_type            varchar(36) comment '组织机构类型',
   dept_code            varchar(64) not null comment '组织机构编码',
   dept_name            varchar(128) not null comment '组织机构名称',
   dept_short_name      varchar(128) comment '组织机构简称',
   dept_alias           varchar(64) comment '组织机构别名',
   dept_listing_name    varchar(64) comment '组织机构挂牌名',
   dept_desc            varchar(512) comment '组织机构描述',
   function_keyword     varchar(200) comment '职能关键字',
   dept_function        varchar(4000) comment '组织机构职能',
   fid                  varchar(64) comment '父组织机构编码',
   fname                varchar(64) comment '父组织机构名称',
   dept_structure_name  varchar(200) comment '组织机构结构名称',
   dept_level           int(3) comment '部门级别',
   dept_response_man    varchar(36) comment '部门负责人',
   dept_response_phone  varchar(36) comment '部门负责人电话',
   dept_response_email  varchar(64) comment '部门负责人邮箱',
   dept_contact_man     varchar(36) comment '联系人',
   dept_contact_dept    varchar(36) comment '联系人所属部门',
   dept_contact_post    varchar(36) comment '联系人职务',
   dept_contact_phone   varchar(36) comment '联系人手机',
   dept_contact_fixed_phone varchar(36) comment '联系人座机',
   dept_contact_email   varchar(64) comment '联系人邮箱',
   dept_address         varchar(256) comment '组织机构地址',
   org_longitude        varchar(36) comment '组织位置经度',
   org_latitude         varchar(36) comment '组织位置纬度',
   icon                 varchar(200) comment '图标',
   order_number         int(4) comment '排序',
   validate_from        date comment '组织启用时间',
   validate_to          date comment '组织停用时间',
   pinyin               varchar(200) comment '名称拼音',
   status               int(3) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   tree_index           int(6) default 0 comment '树索引',
   tree_code            varchar(128) comment '树编码',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_dept comment '系统组织机构表';

/*==============================================================*/
/* Table: sys_dept_authority                                    */
/*==============================================================*/
create table sys_dept_authority
(
   id                   varchar(36) not null comment 'id',
   auth_obj_type        varchar(36) comment '权限对象类型',
   auth_obj_id          varchar(36) comment '权限对象ID',
   dept_id              varchar(36) comment '被分配权限部门ID',
   read_auth            int(3) comment '读权限',
   write_auth           int(3) comment '写权限',
   distributor_id       varchar(36) comment '分配操作人',
   distribute_opinion   varchar(512) comment '分配意见',
   distribute_date      date comment '分配操作时间',
   is_from_audit        varchar(2) comment '是否来自于审核',
   primary key (id)
);

alter table sys_dept_authority comment '部门数据权限分配表';

/*==============================================================*/
/* Table: sys_dept_authority_apply                              */
/*==============================================================*/
create table sys_dept_authority_apply
(
   id                   varchar(36) not null comment 'ID',
   applicant            varchar(36) comment '申请人ID',
   apply_reason         varchar(512) comment '申请理由',
   apply_time           datetime comment '申请时间',
   to_dept_id           varchar(36) comment '申请权限对应部门',
   authority_type       varchar(36) comment '申请权限类型',
   auditor              varchar(36) comment '审核人',
   audit_time           datetime comment '审核时间',
   audit_opinion        varchar(512) comment '审核意见',
   audit_status         varchar(36) comment '审核状态',
   primary key (id)
);

alter table sys_dept_authority_apply comment '部门数据权限申请表';

/*==============================================================*/
/* Table: sys_dept_category_template                            */
/*==============================================================*/
create table sys_dept_category_template
(
   id                   varchar(36) not null comment 'ID',
   category_code        varchar(36) comment '组织机构类别代码',
   category_name        varchar(36) comment '组织机构类别名称',
   fullname_template    varchar(64) comment '组织机构类别全称模板',
   shortname_template   varchar(64) comment '组织机构类别简称模板',
   apply_min_level      int comment '适用最小行政级别',
   apply_max_level      int comment '适用最大行政级别',
   primary key (id)
);

alter table sys_dept_category_template comment '组织机构类别模板表';

/*==============================================================*/
/* Table: sys_dept_contacts                                     */
/*==============================================================*/
create table sys_dept_contacts
(
   id                   varchar(36) not null comment 'id',
   cur_dept_id          varchar(36) comment '部门ID',
   contacts_type        varchar(36) comment '部门联系人类型',
   contacts_name        varchar(64) comment '联系人姓名',
   contacts_dept        varchar(36) comment '联系人处室',
   contacts_post        varchar(36) comment '联系人职务',
   contacts_fixed_phone varchar(36) comment '联系人座机',
   contacts_phone       varchar(36) comment '联系人手机',
   contacts_email       varchar(64) comment '联系人邮箱',
   primary key (id)
);

alter table sys_dept_contacts comment '部门联系人';

/*==============================================================*/
/* Table: sys_dict                                              */
/*==============================================================*/
create table sys_dict
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '行政区划编号',
   category             varchar(36) not null comment '类型',
   dict_code            varchar(36) not null comment '字典编码',
   dict_name            varchar(64) not null comment '字典名称',
   dict_desc            varchar(512) comment '字典描述',
   parent_code          varchar(36) comment '上级字典值',
   order_number         int(4) comment '显示顺序',
   icon                 varchar(256) comment '图标',
   dict_level           int(4) comment '字典级别',
   status               int(3) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
);

alter table sys_dict comment '系统字典表';

/*==============================================================*/
/* Table: sys_dict_category                                     */
/*==============================================================*/
create table sys_dict_category
(
   category_code        varchar(36) not null comment '类别编号',
   category_name        varchar(64) comment '类别名称',
   category_desc        varchar(256) comment '类别描述',
   primary key (category_code)
);

alter table sys_dict_category comment '字典类型表';

/*==============================================================*/
/* Table: sys_guid_dept                                         */
/*==============================================================*/
create table sys_guid_dept
(
   id                   varchar(36) not null comment 'id',
   cur_dept_id          varchar(36) comment '当前部门ID',
   guid_dept_id         varchar(36) comment '业务指导部门ID',
   primary key (id)
);

alter table sys_guid_dept comment '业务指导部门记录表';

/*==============================================================*/
/* Table: sys_icon_category                                     */
/*==============================================================*/
create table sys_icon_category
(
   category_code        varchar(36) not null comment '类别编号',
   category_name        varchar(64) comment '类别名称',
   category_desc        varchar(256) comment '类别描述',
   primary key (category_code)
);

alter table sys_icon_category comment '系统图标类型表';

/*==============================================================*/
/* Table: sys_icon_lib                                          */
/*==============================================================*/
create table sys_icon_lib
(
   id                   varchar(36) not null comment 'ID',
   icon_type            varchar(36) comment '图标类型',
   icon_name            varchar(64) comment '图标显示名称',
   icon_path            varchar(128) comment '图标路径',
   icon_css_class       varchar(64) comment '图标样式名',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_icon_lib comment '系统图标库表';

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   operator_id          varchar(36) comment '操作人ID',
   operate_time         timestamp comment '操作时间',
   operate_type         varchar(36) comment '操作类型',
   operate_ip           varchar(36) comment '操作人IP',
   operate_desc         varchar(256) comment '操作描述',
   operate_detail       longtext comment '操作详情',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_log comment '系统操作日志表';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   id                   varchar(36) not null comment 'id',
   menu_name            varchar(64) not null comment '菜单名称',
   pid                  varchar(36) comment '父级菜单ID',
   url                  varchar(200) comment '连接地址',
   icon                 varchar(200) comment '图标',
   sort                 int(4) comment '排序',
   menu_type            int(3) comment '类型',
   code                 varchar(36) comment '编码',
   resource_name        varchar(200) comment '资源标识',
   status               int(3) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_menu comment '系统菜单表';

/*==============================================================*/
/* Table: sys_product_dept_map                                  */
/*==============================================================*/
create table sys_product_dept_map
(
   id                   varchar(36) not null comment 'id',
   product_id           varchar(36) not null comment '产品ID',
   dept_id              varchar(36) not null comment '部门ID',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_product_dept_map comment '产品部门关系表';

/*==============================================================*/
/* Table: sys_product_dict_map                                  */
/*==============================================================*/
create table sys_product_dict_map
(
   id                   varchar(36) not null comment 'id',
   product_id           varchar(36) not null comment '产品ID',
   dict_category        varchar(36) not null comment '字典类型',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_product_dict_map comment '产品字典关系表';

/*==============================================================*/
/* Table: sys_product_icon_map                                  */
/*==============================================================*/
create table sys_product_icon_map
(
   id                   varchar(36) not null comment 'id',
   product_id           varchar(36) not null comment '产品ID',
   icon_category        varchar(36) not null comment '图标类型',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_product_icon_map comment '产品图标关系';

/*==============================================================*/
/* Table: sys_product_integrate                                 */
/*==============================================================*/
create table sys_product_integrate
(
   id                   varchar(36) not null comment 'ID',
   fid                  varchar(36) comment '父节点ID',
   product_no           varchar(64) comment '产品标识',
   product_name         varchar(64) comment '产品名称',
   product_show_name    varchar(64) comment '产品显示名称',
   product_desc         varchar(256) comment '产品描述',
   root_path            varchar(256) comment '产品访问根路径地址',
   sso_path             varchar(256) comment '单点登录跳转地址',
   order_number         int(6) default 0 comment '显示顺序',
   master_flag          int(3) comment '是否主节点',
   integrate_flag       int(3) default 1 comment '是否集成',
   cur_open_flag        int(3) default 1 comment '是否在当前页面打开',
   icon                 varchar(64) comment '显示图标',
   jump_url             varchar(64) comment '前端跳转地址',
   primary key (id)
);

alter table sys_product_integrate comment '产品集成表';

/*==============================================================*/
/* Table: sys_product_user_map                                  */
/*==============================================================*/
create table sys_product_user_map
(
   id                   varchar(36) not null comment 'id',
   product_id           varchar(36) not null comment '产品ID',
   user_id              varchar(36) not null comment '用户ID',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_product_user_map comment '产品用户关系表';

/*==============================================================*/
/* Table: sys_region                                            */
/*==============================================================*/
create table sys_region
(
   id                   varchar(36) not null comment '主键ID',
   region_code          varchar(6) not null comment '行政区划编号',
   region_name          varchar(64) comment '行政区划名称',
   fcode                varchar(36) comment '上级行政区划编号',
   fname                varchar(64) comment '上级行政区划名称',
   first_charact        varchar(36) comment '首字母',
   pinyin               varchar(200) comment '名称拼音',
   region_level_code    varchar(36) comment '行政区划级别代码',
   status               varchar(36) default '1' comment '状态',
   version_id           varchar(36) comment '版本信息表ID',
   primary key (id)
);

alter table sys_region comment '行政区域表';

/*==============================================================*/
/* Table: sys_region_level                                      */
/*==============================================================*/
create table sys_region_level
(
   region_level_code    varchar(6) not null comment '行政级别代码',
   region_level_name    varchar(64) comment '行政级别名称',
   region_level_value   int comment '行政级别',
   primary key (region_level_code)
);

alter table sys_region_level comment '行政级别表';

/*==============================================================*/
/* Table: sys_region_version                                    */
/*==============================================================*/
create table sys_region_version
(
   id                   varchar(36) not null comment 'ID',
   version_code         varchar(6) not null comment '版本号',
   source               varchar(64) comment '版本来源',
   publish_date         varchar(6) comment '版本发布时间',
   apply_desc           varchar(512) comment '版本来源适应说明',
   version_info         varchar(512) comment '版本记录描述',
   validate_from        date comment '版本有效期开始',
   validate_to          date comment '版本有效期结束',
   primary key (id)
);

alter table sys_region_version comment '行政区划版本记录表';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   varchar(36) not null comment 'id',
   role_name            varchar(128) not null comment '角色名称',
   role_desc            varchar(512) comment '角色描述',
   role_level           int(3) comment '角色级别',
   status               int(3) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_role comment '系统角色表';

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   id                   varchar(36) not null comment 'id',
   role_id              varchar(36) not null comment '角色ID',
   menu_id              varchar(36) not null comment '菜单ID',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_role_menu comment '角色权限表';

/*==============================================================*/
/* Table: sys_setting                                           */
/*==============================================================*/
create table sys_setting
(
   id                   varchar(36) not null comment 'id',
   region_code          varchar(6) comment '所属行政区划',
   setting_type         varchar(36) not null comment '配置类型',
   setting_code         varchar(128) not null comment '配置编码',
   setting_name         varchar(128) not null comment '配置名称',
   setting_value        varchar(128) not null comment '配置值',
   setting_desc         varchar(512) comment '配置描述',
   status               int(3) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   rule varchar(50) DEFAULT NULL COMMENT '配置值的规则',
   placeholder varchar(50) DEFAULT NULL COMMENT '配置值填写提示信息',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_setting comment '系统配置表';

/*==============================================================*/
/* Table: sys_setting_category                                  */
/*==============================================================*/
create table sys_setting_category
(
   category_code        varchar(36) not null comment '类别编号',
   category_name        varchar(64) comment '类别名称',
   category_desc        varchar(256) comment '类别描述',
   primary key (category_code)
);

alter table sys_setting_category comment '系统配置类型表';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   varchar(36) not null comment 'id',
   region_code          varchar(6) comment '所属行政区划',
   dept_id              varchar(36) comment '所属组织机构',
   user_type            varchar(36) comment '用户类型',
   user_name            varchar(64) not null comment '用户名',
   real_name            varchar(36) comment '用户真实姓名',
   password             varchar(36) not null comment '密码',
   token                varchar(64) comment '用户接口验证码',
   telephone_number     varchar(16) comment '电话号码',
   cell_phone_number    varchar(16) comment '手机号码',
   email                varchar(64) comment '邮箱',
   user_img             varchar(200) comment '用户头像',
   user_desc            varchar(512) comment '用户描述',
   pinyin               varchar(200) comment '名称拼音',
   status               int(3) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_user comment '系统用户表';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   id                   varchar(36) not null comment 'id',
   user_id              varchar(36) not null comment '用户ID',
   role_id              varchar(36) not null comment '角色ID',
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_user_role comment '用户角色表';

/*==============================================================*/
/* Table: vm_chart_classify                                     */
/*==============================================================*/
create table vm_chart_classify
(
   id                   varchar(36) not null comment 'id',
   chart_id             varchar(36) comment '图表ID',
   classify_name        varchar(36) comment '分类名称',
   classify_level       varchar(36) comment '分类级别',
   chart_type           varchar(36) comment '对应图形类型',
   primary key (id)
);

alter table vm_chart_classify comment '图表分类信息';

/*==============================================================*/
/* Table: vm_chart_conf                                         */
/*==============================================================*/
create table vm_chart_conf
(
   id                   varchar(36) not null comment 'id',
   chart_code           varchar(36) comment '图表编号',
   chart_name           varchar(36) comment '图表标题',
   is_name_show         int(3) comment '标题是否显示',
   chart_desc           varchar(36) comment '图表描述',
   chart_type           varchar(36) comment '图表类型',
   chart_url            varchar(256) comment '图表URL',
   chart_time_type      varchar(36) comment '图表时间范围类型',
   chart_time_scope     varchar(64) comment '图表时间范围取值',
   status               int(3) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   has_sub_indictor     int(3) default 0 comment '是否有附属指标',
   primary key (id)
);

alter table vm_chart_conf comment '系统图表配置表';

/*==============================================================*/
/* Table: vm_chart_desc_indictor_map                            */
/*==============================================================*/
create table vm_chart_desc_indictor_map
(
   id                   varchar(36) not null comment 'id',
   chart_id             varchar(36) comment '图表ID',
   indictor_code        varchar(36) comment '指标编号',
   indictor_show_name   varchar(64) comment '指标显示名称',
   primary key (id)
);

alter table vm_chart_desc_indictor_map comment '图表描述与指标关系表';

/*==============================================================*/
/* Table: vm_chart_description                                  */
/*==============================================================*/
create table vm_chart_description
(
   id                   varchar(36) not null comment 'id',
   chart_id             varchar(36) comment '图表ID',
   sub_title            varchar(64) comment '副标题',
   description          varchar(512) comment '描述信息',
   primary key (id)
);

alter table vm_chart_description comment '图表指标描述信息';

/*==============================================================*/
/* Table: vm_chart_menu_custom                                  */
/*==============================================================*/
create table vm_chart_menu_custom
(
   id                   varchar(36) not null comment 'id',
   chart_id              varchar(36) comment '图表ID',
   menu_id              varchar(36) comment '菜单ID',
   location             varchar(128) comment '图表位置',
   show_order           int(3) comment '图表显示顺序',
   user                 varchar(36) comment '使用人',
   primary key (id)
);

alter table vm_chart_menu_custom comment '图表与菜单自定义关系';

/*==============================================================*/
/* Table: vm_chart_menu_template                                */
/*==============================================================*/
create table vm_chart_menu_template
(
   id                   varchar(36) not null comment 'id',
   chart_id             varchar(36) comment '图表ID',
   menu_id              varchar(128) comment '菜单ID',
   location             varchar(36) comment '图表位置',
   show_order           int(3) comment '图表显示顺序',
   primary key (id)
);

alter table vm_chart_menu_template comment '图表与菜单关系模板表';

/*==============================================================*/
/* Table: vm_classify_indictor_map                              */
/*==============================================================*/
create table vm_classify_indictor_map
(
   id                   varchar(36) not null comment 'id',
   classify_id          varchar(36) comment '分类ID',
   indictor_code        varchar(36) comment '指标编号',
   indictor_show_name   varchar(64) comment '指标显示名称',
   highlight_flag       varchar(36) comment '是否高亮显示',
   point_num            varchar(36) comment '保留小数点位数',
   primary key (id)
);

alter table vm_classify_indictor_map comment '图表分类与指标关系表';

