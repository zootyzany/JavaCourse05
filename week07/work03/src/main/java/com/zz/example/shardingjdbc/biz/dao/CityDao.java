package com.zz.example.shardingjdbc.biz.dao;

import com.zz.example.shardingjdbc.biz.model.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhouzeng
 */
@Mapper
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     * @return city
     */
    City findByName(@Param("cityName") String cityName);


    /**
     * 创建城市
     *
     * @param city 城市
     * @return 插入成功的条数
     */
    Integer create(City city);
}
