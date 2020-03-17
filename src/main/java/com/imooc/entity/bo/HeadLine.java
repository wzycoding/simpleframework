package com.imooc.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * 首页头条实体类
 */
@Data
public class HeadLine {
    /**
     * 主键ID
     */
    private Long lineId;
    /**
     * 头条名字
     */
    private String lineName;
    /**
     * 头条链接
     */
    private String lineLink;
    /**
     * 头条图片
     */
    private String lineImg;
    /**
     * 权重，越大越排前显示
     */
    private Integer priority;
    /**
     * 0.不可用 1可用
     */
    private Integer enableStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改时间
     */
    private Date lastEditTime;
}
