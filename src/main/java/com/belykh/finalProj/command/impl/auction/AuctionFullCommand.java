package com.belykh.finalProj.command.impl.auction;

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
import java.util.List;

public class AuctionFullCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        Long id = Long.decode(request.getParameter("id")) ;
        LotService service = ServiceFactory.getInstance().getLotService();
        try {
            List<LotHeader> lotList = service.findAcceptedLotHeaders(id);
            if(lotList.isEmpty()){
                request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorLotListIsEmpty"));
                request.setAttribute("lotList",null);
            }else{
                request.setAttribute("errorLotListIsEmpty", null);
                request.setAttribute("lotList",lotList);
            }
            result= ConfigurationManager.getProperty("path.page.auction");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return result;
    }
}
