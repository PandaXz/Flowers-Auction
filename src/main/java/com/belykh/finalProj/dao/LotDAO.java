package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.LotDBO;
import com.belykh.finalProj.entity.LotState;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

/**
 * Created by panda on 8.1.18.
 */
public interface LotDAO {

    LotDBO findLotById(Long id) throws DAOException;
    List<LotDBO> findAllLots() throws DAOException;
    boolean changeCurrentPrice(Double newPrice);
    boolean changeBuyer(Long userId);
    boolean changeState(LotState state);

    boolean addLot(LotDBO lotDBO) throws DAOException;
    boolean delete(Long id) throws DAOException;
}
