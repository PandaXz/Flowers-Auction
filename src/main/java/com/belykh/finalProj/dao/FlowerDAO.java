package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

/**
 * Created by panda on 7.1.18.
 */
public interface FlowerDAO {
    FlowerDBO findFlowerById(Long id) throws DAOException;
    List<FlowerDBO> findAllFlowers() throws DAOException;
    boolean addFlower(FlowerDBO flowerDBO) throws DAOException;
}
