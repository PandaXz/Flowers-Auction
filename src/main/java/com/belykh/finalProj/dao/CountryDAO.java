package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.Country;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface CountryDAO {

    Country findCountryById(Long id);
    List<Country> findAllCountries();

    boolean addCountry(Country country);
    boolean delete(Long id);
}
