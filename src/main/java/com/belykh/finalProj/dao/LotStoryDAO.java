package com.belykh.finalProj.dao;

import com.belykh.finalProj.entity.dbo.LotStoryDBO;
import com.belykh.finalProj.exception.DAOException;

/**
 * Created by panda on 14.1.18.
 */
public interface LotStoryDAO {

    boolean addLotStory(LotStoryDBO lotStoryDBO) throws DAOException;
}
