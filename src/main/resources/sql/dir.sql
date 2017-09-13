/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/9/12 15:12:00                           */
/*==============================================================*/


drop table if exists common_extend_config_info;

drop table if exists common_extend_data_info;

drop table if exists common_message_info;

drop table if exists common_message_response;

drop table if exists common_obj_label;

drop table if exists dir_classify;

drop table if exists dir_classify_authority;

drop table if exists dir_data_audit;

drop table if exists dir_data_collection;

drop table if exists dir_data_comment;

drop table if exists dir_data_correction;

drop table if exists dir_data_offline;

drop table if exists dir_data_publish;

drop table if exists dir_data_rate;

drop table if exists dir_data_visit;

drop table if exists dir_dataitem;

drop table if exists dir_dataitem_apply;

drop table if exists dir_dataitem_distribute;

drop table if exists dir_dataitem_source_info;

drop table if exists dir_dataset;

drop table if exists dir_dataset_classify_map;

drop table if exists dir_dataset_ext_carrier;

drop table if exists dir_dataset_ext_format;

drop table if exists dir_dataset_ext_service_target;

drop table if exists dir_dataset_ext_sevice_field;

drop table if exists dir_dataset_ext_share_consult;

drop table if exists dir_dataset_ext_source;

drop table if exists dir_dataset_service_map;

drop table if exists dir_dataset_source_info;

drop table if exists dir_dataset_source_relation;

drop table if exists dir_develop_apis;

drop table if exists dir_news;

drop table if exists dir_policy;

drop table if exists dir_regist_user;

drop table if exists dir_service_info;

drop table if exists dir_special_apps;

drop table if exists dir_suggestion;

drop table if exists sys_dept;

drop table if exists sys_dept_category_template;

drop table if exists sys_dict;

drop table if exists sys_dict_category;

drop table if exists sys_guid_dept;

drop table if exists sys_log;

drop table if exists sys_menu;

drop table if exists sys_region;

drop table if exists sys_region_level;

drop table if exists sys_region_version;

drop table if exists sys_role;

drop table if exists sys_role_menu;

drop table if exists sys_setting;

drop table if exists sys_user;

drop table if exists sys_user_role;

/*==============================================================*/
/* Table: common_extend_config_info                             */
/*==============================================================*/
create table common_extend_config_info
(
   id                   varchar(36) not null comment 'id',
   category             varchar(36) comment '所属对象类型',
   name                 varchar(64) comment '属性名称',
   description          varchar(256) comment '属性描述',
   type                 varchar(36) comment '属性类型',
   primary key (id)
);

alter table common_extend_config_info comment '扩展属性配置表';

/*==============================================================*/
/* Table: common_extend_data_info                               */
/*==============================================================*/
create table common_extend_data_info
(
   id                   varchar(32) not null comment 'ID',
   extend_type          varchar(32) comment '扩展信息类别',
   obj_id               varchar(32) comment '扩展对象ID',
   extend_id            varchar(32) comment '扩展配置表ID',
   extend_value         varchar(64) comment '扩展值',
   primary key (id)
);

alter table common_extend_data_info comment '扩展信息数据表';

/*==============================================================*/
/* Table: common_message_info                                   */
/*==============================================================*/
create table common_message_info
(
   id                   varchar(36) not null comment 'id',
   message_type         varchar(36) comment '消息类型',
   obj_type             varchar(36) comment '接收对象类型',
   obj_id               varchar(36) comment '接收对象ID',
   title                varchar(128) comment '消息标题',
   content              varchar(1000) comment '消息内容',
   sender               varchar(64) comment '发送人',
   send_time            datetime comment '发送时间',
   primary key (id)
);

alter table common_message_info comment '系统消息表';

/*==============================================================*/
/* Table: common_message_response                               */
/*==============================================================*/
create table common_message_response
(
   id                   varchar(36) not null comment 'id',
   message_id           varchar(36) comment '消息ID',
   responder            varchar(36) comment '响应人ID',
   response_time        datetime comment '响应时间',
   response_status      varchar(36) comment '响应状态',
   primary key (id)
);

