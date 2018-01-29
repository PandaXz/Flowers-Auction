package com.belykh.finalProj.command.impl.lot;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.entity.LotFull;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.manager.ConfigurationManager;
import com.belykh.finalProj.service.LotService;
import com.belykh.finalProj.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.net.URL;

public class DeleteLotCommand implements ActionCommand {
    private static final String PARAM_HEADER_REFERER = "referer";

    private static final String PARAM_NAME_SERVLET = "auction?";



    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        HttpSession session = request.getSession(false);
        Long ownerId = (Long) session.getAttribute("userId");
        String lotIdString = request.getParameter("id");

        if(lotIdString!=null) {
            Long lotId = Long.decode(lotIdString);
            LotService service = ServiceFactory.getInstance().getLotService();
            try {
                service.deleteLot(lotId,ownerId);
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

        result = ConfigurationManager.getProperty("path.page.main");

        return result;
    }

}
