package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.AuctionDBO;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface AuctionDAO {
    AuctionDBO findAuctionById(Long id);
    List<AuctionDBO> findAllAuctions();

    boolean addAuction(AuctionDBO auctionDBO);
    boolean delete(Long id);
}
