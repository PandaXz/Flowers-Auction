package com.belykh.flowerAuction.command.impl.admin;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.AddressService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class AddCityCommand.
 */
public class AddCityCommand implements ActionCommand {

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        String cityName = request.getParameter("cityName");

        ParameterValidator validator = ParameterValidator.getInstance();
        if(cityName!=null) {
            if (validator.validateName(cityName)) {
                AddressService service = serviceFactory.getAddressService();
                try {
                    if (!service.addCity(cityName)) {
                        request.setAttribute("errorAddMessage", AuctionServlet.messageManager.getProperty("message.errorAddCityMessage"));
                    }
                } catch (ServiceException e) {
                    throw new CommandException(e);
                }
            } else {
                request.setAttribute("errorAddMessage", AuctionServlet.messageManager.getProperty("message.errorAddCityMessage"));
            }
        }
        return PathPage.ADD_CITY.getPath();

    }
}
