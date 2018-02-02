package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.LotStoryDBO;
import com.belykh.finalProj.exception.DAOException;

import java.util.List;

/**
 * Created by panda on 14.1.18.
 */
public interface LotStoryDAO {

    boolean addLotStory(LotStoryDBO lotStoryDBO) throws DAOException;

    List<LotStoryDBO> findLotStoriesByLotId(Long id) throws DAOException;
}
