package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.FlowerDBO;

import java.util.List;

/**
 * Created by panda on 7.1.18.
 */
public interface FlowerDAO {
    FlowerDBO findFlowerById(Long id);
    List<FlowerDBO> findAllFlowers();

    boolean addFlower(FlowerDBO flowerDBO);
    boolean delete(Long id);
}
