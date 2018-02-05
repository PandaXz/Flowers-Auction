package com.belykh.flowerAuction.command.impl.admin;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.LotService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The Class DenyLotCommand.
 */
public class DenyLotCommand implements ActionCommand {
    private static final String PARAM_HEADER_REFERER = "referer";

    private static final String PARAM_NAME_SERVLET = "auction?";

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;
        String lotId = request.getParameter("id");

        ParameterValidator validator = ParameterValidator.getInstance();

        if(validator.validateId(lotId)) {
            LotService service = serviceFactory.getLotService();
            try {
                service.denyLot(Long.decode(lotId));
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

        result = PathPage.MAIN.getPath();
        return result;
    }
}
