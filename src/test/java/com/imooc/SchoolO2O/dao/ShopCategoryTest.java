package com.imooc.SchoolO2O.dao;

import com.imooc.SchoolO2O.BaseTest;
import com.imooc.SchoolO2O.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryTest extends BaseTest{
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory()
    {
        /*List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(1,shopCategoryList.size());*/
        ShopCategory testCategory = new ShopCategory();
        //ShopCategory parentCategory = new ShopCategory();
       // parentCategory.setShopCategoryId(1L);
        //testCategory.setParent(parentCategory);
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(testCategory);
       // assertEquals(1,shopCategoryList.size());
        System.out.println(shopCategoryList.get(0).getShopCategoryName());
    }
}

