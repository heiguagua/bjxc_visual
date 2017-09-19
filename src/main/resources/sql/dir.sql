/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/9/18 13:49:32                           */
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

drop table if exists dir_data_registe;

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

drop table if exists drap_activity_doc_map;

drop table if exists drap_activity_rel_depts;

drop table if exists drap_activity_set_map;

drop table if exists drap_activity_system_map;

drop table if exists drap_business_activity;

drop table if exists drap_business_doc;

drop table if exists drap_business_requirement;

drop table if exists drap_data_authority_apply;

drop table if exists drap_data_authority_audit;

drop table if exists drap_data_column_map;

drop table if exists drap_dataset;

drop table if exists drap_dataset_item;

drop table if exists drap_dataset_item_map;

drop table if exists drap_dataset_system_map;

drop table if exists drap_dataset_table_relation;

drop table if exists drap_db_info;

drop table if exists drap_db_system_map;

drop table if exists drap_db_table_column;

drop table if exists drap_db_table_info;

drop table if exists drap_dict_table_column;

drop table if exists drap_dict_table_info;

drop table if exists drap_info_system;

drop table if exists drap_requirement_dataset_map;

drop table if exists drap_requirement_resources;

drop table if exists drap_sx_table_feedback;

drop table if exists drap_system_use_dept;

drop table if exists drap_system_use_info;

drop table if exists sys_dept;

drop table if exists sys_dept_authority;

drop table if exists sys_dept_category_template;

drop table if exists sys_dept_contacts;

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
   classify_index       int default 0 comment '目录类别索引',
   dcm_index            int default 0 comment '信息资源索引',
   order_number         int(4) comment '显示顺序',
   classify_structure_code varchar(256) comment '分类结构编号',
   classify_structure_name varchar(1024) comment '分类结构名称',
   status               varchar(36) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
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
   distributor_id       varchar(36) comment '分配操作人',
   distribute_opinion   varchar(512) comment '分配意见',
   distribute_date      date comment '分配操作时间',
   primary key (id)
);

alter table dir_classify_authority comment '目录类别权限分配表';

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
/* Table: dir_data_registe                                      */
/*==============================================================*/
create table dir_data_registe
(
   id                   varchar(36) not null comment 'ID',
   dcm_id               varchar(36) comment '信息资源ID',
   register_id          varchar(36) comment '注册人',
   registe_date         date comment '注册时间',
   registe_opinion      varchar(500) comment '注册意见',
   primary key (id)
);

alter table dir_data_registe comment '数据注册情况表';

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
   share_method_desc	  varchar(500) comment '【国】信息资源共享方式说明',
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
   format_category      varchar(36) comment '资源格式分类',
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
   obj_type             varchar(36) comment '服务注册对象类型',
   obj_id               varchar(36) comment '服务注册对象ID',
   valid_from           date comment '有效期开始',
   valid_to             date comment '有效期结束',
   status               varchar(36) comment '状态',
   operate_time         datetime comment '服务注册时间',
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
/* Table: drap_activity_doc_map                                 */
/*==============================================================*/
create table drap_activity_doc_map
(
   id                   varchar(36) not null comment 'ID',
   activity_id          varchar(36) comment '业务活动ID',
   doc_id               varchar(36) comment '业务资料ID',
   doc_io_type          varchar(36) comment '资料类型（输入/输出）',
   primary key (id)
);

alter table drap_activity_doc_map comment '业务活动关联资料表';

/*==============================================================*/
/* Table: drap_activity_rel_depts                               */
/*==============================================================*/
create table drap_activity_rel_depts
(
   id                   varchar(36) not null comment 'ID',
   activity_id          varchar(36) comment '业务活动ID',
   dept_id              varchar(36) comment '相关部门ID',
   primary key (id)
);

alter table drap_activity_rel_depts comment '业务活动关联部门表';

