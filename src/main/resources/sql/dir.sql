SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `dept_type` int(3) DEFAULT NULL COMMENT '组织机构类型',
  `dept_name` varchar(128) NOT NULL COMMENT '组织机构名称',
  `dept_alias` varchar(64) DEFAULT NULL COMMENT '组织机构简称',
  `dept_code` varchar(64) NOT NULL COMMENT '组织机构编码',
  `dept_contact_man` varchar(32) DEFAULT NULL COMMENT '联系人',
  `dept_contact_num` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `dept_address` varchar(256) DEFAULT NULL COMMENT '地址',
  `dept_desc` varchar(512) DEFAULT NULL COMMENT '组织机构描述',
  `icon` varchar(256) DEFAULT NULL COMMENT '图标',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `pid` varchar(36) DEFAULT NULL COMMENT '父组织机构ID',
  `status` int(3) DEFAULT NULL COMMENT '状态',
  `create_user_id` varchar(36) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(36) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(3) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织机构表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(36) NOT NULL COMMENT 'ID',
  `operator` varchar(36) DEFAULT NULL COMMENT '操作人Id',
  `operate_time` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `operate_type` varchar(36) DEFAULT NULL COMMENT '操作类型',
  `operate_desc` varchar(256) DEFAULT NULL COMMENT '操作描述',
  `operate_detail` longtext COMMENT '操作详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `menu_name` varchar(64) NOT NULL COMMENT '菜单名称',
  `pid` varchar(36) DEFAULT NULL COMMENT '父级菜单ID',
  `url` varchar(256) DEFAULT NULL COMMENT '连接地址',
  `icon` varchar(256) DEFAULT NULL COMMENT '图标',
  `sort` int(4) DEFAULT NULL COMMENT '排序',
  `menu_type` int(3) DEFAULT NULL COMMENT '类型   1：目录   2：菜单   3：功能',
  `code` varchar(36) DEFAULT NULL COMMENT '编码',
  `resource_name` varchar(256) DEFAULT NULL COMMENT '资源标识',
  `status` int(3) DEFAULT NULL COMMENT '状态',
  `create_user_id` varchar(36) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(36) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(3) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
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

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `role_type` int(3) NOT NULL COMMENT '角色类型',
  `role_name` varchar(128) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(512) DEFAULT NULL COMMENT '角色描述',
  `status` int(3) DEFAULT NULL COMMENT '状态',
  `create_user_id` varchar(36) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(36) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(3) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('737933bffef640329a4f864c4e2746ba', '1', '超级管理员', '超级管理员', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-08 17:18:19', null, null, 0);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `role_id` varchar(36) NOT NULL COMMENT '角色ID',
  `menu_id` varchar(36) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('0685b1490a3a4e62a2b69199f964de2a', 'ab7e4b34e5d141fa8566fdbb5d3e66f7', 'd2bc30feb5474a1bb7e02d48d39a3f8a');
INSERT INTO `sys_role_menu` VALUES ('08c54b744ccf415facf7b6d56fc85021', '737933bffef640329a4f864c4e2746ba', '686630c7cb624cc786dcdc9958971a6b');
INSERT INTO `sys_role_menu` VALUES ('09f4fef9249c457ca67b4a7a45823730', '737933bffef640329a4f864c4e2746ba', '649b484b58414d91aefa5a26143e6557');
INSERT INTO `sys_role_menu` VALUES ('0f74bd67f00b4a4b9508231bd472d605', '737933bffef640329a4f864c4e2746ba', 'ca840bc59c4e4ba38d43fe77fd4e3423');
INSERT INTO `sys_role_menu` VALUES ('121b1db2c51d4d3ba7b8c0ebc3e1e32e', 'a21876314a764438b6af6bfa422ec09a', '2');
INSERT INTO `sys_role_menu` VALUES ('19250006006a4439a32e1c6aea79b229', '737933bffef640329a4f864c4e2746ba', '3f26102ef0e04c3c9328cb97067cc5fa');
INSERT INTO `sys_role_menu` VALUES ('1c6642cb915442359d9fc2543b5a8c79', 'a21876314a764438b6af6bfa422ec09a', '488ef1eff57b4827acade7c0744278ce');
INSERT INTO `sys_role_menu` VALUES ('1d24c2bd05214ff8b0712471d280d9f4', '737933bffef640329a4f864c4e2746ba', '5d3dd56c16ff4e32aecae1b3228159c7');
INSERT INTO `sys_role_menu` VALUES ('1e0e01a71b8842e7ac203036f7384685', 'ab7e4b34e5d141fa8566fdbb5d3e66f7', '4253190001c1480fb0d631d64d150535');
INSERT INTO `sys_role_menu` VALUES ('21629df3640f4ccdb74c597142840ddd', 'a21876314a764438b6af6bfa422ec09a', '3f26102ef0e04c3c9328cb97067cc5fa');
INSERT INTO `sys_role_menu` VALUES ('2206b8a75e484ccabfce6a086e14bb43', 'ab7e4b34e5d141fa8566fdbb5d3e66f7', '2');
INSERT INTO `sys_role_menu` VALUES ('278b16b942a94902befe6cd8e416626d', '737933bffef640329a4f864c4e2746ba', 'f899f3d3baec4571b1c786717f9906fd');
INSERT INTO `sys_role_menu` VALUES ('34d1ba7b031543d0a4e01222347f4091', '737933bffef640329a4f864c4e2746ba', 'f5a20c82110b4a3ea9e30ca01a038680');
INSERT INTO `sys_role_menu` VALUES ('35c27b37c89c4e6ca7160ef320329961', '1d0d43b9fbbe4c078beb4a732309fe64', '1');
INSERT INTO `sys_role_menu` VALUES ('39fcbb569b544bc48c9ff0a1808d66a4', '737933bffef640329a4f864c4e2746ba', 'd2bc30feb5474a1bb7e02d48d39a3f8a');
INSERT INTO `sys_role_menu` VALUES ('3aceb6111772490e9887904fb54949e3', 'eb2e1fa3caa448658da909cf141788f8', '9');
INSERT INTO `sys_role_menu` VALUES ('3f545309df364e47b471082af287011b', '737933bffef640329a4f864c4e2746ba', '1');
INSERT INTO `sys_role_menu` VALUES ('47df737d83cf4d37b59914b95d23c3ee', '737933bffef640329a4f864c4e2746ba', '0c9b5fc8b44b41d1871a8fc8300247ec');
INSERT INTO `sys_role_menu` VALUES ('48dd8350fb7a4c3cb4406cbfa78aa524', 'a21876314a764438b6af6bfa422ec09a', '1');
INSERT INTO `sys_role_menu` VALUES ('4967e350a51e42cc9f613f90b6f7fe89', '737933bffef640329a4f864c4e2746ba', '10');
INSERT INTO `sys_role_menu` VALUES ('537af500a6b9442eb71e0d77a1ea4841', '1d0d43b9fbbe4c078beb4a732309fe64', '9');
INSERT INTO `sys_role_menu` VALUES ('54aa249b5ff345bebd5a494777e58be7', '737933bffef640329a4f864c4e2746ba', '1db9105008404a3485b6fac30dba3c0e');
INSERT INTO `sys_role_menu` VALUES ('55198bca649b476a96247409e591f770', '737933bffef640329a4f864c4e2746ba', '3fb6a7a5935b4efabf3de82e7e1baeb6');
INSERT INTO `sys_role_menu` VALUES ('57ab8e5a8c3f4412b5dd7f6ca884e531', '737933bffef640329a4f864c4e2746ba', '37a1abf4b9fb4c43a9ca4688a051008d');
INSERT INTO `sys_role_menu` VALUES ('603b1709c5ee4cacad596a0fb27123d5', '737933bffef640329a4f864c4e2746ba', '60dda993d87647f5989c15f14f866df9');
INSERT INTO `sys_role_menu` VALUES ('613112d120d642bbb83810d07a96e477', '2a9b728a431246b08f853c2529e6ba84', '2');
INSERT INTO `sys_role_menu` VALUES ('6a173b8355a9438291ecfdfd2ec8279d', '737933bffef640329a4f864c4e2746ba', '79d78b8357174cac8f44abd275dec597');
INSERT INTO `sys_role_menu` VALUES ('6aad723536484826a8ff4909a63b9db0', '737933bffef640329a4f864c4e2746ba', '488ef1eff57b4827acade7c0744278ce');
INSERT INTO `sys_role_menu` VALUES ('6b3f30ec097a4d259c18e9ef121d8ca5', '737933bffef640329a4f864c4e2746ba', '4');
INSERT INTO `sys_role_menu` VALUES ('6d802565d55b4c0798e32fb09902aff6', '737933bffef640329a4f864c4e2746ba', '42dd5ae31e3a43b3a197440e8ec19a94');
INSERT INTO `sys_role_menu` VALUES ('6f41c85dd5174f78ad2db183db359b55', 'a21876314a764438b6af6bfa422ec09a', '4');
INSERT INTO `sys_role_menu` VALUES ('712118e6fe374f92b3beaffc1019952a', 'f08487637b0d4bfc9accc14cbca6f1cd', '3');
INSERT INTO `sys_role_menu` VALUES ('750868dfc79a4a32841da56d1601a8d1', 'f08487637b0d4bfc9accc14cbca6f1cd', '1');
INSERT INTO `sys_role_menu` VALUES ('75de737633cc405facca79d71d9926ed', '737933bffef640329a4f864c4e2746ba', '363a778e78a346a68210b2590163a943');
INSERT INTO `sys_role_menu` VALUES ('75e2d8fc86b7405496137ff953e51db9', '737933bffef640329a4f864c4e2746ba', '22e38e885f9b40b9aae6a36deb78e89c');
INSERT INTO `sys_role_menu` VALUES ('77fd54d3ab0d4eaa8605346d93095eb9', 'eb2e1fa3caa448658da909cf141788f8', '8');
INSERT INTO `sys_role_menu` VALUES ('83c8154646fb49bd91e9a7f3435f537e', '737933bffef640329a4f864c4e2746ba', 'b4e7232189b14cf3ba160cf7b0d3bf37');
INSERT INTO `sys_role_menu` VALUES ('851ea372461240ce964fd3f757db9413', '737933bffef640329a4f864c4e2746ba', '915c309ebe5047b68645b3eb777dd8c9');
INSERT INTO `sys_role_menu` VALUES ('883470c5cb43422687d290e6f6abbca2', '737933bffef640329a4f864c4e2746ba', '4e816a9854714d24b0413d929d637a2b');
INSERT INTO `sys_role_menu` VALUES ('8898f16fd0d840808e20ed7f4643a821', '737933bffef640329a4f864c4e2746ba', 'a5ebf29168234406939856bc6890c86b');
INSERT INTO `sys_role_menu` VALUES ('8989351fbb3b42709ea3a18f07b7c4a5', '737933bffef640329a4f864c4e2746ba', 'dc5f478d98ed4297a8ae638fe90df050');
INSERT INTO `sys_role_menu` VALUES ('96ea5bf432c642a59264e85d3b884136', '737933bffef640329a4f864c4e2746ba', 'a73802e513cc4465883530ec8074abbb');
INSERT INTO `sys_role_menu` VALUES ('977c24618d0e48beaa57d648b5d08d8c', '737933bffef640329a4f864c4e2746ba', '2');
INSERT INTO `sys_role_menu` VALUES ('a7f8c4a91b82480eaa28a281984a064b', '737933bffef640329a4f864c4e2746ba', '5');
INSERT INTO `sys_role_menu` VALUES ('a9559c9ab4cc4ba8b1d5554d9f95df9d', '737933bffef640329a4f864c4e2746ba', '0b71762ebc0346239efd5f2069ff2124');
INSERT INTO `sys_role_menu` VALUES ('b71cea3a72d545ad9d1fb5f302c0d035', 'a21876314a764438b6af6bfa422ec09a', '60dda993d87647f5989c15f14f866df9');
INSERT INTO `sys_role_menu` VALUES ('c015003b62a84e44aa678bdd9d9ce99b', 'a21876314a764438b6af6bfa422ec09a', 'a73802e513cc4465883530ec8074abbb');
INSERT INTO `sys_role_menu` VALUES ('c4ed1e58395643b1ada4782c7f204b0c', '737933bffef640329a4f864c4e2746ba', '4eaf9b0cc3f14c96b8ccec03344b5c17');
INSERT INTO `sys_role_menu` VALUES ('cd3bbdbd59aa44eab3e263aac341af79', '737933bffef640329a4f864c4e2746ba', '0818e1c76bbd44eba3a698547ec4e637');
INSERT INTO `sys_role_menu` VALUES ('ea5febe36eee451bb95c0b443f90245a', '737933bffef640329a4f864c4e2746ba', '4253190001c1480fb0d631d64d150535');
INSERT INTO `sys_role_menu` VALUES ('f6e982dfc59a4233b999ca40dbe8b356', '737933bffef640329a4f864c4e2746ba', '3');

-- ----------------------------
-- Table structure for sys_setting
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `setting_type` int(3) NOT NULL COMMENT '配置类型',
  `setting_code` varchar(128) NOT NULL COMMENT '配置编码',
  `setting_name` varchar(128) NOT NULL COMMENT '配置名称',
  `setting_value` varchar(512) NOT NULL COMMENT '配置值',
  `setting_desc` varchar(512) DEFAULT NULL COMMENT '配置描述',
  `status` int(3) DEFAULT NULL COMMENT '状态',
  `create_user_id` varchar(36) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(36) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(3) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置表';

-- ----------------------------
-- Records of sys_setting
-- ----------------------------
INSERT INTO `sys_setting` VALUES ('1', '1', 'systemName', '系统名称', '数据采集系统', null, '1', null, null, null, null, 0);
INSERT INTO `sys_setting` VALUES ('2', '1', 'systemSubName', '系统简称', 'DCM', null, '1', null, null, null, null, 0);
INSERT INTO `sys_setting` VALUES ('3', '1', 'bottomCopyright', '许可说明', 'Copyright © 2017 勤智数码. All rights reserved.', null, '1', null, null, null, null, 0);
INSERT INTO `sys_setting` VALUES ('4', '1', 'crawlerInterface', '爬虫接口地址', 'http://127.0.0.1:8080/crawler/wbsiteStore', '', '1', '549d321508db446e9bcaa477835fe5f1', '2017-06-27 10:46:53', null, null, '0');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `user_name` varchar(64) NOT NULL COMMENT '用户名',
  `real_name` varchar(36) DEFAULT NULL COMMENT '用户真实姓名',
  `password` varchar(36) NOT NULL COMMENT '密码',
  `user_type` int(3) NOT NULL COMMENT '用户类型',
  `telephone_number` varchar(16) DEFAULT NULL COMMENT '电话号码',
  `cell_phone_number` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `user_img` varchar(125) DEFAULT NULL COMMENT '用户头像',
  `user_desc` varchar(512) DEFAULT NULL COMMENT '用户描述',
  `dept_id` varchar(36) NOT NULL COMMENT '所属组织机构',
  `status` int(3) DEFAULT NULL COMMENT '状态',
  `create_user_id` varchar(36) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` varchar(36) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_flag` int(3) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('549d321508db446e9bcaa477835fe5f1', 'admin', '系统管理员', 'e10adc3949ba59abbe56e057f20f883e', '1', null, null, null, '/images/userImg/avatar5.png', null, '1', '1', '549d321508db446e9bcaa477835fe5f1', '2017-05-08 15:24:57', null, null, 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(36) NOT NULL COMMENT 'id',
  `user_id` varchar(36) NOT NULL COMMENT '用户ID',
  `role_id` varchar(36) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('5d5b40c094cd4a67bc85173811b25214', '549d321508db446e9bcaa477835fe5f1', '737933bffef640329a4f864c4e2746ba');



