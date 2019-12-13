package com.imooc.SchoolO2O.Service;

import com.imooc.SchoolO2O.BaseTest;
import com.imooc.SchoolO2O.dto.ShopExecution;
import com.imooc.SchoolO2O.entity.Area;
import com.imooc.SchoolO2O.entity.PersonInfo;
import com.imooc.SchoolO2O.entity.Shop;
import com.imooc.SchoolO2O.entity.ShopCategory;
import com.imooc.SchoolO2O.enums.ShopStateEnum;
import com.imooc.SchoolO2O.service.ShopService;
import com.imooc.SchoolO2O.service.ShopService;
import com.imooc.SchoolO2O.util.ImageUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;
    @Test
    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopName("测试的店铺4");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("C:/Users/clx/Desktop/car.png");
        InputStream is = new FileInputStream(shopImg);
        //CommonsMultipartFile shopImg = new CommonsMultipartFile().write("C:\\Users\\clx\\Desktop\\car.png");
        ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
        //System.out.println("aaa:"+ImageUtil.basePath);
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }
}
