  delete from sys_menu;
  delete from sys_role;
  delete from sys_role_menu;
  delete from sys_user;
  delete from sys_user_role;
  delete from sys_setting;

  delete from sys_region;
  delete from sys_region_version;
  delete from sys_region_level;
  delete from sys_dept_category_template;
  delete from sys_dept;
  delete from sys_guid_dept;
  delete from sys_dict_category;
  delete from sys_dict;
  delete from sys_user;
-- 菜单表
  INSERT INTO `sys_menu` VALUES ('0818e1c76bbd44eba3a698547ec4e637', '查询系统设置', '10', null, null, '0', '3', '010600', 'system:setting:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('0c9b5fc8b44b41d1871a8fc8300247ec', '删除菜单', '4', null, null, '4', '3', '010303', 'system:menu:delete', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', null, 'fa fa-cogs', '10', '1', '01', 'system', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('10', '系统配置', '1', '/system/setting', ' fa-cog', '6', '2', '0106', 'system:setting', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('1db9105008404a3485b6fac30dba3c0e', '查看角色列表', '3', null, null, '0', '3', '010200', 'system:role:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:33:50', '0');
  INSERT INTO `sys_menu` VALUES ('2', '用户管理', '1', '/system/user', 'fa-user-circle-o', '1', '2', '0101', 'system:user', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('22e38e885f9b40b9aae6a36deb78e89c', '组织机构管理', '1', '/system/dept', 'fa-graduation-cap', '4', '2', '0104', 'system:dept', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('3', '角色管理', '1', '/system/role', 'fa-users', '2', '2', '0102', 'system:role', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('363a778e78a346a68210b2590163a943', '编辑组织机构', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '2', '3', '010402', 'system:dept:edit', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('3f26102ef0e04c3c9328cb97067cc5fa', '创建菜单', '4', null, null, '1', '3', '010301', 'system:menu:add', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('3fb6a7a5935b4efabf3de82e7e1baeb6', '新增组织机构', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '1', '3', '010401', 'system:dept:add', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('4', '菜单管理', '1', '/system/menu', 'fa-list', '3', '2', '0103', 'system:menu', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('4253190001c1480fb0d631d64d150535', '编辑用户', '2', null, null, '2', '3', '010102', 'system:user:edit', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:31:01', '0');
  INSERT INTO `sys_menu` VALUES ('42dd5ae31e3a43b3a197440e8ec19a94', '监控列表', 'f5a20c82110b4a3ea9e30ca01a038680', null, null, '1', '3', '010701', 'system:monitor:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('488ef1eff57b4827acade7c0744278ce', '查看菜单列表', '4', null, null, '0', '3', '010300', 'system:menu:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('4e816a9854714d24b0413d929d637a2b', '查看组织机构列表', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '0', '3', '010400', 'system:dept:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('5', '业务日志', '1', '/system/log', 'fa-info-circle', '5', '2', '0105', 'system:log', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('5d3dd56c16ff4e32aecae1b3228159c7', '查看日志列表', '5', null, null, '0', '3', '010500', 'system:log:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('60dda993d87647f5989c15f14f866df9', '新增角色', '3', null, null, '1', '3', '010201', 'system:role:add', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:34:01', '0');
  INSERT INTO `sys_menu` VALUES ('649b484b58414d91aefa5a26143e6557', '删除用户', '2', null, null, '3', '3', '010103', 'system:user:delete', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:31:20', '0');
  INSERT INTO `sys_menu` VALUES ('686630c7cb624cc786dcdc9958971a6b', '编辑角色', '3', null, null, '2', '3', '010202', 'system:role:edit', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:34:10', '0');
  INSERT INTO `sys_menu` VALUES ('79d78b8357174cac8f44abd275dec597', '删除组织机构', '22e38e885f9b40b9aae6a36deb78e89c', null, null, '3', '3', '010403', 'system:dept:delete', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('915c309ebe5047b68645b3eb777dd8c9', '操作系统设置', '10', null, null, '1', '3', '010601', 'system:setting:edit', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('a5ebf29168234406939856bc6890c86b', '角色授权', '3', null, null, '4', '3', '010204', 'system:role:auth', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:34:45', '0');
  INSERT INTO `sys_menu` VALUES ('a73802e513cc4465883530ec8074abbb', '新增用户', '2', null, null, '1', '3', '010101', 'system:user:add', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:30:22', '0');
  INSERT INTO `sys_menu` VALUES ('b4e7232189b14cf3ba160cf7b0d3bf37', '删除角色', '3', null, null, '3', '3', '010203', 'system:role:delete', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:34:27', '0');
  INSERT INTO `sys_menu` VALUES ('d2bc30feb5474a1bb7e02d48d39a3f8a', '查看用户列表', '2', null, null, '0', '3', '010100', 'system:user:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:28:01', '0');
  INSERT INTO `sys_menu` VALUES ('dc5f478d98ed4297a8ae638fe90df050', '编辑菜单', '4', null, null, '3', '3', '010302', 'system:menu:edit', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('f5a20c82110b4a3ea9e30ca01a038680', '系统监控', '1', '/system/monitor', 'fa-eye', '7', '2', '0107', 'system:monitor', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('f899f3d3baec4571b1c786717f9906fd', '批量删除角色', '3', null, null, '5', '3', '010205', 'system:role:deleteBatch', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', '549d321508db446e9bcaa477835fe5f1', '2017-05-18 17:35:08', '0');

  INSERT INTO `sys_menu` VALUES ('201', '目录管理', '0', null, 'fa fa-cogs', '1', '1', '02', 'catalog', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('20101', '目录类别', '201', '/catalog/classify', 'fa-cog', '1', '2', '0201', 'catalog:classify', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010101', '查看目录类别列表', '20101', null, null, '1', '3', '020101', 'catalog:classify:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010102', '新增目录类别', '20101', null, null, '2', '3', '020102', 'catalog:classify:add', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010103', '修改目录类别', '20101', null, null, '3', '3', '020103', 'catalog:classify:edit', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010104', '删除目录类别', '20101', null, null, '4', '3', '020104', 'catalog:classify:delete', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');

  INSERT INTO `sys_menu` VALUES ('20102', '目录编目', '201', '/catalog/catalogue', 'fa-cog', '2', '2', '0202', 'catalog:catalogue', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010201', '查看目录列表', '20102', null, null, '1', '3', '020201', 'catalog:catalogue:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010202', '自定义新增目录', '20102', null, null, '2', '3', '020202', 'catalog:catalogue:add', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010203', '快速新增目录', '20102', null, null, '3', '3', '020202', 'catalog:catalogue:fastAdd', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010204', '修改目录', '20102', null, null, '4', '3', '020203', 'catalog:catalogue:edit', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010205', '删除目录', '20102', null, null, '5', '3', '020204', 'catalog:catalogue:delete', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');

  INSERT INTO `sys_menu` VALUES ('20103', '目录注册', '201', '/catalog/register', 'fa-cog', '3', '2', '0203', 'catalog:register', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010301', '查看目录列表', '20103', null, null, '1', '3', '020301', 'catalog:register:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010302', '注册', '20103', null, null, '2', '3', '020302', 'catalog:register:save', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');

  INSERT INTO `sys_menu` VALUES ('20104', '目录审核', '201', '/catalog/audit', 'fa-cog', '4', '2', '0204', 'catalog:audit', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010401', '查看目录列表', '20104', null, null, '1', '3', '020401', 'catalog:audit:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010402', '审核', '20104', null, null, '2', '3', '020402', 'catalog:audit:save', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');

  INSERT INTO `sys_menu` VALUES ('20105', '目录发布', '201', '/catalog/release', 'fa-cog', '5', '2', '0205', 'catalog:release', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010501', '查看待发布目录列表', '20105', null, null, '1', '3', '020501', 'catalog:release:unReleaseList', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010502', '审核驳回', '20105', null, null, '2', '3', '020502', 'catalog:release:audit', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010503', '发布', '20105', null, null, '3', '3', '020503', 'catalog:release:save', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010504', '查看已发布目录列表', '20105', null, null, '4', '3', '020504', 'catalog:release:releasedList', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010505', '下架', '20105', null, null, '5', '3', '020505', 'catalog:release:off', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');

  INSERT INTO `sys_menu` VALUES ('20106', '目录查询', '201', '/catalog/query', 'fa-cog', '6', '2', '0206', 'catalog:query', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');
  INSERT INTO `sys_menu` VALUES ('2010601', '查看目录列表', '20106', null, null, '1', '3', '020601', 'catalog:query:list', '1', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 14:03:42', null, null, '0');

  INSERT INTO `sys_menu` VALUES ('ac760cad5be946af907e456b28b85059', '配置管理', '0', NULL, 'fa-list', '7', '1', '08', 'system', '1', '09f4fef9249c457ca67b4a7a45823730', '2017-09-13 11:16:57', '549d321508db446e9bcaa477835fe5f1', '2017-09-13 11:20:17', '0');
  INSERT INTO `sys_menu` VALUES ('533293eab1d2486895a30543c841c12d', '政策发布', 'ac760cad5be946af907e456b28b85059', '/dirPolicy', 'fa-cog', '1', '2', '0801', NULL, NULL, '09f4fef9249c457ca67b4a7a45823730', '2017-09-13 15:10:54', NULL, NULL, '0');

-- 龚均
INSERT INTO `sys_menu` (`id`, `menu_name`, `pid`, `url`, `icon`, `sort`, `menu_type`, `code`, `resource_name`, `status`, `create_user_id`, `create_time`, `update_user_id`, `update_time`, `delete_flag`)
  VALUES ('228789199c1642747ccf530e6c6a1278', '用户注册管理', '95488536f1004e738f1796a923902d4f', '', 'fa-cog', 5, 2, '0406', 'system', 1, '09f4fef9249c457ca67b4a7a45823730', '2017-9-13 12:22:47', '549d321508db446e9bcaa477835fe5f1', '2017-9-13 12:32:36', 0);
INSERT INTO `sys_menu` (`id`, `menu_name`, `pid`, `url`, `icon`, `sort`, `menu_type`, `code`, `resource_name`, `status`, `create_user_id`, `create_time`, `update_user_id`, `update_time`, `delete_flag`)
  VALUES ('228789199c1642748aaf530e6c6a1278', '政策发布', '95488536f1004e738f1796a923902d4f', '', 'fa-cog', 3, 2, '0404', 'system', 1, '09f4fef9249c457ca67b4a7a45823730', '2017-9-13 12:22:47', '549d321508db446e9bcaa477835fe5f1', '2017-9-13 12:32:36', 0);
INSERT INTO `sys_menu` (`id`, `menu_name`, `pid`, `url`, `icon`, `sort`, `menu_type`, `code`, `resource_name`, `status`, `create_user_id`, `create_time`, `update_user_id`, `update_time`, `delete_flag`)
  VALUES ('228789199c1642749a9f530e6c6a1278', '用户咨询', '95488536f1004e738f1796a923902d4f', '/feedback/dirsuggestion', 'fa-cog', 4, 2, '0405', 'system', 1, '09f4fef9249c457ca67b4a7a45823730', '2017-9-13 12:22:47', '549d321508db446e9bcaa477835fe5f1', '2017-9-13 12:32:36', 0);
INSERT INTO `sys_menu` (`id`, `menu_name`, `pid`, `url`, `icon`, `sort`, `menu_type`, `code`, `resource_name`, `status`, `create_user_id`, `create_time`, `update_user_id`, `update_time`, `delete_flag`)
  VALUES ('421546178fda40f79601e2d3d77866d7', '评分管理', '95488536f1004e738f1796a923902d4f', '/feedback/dirdatarate', 'fa-cog', 2, 2, '0403', 'system', 1, '09f4fef9249c457ca67b4a7a45823730', '2017-9-13 12:21:35', '549d321508db446e9bcaa477835fe5f1', '2017-9-13 12:32:39', 0);
INSERT INTO `sys_menu` (`id`, `menu_name`, `pid`, `url`, `icon`, `sort`, `menu_type`, `code`, `resource_name`, `status`, `create_user_id`, `create_time`, `update_user_id`, `update_time`, `delete_flag`)
  VALUES ('95488536f1004e738f1796a923902d4f', '门户管理', '0', NULL, 'fa fa-cogs', 4, 1, '04', 'system', 1, '09f4fef9249c457ca67b4a7a45823730', '2017-9-13 11:17:27', '09f4fef9249c457ca67b4a7a45823730', '2017-9-18 15:13:49', 0);
INSERT INTO `sys_menu` (`id`, `menu_name`, `pid`, `url`, `icon`, `sort`, `menu_type`, `code`, `resource_name`, `status`, `create_user_id`, `create_time`, `update_user_id`, `update_time`, `delete_flag`)
  VALUES ('a0dff3fab9124dc5877577a4aa65dae3', '纠错管理', '95488536f1004e738f1796a923902d4f', '/feedback/dirdatacorrection', 'fa-cog', 1, 2, '0402', 'system', 1, '09f4fef9249c457ca67b4a7a45823730', '2017-9-13 12:21:01', '549d321508db446e9bcaa477835fe5f1', '2017-9-13 12:32:43', 0);
INSERT INTO `sys_menu` (`id`, `menu_name`, `pid`, `url`, `icon`, `sort`, `menu_type`, `code`, `resource_name`, `status`, `create_user_id`, `create_time`, `update_user_id`, `update_time`, `delete_flag`)
  VALUES ('da07a894c55944acb1862804410dc352', '收藏管理', '95488536f1004e738f1796a923902d4f', '/feedback/dirdatacollection', 'fa-cog', 0, 2, '0401', 'system', 1, '09f4fef9249c457ca67b4a7a45823730', '2017-9-13 12:19:26', '549d321508db446e9bcaa477835fe5f1', '2017-9-13 12:32:46', 0);
-- 熊章亮
INSERT INTO `sys_menu` VALUES ('111111a', '开发者工具管理', 'ac760cad5be946af907e456b28b85059', '/dirDevelopApis', 'fa-cog', '2', '2', '0802', NULL, NULL, '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', NULL, NULL, '0');
INSERT INTO `sys_menu` VALUES ('222222a', '专题应用管理', 'ac760cad5be946af907e456b28b85059', '/dirSpecialApps', 'fa-cog', '3', '2', '0803', NULL, NULL, '549d321508db446e9bcaa477835fe5f1', '2017-05-17 14:03:42', NULL, NULL, '0');



-- 角色表
  INSERT INTO `sys_role` VALUES ('737933bffef640329a4f864c4e2746ba', '1', '超级管理员', '超级管理员', -1,1, '549d321508db446e9bcaa477835fe5f1', '2017-05-08 17:18:19', null, null, 0);
-- 用户表
  insert into sys_user (id,region_code,dept_id,user_type,user_name,real_name,password,status)
    values ('09f4fef9249c457ca67b4a7a45823730','510000','','1','admin','超级管理员','96e79218965eb72c92a549dd5a330112','1');

-- 角色菜单表
  INSERT INTO `sys_role_menu` SELECT UUID() AS id,(SELECT id FROM sys_role WHERE role_name='超级管理员') AS role_id, id AS menu_id FROM sys_menu;

-- 用户角色表
  insert into sys_user_role(id,user_id,role_id)
    values (REPLACE(uuid(),'-',''),'09f4fef9249c457ca67b4a7a45823730','737933bffef640329a4f864c4e2746ba');

-- 系统配置表
  INSERT INTO `sys_setting` VALUES ('1', '', '1', 'systemName', '系统名称', '数据采集系统', null, '1', null, null, null, null, 0);
  INSERT INTO `sys_setting` VALUES ('2', '', '1', 'systemSubName', '系统简称', 'DCM', null, '1', null, null, null, null, 0);
  INSERT INTO `sys_setting` VALUES ('3', '', '1', 'bottomCopyright', '许可说明', 'Copyright © 2017 勤智数码. All rights reserved.', null, '1', null, null, null, null, 0);
  INSERT INTO `sys_setting` VALUES ('4', '', '1', 'crawlerInterface', '爬虫接口地址', 'http://127.0.0.1:8080/crawler/wbsiteStore', '', '1', '549d321508db446e9bcaa477835fe5f1', '2017-06-27 10:46:53', null, null, '0');

-- 系统字典分类表
  INSERT INTO `sys_dict_category` VALUES ('001', '', null);
  INSERT INTO `sys_dict_category` VALUES ('appRequirementNameSource', '需求名称来源', null);
  INSERT INTO `sys_dict_category` VALUES ('belongSystem', '系统所属网络', null);
  INSERT INTO `sys_dict_category` VALUES ('businessRequirementNameSource', '需求名称来源', null);
  INSERT INTO `sys_dict_category` VALUES ('categoryApp', '专题应用类型', null);
  INSERT INTO `sys_dict_category` VALUES ('contactsType', '联络人性质', null);
  INSERT INTO `sys_dict_category` VALUES ('dataSetIsOpen', '业务数据集管理-是否可开放', null);
  INSERT INTO `sys_dict_category` VALUES ('dataSetShareMethod', '业务数据集管理-共享方式', null);
  INSERT INTO `sys_dict_category` VALUES ('dataSetShareType', '业务数据集共享类型', null);
  INSERT INTO `sys_dict_category` VALUES ('dataSetStoreMedia', '业务数据集管理-存储介质', null);
  INSERT INTO `sys_dict_category` VALUES ('dataSetType', '业务数据集类型', null);
  INSERT INTO `sys_dict_category` VALUES ('dbCategory', '数据库管理-数据库大分类', null);
  INSERT INTO `sys_dict_category` VALUES ('dbType', '数据库管理-数据库类型', null);
  INSERT INTO `sys_dict_category` VALUES ('goldProjecty', '十二金工程类型', null);
  INSERT INTO `sys_dict_category` VALUES ('interfaceAble', '是否提供接口服务', null);
  INSERT INTO `sys_dict_category` VALUES ('isExplain', '是否提供调用规范说明', null);
  INSERT INTO `sys_dict_category` VALUES ('isLoacl', '是否是本地部门建设', null);
  INSERT INTO `sys_dict_category` VALUES ('isOutPut', '是否有导出功能', null);
  INSERT INTO `sys_dict_category` VALUES ('isUseAble', '是否提供服务调用', null);
  INSERT INTO `sys_dict_category` VALUES ('oldSystem', '是否有旧系统', null);
  INSERT INTO `sys_dict_category` VALUES ('onLineBussnines', '是否提供在线对外在线服务', null);
  INSERT INTO `sys_dict_category` VALUES ('ordinary', '通用字典', null);
  INSERT INTO `sys_dict_category` VALUES ('requirementExpectGetType', '业务需求-期望获取方式', null);
  INSERT INTO `sys_dict_category` VALUES ('requirementExpectUpdateFrequence', '业务需求-数据使用频率', null);
  INSERT INTO `sys_dict_category` VALUES ('requirementNameSource', '需求名称来源', null);
  INSERT INTO `sys_dict_category` VALUES ('sensitive', '业务数据集的数据项-敏感标识', null);
  INSERT INTO `sys_dict_category` VALUES ('serviceTarget', '业务管理服务对象', null);
  INSERT INTO `sys_dict_category` VALUES ('setItemFrequency', '业务数据集的数据项-更新周期', null);
  INSERT INTO `sys_dict_category` VALUES ('setItemIsOpen', '业务数据集的数据项-是否可开放', null);
  INSERT INTO `sys_dict_category` VALUES ('setItemSetType', '业务数据集的数据项-业务数据集类型', null);
  INSERT INTO `sys_dict_category` VALUES ('setItemShareMethod', '业务数据集的数据项-共享方式', null);
  INSERT INTO `sys_dict_category` VALUES ('setItemStoreLocation', '业务数据集的数据项-物理存储位置', null);
  INSERT INTO `sys_dict_category` VALUES ('setItemStoreMedia', '业务数据集的数据项-存储介质', null);
  INSERT INTO `sys_dict_category` VALUES ('systemArchitecture', '系统架构', null);
  INSERT INTO `sys_dict_category` VALUES ('systemConstructionProperty', '系统建设性质', null);
  INSERT INTO `sys_dict_category` VALUES ('systemDeploymentLocation', '系统-部署位置', null);
  INSERT INTO `sys_dict_category` VALUES ('systemLevel', '系统级别', null);
  INSERT INTO `sys_dict_category` VALUES ('systemNet', '系统网络', null);
  INSERT INTO `sys_dict_category` VALUES ('systemStage', '系统阶段', null);
  INSERT INTO `sys_dict_category` VALUES ('systemStatus', '系统应用情况', null);

-- 系统字典表
  INSERT INTO `sys_dict` VALUES ('10', '', 'systemLevel', '0', '产生的', null, null, null, '1', null, '2017-06-27 17:28:28', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('100', '', 'systemLevel', '4', '产生的', null, null, null, '1', null, '2017-06-28 19:34:25', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('101', '', 'systemLevel', '4', '产生的', null, null, null, '1', null, '2017-04-29 19:45:06', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('102', '', 'systemLevel', '5', '产生的', null, null, null, '1', null, '2017-06-28 19:33:03', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('103', '', 'belongSystem', '1', '专网', null, null, null, '1', null, '2017-04-29 19:36:45', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('104', '', 'belongSystem', '2', '电子政务外网', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('105', '', 'belongSystem', '3', '电子政务内网', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('106', '', 'belongSystem', '4', '互联网', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('107', '', 'isLoacl', '0', '否', null, null, null, '1', null, '2017-06-27 16:21:02', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('108', '', 'isLoacl', '1', '是', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('109', '', 'systemArchitecture', '1', 'B/S', null, null, null, '1', null, '2017-07-03 14:31:50', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('11', '', 'dataSetType', '1', '需要的', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('110', '', 'systemArchitecture', '2', 'C/S', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('111', '', 'systemStatus', '1', '好', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('112', '', 'systemStatus', '2', '良好', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('113', '', 'systemStatus', '3', '一般', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('114', '', 'systemStatus', '4', '差', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('115', '', 'interfaceAble', '0', '否', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('116', '', 'interfaceAble', '1', '是', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('117', '', 'onLineBussnines', '0', '否', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('118', '', 'onLineBussnines', '1', '是', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('119', '', 'isExplain', '1', '是', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('12', '', 'dataSetShareType', '1', '有条件共享', null, null, null, '1', 'admin', '2017-02-20 20:46:52', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('120', '', 'isExplain', '0', '否', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('121', '', 'isOutPut', '0', '否', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('122', '', 'isOutPut', '1', '是', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('123', '', 'oldSystem', '1', '是', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('124', '', 'oldSystem', '0', '否', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('125', '', 'isUseAble', '0', '否', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('126', '', 'isUseAble', '1', '是', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('1261', '', 'contactsType', '1', '组织联络人', null, '', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('127', '', 'contactsType', '2', '组织负责人', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('129', '', 'systemConstructionProperty', '1', '国家垂直系统', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('13', '', 'dataSetShareType', '2', '不予共享', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('130', '', 'systemConstructionProperty', '2', '省级垂直系统', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('131', '', 'systemConstructionProperty', '3', '市级系统（多部门共用）', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('132', '', 'systemConstructionProperty', '4', '市级系统（部门专用）', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('133', '', 'systemNet', '1', '是', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('134', '', 'systemNet', '0', '否', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('135', '', 'requirementNameSource', 'select', '从资源选择', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('136', '', 'requirementNameSource', 'input', '手工新增', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('137', '', 'systemDeploymentLocation', '1', '政务云平台', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('138', '', 'systemDeploymentLocation', '2', '自建机房', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('139', '', 'systemDeploymentLocation', '3', '政务集中机房', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('14', '', 'dataSetShareMethod', '1', '文件传输', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('140', '', 'systemDeploymentLocation', '4', '其它', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('141', '', 'dbCategory', '1', '关系型数据库', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('142', '', 'dbCategory', '2', '普通文件系统', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('143', '', 'dbType', '1', 'MYSQL', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('144', '', 'dbType', '2', 'SQLSERVER', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('145', '', 'dbType', '3', 'ORACLE', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('146', '', 'dbType', '4', 'ACCESS', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('15', '', 'dataSetShareMethod', '2', '接口方式', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('16', '', 'dataSetShareMethod', '3', '数据库对接', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('17', '', 'dataSetShareMethod', '4', '前置机对接', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('17607cc979374c10b6a4df3048b5a6e6', '', 'dataSetType', '676ee4b999e548c2a40ed15cd68d1aca', '121212', null, null, null, '1', null, '2017-06-27 11:48:13', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('18', '', 'dataSetShareMethod', '5', '在线查询', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('19', '', 'dataSetShareMethod', '6', '其他\r\n', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('1d61d83f8d8644ae80f32bae58e639cc', '', 'categoryApp', '74f9540b115c4d0d96dfffd4ffebd112', '审计局', null, '35e2236aecde4dc795a427a82170b455', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('2', '', '001', '吞吞吐吐', '市', null, '1', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('20', '', 'dataSetIsOpen', '3', '不开放', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('21', '', 'dataSetIsOpen', '2', '依申请开放', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('22', '', 'dataSetStoreMedia', '1', '电子表格', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('23', '', 'dataSetStoreMedia', '2', '纸质文件', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('232c88e8-83f5-11e7-934d-00ffffff0000', '', 'belongSystem', '5', '其他', null, null, null, '1', null, '2017-04-29 19:36:45', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('24', '', 'dataSetStoreMedia', '3', '数据库', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('25', '', 'dataSetStoreMedia', '4', '其它', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('26', '', 'setItemSetType', '1', '需要的', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('27', '', 'setItemSetType', '0', '产生的', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('28', '', 'sensitive', '1', '个人隐私', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('2820b775f24d4c0ebb61ddbf60806b31', '', 'dataSetType', 'cc44e69dbbf74fa1b3f5b312db08cdb2', '11111111111111111', null, null, null, '1', null, '2017-06-27 11:48:45', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('29', '', 'sensitive', '2', '商业机密', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('3', '', 'ordinary', '0', '否', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('30', '', 'sensitive', '3', '国家机密', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('31', '', 'sensitive', '4', '不涉密', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('32', '', 'setItemFrequency', '1', '年', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('33', '', 'setItemFrequency', '2', '半年', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('34', '', 'setItemFrequency', '3', '季', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('35', '', 'setItemFrequency', '4', '月', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('36', '', 'setItemFrequency', '5', '旬', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('37', '', 'setItemFrequency', '6', '周', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('371d23829533445a8705cde2d82aab76', '', 'categoryApp', '371d23829533445a8705cde2d82aab76', 'APP客户端', null, '371d23829533445a8705cde2d82eeb76', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('371d23829533445a8705cde2d82eeb63', '', 'categoryApp', '371d23829533445a8705cde2d82eeb63', '常规应用', null, 'root', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('371d23829533445a8705cde2d82eeb76', '', 'categoryApp', '371d23829533445a8705cde2d82eeb76', 'App应用', null, 'root', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('371d23829533445a8705cde2d82eebb8', '', 'dataSetType', '54919dad22bc4d099602446e9aa1cf2b', 'fwegweg', null, null, null, '1', null, '2017-06-28 19:22:50', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('371d23829533445a8705cde2d82qwb75', '', 'categoryApp', '371d23829533445a8705cde2d82qwb75', '微信', null, '371d23829533445a8705cde2d82eeb76', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('371d23829533445a8705cde2d82ssb74', '', 'categoryApp', '371d23829533445a8705cde2d82ssb74', '手机版网站', null, '371d23829533445a8705cde2d82eeb76', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('38', '', 'setItemFrequency', '7', '日', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('39', '', 'setItemFrequency', '8', '小时', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('4', '', 'ordinary', '1', '是', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('40', '', 'setItemFrequency', '9', '实时', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('41', '', 'setItemFrequency', '10', '不定期', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('4160183539a445a6bc0531ecb22bbd0e', '', 'dataSetType', '33b706f02dca47b9812ed05a8a4bed76', '121111111111111', null, null, null, '1', null, '2017-06-27 11:48:28', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('42', '', 'setItemFrequency', '11', '其它', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('43', '', 'setItemShareMethod', '1', '文件传输', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('44', '', 'setItemShareMethod', '2', '接口方式', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('45', '', 'setItemShareMethod', '3', '数据库对接', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('45b1742c38ff4de3aecb7e17da69157e', '', 'dataSetType', '62b3f505926345939db506a8ca366aed', '新增字典值', null, null, null, '1', null, '2017-06-27 15:50:24', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('46', '', 'setItemShareMethod', '4', '前置机对接', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('47', '', 'setItemShareMethod', '5', '在线查询', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('48', '', 'setItemShareMethod', '6', '其它', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('49', '', 'setItemIsOpen', '1', '普遍开放', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('4c06544170624680ba91e80a405c0963', '', 'categoryApp', '9556054c38794e0d968d9e5482894b3a', '公安局', null, '35e2236aecde4dc795a427a82170b455', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('5', '', 'serviceTarget', '1', '个人', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('50', '', 'setItemIsOpen', '2', '依申请开放', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('51', '', 'setItemStoreMedia', '1', '电子表格', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('52', '', 'setItemStoreMedia', '2', '纸质文件', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('53', '', 'setItemStoreMedia', '3', '数据库', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('54', '', 'setItemStoreMedia', '4', '其它', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('54123', '', 'categoryApp', '54123', '跨部门应用', null, '371d23829533445a8705cde2d82eeb76', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('54312', '', 'categoryApp', '54312', '典型应用', null, '371d23829533445a8705cde2d82eeb63', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('54333', '', 'categoryApp', '54333', '政务类', null, '371d23829533445a8705cde2d82eeb63', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('55', '', 'setItemStoreLocation', '1', '政务云平台', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('56', '', 'setItemStoreLocation', '2', '自建机房', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('57', '', 'setItemStoreLocation', '3', '政务集中机房', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('58', '', 'setItemStoreLocation', '4', '其它', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('59', '', 'requirementExpectGetType', '1', '文件传输', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('6', '', 'serviceTarget', '2', '企业', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('60', '', 'requirementExpectGetType', '2', '接口方式', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('61', '', 'requirementExpectGetType', '3', '数据库对接', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('62', '', 'requirementExpectGetType', '4', '前置机对接', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('63', '', 'requirementExpectGetType', '5', '在线查询', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('64', '', 'requirementExpectGetType', '6', '其它', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('65', '', 'requirementExpectUpdateFrequence', '1', '年', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('66', '', 'requirementExpectUpdateFrequence', '2', '半年', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('67', '', 'requirementExpectUpdateFrequence', '3', '季', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('68', '', 'requirementExpectUpdateFrequence', '4', '月', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('69', '', 'requirementExpectUpdateFrequence', '5', '旬', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('7', '', 'serviceTarget', '3', '个人和企业', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('70', '', 'requirementExpectUpdateFrequence', '6', '周', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('71', '', 'requirementExpectUpdateFrequence', '7', '日', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('72', '', 'requirementExpectUpdateFrequence', '8', '小时', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('73', '', 'requirementExpectUpdateFrequence', '9', '实时', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('74', '', 'requirementExpectUpdateFrequence', '10', '不定期 ', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('75', '', 'requirementExpectUpdateFrequence', '11', '其他', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('76', '', 'dataSetShareType', '0', '无条件共享', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('77', '', 'dataSetIsOpen', '1', '普遍开放', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('78', '', 'setItemIsOpen', '3', '不开放', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('79', '', 'systemStage', '1', '拟建', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('8', '', 'serviceTarget', '4', '政府', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('80', '', 'systemStage', '2', '在建', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('81', '', 'systemStage', '3', '试运', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('82', '', 'systemStage', '4', '投运', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('83', '', 'systemStage', '5', '停运', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('84', '', 'goldProjecty', '1', '非十二金工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('85', '', 'goldProjecty', '2', '金宏工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('86', '', 'goldProjecty', '3', '金土工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('87', '', 'goldProjecty', '4', '金财工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('88', '', 'goldProjecty', '5', '金税工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('89', '', 'goldProjecty', '5', '金卡工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('8b65d441a5744b38ab988d2d9c091e4e', '', 'dataSetType', '879e1fd8769e4cf8a506c073468b3779', '12323123', null, null, null, '1', null, '2017-06-28 19:34:37', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('8e800ff71e5240e3847cf29ebc406ab8', '', 'dataSetType', '02e75b99e14141758cdf66c3a51956c4', '1212', null, null, null, '1', null, '2017-06-27 11:56:14', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('8ed28f58efa548e9bbf3605bc9db065a', '', 'dataSetType', '6134de9f4b8a4884ad88f3c80d6687f5', '222', null, null, null, '1', null, '2017-04-29 20:11:18', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('9', '', 'serviceTarget', '5', '其他', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('90', '', 'goldProjecty', '6', '金审工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('91', '', 'goldProjecty', '7', '金关工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('92', '', 'goldProjecty', '8', '金盾工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('93', '', 'goldProjecty', '9', '金保工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('9346054d051a4ec9b74544cf692051b9', '', 'categoryApp', '421b9cea8ce74d9ab392f51b2ef3eb65', '教育局 ', null, '35e2236aecde4dc795a427a82170b455', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('94', '', 'goldProjecty', '10', '金农工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('95', '', 'goldProjecty', '11', '金水工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('96', '', 'goldProjecty', '12', '金质工程', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('97', '', 'systemLevel', '1', '国家部委', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('98', '', 'systemLevel', '2', '省级', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('99', '', 'systemLevel', '3', '地市级', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('b0c8e140ce79418783973496f91aaca2', '', 'categoryApp', '35e2236aecde4dc795a427a82170b455', '部门应用', null, '371d23829533445a8705cde2d82eeb63', null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('b455f4e822804d1a9c147dc6b9460475', '', 'dataSetType', '75b74ce627e64708bb3eed2db42fb467', '322', null, null, null, '1', null, '2017-06-27 15:36:52', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('b890ef402a264d6dae9ac46a6be228c2', '', 'dataSetType', 'b766bd0787c446659b2c3f92ceacc671', 'kkkkkkkkkkkkkkkkkkkk', null, null, null, '1', null, '2017-06-27 12:00:24', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('c7c1198f-7348-11e7-8cef-000c29e0ca25', '', 'appRequirementNameSource', 'input', '手动添加', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('c81bee48-7348-11e7-8cef-000c29e0ca25', '', 'businessRequirementNameSource', 'select', '从信息资源选择', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('c85223c9-7348-11e7-8cef-000c29e0ca25', '', 'businessRequirementNameSource', 'input', '手动添加', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('cea49c49e60442dd9ca451ac74e5a7f2', '', 'dataSetType', 'd818100036424e7996569111be88cea9', '22223333', null, null, null, '1', null, '2017-04-29 20:30:43', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('d398102d-7348-11e7-8cef-000c29e0ca25', '', 'appRequirementNameSource', 'select', '从应用系统选择', null, null, null, '1', null, null, null, null, '0');
  INSERT INTO `sys_dict` VALUES ('d8395c97d4f54d5b87e4c9da8fa11c14', '', 'dataSetType', 'c65eafa236be4dc28519d614893edbb1', '23432423432423', null, null, null, '1', null, '2017-06-27 11:40:40', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('db40d89496e1465b8b24ed1589acfe36', '', 'dataSetType', '0502bc2d11754d238810038067c01735', 'bbbbbbbbbbbbbbbbbbb', null, null, null, '1', null, '2017-06-27 12:18:12', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('e0fd115891144294a013afb5a2ee03b7', '', 'dataSetType', 'e940aab8331847628468b1616f21c95d', 'mmmmmmmmmmmmmmmm', null, null, null, '1', null, '2017-06-27 11:49:33', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('e2626337d13b4d7899bc07afe94dcf29', '', 'dataSetType', '42745d642eec4b088e8563efbad43bbd', 'mllllllllllllllllllllllllllllllll', null, null, null, '1', null, '2017-06-27 12:00:44', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('e49ea95ffdb14f22a5aba7e81d554644', '', 'systemLevel', 'c16cf650efaa4f8d8204cd7f8e3ca8ca', '111111111111111', null, null, null, '1', null, '2017-04-29 19:18:52', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('f1b3eec9c7204484bc4bd19d54124f66', '', 'dataSetType', 'fcca0b72e56849e3a5b7ff1e42b6a205', '222', null, null, null, '1', null, '2017-04-29 20:11:18', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('f3f879edee42429a9a553c362e33ed0f', '', 'dataSetType', '839c7ed6c80d4bc4970a34bcb337bd68', 'vvvvvvvvvvvvvvvvvvvv', null, null, null, '1', null, '2017-06-27 12:20:31', null, null, '0');
  INSERT INTO `sys_dict` VALUES ('f777828ff96e4dcda1681bc0dd67a8d5', '', 'dataSetType', 'ccfd83abbb854ecda292b45063c656e0', '1213', null, null, null, '1', null, '2017-06-27 10:03:57', null, null, '0');


  -- 行政区划相关初始化数据
  -- 行政区划版本表
  insert into sys_region_version(id,version_code) values ('1','v1.0');
  -- 行政区划级别表
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('10','国家级','1');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('20','省、自治区、直辖市以及特别行政区级','2');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('21','省','2');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('22','自治区','2');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('23','直辖市','2');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('24','特别行政区','2');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('30','副省级','3');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('31','副省级省会城市','3');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('32','计划单列市','3');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('40','市、自治州级','4');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('41','地级市','4');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('42','自治州','4');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('50','区、县级市、县级','5');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('51','区','5');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('52','县级市','5');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('53','县','5');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('60','乡镇（街道）级','6');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('61','乡','6');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('62','镇','6');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('63','街道','6');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('70','村（社区）级','7');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('71','村','7');
  insert into sys_region_level (region_level_code,region_level_name,region_level_value) values ('72','社区','7');
  -- 行政区划表

  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9c0f822c-50cb-11e7-889e-00ffffff0000', '510000', '四川省', '', '四川省', null, '21', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9c1f864c-50cb-11e7-889e-00ffffff0000', '510100', '成都市', '510000', '四川省', null, '30', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9c36639f-50cb-11e7-889e-00ffffff0000', '510104', '锦江区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9c477021-50cb-11e7-889e-00ffffff0000', '510105', '青羊区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9c6aa162-50cb-11e7-889e-00ffffff0000', '510106', '金牛区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9c7981c4-50cb-11e7-889e-00ffffff0000', '510107', '武侯区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9c8a28bf-50cb-11e7-889e-00ffffff0000', '510108', '成华区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9c9b9d59-50cb-11e7-889e-00ffffff0000', '510112', '龙泉驿区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9cac22fb-50cb-11e7-889e-00ffffff0000', '510113', '青白江区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9cbcb035-50cb-11e7-889e-00ffffff0000', '510114', '新都区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9ccad4b5-50cb-11e7-889e-00ffffff0000', '510115', '温江区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9cd28292-50cb-11e7-889e-00ffffff0000', '510116', '双流区', '510100', '成都市', null, '51', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9ce2bfaf-50cb-11e7-889e-00ffffff0000', '510121', '金堂县', '510100', '成都市', null, '53', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9cee6f0c-50cb-11e7-889e-00ffffff0000', '510124', '郫县', '510100', '成都市', null, '53', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9cf6856e-50cb-11e7-889e-00ffffff0000', '510129', '大邑县', '510100', '成都市', null, '53', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9d028903-50cb-11e7-889e-00ffffff0000', '510131', '蒲江县', '510100', '成都市', null, '53', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9d0cdb08-50cb-11e7-889e-00ffffff0000', '510132', '新津县', '510100', '成都市', null, '53', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9d201580-50cb-11e7-889e-00ffffff0000', '510181', '都江堰市', '510100', '成都市', null, '52', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9d2b1975-50cb-11e7-889e-00ffffff0000', '510182', '彭州市', '510100', '成都市', null, '52', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9d36fdee-50cb-11e7-889e-00ffffff0000', '510183', '邛崃市', '510100', '成都市', null, '52', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9d410bea-50cb-11e7-889e-00ffffff0000', '510184', '崇州市', '510100', '成都市', null, '52', '1', '1');
  INSERT INTO `sys_region` (id,region_code,region_name,fcode,fname,first_charact,region_level_code,status,version_id)
	values  ('9d4aee39-50cb-11e7-889e-00ffffff0000', '510185', '简阳市', '510100', '成都市', null, '52', '1', '1');


  -- 基础部门模板表
  INSERT INTO `sys_dept_category_template` (`ID`, `category_code`, `category_name`, `fullname_template`, `shortname_template`, `apply_min_level`, `apply_max_level`) VALUES ('39e27000-50d3-11e7-889e-00ffffff0000', 'A', '党委', '中国共产党XX委员会', 'XX党委', 6, 2);
  INSERT INTO `sys_dept_category_template` (`ID`, `category_code`, `category_name`, `fullname_template`, `shortname_template`, `apply_min_level`, `apply_max_level`) VALUES ('39fbde80-50d3-11e7-889e-00ffffff0000', 'B', '人大', 'XX人民代表大会常务委员会', 'XX人大', 5, 2);
  INSERT INTO `sys_dept_category_template` (`ID`, `category_code`, `category_name`, `fullname_template`, `shortname_template`, `apply_min_level`, `apply_max_level`) VALUES ('3a0f0d6f-50d3-11e7-889e-00ffffff0000', 'C', '政府', 'XX人民政府', 'XX政府', 6, 2);
  INSERT INTO `sys_dept_category_template` (`ID`, `category_code`, `category_name`, `fullname_template`, `shortname_template`, `apply_min_level`, `apply_max_level`) VALUES ('3a442a08-50d3-11e7-889e-00ffffff0000', 'D', '政协', '中国人民政治协商会议XX委员会', 'XX政协', 5, 2);
  INSERT INTO `sys_dept_category_template` (`ID`, `category_code`, `category_name`, `fullname_template`, `shortname_template`, `apply_min_level`, `apply_max_level`) VALUES ('3a5c7e00-50d3-11e7-889e-00ffffff0000', 'E', '法院', 'XX人民法院', 'XX人民法院', 5, 2);
  INSERT INTO `sys_dept_category_template` (`ID`, `category_code`, `category_name`, `fullname_template`, `shortname_template`, `apply_min_level`, `apply_max_level`) VALUES ('3a75d344-50d3-11e7-889e-00ffffff0000', 'F', '检察院', 'XX人民检察院', 'XX人民检察院', 5, 2);

  -- 导入基础顶级部门表


  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('96891c92-50d4-11e7-889e-00ffffff0000', '100000', 'A', '100000_A', '中国共产党中央委员会', '中共中央', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('96a43de0-50d4-11e7-889e-00ffffff0000', '100000', 'B', '100000_B', '中华人民共和国全国人民代表大会', '全国人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('96af1403-50d4-11e7-889e-00ffffff0000', '100000', 'C', '100000_C', '中华人民共和国国务院', '国务院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('96bdff88-50d4-11e7-889e-00ffffff0000', '100000', 'D', '100000_D', '中国人民政治协商会议全国委员会', '全国政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('96d39b94-50d4-11e7-889e-00ffffff0000', '100000', 'E', '100000_E', '中华人民共和国最高人民法院', '最高人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('96f588f6-50d4-11e7-889e-00ffffff0000', '100000', 'F', '100000_F', '中华人民共和国最高人民检察院', '最高人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('97022130-50d4-11e7-889e-00ffffff0000', '510000', 'A', '510000_A', '中国共产党四川省委员会', '四川省党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('970a20ca-50d4-11e7-889e-00ffffff0000', '510000', 'B', '510000_B', '四川省人民代表大会常务委员会', '四川省人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9723a489-50d4-11e7-889e-00ffffff0000', '510000', 'C', '510000_C', '四川省人民政府', '四川省政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9734d2a6-50d4-11e7-889e-00ffffff0000', '510000', 'D', '510000_D', '中国人民政治协商会议四川省委员会', '四川省政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9743a732-50d4-11e7-889e-00ffffff0000', '510000', 'E', '510000_E', '四川省高级人民法院', '四川省高级人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('975381af-50d4-11e7-889e-00ffffff0000', '510000', 'F', '510000_F', '四川省人民检察院', '四川省人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('975cefc6-50d4-11e7-889e-00ffffff0000', '510100', 'A', '510100_A', '中国共产党成都市委员会', '成都市党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9769f6a7-50d4-11e7-889e-00ffffff0000', '510100', 'B', '510100_B', '成都市人民代表大会常务委员会', '成都市人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9772e229-50d4-11e7-889e-00ffffff0000', '510100', 'C', '510100_C', '成都市人民政府', '成都市政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9781accd-50d4-11e7-889e-00ffffff0000', '510100', 'D', '510100_D', '中国人民政治协商会议成都市委员会', '成都市政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('97891bbf-50d4-11e7-889e-00ffffff0000', '510100', 'E', '510100_E', '成都市高级人民法院', '成都市中级人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9799c9fd-50d4-11e7-889e-00ffffff0000', '510100', 'F', '510100_F', '成都市人民检察院', '成都市人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('97a3a0c4-50d4-11e7-889e-00ffffff0000', '510104', 'A', '510104_A', '中国共产党锦江区委员会', '锦江区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('97b03da9-50d4-11e7-889e-00ffffff0000', '510104', 'B', '510104_B', '锦江区人民代表大会常务委员会', '锦江区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('97b9f27a-50d4-11e7-889e-00ffffff0000', '510104', 'C', '510104_C', '锦江区人民政府', '锦江区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('97cbb1e9-50d4-11e7-889e-00ffffff0000', '510104', 'D', '510104_D', '中国人民政治协商会议锦江区委员会', '锦江区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('97d86c36-50d4-11e7-889e-00ffffff0000', '510104', 'E', '510104_E', '锦江区人民法院', '锦江区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('97e37c5d-50d4-11e7-889e-00ffffff0000', '510104', 'F', '510104_F', '锦江区人民检察院', '锦江区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('97f011b6-50d4-11e7-889e-00ffffff0000', '510105', 'A', '510105_A', '中国共产党青羊区委员会', '青羊区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('980052d6-50d4-11e7-889e-00ffffff0000', '510105', 'B', '510105_B', '青羊区人民代表大会常务委员会', '青羊区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('980dc645-50d4-11e7-889e-00ffffff0000', '510105', 'C', '510105_C', '青羊区人民政府', '青羊区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('984743b7-50d4-11e7-889e-00ffffff0000', '510105', 'D', '510105_D', '中国人民政治协商会议青羊区委员会', '青羊区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98563b30-50d4-11e7-889e-00ffffff0000', '510105', 'E', '510105_E', '青羊区人民法院', '青羊区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98624029-50d4-11e7-889e-00ffffff0000', '510105', 'F', '510105_F', '青羊区人民检察院', '青羊区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('986fabb7-50d4-11e7-889e-00ffffff0000', '510106', 'A', '510106_A', '中国共产党金牛区委员会', '金牛区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98778706-50d4-11e7-889e-00ffffff0000', '510106', 'B', '510106_B', '金牛区人民代表大会常务委员会', '金牛区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9883513a-50d4-11e7-889e-00ffffff0000', '510106', 'C', '510106_C', '金牛区人民政府', '金牛区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98a7eaf9-50d4-11e7-889e-00ffffff0000', '510106', 'D', '510106_D', '中国人民政治协商会议金牛区委员会', '金牛区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98b30c5e-50d4-11e7-889e-00ffffff0000', '510106', 'E', '510106_E', '金牛区人民法院', '金牛区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98bc1914-50d4-11e7-889e-00ffffff0000', '510106', 'F', '510106_F', '金牛区人民检察院', '金牛区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98c7704a-50d4-11e7-889e-00ffffff0000', '510107', 'A', '510107_A', '中国共产党武侯区委员会', '武侯区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98d059ac-50d4-11e7-889e-00ffffff0000', '510107', 'B', '510107_B', '武侯区人民代表大会常务委员会', '武侯区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98daf6c9-50d4-11e7-889e-00ffffff0000', '510107', 'C', '510107_C', '武侯区人民政府', '武侯区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98f06472-50d4-11e7-889e-00ffffff0000', '510107', 'D', '510107_D', '中国人民政治协商会议武侯区委员会', '武侯区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('98fe2127-50d4-11e7-889e-00ffffff0000', '510107', 'E', '510107_E', '武侯区人民法院', '武侯区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9910ad3e-50d4-11e7-889e-00ffffff0000', '510107', 'F', '510107_F', '武侯区人民检察院', '武侯区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9921581d-50d4-11e7-889e-00ffffff0000', '510108', 'A', '510108_A', '中国共产党成华区委员会', '成华区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('992e6fec-50d4-11e7-889e-00ffffff0000', '510108', 'B', '510108_B', '成华区人民代表大会常务委员会', '成华区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9937cb62-50d4-11e7-889e-00ffffff0000', '510108', 'C', '510108_C', '成华区人民政府', '成华区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('996e7f26-50d4-11e7-889e-00ffffff0000', '510108', 'D', '510108_D', '中国人民政治协商会议成华区委员会', '成华区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9977fea4-50d4-11e7-889e-00ffffff0000', '510108', 'E', '510108_E', '成华区人民法院', '成华区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99879d8f-50d4-11e7-889e-00ffffff0000', '510108', 'F', '510108_F', '成华区人民检察院', '成华区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99911c28-50d4-11e7-889e-00ffffff0000', '510112', 'A', '510112_A', '中国共产党龙泉驿区委员会', '龙泉驿区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('999f43be-50d4-11e7-889e-00ffffff0000', '510112', 'B', '510112_B', '龙泉驿区人民代表大会常务委员会', '龙泉驿区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99ab10e4-50d4-11e7-889e-00ffffff0000', '510112', 'C', '510112_C', '龙泉驿区人民政府', '龙泉驿区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99b62f01-50d4-11e7-889e-00ffffff0000', '510112', 'D', '510112_D', '中国人民政治协商会议龙泉驿区委员会', '龙泉驿区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99c0a327-50d4-11e7-889e-00ffffff0000', '510112', 'E', '510112_E', '龙泉驿区人民法院', '龙泉驿区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99c96344-50d4-11e7-889e-00ffffff0000', '510112', 'F', '510112_F', '龙泉驿区人民检察院', '龙泉驿区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99d4df62-50d4-11e7-889e-00ffffff0000', '510113', 'A', '510113_A', '中国共产党青白江区委员会', '青白江区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99dd4efc-50d4-11e7-889e-00ffffff0000', '510113', 'B', '510113_B', '青白江区人民代表大会常务委员会', '青白江区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99ea3cb9-50d4-11e7-889e-00ffffff0000', '510113', 'C', '510113_C', '青白江区人民政府', '青白江区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('99f8885e-50d4-11e7-889e-00ffffff0000', '510113', 'D', '510113_D', '中国人民政治协商会议青白江区委员会', '青白江区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9a08c40b-50d4-11e7-889e-00ffffff0000', '510113', 'E', '510113_E', '青白江区人民法院', '青白江区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9a12cd7a-50d4-11e7-889e-00ffffff0000', '510113', 'F', '510113_F', '青白江区人民检察院', '青白江区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9a1e9a58-50d4-11e7-889e-00ffffff0000', '510114', 'A', '510114_A', '中国共产党新都区委员会', '新都区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9a2816e4-50d4-11e7-889e-00ffffff0000', '510114', 'B', '510114_B', '新都区人民代表大会常务委员会', '新都区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9a35e756-50d4-11e7-889e-00ffffff0000', '510114', 'C', '510114_C', '新都区人民政府', '新都区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9a406740-50d4-11e7-889e-00ffffff0000', '510114', 'D', '510114_D', '中国人民政治协商会议新都区委员会', '新都区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9a53587d-50d4-11e7-889e-00ffffff0000', '510114', 'E', '510114_E', '新都区人民法院', '新都区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9a5e3bdb-50d4-11e7-889e-00ffffff0000', '510114', 'F', '510114_F', '新都区人民检察院', '新都区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9a6b90c0-50d4-11e7-889e-00ffffff0000', '510115', 'A', '510115_A', '中国共产党温江区委员会', '温江区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9acca1ec-50d4-11e7-889e-00ffffff0000', '510115', 'B', '510115_B', '温江区人民代表大会常务委员会', '温江区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9ae7c987-50d4-11e7-889e-00ffffff0000', '510115', 'C', '510115_C', '温江区人民政府', '温江区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9af50139-50d4-11e7-889e-00ffffff0000', '510115', 'D', '510115_D', '中国人民政治协商会议温江区委员会', '温江区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9afcc2f7-50d4-11e7-889e-00ffffff0000', '510115', 'E', '510115_E', '温江区人民法院', '温江区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b07ec97-50d4-11e7-889e-00ffffff0000', '510115', 'F', '510115_F', '温江区人民检察院', '温江区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b238d39-50d4-11e7-889e-00ffffff0000', '510116', 'A', '510116_A', '中国共产党双流区委员会', '双流区党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b30f79f-50d4-11e7-889e-00ffffff0000', '510116', 'B', '510116_B', '双流区人民代表大会常务委员会', '双流区人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b3ab5fd-50d4-11e7-889e-00ffffff0000', '510116', 'C', '510116_C', '双流区人民政府', '双流区政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b469a4c-50d4-11e7-889e-00ffffff0000', '510116', 'D', '510116_D', '中国人民政治协商会议双流区委员会', '双流区政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b4ed4fa-50d4-11e7-889e-00ffffff0000', '510116', 'E', '510116_E', '双流区人民法院', '双流区人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b58fd48-50d4-11e7-889e-00ffffff0000', '510116', 'F', '510116_F', '双流区人民检察院', '双流区人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b64304a-50d4-11e7-889e-00ffffff0000', '510121', 'A', '510121_A', '中国共产党金堂县委员会', '金堂县党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b6d21bd-50d4-11e7-889e-00ffffff0000', '510121', 'B', '510121_B', '金堂县人民代表大会常务委员会', '金堂县人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b7a2173-50d4-11e7-889e-00ffffff0000', '510121', 'C', '510121_C', '金堂县人民政府', '金堂县政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b82ff60-50d4-11e7-889e-00ffffff0000', '510121', 'D', '510121_D', '中国人民政治协商会议金堂县委员会', '金堂县政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b8e5d84-50d4-11e7-889e-00ffffff0000', '510121', 'E', '510121_E', '金堂县人民法院', '金堂县人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9b9b2293-50d4-11e7-889e-00ffffff0000', '510121', 'F', '510121_F', '金堂县人民检察院', '金堂县人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9bd9cd74-50d4-11e7-889e-00ffffff0000', '510124', 'A', '510124_A', '中国共产党郫县委员会', '郫县党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9be36f79-50d4-11e7-889e-00ffffff0000', '510124', 'B', '510124_B', '郫县人民代表大会常务委员会', '郫县人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9bef8dfc-50d4-11e7-889e-00ffffff0000', '510124', 'C', '510124_C', '郫县人民政府', '郫县政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9bf7a598-50d4-11e7-889e-00ffffff0000', '510124', 'D', '510124_D', '中国人民政治协商会议郫县委员会', '郫县政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c07d160-50d4-11e7-889e-00ffffff0000', '510124', 'E', '510124_E', '郫县人民法院', '郫县人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c14a099-50d4-11e7-889e-00ffffff0000', '510124', 'F', '510124_F', '郫县人民检察院', '郫县人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c209570-50d4-11e7-889e-00ffffff0000', '510129', 'A', '510129_A', '中国共产党大邑县委员会', '大邑县党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c287272-50d4-11e7-889e-00ffffff0000', '510129', 'B', '510129_B', '大邑县人民代表大会常务委员会', '大邑县人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c35c287-50d4-11e7-889e-00ffffff0000', '510129', 'C', '510129_C', '大邑县人民政府', '大邑县政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c40d400-50d4-11e7-889e-00ffffff0000', '510129', 'D', '510129_D', '中国人民政治协商会议大邑县委员会', '大邑县政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c4e6d67-50d4-11e7-889e-00ffffff0000', '510129', 'E', '510129_E', '大邑县人民法院', '大邑县人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c5a5447-50d4-11e7-889e-00ffffff0000', '510129', 'F', '510129_F', '大邑县人民检察院', '大邑县人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c688815-50d4-11e7-889e-00ffffff0000', '510131', 'A', '510131_A', '中国共产党浦江县委员会', '浦江县党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c714d75-50d4-11e7-889e-00ffffff0000', '510131', 'B', '510131_B', '浦江县人民代表大会常务委员会', '浦江县人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c7df54b-50d4-11e7-889e-00ffffff0000', '510131', 'C', '510131_C', '浦江县人民政府', '浦江县政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c855470-50d4-11e7-889e-00ffffff0000', '510131', 'D', '510131_D', '中国人民政治协商会议浦江县委员会', '浦江县政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c9620ad-50d4-11e7-889e-00ffffff0000', '510131', 'E', '510131_E', '浦江县人民法院', '浦江县人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9c9ec039-50d4-11e7-889e-00ffffff0000', '510131', 'F', '510131_F', '浦江县人民检察院', '浦江县人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9cba8e7d-50d4-11e7-889e-00ffffff0000', '510132', 'A', '510132_A', '中国共产党新津县委员会', '新津县党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9cc237cd-50d4-11e7-889e-00ffffff0000', '510132', 'B', '510132_B', '新津县人民代表大会常务委员会', '新津县人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9cced0bc-50d4-11e7-889e-00ffffff0000', '510132', 'C', '510132_C', '新津县人民政府', '新津县政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9ce0133f-50d4-11e7-889e-00ffffff0000', '510132', 'D', '510132_D', '中国人民政治协商会议新津县委员会', '新津县政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9cef6bb2-50d4-11e7-889e-00ffffff0000', '510132', 'E', '510132_E', '新津县人民法院', '新津县人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9cff9439-50d4-11e7-889e-00ffffff0000', '510132', 'F', '510132_F', '新津县人民检察院', '新津县人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9d1271d0-50d4-11e7-889e-00ffffff0000', '510181', 'A', '510181_A', '中国共产党都江堰市委员会', '都江堰市党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9d285d87-50d4-11e7-889e-00ffffff0000', '510181', 'B', '510181_B', '都江堰市人民代表大会常务委员会', '都江堰市人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9d310834-50d4-11e7-889e-00ffffff0000', '510181', 'C', '510181_C', '都江堰市人民政府', '都江堰市政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9d3e9dab-50d4-11e7-889e-00ffffff0000', '510181', 'D', '510181_D', '中国人民政治协商会议都江堰市委员会', '都江堰市政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9d4660f2-50d4-11e7-889e-00ffffff0000', '510181', 'E', '510181_E', '都江堰市人民法院', '都江堰市人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9d52c53e-50d4-11e7-889e-00ffffff0000', '510181', 'F', '510181_F', '都江堰市人民检察院', '都江堰市人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9d71606b-50d4-11e7-889e-00ffffff0000', '510182', 'A', '510182_A', '中国共产党彭州市委员会', '彭州市党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9d89e449-50d4-11e7-889e-00ffffff0000', '510182', 'B', '510182_B', '彭州市人民代表大会常务委员会', '彭州市人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9da0f5e5-50d4-11e7-889e-00ffffff0000', '510182', 'C', '510182_C', '彭州市人民政府', '彭州市政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9db8bf02-50d4-11e7-889e-00ffffff0000', '510182', 'D', '510182_D', '中国人民政治协商会议彭州市委员会', '彭州市政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9dca8ee1-50d4-11e7-889e-00ffffff0000', '510182', 'E', '510182_E', '彭州市人民法院', '彭州市人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9dd66643-50d4-11e7-889e-00ffffff0000', '510182', 'F', '510182_F', '彭州市人民检察院', '彭州市人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9ded703b-50d4-11e7-889e-00ffffff0000', '510183', 'A', '510183_A', '中国共产党邛崃市委员会', '邛崃市党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9dfac080-50d4-11e7-889e-00ffffff0000', '510183', 'B', '510183_B', '邛崃市人民代表大会常务委员会', '邛崃市人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e08721a-50d4-11e7-889e-00ffffff0000', '510183', 'C', '510183_C', '邛崃市人民政府', '邛崃市政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e1559f7-50d4-11e7-889e-00ffffff0000', '510183', 'D', '510183_D', '中国人民政治协商会议邛崃市委员会', '邛崃市政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e1ed1d8-50d4-11e7-889e-00ffffff0000', '510183', 'E', '510183_E', '邛崃市人民法院', '邛崃市人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e2d85c0-50d4-11e7-889e-00ffffff0000', '510183', 'F', '510183_F', '邛崃市人民检察院', '邛崃市人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e3bb403-50d4-11e7-889e-00ffffff0000', '510184', 'A', '510184_A', '中国共产党崇州市委员会', '崇州市党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e4b6644-50d4-11e7-889e-00ffffff0000', '510184', 'B', '510184_B', '崇州市人民代表大会常务委员会', '崇州市人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e55ec7b-50d4-11e7-889e-00ffffff0000', '510184', 'C', '510184_C', '崇州市人民政府', '崇州市政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e62fffa-50d4-11e7-889e-00ffffff0000', '510184', 'D', '510184_D', '中国人民政治协商会议崇州市委员会', '崇州市政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e6d9df6-50d4-11e7-889e-00ffffff0000', '510184', 'E', '510184_E', '崇州市人民法院', '崇州市人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e78ea3a-50d4-11e7-889e-00ffffff0000', '510184', 'F', '510184_F', '崇州市人民检察院', '崇州市人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e85cd9d-50d4-11e7-889e-00ffffff0000', '510185', 'A', '510185_A', '中国共产党简阳市委员会', '简阳市党委', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e90ff7d-50d4-11e7-889e-00ffffff0000', '510185', 'B', '510185_B', '简阳市人民代表大会常务委员会', '简阳市人大', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9e9d794a-50d4-11e7-889e-00ffffff0000', '510185', 'C', '510185_C', '简阳市人民政府', '简阳市政府', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9ea84f73-50d4-11e7-889e-00ffffff0000', '510185', 'D', '510185_D', '中国人民政治协商会议简阳市委员会', '简阳市政协', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9eb1b9a6-50d4-11e7-889e-00ffffff0000', '510185', 'E', '510185_E', '简阳市人民法院', '简阳市人民法院', '', 'root','root', '', 1, 1, null, null, 0, '');
  INSERT INTO sys_dept (id, region_code, dept_type, dept_code, dept_name, dept_short_name, dept_function, fcode, fname, icon, order_number, status, create_user_id, create_time, tree_index, tree_code)
    VALUES ('9ebc9be8-50d4-11e7-889e-00ffffff0000', '510185', 'F', '510185_F', '简阳市人民检察院', '简阳市人民检察院', '', 'root','root', '', 1, 1, null, null, 0, '');


