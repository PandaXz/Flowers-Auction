package com.belykh.flowerAuction.command.impl.lot;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.entity.dto.CityDTO;
import com.belykh.flowerAuction.entity.dto.FlowerDTO;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.AddressService;
import com.belykh.flowerAuction.service.FlowerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The Class OfferInfoCommand.
 */
public class OfferInfoCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;

        FlowerService flowerService = serviceFactory.getFlowerService();
        AddressService addressService = serviceFactory.getAddressService();
        try {
            List<FlowerDTO> flowerList = flowerService.findAllFlowers();
            List<CityDTO> cityList = addressService.findAllCities();
            request.setAttribute("flowerList", flowerList);
            request.setAttribute("cityList", cityList);

            result = PathPage.OFFER_LOT.getPath();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return result;
    }
}