/*==============================================================*/
/* Table: drap_activity_set_map                                 */
/*==============================================================*/
create table drap_activity_set_map
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '信息资源ID',
   activity_id          varchar(36) comment '关联业务活动ID',
   primary key (id)
);

alter table drap_activity_set_map comment '信息资源关联业务表';

/*==============================================================*/
/* Table: drap_activity_system_map                              */
/*==============================================================*/
create table drap_activity_system_map
(
   id                   varchar(36) not null comment 'ID',
   activity_id          varchar(36) comment '业务活动ID',
   system_id            varchar(36) comment '关联信息系统ID',
   primary key (id)
);

alter table drap_activity_system_map comment '业务活动关联信息系统表';

/*==============================================================*/
/* Table: drap_business_activity                                */
/*==============================================================*/
create table drap_business_activity
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   belong_dept          varchar(36) comment '所属组织',
   category             varchar(36) comment '业务类型',
   activity_code        varchar(64) comment '业务编码',
   handle_basis         varchar(256) comment '办理依据',
   activity_desc        varchar(1000) comment '业务描述',
   activity_name        varchar(256) comment '业务名称',
   extend_code          varchar(64) comment '扩展编码？',
   short_name           varchar(64) comment '业务简称',
   parent_code          varchar(36) comment '上级业务节点编码',
   parent_guid_activity varchar(36) comment '上级组织指导业务',
   function_keywords    varchar(256) comment '对应职能关键字',
   is_run               varchar(36) comment '是否为具体执行业务',
   service_target       varchar(64) comment '服务对象',
   legal_deploy_dept    varchar(36) comment '法定实施单位',
   actual_deploy_dept   varchar(36) comment '具体实施单位',
   is_cooperate_business varchar(36) comment '是否跨部门联办业务',
   handle_condition     varchar(1000) comment '办理条件',
   handle_result        varchar(1000) comment '办理结果',
   validity_from        date comment '结果有效期开始',
   validity_end         date comment '结果有效期结束',
   is_in_gc             varchar(36) comment '是否进驻政务中心',
   handle_method        varchar(256) comment '办理方式',
   is_open              varchar(36) comment '是否公开',
   charge_standard      varchar(36) comment '收费标准和依据',
   handle_address       varchar(256) comment '办理地点',
   legal_time_limit     varchar(36) comment '法定时限',
   promise_time_limit   varchar(36) comment '承诺时限',
   handler              varchar(36) comment '办理联系人',
   handler_phone        varchar(64) comment '办理联系人电话',
   supervise_phone      varchar(64) comment '监督电话',
   handle_online        varchar(36) comment '是否可网上办理',
   online_address       varchar(256) comment '网上办理网址',
   handle_online_desc   varchar(1000) comment '网上办理说明',
   handle_program       varchar(1000) comment '办理程序',
   handle_flowsheet     varchar(36) comment '办理程序流程图',
   year_business_volume varchar(36) comment '年业务量估计',
   order_by             numeric(6) comment '排序号',
   is_show              int comment '是否显示',
   code_index           int comment '业务编码序号',
   status               int(3) comment '状态',
   create_user_id       varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user_id       varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   delete_flag          int(3) default 0 comment '逻辑删除标识',
   tree_index           int comment '树索引',
   tree_code            varchar(128) comment '树编码',
   primary key (id)
);

alter table drap_business_activity comment '业务活动表';

/*==============================================================*/
/* Table: drap_business_doc                                     */
/*==============================================================*/
create table drap_business_doc
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   belong_dept          varchar(36) comment '所属部门',
   doc_code             varchar(36) comment '资料编码',
   doc_name             varchar(64) comment '资料名称',
   doc_desc             varchar(1000) comment '资料描述',
   category             varchar(36) comment '资料类型',
   doc_sample           varchar(64) comment '材料样本',
   template_flag        int comment '是否资料库',
   code_index           int comment '编码序号',
   create_user          varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table drap_business_doc comment '业务活动资料';

