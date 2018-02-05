package com.belykh.flowerAuction.service;

import com.belykh.flowerAuction.entity.LotFull;
import com.belykh.flowerAuction.entity.LotHeader;
import com.belykh.flowerAuction.entity.dto.LotState;
import com.belykh.flowerAuction.exception.ServiceException;

import javax.servlet.http.Part;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The Interface LotService.
 */
public interface LotService {

    /**
     * Find lot headers by state.
     *
     * @param state the state
     * @return the list
     * @throws ServiceException the service exception
     */
    List<LotHeader> findLotHeadersByState(LotState state) throws ServiceException;
    
    /**
     * Deny lot.
     *
     * @param lotId the lot id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean denyLot(Long lotId) throws ServiceException;
    
    /**
     * Find lot headers by state and id.
     *
     * @param id the id
     * @param state the state
     * @param isBuyer the is buyer
     * @return the list
     * @throws ServiceException the service exception
     */
    List<LotHeader> findLotHeadersByStateAndId(Long id, LotState state, boolean isBuyer) throws ServiceException;
    
    /**
     * Find full lot info.
     *
     * @param id the id
     * @return the lot full
     * @throws ServiceException the service exception
     */
    LotFull findFullLotInfo(Long id) throws ServiceException;
    
    /**
     * Delete lot.
     *
     * @param id the id
     * @param ownerId the owner id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean deleteLot(Long id,Long ownerId) throws ServiceException;

    /**
     * Delete lot.
     *
     * @param id the id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean deleteLot(Long id) throws ServiceException;

    /**
     * Buy lot.
     *
     * @param id the id
     * @param buyerId the buyer id
     * @param price the price
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean buyLot(Long id, Long buyerId, BigDecimal price) throws ServiceException;
    
    /**
     * Pay lot.
     *
     * @param lotId the lot id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean payLot(Long lotId) throws ServiceException;
    
    /**
     * Offer lot.
     *
     * @param ownerId the owner id
     * @param flowerId the flower id
     * @param cityId the city id
     * @param street the street
     * @param houseNumber the house number
     * @param price the price
     * @param count the count
     * @param end the end
     * @param description the description
     * @param image the image
     * @param filePath the file path
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean offerLot(Long ownerId, Long flowerId, Long cityId, String street, Integer houseNumber, BigDecimal price, Integer count, LocalDateTime end, String description, Part image, String filePath) throws ServiceException;
    
    /**
     * Approve lot.
     *
     * @param lotId the lot id
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    boolean approveLot(Long lotId) throws ServiceException;
}
