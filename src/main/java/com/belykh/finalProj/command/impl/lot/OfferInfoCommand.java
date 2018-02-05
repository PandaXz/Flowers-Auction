package com.belykh.finalProj.command.impl.lot;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.entity.dbo.CityDBO;
import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.AddressService;
import com.belykh.finalProj.service.FlowerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class OfferInfoCommand.
 */
public class OfferInfoCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.finalProj.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;

        FlowerService flowerService = serviceFactory.getFlowerService();
        AddressService addressService = serviceFactory.getAddressService();
        try {
            List<FlowerDBO> flowerList = flowerService.findAllFlowers();
            List<CityDBO> cityList = addressService.findAllCities();
            request.setAttribute("flowerList", flowerList);
            request.setAttribute("cityList", cityList);

            result = PathPage.OFFER_LOT.getPath();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return result;
    }
}
