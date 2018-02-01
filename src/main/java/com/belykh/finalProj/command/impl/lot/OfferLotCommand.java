package com.belykh.finalProj.command.impl.lot;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.LotService;
import com.belykh.finalProj.service.ServiceFactory;
import com.belykh.finalProj.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

public class OfferLotCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;

        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");

        String flowerId = request.getParameter("flowerId");
        String cityId = request.getParameter("cityId");
        String street = request.getParameter("street");
        String houseNumber = request.getParameter("houseNumber");
        String price = request.getParameter("price");
        String count = request.getParameter("count");
        String description = request.getParameter("description");
        String end = request.getParameter("end");

        ParameterValidator validator = ParameterValidator.getInstance();
        if (validator.validateId(flowerId) && validator.validateId(cityId)
                && validator.validateStreet(street) && validator.validateNumber(houseNumber)
                && validator.validateMoney(price) && validator.validateNumber(count) && validator.validateDateTime(end)&&description!=null) {
            LotService service = ServiceFactory.getInstance().getLotService();

            try {
                if (service.offerLot(userId,Long.decode(flowerId),Long.decode(cityId),street,Integer.decode(houseNumber),Double.parseDouble(price),Integer.decode(count),LocalDateTime.parse(end),description)) {
                    result = PathPage.MAIN.getPath();
                } else {
                    request.setAttribute("errorOfferMessage", AuctionServlet.messageManager.getProperty("message.errorOffer"));
                    result = PathPage.OFFER_LOT.getPath();
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }

        }
        return result;
    }
}
