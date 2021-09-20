package com.zz.example.work02.biz.controller;

import com.zz.example.work02.biz.model.City;
import com.zz.example.work02.biz.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhouzeng
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName") String cityName) {
        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public Boolean createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

}
