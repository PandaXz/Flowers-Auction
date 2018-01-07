package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.Flower;

import java.util.List;

/**
 * Created by panda on 7.1.18.
 */
public interface FlowerDAO {
    Flower findFlowerById(Long id);
    List<Flower> findAllFlowers();

    boolean addFlower(Flower flower);
    boolean delete(Long id);
}