/*==============================================================*/
/* Table: drap_business_requirement                             */
/*==============================================================*/
create table drap_business_requirement
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   requirement_desc     varchar(1000) comment '需求资源描述',
   requre_dept_id       varchar(36) comment '需求组织ID',
   source_dept_id       varchar(36) comment '需求来源组织',
   code_index           int comment '编码序号',
   create_user          varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table drap_business_requirement comment '业务资源需求表';

/*==============================================================*/
/* Table: drap_data_authority_apply                             */
/*==============================================================*/
create table drap_data_authority_apply
(
   id                   varchar(36) not null comment 'ID',
   applicant            varchar(36) comment '申请人ID',
   apply_reason         varchar(512) comment '申请理由',
   apply_time           datetime comment '申请时间',
   primary key (id)
);

alter table drap_data_authority_apply comment '数据权限申请表';

/*==============================================================*/
/* Table: drap_data_authority_audit                             */
/*==============================================================*/
create table drap_data_authority_audit
(
   id                   varchar(36) not null comment 'ID',
   apply_id             varchar(36) comment '申请表ID',
   to_dept_id           varchar(36) comment '数据权限对应部门',
   authority_type       varchar(36) comment '数据权限类型',
   auditor              varchar(36) comment '审核人',
   audit_time           datetime comment '审核时间',
   audit_opinion        varchar(512) comment '审核意见',
   audit_status         varchar(36) comment '审核状态',
   primary key (id)
);

alter table drap_data_authority_audit comment '数据权限审核表';

/*==============================================================*/
/* Table: drap_data_column_map                                  */
/*==============================================================*/
create table drap_data_column_map
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '信息资源ID',
   business_item_id     varchar(36) comment '信息资源表数据项ID',
   system_column_id     varchar(36) comment '数据库表字段ID',
   info_system_id       varchar(36) comment '信息系统ID',
   db_id                varchar(36) comment '数据库ID',
   table_id             varchar(36) comment '数据表ID',
   primary key (id)
);

alter table drap_data_column_map comment '数据项与表字段关系梳理表';

/*==============================================================*/
/* Table: drap_dataset                                          */
/*==============================================================*/
create table drap_dataset
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   belong_dept_id       varchar(36) comment '【国】信息资源提供方ID',
   belong_activity_id   varchar(36) comment '所属业务',
   dataset_code         varchar(36) comment '数据集编号',
   dataset_name         varchar(64) comment '【国】信息资源名称',
   category             varchar(36) comment '业务数据类型',
   sensitive_remark     varchar(36) comment '敏感标识',
   update_frequency     varchar(36) comment '【国】信息资源更新周期',
   dataset_desc         varchar(256) comment '【国】信息资源摘要',
   share_type           varchar(36) comment '【国】信息资源共享类型',
   share_condition_desc varchar(1000) comment '【国】信息资源共享条件',
   share_method         varchar(36) comment '【国】信息资源共享方式',
   share_method_desc    varchar(1000) comment '共享方式说明',
   share_range          varchar(1000) comment '共享范围',
   no_share_reason      varchar(1000) comment '不予共享依据',
   is_open              varchar(36) comment '【国】信息资源是否社会开放',
   open_condition       varchar(36) comment '【国】信息资源开放条件',
   rel_dataset_code     varchar(36) comment '【国】信息资源关联资源代码',
   data_level           varchar(36) comment '【川】信息资源最小分级单元',
   data_index_system    varchar(36) comment '【川】信息资源指标体系',
   is_secret            varchar(36) comment '【川】信息资源涉密性',
   store_media          varchar(36) comment '存储介质',
   physics_store_location varchar(128) comment '物理存储位置',
   扩展编码                 varchar(64) comment '扩展编码',
   code_index           int comment '编码序号',
   create_user          varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table drap_dataset comment '信息资源（数据集）';