alter table common_message_response comment '系统消息响应表';

/*==============================================================*/
/* Table: common_obj_label                                      */
/*==============================================================*/
create table common_obj_label
(
   id                   varchar(36) not null comment 'id',
   obj_type             varchar(36) comment '对象类型',
   obj_id               varchar(36) comment '对象ID',
   lable_name           varchar(64) comment '标签名称',
   primary key (id)
);

alter table common_obj_label comment '对象标签映射表';

/*==============================================================*/
/* Table: dir_classify                                          */
/*==============================================================*/
create table dir_classify
(
   id                   varchar(36) not null comment 'id',
   region_code          varchar(6) comment '所属行政区划',
   classify_code        varchar(64) comment '【国】分类编号',
   classify_name        varchar(128) comment '【国】分类名称',
   classify_desc        varchar(1000) comment '分类描述',
   fcode                varchar(36) comment '上级分类编号',
   fname                varchar(128) comment '上级分类名称',
   classify_level       int comment '级别',
   classify_index       int comment '目录类别索引',
   dcm_index            int comment '信息资源索引',
   order_number         int(4) comment '显示顺序',
   status               varchar(36) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   tree_index           int,
   tree_code            varchar(128),
   primary key (id)
);

alter table dir_classify comment '目录分类表';

/*==============================================================*/
/* Table: dir_classify_authority                                */
/*==============================================================*/
create table dir_classify_authority
(
   id                   varchar(36) not null comment 'ID',
   auth_obj_type        varchar(36) comment '权限对象类型',
   auth_obj_id          varchar(36) comment '权限对象ID',
   classify_id          varchar(36) comment '目录类别ID',
   auth_detail          varchar(256) comment '权限说明',
   primary key (id)
);

alter table dir_classify_authority comment '目录类别控制权限表';

/*==============================================================*/
/* Table: dir_data_audit                                        */
/*==============================================================*/
create table dir_data_audit
(
   id                   varchar(36) not null comment 'ID',
   dcm_id               varchar(36) comment '信息资源ID',
   auditor_id           varchar(36) comment '审核人ID',
   audit_date           date comment '审核时间',
   audit_status         varchar(36) comment '审核状态',
   audit_opinion        varchar(500) comment '审核意见',
   primary key (id)
);

alter table dir_data_audit comment '数据审核情况表';

/*==============================================================*/
/* Table: dir_data_collection                                   */
/*==============================================================*/
create table dir_data_collection
(
   id                   varchar(36) not null comment 'ID',
   dcm_id               varchar(36) comment '信息资源ID',
   collector_id         varchar(36) comment '收藏人ID',
   collect_date         date comment '收藏时间',
   primary key (id)
);

alter table dir_data_collection comment '数据集收藏记录';

/*==============================================================*/
/* Table: dir_data_comment                                      */
/*==============================================================*/
create table dir_data_comment
(
   id                   varchar(36) not null comment 'ID',
   dcm_id               varchar(36) comment '信息资源ID',
   commentator_id       varchar(36) comment '评论人ID',
   comment_date         date comment '评论时间',
   comment_content      varchar(500) comment '评论内容',
   satus                varchar(36) comment '状态',
   primary key (id)
);

alter table dir_data_comment comment '数据集评论记录';

/*==============================================================*/
/* Table: dir_data_correction                                   */
/*==============================================================*/
create table dir_data_correction
(
   id                   varchar(36) not null comment 'ID',
   dcm_id               varchar(36) comment '信息资源ID',
   corrector_id         varchar(36) comment '纠错人ID',
   correct_content      varchar(500) comment '纠错内容',
   correct_date         date comment '纠错时间',
   auditor_id           varchar(36) comment '审核人ID',
   audit_date           date comment '审核时间',
   audit_status         varchar(36) comment '审核状态',
   audit_opinion        varchar(500) comment '审核意见',
   primary key (id)
);

alter table dir_data_correction comment '数据纠错记录';

