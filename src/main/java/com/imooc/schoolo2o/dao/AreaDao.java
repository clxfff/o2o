package com.imooc.schoolo2o.dao;

import com.imooc.schoolo2o.entity.Area;

import java.util.List;

public interface AreaDao {
    /*
    * 列出区域列表
    * @return arealist
    */
    List<Area> queryArea();
}
