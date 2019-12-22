package com.imooc.schoolo2o.dao;

import com.imooc.schoolo2o.BaseTest;
import com.imooc.schoolo2o.entity.ShopCategory;
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