/*==============================================================*/
/* Table: dir_data_offline                                      */
/*==============================================================*/
create table dir_data_offline
(
   id                   varchar(36) not null comment 'ID',
   dcm_id               varchar(36) comment '信息资源ID',
   offline_user_id      varchar(36) comment '下架人',
   offline_time         date comment '下架时间',
   primary key (id)
);

alter table dir_data_offline comment '数据下架情况';

/*==============================================================*/
/* Table: dir_data_publish                                      */
/*==============================================================*/
create table dir_data_publish
(
   id                   varchar(36) not null comment 'ID',
   dcm_id               varchar(36) comment '信息资源ID',
   publish_to_net       int comment '是否发布到互联网',
   publish_to_dzzw      int comment '是否发布到电子政务外网',
   publisher_id         varchar(36) comment '发布人',
   publish_date         date comment '发布时间',
   primary key (id)
);

alter table dir_data_publish comment '数据发布情况';

/*==============================================================*/
/* Table: dir_data_rate                                         */
/*==============================================================*/
create table dir_data_rate
(
   id                   varchar(36) not null comment 'ID',
   dcm_id               varchar(36) comment '信息资源ID',
   rater_id             varchar(36) comment '评分人ID',
   rate_score           numeric(6) comment '评分人分数',
   rate_date            date comment '评分时间',
   primary key (id)
);

alter table dir_data_rate comment '数据集评分记录';

/*==============================================================*/
/* Table: dir_data_visit                                        */
/*==============================================================*/
create table dir_data_visit
(
   id                   varchar(36) not null comment 'ID',
   dcm_id               varchar(36) comment '信息资源ID',
   obj_type             varchar(36) comment '浏览对象类型',
   obj_id               varchar(36) comment '浏览对象ID',
   visitor_id           varchar(36) comment '浏览人ID',
   visit_ip             varchar(36) comment '浏览人IP',
   visit_date           date comment '浏览时间',
   primary key (id)
);

alter table dir_data_visit comment '数据集浏览记录';

/*==============================================================*/
/* Table: dir_dataitem                                          */
/*==============================================================*/
create table dir_dataitem
(
   id                   varchar(36) not null comment 'id',
   dataset_id           varchar(36) comment '数据集ID',
   item_code            varchar(128) comment '数据项编号',
   item_name            varchar(128) comment '【国】数据项名称',
   item_desc            varchar(500) comment '数据项描述',
   item_type            varchar(36) comment '【国】数据项类型',
   belong_dept_id       varchar(36) comment '责任部门',
   share_type           varchar(36) comment '共享类型',
   share_method         varchar(36) comment '共享方式',
   share_condition      varchar(500) comment '共享条件',
   no_share_explain     varchar(500) comment '不予共享说明',
   is_open              varchar(36) comment '是否开放',
   open_condition       varchar(500) comment '开放条件',
   update_frequency     varchar(36) comment '更新周期',
   storage_medium       varchar(36) comment '存储介质',
   storage_location     varchar(500) comment '存储位置',
   status               varchar(36) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
);

alter table dir_dataitem comment '数据集对应数据项表【国】';

/*==============================================================*/
/* Table: dir_dataitem_apply                                    */
/*==============================================================*/
create table dir_dataitem_apply
(
   id                   varchar(36) not null comment 'id',
   dcm_id               varchar(36) comment '申请信息资源ID',
   item_id              varchar(36) comment '申请数据项ID',
   applicant_id         varchar(36) comment '申请人ID',
   apply_info           varchar(512) comment '申请详情',
   apply_date           date comment '申请时间',
   auditor_id           varchar(36) comment '审核人',
   status               varchar(36) comment '审核状态',
   audit_opinion        varchar(512) comment '审核意见',
   audit_date           date comment '审核时间',
   primary key (id)
);

alter table dir_dataitem_apply comment '数据项权限申请表';

/*==============================================================*/
/* Table: dir_dataitem_distribute                               */
/*==============================================================*/
create table dir_dataitem_distribute
(
   id                   varchar(36) not null comment 'id',
   dcm_id               varchar(36) comment '分配信息资源ID',
   item_id              varchar(36) comment '分配数据项ID',
   obj_type             varchar(36) comment '分配对象类型',
   obj_id               varchar(36) comment '分配对象ID',
   distributor_id       varchar(36) comment '分配操作人',
   distribute_opinion   varchar(512) comment '分配意见',
   distribute_date      date comment '分配操作时间',
   primary key (id)
);

