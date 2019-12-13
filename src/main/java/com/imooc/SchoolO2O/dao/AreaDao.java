package com.imooc.SchoolO2O.dao;

import com.imooc.SchoolO2O.entity.Area;

import java.util.List;

public interface AreaDao {
    /*
    * 列出区域列表
    * @return arealist
    */
    List<Area> queryArea();
}
