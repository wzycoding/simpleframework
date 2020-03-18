package com.imooc.controller.superadmin;

import com.imooc.entity.bo.ShopCategory;
import com.imooc.entity.dto.Result;
import com.imooc.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ShopCategoryOperationController {

    @Autowired
    private ShopCategoryService shopCategoryService;

    Result<Boolean> addShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        //TODO: 参数校验以及请求参数转化
        return shopCategoryService.addShopCategory(new ShopCategory());
    }

    Result<Boolean> removeShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        //TODO: 参数校验以及请求参数转化
        return shopCategoryService.removeShopCategory(1);
    }

    Result<Boolean> modifyShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        //TODO: 参数校验以及请求参数转化
        return shopCategoryService.modifyShopCategory(new ShopCategory());
    }

    Result<ShopCategory> queryShopCategoryById(HttpServletRequest req, HttpServletResponse resp) {
        //TODO: 参数校验以及请求参数转化
        return shopCategoryService.queryShopCategoryById(1);
    }


    Result<List<ShopCategory>> queryShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        //TODO: 参数校验以及请求参数转化
        return shopCategoryService.queryShopCategory(new ShopCategory(), 1, 100);
    }
}
