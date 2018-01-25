package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.AuctionDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface AuctionDAO {
    AuctionDBO findAuctionById(Long id) throws DAOException;
    List<AuctionDBO> findAllAuctions() throws DAOException;
    List<AuctionDBO> findActualAuctions() throws DAOException;
    boolean addAuction(AuctionDBO auctionDBO) throws DAOException;
    boolean delete(Long id) throws DAOException;
}
