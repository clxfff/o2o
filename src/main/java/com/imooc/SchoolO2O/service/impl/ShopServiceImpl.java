package com.imooc.SchoolO2O.service.impl;

import com.imooc.SchoolO2O.dao.ShopDao;
import com.imooc.SchoolO2O.dto.ShopExecution;
import com.imooc.SchoolO2O.entity.Shop;
import com.imooc.SchoolO2O.enums.ShopStateEnum;
import com.imooc.SchoolO2O.exceptions.ShopOperationException;
import com.imooc.SchoolO2O.service.ShopService;
import com.imooc.SchoolO2O.util.PathUtil;
import com.imooc.SchoolO2O.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        /*空值判断*/
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            /*给店铺信息赋初始值*/
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            /*添加店铺信息*/
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                if (shopImgInputStream != null) {
                    /*存储图片*/
                    try {
                        addShopImg(shop, shopImgInputStream, fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImgInputStream error"+e.getMessage());
                    }
                    /*更新店铺的图片地址*/
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <=0) {
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        /*获取shop图片目录的相对值路径*/
        String dest = PathUtil.getShopImgPath(shop.getShopId());
        String shopImgInputStreamAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName, dest);
        shop.setShopImg(shopImgInputStreamAddr);
    }
}

