package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.LotStoryDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

/**
 * Created by panda on 14.1.18.
 */
public interface LotStoryDAO {

    LotStoryDBO findLotStoryById(Long id) throws DAOException;
    List<LotStoryDBO> findLotStoryByUserId(Long userId) throws DAOException;
    List<LotStoryDBO> findLotStoryByLotId(Long lotId) throws DAOException;
    boolean addLotStory(LotStoryDBO lotStoryDBO) throws DAOException;
    boolean delete(Long id) throws DAOException;
}
