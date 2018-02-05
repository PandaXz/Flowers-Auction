package com.belykh.finalProj.command.impl.lot;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.LotService;
import com.belykh.finalProj.util.ParameterValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferLotCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OfferLotCommand.class);


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


        Part filePart = null;
        try {
            filePart  = request.getPart("img");
        } catch (IOException|ServletException e) {
            throw new CommandException(e);
        } finally {
            request.setAttribute("errorOfferMessage", AuctionServlet.messageManager.getProperty("message.errorOffer"));
            result = PathPage.OFFER_LOT.getPath();
        }
        LOGGER.debug(userId+" "+Long.decode(flowerId)+" "+Long.decode(cityId)+" "+street+" "+Integer.decode(houseNumber)+" "+new BigDecimal(price)+" "+Integer.decode(count)+" "+LocalDateTime.parse(end)+" "+description+" "+filePart );
        ParameterValidator validator = ParameterValidator.getInstance();
        if (validator.validateId(flowerId) && validator.validateId(cityId)
                && validator.validateStreet(street) && validator.validateNumber(houseNumber)
                && validator.validateMoney(price) && validator.validateNumber(count) && validator.validateDateTime(end)&&description!=null&&filePart!=null) {
            LotService service = serviceFactory.getLotService();

            String savePath = request.getServletContext().getRealPath("") + "images";

            try {

                if (service.offerLot(userId,Long.decode(flowerId),Long.decode(cityId),street,Integer.decode(houseNumber),new BigDecimal(price),Integer.decode(count),LocalDateTime.parse(end),description,filePart ,savePath )) {
                    result = PathPage.MAIN.getPath();
                } else {
                    request.setAttribute("errorOfferMessage", AuctionServlet.messageManager.getProperty("message.errorOffer"));
                    result = PathPage.OFFER_LOT.getPath();
                }
            } catch (ServiceException  e) {
                throw new CommandException(e);
            }

        }
        return result;
    }
}
