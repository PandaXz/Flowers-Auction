package com.belykh.flowerAuction.command.impl.lot;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.LotService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The Class BuyLotCommand.
 */
public class BuyLotCommand implements ActionCommand {

    private static final String PARAM_HEADER_REFERER = "referer";

    private static final String PARAM_NAME_SERVLET = "auction?";

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;
        HttpSession session = request.getSession(false);
        Long ownerId = (Long) session.getAttribute("userId");
        String lotId = request.getParameter("id");
        String price = request.getParameter("price");

        ParameterValidator validator = ParameterValidator.getInstance();

        if(validator.validateId(lotId)&&validator.validateMoney(price)) {
            LotService service = serviceFactory.getLotService();
            try {
                service.buyLot(Long.decode(lotId), ownerId, new BigDecimal(price));
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }

        try {
            URL url = new URL(request.getHeader(PARAM_HEADER_REFERER));

            request.setAttribute("redirect", PARAM_NAME_SERVLET + url.getQuery());

        } catch (MalformedURLException e) {
            throw new CommandException(e);
        }

        result= PathPage.MAIN.getPath();
        return result;
    }
}
