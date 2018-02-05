package com.belykh.flowerAuction.command.impl.admin;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.entity.LotHeader;
import com.belykh.flowerAuction.entity.dto.LotState;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.LotService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The Class AddedLotsCommand.
 */
public class AddedLotsCommand implements ActionCommand{
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;
        LotService service = serviceFactory.getLotService();
        try {
            List<LotHeader> lotList = service.findLotHeadersByState(LotState.ADDED);
            if(lotList.isEmpty()){
                request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorLotListIsEmpty"));
                request.setAttribute("lotList",null);
            }else{
                request.setAttribute("lotList",lotList);
                request.setAttribute("errorLotListIsEmpty", null);
            }
            result= PathPage.ADDED_LOTS.getPath();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return result;
    }
}