alter table dir_dataitem_distribute comment '数据项权限分配表';

/*==============================================================*/
/* Table: dir_dataitem_source_info                              */
/*==============================================================*/
create table dir_dataitem_source_info
(
   id                   varchar(36) not null comment 'id',
   item_id              varchar(36) comment '数据项ID',
   source_obj_type      varchar(36) comment '来源对象类型',
   source_obj_id        varchar(36) comment '来源对象ID',
   source__item_id      varchar(36) comment '来源数据项ID',
   primary key (id)
);

alter table dir_dataitem_source_info comment '数据项来源信息表';

/*==============================================================*/
/* Table: dir_dataset                                           */
/*==============================================================*/
create table dir_dataset
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   dataset_code         varchar(64) comment '数据集编码',
   dataset_name         varchar(128) comment '【国】信息资源名称',
   alias                varchar(128) comment '别名',
   belong_dept_id       varchar(36) comment '【国】信息资源提供方ID',
   dataset_desc         varchar(1000) comment '【国】信息资源摘要',
   share_type           varchar(36) comment '【国】信息资源共享类型',
   share_condition      varchar(500) comment '【国】信息资源共享条件',
   share_method         varchar(36) comment '【国】信息资源共享方式',
   is_open              varchar(36) comment '【国】信息资源是否社会开放',
   open_condition       varchar(500) comment '【国】信息资源开放条件',
   update_frequency     varchar(36) comment '【国】信息资源更新周期',
   rel_dataset_code     varchar(36) comment '【国】信息资源关联资源代码',
   storage_medium       varchar(36) comment '存储介质',
   storage_location     varchar(500) comment '物理存储位置',
   data_level           varchar(36) comment '【川】信息资源最小分级单元',
   data_index_system    varchar(36) comment '【川】信息资源指标体系',
   is_secret            varchar(36) comment '【川】信息资源涉密性',
   source_type          varchar(36) comment '添加来源',
   status               varchar(36) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime default CURRENT_TIMESTAMP comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
);

alter table dir_dataset comment '数据集（信息资源）';

/*==============================================================*/
/* Table: dir_dataset_classify_map                              */
/*==============================================================*/
create table dir_dataset_classify_map
(
   id                   varchar(36) not null comment 'id',
   dataset_id           varchar(36) comment '数据集ID',
   classify_id          varchar(36) comment '目录类别ID',
   info_resource_code   varchar(64) comment '【国】信息资源代码',
   register_id          varchar(36) comment '注册人',
   registe_date         date comment '注册时间',
   status               varchar(36) comment '状态',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table dir_dataset_classify_map comment '数据集目录类别关系表';

/*==============================================================*/
/* Table: dir_dataset_ext_carrier                               */
/*==============================================================*/
create table dir_dataset_ext_carrier
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '数据集ID',
   carrier_type         varchar(36) comment '存储载体',
   primary key (id)
);

alter table dir_dataset_ext_carrier comment '数据集扩展信息（【川】基本载体）';

/*==============================================================*/
/* Table: dir_dataset_ext_format                                */
/*==============================================================*/
create table dir_dataset_ext_format
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '数据集ID',
   format_type          varchar(36) comment '资源格式类型',
   format_info          varchar(256) comment '资源格式说明',
   primary key (id)
);

alter table dir_dataset_ext_format comment '数据集扩展信息（【国】资源格式）';

/*==============================================================*/
/* Table: dir_dataset_ext_service_target                        */
/*==============================================================*/
create table dir_dataset_ext_service_target
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '数据集ID',
   service_target       varchar(36) comment '服务对象',
   primary key (id)
);

alter table dir_dataset_ext_service_target comment '数据集扩展信息（【川】服务对象）';

