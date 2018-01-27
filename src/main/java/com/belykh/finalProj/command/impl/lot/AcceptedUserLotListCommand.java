package com.belykh.finalProj.command.impl.lot;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.manager.ConfigurationManager;
import com.belykh.finalProj.service.LotService;
import com.belykh.finalProj.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AcceptedUserLotListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        HttpSession session = request.getSession(false);
        if(session!=null) {
            Long userId = (Long)session.getAttribute("userId");;
            LotService service = ServiceFactory.getInstance().getLotService();
            try {
                List<LotHeader> lotList = service.findAcceptedLotHeaders(userId);
                if (lotList.isEmpty()) {
                    request.setAttribute("lotList", null);
                    request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorLotListIsEmpty"));
                } else {
                    request.setAttribute("errorLotListIsEmpty", null);
                    request.setAttribute("lotList", lotList);
                }
                result = ConfigurationManager.getProperty("path.page.accepted_user_lot_list");
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }else{
            result= ConfigurationManager.getProperty("path.page.login");
        }
        return result;
    }
}