/*==============================================================*/
/* Table: drap_dataset_item                                     */
/*==============================================================*/
create table drap_dataset_item
(
   id                   varchar(36) not null comment 'ID',
   item_code            varchar(64) comment '数据项编码',
   item_name            varchar(64) comment '【国】数据项名称',
   item_type            varchar(36) comment '【国】数据项类型',
   item_desc            varchar(1000) comment '数据项描述',
   belong_dept          varchar(36) comment '所属组织',
   sensitive_remark     varchar(36) comment '敏感标识',
   update_frequency     varchar(36) comment '更新频率',
   share_type           varchar(36) comment '共享类型',
   share_range          varchar(1000) comment '共享范围',
   share_method         varchar(36) comment '共享方式',
   share_condition_desc varchar(1000) comment '共享条件说明',
   share_method_desc    varchar(1000) comment '共享方式说明',
   no_share_reason      varchar(1000) comment '不予共享依据',
   is_open              varchar(36) comment '是否开放',
   open_condition       varchar(36) comment '开放条件',
   store_media          varchar(36) comment '存储介质',
   physics_store_location varchar(128) comment '物理存储位置',
   code_index           int comment '编码序号',
   create_user          varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table drap_dataset_item comment '业务数据项【国】';

/*==============================================================*/
/* Table: drap_dataset_item_map                                 */
/*==============================================================*/
create table drap_dataset_item_map
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '数据集ID',
   item_id              varchar(36) comment '数据项ID',
   primary key (id)
);

alter table drap_dataset_item_map comment '数据集数据项关联表';

/*==============================================================*/
/* Table: drap_dataset_system_map                               */
/*==============================================================*/
create table drap_dataset_system_map
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '信息资源ID',
   system_id            varchar(36) comment '信息系统ID',
   primary key (id)
);

alter table drap_dataset_system_map comment '信息资源关联信息系统';

/*==============================================================*/
/* Table: drap_dataset_table_relation                           */
/*==============================================================*/
create table drap_dataset_table_relation
(
   id                   varchar(36) not null comment 'ID',
   dataset_id           varchar(36) comment '业务数据集ID',
   source_table         varchar(64) comment '关联源表名',
   source_column        varchar(64) comment '关联源表字段名',
   target_table         varchar(64) comment '关联目标表名',
   target_column        varchar(64) comment '关联目标表字段名',
   relation_type        varchar(36) comment '关联类型',
   primary key (id)
);

alter table drap_dataset_table_relation comment '信息资源梳理表关系记录表';

/*==============================================================*/
/* Table: drap_db_info                                          */
/*==============================================================*/
create table drap_db_info
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   belong_dept          varchar(36) comment '所属组织',
   db_code              varchar(36) comment '数据库编码',
   db_cn_name           varchar(36) comment '数据库中文名称',
   category             varchar(36) comment '数据库类型',
   db_type              varchar(36) comment '数据库小类',
   db_name              varchar(64) comment '数据库英文名称',
   version              varchar(64) comment '版本号',
   ip_address           varchar(128) comment '数据库IP地址',
   port                 varchar(36) comment '数据库端口号',
   sid                  varchar(64) comment '实例名',
   service_name         varchar(64) comment '服务名',
   param1               varchar(64) comment '参数1',
   param2               varchar(64) comment '参数2',
   param3               varchar(64) comment '参数3',
   param4               varchar(64) comment '参数4',
   param5               varchar(64) comment '参数5',
   cur_storage          numeric(12) comment '当前数据存储量',
   month_increment      numeric(8) comment '每月数据增量',
   year_increment       numeric(8) comment '年增量',
   is_backup            int comment '是否备份',
   backup_desc          varchar(36) comment '备份说明',
   network              varchar(36) comment '所属网络',
   room_addr            varchar(256) comment '所属机房地址',
   user_name            varchar(64) comment '用户名',
   password             varchar(64) comment '密码',
   order_by             numeric(6) comment '排序号',
   is_show              int comment '是否显示',
   delete_flag          int(1) comment '删除标志',
   code_index           int comment '编码序号',
   cur_connect_status   varchar(36) comment '本次连接状态',
   cur_update_status    varchar(36) comment '本次更新状态',
   cur_monitor_time     datetime comment '本次监控时间',
   create_user          varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table drap_db_info comment '数据库信息';

