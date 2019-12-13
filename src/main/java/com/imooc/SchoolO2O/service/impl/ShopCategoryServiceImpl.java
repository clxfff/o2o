package com.imooc.SchoolO2O.service.impl;

import com.imooc.SchoolO2O.dao.ShopCategoryDao;
import com.imooc.SchoolO2O.entity.ShopCategory;
import com.imooc.SchoolO2O.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {

        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
