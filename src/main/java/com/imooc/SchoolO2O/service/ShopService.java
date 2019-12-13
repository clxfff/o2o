package com.imooc.SchoolO2O.service;

import com.imooc.SchoolO2O.dto.ShopExecution;
import com.imooc.SchoolO2O.entity.Shop;
import com.imooc.SchoolO2O.exceptions.ShopOperationException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.stream.FileCacheImageOutputStream;
import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