/*==============================================================*/
/* Table: drap_db_system_map                                    */
/*==============================================================*/
create table drap_db_system_map
(
   id                   varchar(36) not null comment 'ID',
   db_id                varchar(36) comment '数据库ID',
   info_system_id       varchar(36) comment '信息系统ID',
   primary key (id)
);

alter table drap_db_system_map comment '数据库业务系统关系表';

/*==============================================================*/
/* Table: drap_db_table_column                                  */
/*==============================================================*/
create table drap_db_table_column
(
   id                   varchar(36) not null comment 'ID',
   table_id             varchar(36) comment '数据表ID',
   column_code          varchar(64) comment '字段编码',
   column_cn_name       varchar(64) comment '字段中文名',
   default_value        varchar(64) comment '默认值',
   column_length        numeric(6) comment '字段长度',
   column_en_name       varchar(64) comment '字段英文名',
   is_business_data     int comment '是否业务数据',
   is_pk                int comment '是否为主键',
   is_null              int comment '是否为空',
   column_type          varchar(36) comment '字段类型',
   sensitive_remark     varchar(36) comment '敏感标识',
   update_frequency     varchar(36) comment '更新频率',
   column_desc          varchar(256) comment '字段描述',
   data_precision       varchar(36) comment '字段数据精度',
   code_index           int comment '编码序号',
   primary key (id)
);

alter table drap_db_table_column comment '数据表字段信息';

/*==============================================================*/
/* Table: drap_db_table_info                                    */
/*==============================================================*/
create table drap_db_table_info
(
   id                   varchar(36) not null comment 'ID',
   db_id                varchar(36) comment '数据库ID',
   table_type           varchar(64) comment '数据表类型',
   table_code           varchar(36) comment '数据表编号',
   table_name           varchar(64) comment '数据表英文名称',
   table_cn_name        varchar(64) comment '数据表中文名称',
   table_desc           varchar(256) comment '数据表描述',
   code_index           int comment '编码序号',
   primary key (id)
);

alter table drap_db_table_info comment '数据表信息';

/*==============================================================*/
/* Table: drap_dict_table_column                                */
/*==============================================================*/
create table drap_dict_table_column
(
   id                   varchar(36) not null comment 'ID',
   table_id             varchar(36) comment '数据表ID',
   column_code          varchar(64) comment '字段编码',
   column_cn_name       varchar(64) comment '字段中文名',
   default_value        varchar(64) comment '默认值',
   column_length        numeric(6) comment '字段长度',
   column_en_name       varchar(64) comment '字段英文名',
   is_business_data     int comment '是否业务数据',
   is_pk                int comment '是否为主键',
   is_null              int comment '是否为空',
   column_type          varchar(36) comment '字段类型',
   sensitive_remark     varchar(36) comment '敏感标识',
   update_frequency     varchar(36) comment '更新频率',
   column_desc          varchar(256) comment '字段描述',
   data_precision       varchar(36) comment '字段数据精度',
   code_index           int comment '编码序号',
   primary key (id)
);

alter table drap_dict_table_column comment '字典导入数据表字段信息';

/*==============================================================*/
/* Table: drap_dict_table_info                                  */
/*==============================================================*/
create table drap_dict_table_info
(
   id                   varchar(36) not null comment 'ID',
   db_id                varchar(36) comment '数据库ID',
   table_type           varchar(64) comment '数据表类型',
   table_code           varchar(36) comment '数据表编号',
   table_name           varchar(64) comment '数据表英文名称',
   table_cn_name        varchar(64) comment '数据表中文名称',
   table_desc           varchar(256) comment '数据表描述',
   code_index           int comment '编码序号',
   table_source_type    varchar(36) comment '表来源',
   real_table_id        varchar(36) comment '对应实际数据表ID',
   primary key (id)
);

