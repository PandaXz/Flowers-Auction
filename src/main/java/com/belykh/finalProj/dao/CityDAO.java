package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.City;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface CityDAO {

    City findCityById(Long id);
    List<City> findAllCities();
    List<City> findCitiesByCountryId(Long countryId);

    boolean addCity(City city);
    boolean delete(Long id);
}
