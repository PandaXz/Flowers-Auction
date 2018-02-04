package com.belykh.finalProj.command.impl.admin;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.AddressService;
import com.belykh.finalProj.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCityCommand implements ActionCommand {

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