/*==============================================================*/
/* Table: dir_dataset_ext_sevice_field                          */
/*==============================================================*/
create table dir_dataset_ext_sevice_field
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '数据集ID',
   sevice_field_type    varchar(36) comment '服务领域类型',
   service_field_property varchar(36) comment '服务领域',
   primary key (id)
);

alter table dir_dataset_ext_sevice_field comment '数据集扩展信息（【川】服务领域）';

/*==============================================================*/
/* Table: dir_dataset_ext_share_consult                         */
/*==============================================================*/
create table dir_dataset_ext_share_consult
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '数据集ID',
   contact              varchar(64) comment '主管部门联系人',
   contact_phone        varchar(36) comment '主管部门联系电话',
   primary key (id)
);

alter table dir_dataset_ext_share_consult comment '数据集扩展信息（【川】共享咨询）';

/*==============================================================*/
/* Table: dir_dataset_ext_source                                */
/*==============================================================*/
create table dir_dataset_ext_source
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '数据集ID',
   source_type          varchar(36) comment '主要来源',
   primary key (id)
);

alter table dir_dataset_ext_source comment '数据集扩展信息（【川】主要来源）';

/*==============================================================*/
/* Table: dir_dataset_service_map                               */
/*==============================================================*/
create table dir_dataset_service_map
(
   id                   varchar(36) not null comment 'id',
   service_id           varchar(36) comment '服务ID',
   dcm_id               varchar(36) comment '信息资源ID',
   valid_from           date comment '有效期开始',
   valid_to             date comment '有效期结束',
   status               varchar(36) comment '状态',
   primary key (id)
);

alter table dir_dataset_service_map comment '数据集对应接口服务表';

/*==============================================================*/
/* Table: dir_dataset_source_info                               */
/*==============================================================*/
create table dir_dataset_source_info
(
   id                   varchar(36) not null comment 'id',
   dataset_id           varchar(36) comment '数据集ID',
   source_mode          varchar(36) comment '来源模块',
   source_obj_type      varchar(36) comment '来源对象类型',
   source_obj_id        varchar(36) comment '来源对象ID',
   primary key (id)
);

alter table dir_dataset_source_info comment '信息资源来源信息';

/*==============================================================*/
/* Table: dir_dataset_source_relation                           */
/*==============================================================*/
create table dir_dataset_source_relation
(
   id                   varchar(36) not null comment 'id',
   dataset_id           varchar(36) comment '数据集ID',
   source_mode          varchar(36) comment '来源模块',
   source_table_id      varchar(36) comment '关联源表ID',
   source_column_id     varchar(36) comment '关联源表字段ID',
   target_table_id      varchar(36) comment '关联目标表ID',
   target_column_id     varchar(36) comment '关联目标表字段ID',
   relation_type        varchar(36) comment '关联类型',
   relation_ext_info    varchar(512) comment '关联其他信息',
   primary key (id)
);

alter table dir_dataset_source_relation comment '信息资源来源关系表';

/*==============================================================*/
/* Table: dir_develop_apis                                      */
/*==============================================================*/
create table dir_develop_apis
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   api_name             varchar(128) comment 'API名称',
   api_category         varchar(36) comment 'API种类',
   api_url              varchar(128) comment 'URL地址',
   api_desc             varchar(512) comment '描述',
   parent_id            varchar(36) comment '父节点ID',
   parent_name          varchar(128) comment '父节点名称',
   order_number         int(4) comment '排序',
   status               varchar(36) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
);

alter table dir_develop_apis comment '开发者工具';

/*==============================================================*/
/* Table: dir_news                                              */
/*==============================================================*/
create table dir_news
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   title                varchar(256) comment '新闻标题',
   news_pic             varchar(128) comment '新闻图片',
   news_content         text comment '新闻内容',
   publisher            varchar(36) comment '发布人',
   publish_date         date comment '发布时间',
   status               varchar(36) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
);

alter table dir_news comment '新闻表';

