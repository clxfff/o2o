package com.imooc.SchoolO2O.service.impl;

import com.imooc.SchoolO2O.dao.AreaDao;
import com.imooc.SchoolO2O.entity.Area;
import com.imooc.SchoolO2O.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
