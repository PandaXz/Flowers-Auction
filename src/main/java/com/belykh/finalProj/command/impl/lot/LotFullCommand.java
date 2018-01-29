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

public class LotFullCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String lotIdString = request.getParameter("id");

        if(lotIdString!=null) {
            Long lotId = Long.decode(lotIdString);
            LotService service = ServiceFactory.getInstance().getLotService();
            try {
                LotFull lot = service.findFullLotInfo(lotId);
                if (lot==null) {
                    request.setAttribute("lot", null);
                    request.setAttribute("errorLotIsEmpty", AuctionServlet.messageManager.getProperty("message.errorLotIsEmpty"));
                } else {
                    request.setAttribute("errorLotIsEmpty", null);
                    request.setAttribute("lot", lot);
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }else{
            request.setAttribute("errorLotIsEmpty", AuctionServlet.messageManager.getProperty("message.errorLotIsEmpty"));
        }

        return ConfigurationManager.getProperty("path.page.lot_full");
    }
}
