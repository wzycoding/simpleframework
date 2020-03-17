package com.imooc.service.combine;

import com.imooc.entity.dto.MainPageInfoDTO;
import com.imooc.entity.dto.Result;

public interface HeadLineShopCategoryCombineService {
    /**
     * 获取主页信息
     */
    Result<MainPageInfoDTO> getMainPageInfo();
}
