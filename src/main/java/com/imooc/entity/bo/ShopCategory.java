package com.imooc.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * 店铺分类实体类
 */
@Data
public class ShopCategory {
    /**
     * 主键id
     */
    private Long shopCategoryId;
    /**
     * 分类名称
     */
    private String shopCategoryName;
    /**
     * 类别描述
     */
    private String shopCategoryDesc;
    /**
     * 类别图片地址
     */
    private String shopCategoryImg;
    /**
     * 权重，越大越排在前面
     */
    private Integer priority;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最近的更新时间
     */
    private Date lastEditTime;
    /**
     * 父类别
     */
    private ShopCategory parent;
}
