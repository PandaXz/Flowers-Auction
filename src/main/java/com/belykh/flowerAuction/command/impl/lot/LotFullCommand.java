package com.belykh.flowerAuction.command.impl.lot;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.entity.LotFull;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.LotService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class LotFullCommand.
 */
public class LotFullCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String lotId = request.getParameter("id");

        if(ParameterValidator.getInstance().validateId(lotId)) {

            LotService service = serviceFactory.getLotService();
            try {
                LotFull lot = service.findFullLotInfo(Long.decode(lotId));
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

        return PathPage.LOT_INFORMATION.getPath();
    }
}
