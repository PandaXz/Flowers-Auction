package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.Auction;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface AuctionDAO {
    Auction findAuctionById(Long id);
    List<Auction> findAllAuctions();

    boolean addAuction(Auction auction);
    boolean delete(Long id);
}
