-- 用户表
CREATE TABLE `t_user`  (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `nickname` varchar(32) NULL COMMENT '名称',
    `username` varchar(32) NULL COMMIT '登入账号',
    `mobile` varchar(20) NULL COMMIT '手机号',
    `emial` varchar(20) NULL COMMIT '手机号',
    `password` varchar(128) NULL COMMIT '密码',
    `avatar_url` varchar(20) NULL COMMIT '头像',
    `status` tinyint(1) NOT NULL COMMIT '状态',
    `delete_flag` bigint(20) NULL COMMIT '删除标记',
    `create_time` datetime(0) NOT NULL COMMENT '创建时间',
    `update_time` datetime(0) NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT= '用户表';

-- 用户收货地址表
CREATE TABLE `t_user_address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '账号ID',
  `receiver_name` varchar(128) DEFAULT NULL COMMENT '收件人',
  `mobile` varchar(64) DEFAULT NULL COMMENT '收件人电话',
  `is_default` tinyint(1) DEFAULT NULL COMMENT '是否默认',
  `country` varchar(255) DEFAULT NULL COMMENT '国家',
  `province` varchar(50) DEFAULT NULL COMMENT '省',
  `province_code` varchar(100) DEFAULT NULL COMMENT '省编码',
  `city` varchar(50) DEFAULT NULL COMMENT '市',
  `city_code` varchar(100) DEFAULT NULL COMMENT '市编码',
  `district` varchar(200) DEFAULT NULL COMMENT '区县',
  `district_code` varchar(100) DEFAULT NULL COMMENT '区县编码',
  `street` varchar(200) DEFAULT NULL COMMENT '街道',
  `street_code` varchar(100) DEFAULT NULL COMMENT '街道编码',
  `details` varchar(1000) DEFAULT NULL COMMENT '详细地址信息',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `tenant_id` varchar(64) DEFAULT NULL COMMENT '租户ID',
  `delete_flag` bigint(20) NULL COMMIT '删除标记',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户地址信息表';

-- 库存表
CREATE TABLE `t_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `item_id` bigint(20) NOT NULL COMMENT '商品id',
  `sku_id` bigint(20) NOT NULL COMMENT 'skuId',
  `quantity` bigint(20) unsigned NOT NULL COMMENT '库存',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT= '库存表';

-- 商品表(默认只有一个店铺)
CREATE TABLE `t_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `item_code` varchar(40) DEFAULT NULL COMMENT '商品编码',
  `name` varchar(200) NOT NULL DEFAULT '' COMMENT '商品名称',
  `main_url` varchar(1000) DEFAULT NULL COMMENT '主图',
  `other_url` varchar(1000) DEFAULT NULL COMMENT '其他的图片',
  `low_price` int(11) DEFAULT NULL COMMENT '最低价格',
  `high_price` int(11) DEFAULT NULL COMMENT '最高价格',
  `status` tinyint(1) NOT NULL COMMENT '状态：1.上架 2.下架 3.冻结 4.删除 5.正常',
  `sale_num` bigint(20) DEFAULT '0' COMMENT '销售数量',
  `on_shelf_time` datetime DEFAULT NULL COMMENT '上架时间',
  `off_shelf_time` datetime DEFAULT NULL COMMENT '下架时间',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT= '商品表';

-- sku表
CREATE TABLE `t_sku` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `sku_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `sku_code` varchar(40) DEFAULT NULL COMMENT 'sku编码',
  `item_id` bigint(20) NOT NULL COMMENT '商品id',
  `status` tinyint(1) NOT NULL COMMENT '商品状态',
  `detail` varchar(1024) DEFAULT NULL COMMENT '详情',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT= '商品SKU表';

-- 订单表
CREATE TABLE `t_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `pay_no` varchar(64) DEFAULT NULL COMMENT '支付唯一单号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '消费者id',
  `username` varchar(128) DEFAULT NULL COMMENT '消费者名称',
  `user_mobile` varchar(32) DEFAULT NULL COMMENT '消费者手机号',
  `status` tinyint(6) DEFAULT NULL COMMENT '订单状态',
  `amount` bigint(20) DEFAULT NULL COMMENT '商品总价',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `user_remark` varchar(255) DEFAULT NULL COMMENT '用户订单备注',
  `pay_time` datetime DEFAULT NULL COMMENT '支付完成时间',
  `delete_flag` tinyint(1) DEFAULT NULL COMMENT '是否删除  1是0否',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT= '订单表';

-- 订单收货地址
CREATE TABLE `t_order_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '消费者id',
  `receiver` varchar(255)  DEFAULT NULL COMMENT '收货人姓名',
  `mobile` varchar(32)  DEFAULT NULL COMMENT '收货人电话',
  `province_id` varchar(20) DEFAULT NULL COMMENT '省编号',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city_id` varchar(20) DEFAULT NULL COMMENT '市编号',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `region_id` varchar(20) DEFAULT NULL COMMENT '区编号',
  `region` varchar(20) DEFAULT NULL COMMENT '区',
  `street_id` varchar(20) DEFAULT NULL COMMENT '街道编号',
  `street` varchar(64) DEFAULT NULL COMMENT '街道',
  `detail` varchar(256) DEFAULT NULL COMMENT '地址详情',
  `zip` varchar(32) DEFAULT NULL COMMENT '邮编',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT= '订单收货地址表';