/*==============================================================*/
/* Table: dir_policy                                            */
/*==============================================================*/
create table dir_policy
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   source_type          varchar(36) comment '政策来源',
   policy_level         varchar(36) comment '政策级别',
   title                varchar(36) comment '政策标题',
   content              text comment '发布内容',
   publisher            varchar(36) comment '政策发布人',
   publish_date         date comment '发布时间',
   status               varchar(36) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
);

alter table dir_policy comment '政策表';

/*==============================================================*/
/* Table: dir_regist_user                                       */
/*==============================================================*/
create table dir_regist_user
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   login_name           varchar(64) comment '登录用户名',
   real_name            varchar(64) comment '真实姓名',
   email                varchar(64) comment '注册邮箱',
   phone                varchar(64) comment '联系电话',
   belong_dept          varchar(36) comment '所属部门',
   status               varchar(36) comment '状态',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table dir_regist_user comment '用户注册表';

/*==============================================================*/
/* Table: dir_service_info                                      */
/*==============================================================*/
create table dir_service_info
(
   id                   varchar(36) not null comment 'ID',
   service_name         varchar(36) comment '服务名称',
   service_type         varchar(36) comment '服务类型',
   service_url          varchar(500) comment '服务URL',
   request_method       varchar(36) comment '服务请求方式',
   request_format       varchar(36) comment '服务请求格式',
   request_info         mediumtext comment '请求信息',
   operate_date         datetime comment '操作时间',
   primary key (id)
);

alter table dir_service_info comment '发布服务信息表';

/*==============================================================*/
/* Table: dir_special_apps                                      */
/*==============================================================*/
create table dir_special_apps
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   app_category         varchar(36) comment '所属类别',
   app_name             varchar(64) comment '应用名称',
   app_url              varchar(512) comment '应用URL',
   order_number         int(4) comment '排序',
   status               varchar(36) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   primary key (id)
);

alter table dir_special_apps comment '专题应用表';

/*==============================================================*/
/* Table: dir_suggestion                                        */
/*==============================================================*/
create table dir_suggestion
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   title                varchar(256) comment '标题',
   content              varchar(1024) comment '问题详情',
   contact_name         varchar(64) comment '联系人称呼',
   contact_email        varchar(64) comment '联系人邮箱',
   contact_phone        varchar(64) comment '联系人电话',
   submit_date          date comment '提交时间',
   response_content     varchar(1024) comment '回复信息',
   response_date        date comment '回复时间',
   responser            varchar(36) comment '回复人',
   primary key (id)
);

alter table dir_suggestion comment '咨询建议表';