alter table drap_dict_table_info comment '字典导入数据表信息';

/*==============================================================*/
/* Table: drap_info_system                                      */
/*==============================================================*/
create table drap_info_system
(
   id                   varchar(36) not null comment 'ID',
   region_code          varchar(6) comment '所属行政区划',
   system_code          varchar(36) comment '业务系统编码',
   system_name          varchar(64) comment '业务系统名称',
   system_phase         varchar(36) comment '系统阶段',
   system_phase_desc    varchar(1000) comment '系统阶段补充说明',
   main_feature         varchar(1000) comment '主要功能',
   main_data            varchar(1000) comment '主要数据',
   enable_time          date comment '启用时间',
   disable_time         date comment '停用时间',
   system_level         varchar(256) comment '系统归属级别(建设性质)',
   belong_network       varchar(256) comment '系统所属网络',
   phisical_location    varchar(256) comment '系统物理位置',
   create_dept          varchar(36) comment '录入单位',
   self_build_flag      varchar(36) comment '是否本地部门建设',
   build_dept           varchar(36) comment '系统建设单位',
   system_structure     varchar(36) comment '系统架构',
   login_type           varchar(36) comment '系统登录方式',
   system_usage_info    varchar(36) comment '系统应用情况',
   system_usage_desc    varchar(1000) comment '系统应用情况说明',
   support_company      varchar(64) comment '系统开发商',
   support_contacts     varchar(64) comment '系统开发商联系人',
   support_contacts_phone varchar(64) comment '系统开发商联系人电话',
   support_contacts_email varchar(128) comment '系统开发商联系人邮箱',
   support_other_contacts varchar(64) comment '系统开发商其他联系方式',
   maintain_dept        varchar(64) comment '运维单位',
   maintain_contacts    varchar(64) comment '运维单位联系人',
   maintain_contacts_phone varchar(64) comment '运维单位联系人电话',
   maintain_contacts_email varchar(64) comment '运维单位联系人邮箱',
   maintain_other_contacts varchar(64) comment '运维单位其他联系方式',
   customer_service_info varchar(1000) comment '系统售后支持情况',
   data_range_begin     varchar(100) comment '数据跨度起',
   data_range_end       varchar(100) comment '数据跨度止',
   calculate_date       date comment '存储量统计截止时间',
   data_storage         numeric(8) comment '数据存储量',
   year_increment       numeric(8) comment '数据年增长量',
   visit_url            varchar(256) comment '通用访问地址',
   visit_username       varchar(64) comment '通用访问账号',
   visit_password       varchar(64) comment '通用访问密码',
   has_interface        varchar(36) comment '是否提供服务接口',
   is_online_external   varchar(36) comment '是否有在线对外业务',
   is_service_called    varchar(36) comment '是否提供服务调用',
   is_service_standard  varchar(36) comment '是否提供服务调用规范说明',
   is_export            varchar(36) comment '是否有导出功能',
   has_old_system       varchar(36) comment '是否有旧系统',
   old_system_name      varchar(36) comment '旧系统名称',
   old_system_desc      varchar(1000) comment '旧系统补充说明',
   system_desc          varchar(1000) comment '系统功能描述',
   code_index           int comment '编码序号',
   create_user          varchar(36) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          varchar(36) comment '更新人',
   update_time          datetime comment '更新时间',
   primary key (id)
);

alter table drap_info_system comment '信息系统表';

/*==============================================================*/
/* Table: drap_requirement_dataset_map                          */
/*==============================================================*/
create table drap_requirement_dataset_map
(
   id                   varchar(36) not null comment 'ID',
   require_id           varchar(36) comment '需求ID',
   dataset_id           varchar(36) comment '数据集ID',
   primary key (id)
);

alter table drap_requirement_dataset_map comment '需求和数据集关联表';

