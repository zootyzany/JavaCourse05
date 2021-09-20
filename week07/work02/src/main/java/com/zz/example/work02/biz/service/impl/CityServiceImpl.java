package com.zz.example.work02.biz.service.impl;

import com.zz.example.work02.annotation.Master;
import com.zz.example.work02.annotation.Slave;
import com.zz.example.work02.biz.dao.CityDao;
import com.zz.example.work02.biz.model.City;
import com.zz.example.work02.biz.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhouzeng
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    @Slave
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    @Master
    public Boolean createCity(City city) {
        return cityDao.create(city) == 1;
    }

}
