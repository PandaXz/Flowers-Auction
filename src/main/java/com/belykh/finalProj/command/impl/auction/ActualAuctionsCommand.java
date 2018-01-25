package com.belykh.finalProj.command.impl.auction;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActualAuctionsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
//        AuctionService service = ServiceFactory.getInstance().getAuctionService();
//        try {
//            List<AuctionDBO> auctionList = service.findActualAuctions();
//            if(auctionList.isEmpty()){
//                request.setAttribute("errorAuctionListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorAuctionListIsEmpty"));
//                request.setAttribute("auctionList",null);
//            }else{
//                request.setAttribute("errorAuctionListIsEmpty", null);
//                request.setAttribute("auctionList",auctionList);
//            }
//            result= ConfigurationManager.getProperty("path.page.main");
//        } catch (ServiceException e) {
//            throw new CommandException(e);
//        }
        return result;
    }
}