/*==============================================================*/
/* Table: drap_requirement_resources                            */
/*==============================================================*/
create table drap_requirement_resources
(
   id                   varchar(36) not null comment 'ID',
   require_id           varchar(36) comment '需求ID',
   require_code         varchar(64) comment '需求编号',
   require_name         varchar(64) comment '需求资源名称',
   requirement_desc     varchar(1000) comment '需求资源描述',
   brace_activity_id    varchar(36) comment '支撑业务ID',
   is_get               varchar(36) comment '是否已获取',
   expect_get_type      varchar(36) comment '期望获取方式',
   source_type          varchar(36) comment '需求来源方式（选择、填写）',
   require_type         varchar(36) comment '需求类型',
   require_remark       varchar(512) comment '需求资源备注',
   other_info           varchar(512) comment '其他信息',
   expect_update_frequence varchar(36) comment '期望更新频率',
   primary key (id)
);

alter table drap_requirement_resources comment '需求资源信息表';

/*==============================================================*/
/* Table: drap_sx_table_feedback                                */
/*==============================================================*/
create table drap_sx_table_feedback
(
   id                   varchar(36) not null comment 'ID',
   collection_id        varchar(36) comment '？采集ID',
   db_id                varchar(36) comment '数据库ID',
   table_id             varchar(36) comment '表ID',
   result_info          varchar(1024) comment '采集状态',
   message_info         varchar(1024) comment '采集结果说明',
   access_time          datetime comment '接收数据时间',
   primary key (id)
);

alter table drap_sx_table_feedback comment '数据表反馈记录(淞幸)';

/*==============================================================*/
/* Table: drap_system_use_dept                                  */
/*==============================================================*/
create table drap_system_use_dept
(
   id                   varchar(36) not null comment 'ID',
   system_id            varchar(36) comment '系统ID',
   dept_id              varchar(36) comment '使用单位ID',
   primary key (id)
);

alter table drap_system_use_dept comment '信息系统使用单位';

/*==============================================================*/
/* Table: drap_system_use_info                                  */
/*==============================================================*/
create table drap_system_use_info
(
   id                   varchar(36) not null comment 'ID',
   info_system_id       varchar(36) comment '信息系统ID',
   visit_url            varchar(256) comment '系统访问地址',
   username             varchar(256) comment '系统访问账号',
   password             varchar(64) comment '系统访问密码',
   belong_dept          varchar(36) comment '分配部门',
   start_use_date       date comment '开始使用日期',
   use_frequence        varchar(36) comment '使用频率',
   key_business         varchar(256) comment '关键业务',
   code_index           int comment '编码序号',
   primary key (id)
);

alter table drap_system_use_info comment '信息系统使用信息';

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
   dept_listing_name    varchar(64) comment '组织机构挂牌名',
   dept_desc            varchar(512) comment '组织机构描述',
   function_keyword     varchar(256) comment '职能关键字',
   dept_function        varchar(4000) comment '组织机构职能',
   fcode                varchar(64) comment '父组织机构编码',
   fname                varchar(64) comment '父组织机构名称',
   dept_structure_name  varchar(512) comment '组织机构结构名称',
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
   tree_index           int default 0 comment '树索引',
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
   primary key (id)
);

alter table sys_dept_authority comment '部门数据权限分配表';

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
   first_charact        varchar(36) comment '首字母',
   region_level_code    varchar(36) comment '行政区划级别代码',
   status               varchar(36) default '1' comment '状态',
   version_id           varchar(36) comment '版本信息表ID',
   primary key (id)
);

alter table sys_region comment '行政区域表';

/*==============================================================*/
/* Index: region_code_index                                     */
/*==============================================================*/
/*drop index region_fcode_index on sys_region;

drop index region_code_index on sys_region;

create index region_code_index on sys_region
(
   region_code
);

*//*==============================================================*//*
*//* Index: region_fcode_index                                    *//*
*//*==============================================================*//*
create index region_fcode_index on sys_region
(
   fcode
);*/

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
   role_type            int(3) not null comment '角色类型',
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

