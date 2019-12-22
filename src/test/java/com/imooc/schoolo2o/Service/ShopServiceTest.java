package com.imooc.schoolo2o.Service;

import com.imooc.schoolo2o.BaseTest;
import com.imooc.schoolo2o.dto.ShopExecution;
import com.imooc.schoolo2o.entity.Area;
import com.imooc.schoolo2o.entity.PersonInfo;
import com.imooc.schoolo2o.entity.Shop;
import com.imooc.schoolo2o.entity.ShopCategory;
import com.imooc.schoolo2o.enums.ShopStateEnum;
import com.imooc.schoolo2o.exceptions.ShopOperationException;
import com.imooc.schoolo2o.service.ShopService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void testModifyShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(16L);
        shop.setShopName("修改后的名字噢");
        File shopImg = new File("C:/Users/clx/Desktop/1.png");
        InputStream is = new FileInputStream((shopImg));
        ShopExecution shopExecution = shopService.modifyShop(shop, is, "1.png");
        System.out.println("新的图片地址为：" + shopExecution.getShop().getShopImg());
    }
    @Test
    @Ignore
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
        shop.setShopName("测试的店铺777");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("C:/Users/clx/Desktop/1.png");
        InputStream is = new FileInputStream(shopImg);
        //CommonsMultipartFile shopImg = new CommonsMultipartFile().write("C:\\Users\\clx\\Desktop\\car.png");
        ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
        //System.out.println("aaa:"+ImageUtil.basePath);
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }
}
