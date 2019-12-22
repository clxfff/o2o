package com.imooc.SchoolO2O.service;

import com.imooc.SchoolO2O.dto.ShopExecution;
import com.imooc.SchoolO2O.entity.Shop;
import com.imooc.SchoolO2O.exceptions.ShopOperationException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.stream.FileCacheImageOutputStream;
import java.io.File;
import java.io.InputStream;

public interface ShopService {
    /* 通过店铺Id查找店铺 */
    Shop getByShopId(long shopId);

    /* 更新店铺的信息，包括对图片的处理*/
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String filename) throws ShopOperationException;

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
