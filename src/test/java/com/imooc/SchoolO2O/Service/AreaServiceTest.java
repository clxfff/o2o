package com.imooc.SchoolO2O.Service;

import com.imooc.SchoolO2O.BaseTest;
import com.imooc.SchoolO2O.entity.Area;
import com.imooc.SchoolO2O.service.AreaService;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals("西苑",areaList.get(0).getAreaName());
    }

}
