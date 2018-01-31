package com.belykh.finalProj.command.impl.admin;

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

public class AddedLotsCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        LotService service = ServiceFactory.getInstance().getLotService();
        try {
            List<LotHeader> lotList = service.findAddedLotHeaders();
            if(lotList.isEmpty()){
                request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorLotListIsEmpty"));
                request.setAttribute("lotList",null);
            }else{
                request.setAttribute("lotList",lotList);
                request.setAttribute("errorLotListIsEmpty", null);
            }
            result= ConfigurationManager.getProperty("path.page.added_lots");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return result;
    }
}
