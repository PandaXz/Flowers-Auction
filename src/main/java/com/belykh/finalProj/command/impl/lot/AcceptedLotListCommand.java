package com.belykh.finalProj.command.impl.lot;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.LotService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class AcceptedLotListCommand.
 */
public class AcceptedLotListCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.finalProj.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        LotService service = serviceFactory.getLotService();
        try {
            List<LotHeader> lotList = service.findLotHeadersByState(LotState.ACCEPTED);
            if(lotList.isEmpty()){
                request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorLotListIsEmpty"));
                request.setAttribute("lotList",null);
            }else{
                request.setAttribute("errorLotListIsEmpty", null);
                request.setAttribute("lotList",lotList);
            }
            result= PathPage.MAIN.getPath();
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return result;
    }
}
