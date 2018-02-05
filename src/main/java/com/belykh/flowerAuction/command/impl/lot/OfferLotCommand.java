package com.belykh.flowerAuction.command.impl.lot;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.LotService;
import com.belykh.flowerAuction.util.ParameterValidator;
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

/**
 * The Class OfferLotCommand.
 */
public class OfferLotCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OfferLotCommand.class);


    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;

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


        Part filePart;
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
