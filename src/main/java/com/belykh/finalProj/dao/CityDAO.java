package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.CityDBO;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface CityDAO {

    CityDBO findCityById(Long id);
    List<CityDBO> findAllCities();
    List<CityDBO> findCitiesByCountryId(Long countryId);

    boolean addCity(CityDBO cityDBO);
    boolean delete(Long id);
}
