package com.imooc.schoolo2o.service;

import com.imooc.schoolo2o.dto.ShopExecution;
import com.imooc.schoolo2o.entity.Shop;
import com.imooc.schoolo2o.exceptions.ShopOperationException;

import java.io.InputStream;

public interface ShopService {
    /* 通过店铺Id查找店铺 */
    Shop getByShopId(long shopId);

    /* 更新店铺的信息，包括对图片的处理*/
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String filename) throws ShopOperationException;

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
