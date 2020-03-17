create table `tb_head_line` (
   `line_id` bigint NOT NULL AUTO_INCREMENT comment '头条id',
   `line_name` varchar(100) DEFAULT NULL comment '头条名称',
   `line_link`varchar(200) NOT NULL comment '头条链接',
   `line_img`varchar(200) NOT NULL comment '头条图片地址',
   `priority` int(2) DEFAULT NULL comment '展示的优先级',
   `enable_status` int(2) NOT NULL DEFAULT 0 comment '可用状态',
   `create_time`datetime DEFAULT NULL comment '创建时间',
   `last_edit_time` datetime DEFAULT NULL comment '最近修改时间',
   PRIMARY KEY (`line_id`)
)ENGINE=InnoDB AUTU_INCREMENT=1 DEFAULT CHARSET=utf-8 COMMENT '头条表';

create table `shop_category` (
    `shop_category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '店铺类别id',
    `shop_category_name` varchar(100) NOT NULL DEFAULT '' COMMENT '店铺类别名称',
    `shop_category_desc` varchar(1000) DEFAULT '' COMMENT '店铺类别描述',
    `shop_category_img` varchar(2000) COMMENT '店铺类别图片地址',
    `priority` int(2) NOT NULL DEFAULT '0' COMMENT '店铺类别展示优先级',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_edit_time` datetime DEFAULT NULL COMMENT '最近一次修改时间',
    `parent_id` bigint DEFAULT NULL COMMENT '店铺类别的父类别',
    PRIMARY KEY (`shop_category_id`),
    KEY `fk_shop_category_self` (`parent_id`),
    CONSTRAINT `fk_shop_category_self` FOREIGN KEY (`parent_id`)
    REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf-8 COMMENT COMMENT '店铺类别表';