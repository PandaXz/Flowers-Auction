package com.belykh.finalProj.service;

import com.belykh.finalProj.entity.dbo.FlowerDBO;

public interface FlowerService {
    FlowerDBO findFlowerById(Long id);
}
