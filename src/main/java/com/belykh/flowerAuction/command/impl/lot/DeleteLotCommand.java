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
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The Class DeleteLotCommand.
 */
public class DeleteLotCommand implements ActionCommand {
    private static final String PARAM_HEADER_REFERER = "referer";

    private static final String PARAM_NAME_SERVLET = "auction?";

    private static final int ADMIN_NUMBER = 2;


    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;
        HttpSession session = request.getSession(false);
        Long ownerId = (Long) session.getAttribute("userId");
        boolean role = (boolean) session.getAttribute("isAdmin");
        String lotId = request.getParameter("id");

        if(ParameterValidator.getInstance().validateId(lotId)) {
            LotService service = serviceFactory.getLotService();
            try {
                if(role) {
                    service.deleteLot(Long.decode(lotId), ownerId);
                }else{
                    service.deleteLot(Long.decode(lotId));
                }

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
