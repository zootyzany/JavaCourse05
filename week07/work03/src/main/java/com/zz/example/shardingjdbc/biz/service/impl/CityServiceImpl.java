package com.zz.example.shardingjdbc.biz.service.impl;

import com.zz.example.shardingjdbc.biz.dao.CityDao;
import com.zz.example.shardingjdbc.biz.model.City;
import com.zz.example.shardingjdbc.biz.service.CityService;
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
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    public Boolean createCity(City city) {
        return cityDao.create(city) == 1;
    }

}
