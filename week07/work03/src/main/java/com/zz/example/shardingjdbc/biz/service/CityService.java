package com.zz.example.shardingjdbc.biz.service;


import com.zz.example.shardingjdbc.biz.model.City;

/**
 * @author zhouzeng
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名称
     * @return 城市
     */
    City findCityByName(String cityName);

    /**
     * 创建城市
     *
     * @param city 城市
     * @return 是否成功
     */
    Boolean createCity(City city);
}
