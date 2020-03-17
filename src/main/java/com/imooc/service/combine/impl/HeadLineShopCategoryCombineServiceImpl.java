package com.imooc.service.combine.impl;

import com.imooc.entity.bo.HeadLine;
import com.imooc.entity.bo.ShopCategory;
import com.imooc.entity.dto.MainPageInfoDTO;
import com.imooc.entity.dto.Result;
import com.imooc.service.combine.HeadLineShopCategoryCombineService;
import com.imooc.service.solo.HeadLineService;
import com.imooc.service.solo.ShopCategoryService;

import java.util.List;

/**
 * 头条和商品分类组合service
 */
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {

    private HeadLineService headLineService;

    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //1.获取头条列表
        HeadLine condition = new HeadLine();
        //状态为可用
        condition.setEnableStatus(1);
        //第一页的四条记录
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(condition, 1, 4);
        //2.获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 100);
        //3.合并两者并返回
        return mergeMainPageInfoResult(headLineResult, shopCategoryResult);
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult,
                                                            Result<List<ShopCategory>> shopCategoryResult) {
        //todo: 合并结果

        return null;
    }


}