/*==============================================================*/
/* Table: sys_dept                                              */
/*==============================================================*/
create table sys_dept
(
   id                   varchar(36) not null comment 'id',
   region_code          varchar(6) comment '所属行政区域',
   dept_type            varchar(36) comment '组织机构类型',
   dept_code            varchar(64) not null comment '组织机构编码',
   dept_name            varchar(256) not null comment '组织机构名称',
   dept_short_name      varchar(256) comment '组织机构简称',
   dept_alias           varchar(64) comment '组织机构别名',
   listing_name         varchar(64) comment '组织机构挂牌名',
   dept_desc            varchar(512) comment '组织机构描述',
   function_keyword     varchar(256) comment '职能关键字',
   dept_function        varchar(4000) comment '组织机构职能',
   fcode                varchar(64) comment '父组织机构编码',
   fname                varchar(64) comment '父组织机构名称',
   dept_response_man    varchar(36) comment '部门负责人',
   dept_response_phone  varchar(36) comment '部门负责人电话',
   dept_response_email  varchar(64) comment '部门负责人邮箱',
   dept_contact_man     varchar(32) comment '联系人',
   dept_contact_dept    varchar(32) comment '联系人所属部门',
   dept_contact_post    varchar(32) comment '联系人职务',
   dept_contact_phone   varchar(32) comment '联系人手机',
   dept_contact_fixed_phone varchar(32) comment '联系人座机',
   dept_contact_email   varchar(64) comment '联系人邮箱',
   dept_address         varchar(256) comment '组织机构地址',
   org_longitude        varchar(36) comment '组织位置经度',
   org_latitude         varchar(36) comment '组织位置纬度',
   icon                 varchar(256) comment '图标',
   order_number         int(4) comment '排序',
   validate_from        date comment '组织启用时间',
   validate_to          date comment '组织停用时间',
   status               int(3) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   tree_index           int,
   tree_code            varchar(128),
   primary key (id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

alter table sys_dept comment '系统组织机构表';

/*==============================================================*/
/* Table: sys_dept_category_template                            */
/*==============================================================*/
create table sys_dept_category_template
(
   ID                   varchar(36) not null comment 'ID',
   category_code        varchar(36) comment '组织机构类别代码',
   category_name        varchar(36) comment '组织机构类别名称',
   fullname_template    varchar(64) comment '组织机构类别全称模板',
   shortname_template   varchar(64) comment '组织机构类别简称模板',
   apply_min_level      int comment '适用最小行政级别',
   apply_max_level      int comment '适用最大行政级别',
   primary key (ID)
);

alter table sys_dept_category_template comment '组织机构类别模板表';

/*==============================================================*/
/* Table: sys_dict                                              */
/*==============================================================*/
create table sys_dict
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) not null comment '行政区划编号',
   category             varchar(36) comment '类型',
   dict_code            varchar(36) comment '字典编码',
   dict_name            varchar(64) comment '字典名称',
   dict_desc            varchar(512) comment '字典描述',
   parent_code          varchar(36) comment '上级字典编码',
   order_number         int(4) comment '显示顺序',
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
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   operator_id          varchar(36) comment '操作人ID',
   operate_time         timestamp comment '操作时间',
   operate_type         varchar(36) comment '操作类型',
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
   url                  varchar(256) comment '连接地址',
   icon                 varchar(256) comment '图标',
   sort                 int(4) comment '排序',
   menu_type            int(3) comment '类型',
   code                 varchar(36) comment '编码',
   resource_name        varchar(256) comment '资源标识',
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
/* Table: sys_region                                            */
/*==============================================================*/
create table sys_region
(
   id                   varchar(36) not null comment '主键ID',
   region_code          varchar(6) not null comment '行政区划编号',
   region_name          varchar(64) comment '行政区划名称',
   fcode                varchar(36) comment '上级行政区划编号',
   fname                varchar(64) comment '上级行政区划名称',
   first_charact        varchar(32) comment '首字母',
   region_level_code    varchar(32) comment '行政区划级别代码',
   status               varchar(32) comment '状态',
   version_id           varchar(32) comment '版本信息表ID',
   tree_index           int,
   tree_code            varchar(128),
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
   ID                   varchar(36) not null comment 'ID',
   version_code         varchar(6) not null comment '版本号',
   source               varchar(64) comment '版本来源',
   publish_date         varchar(6) comment '版本发布时间',
   apply_desc           varchar(512) comment '版本来源适应说明',
   version_info         varchar(512) comment '版本记录描述',
   validate_from        date comment '版本有效期开始',
   validate_to          date comment '版本有效期结束',
   primary key (ID)
);

alter table sys_region_version comment '行政区划版本记录表';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   varchar(36) not null comment 'id',
   role_type            int(3) not null comment '角色类型',
   role_name            varchar(128) not null comment '角色名称',
   role_desc            varchar(512) comment '角色描述',
   role_level           int(3),
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
   setting_value        varchar(512) not null comment '配置值',
   setting_desc         varchar(512) comment '配置描述',
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

alter table sys_setting comment '系统配置表';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   varchar(36) not null comment 'id',
   region_code          varchar(6) comment '所属行政区划',
   dept_id              varchar(36) comment '所属组织机构',
   user_type            varchar(36) not null comment '用户类型',
   user_name            varchar(64) not null comment '用户名',
   real_name            varchar(36) comment '用户真实姓名',
   password             varchar(36) not null comment '密码',
   telephone_number     varchar(16) comment '电话号码',
   cell_phone_number    varchar(16) comment '手机号码',
   email                varchar(64) comment '邮箱',
   user_img             varchar(125) comment '用户头像',
   user_desc            varchar(512) comment '用户描述',
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

