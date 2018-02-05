package com.belykh.flowerAuction.command.impl.lot;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.entity.LotHeader;
import com.belykh.flowerAuction.entity.dto.LotState;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.LotService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The Class UserLotListCommand.
 */
public class UserLotListCommand implements ActionCommand {

    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result;
        boolean isBuyerId = Boolean.parseBoolean(request.getParameter("isBuyer"));

        String stateString = request.getParameter("state");
        LotState state = LotState.ACCEPTED;

        if(ParameterValidator.getInstance().validateState(stateString)){
           state = LotState.valueOf(stateString.toUpperCase());
        }


        HttpSession session = request.getSession(false);
        if(session!=null) {
            Long userId = (Long)session.getAttribute("userId");
            LotService service = serviceFactory.getLotService();
            try {
                List<LotHeader> lotList=service.findLotHeadersByStateAndId(userId, state,isBuyerId );

                if (lotList.isEmpty()) {
                    request.setAttribute("lotList", null);
                    request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorLotListIsEmpty"));
                } else {
                    request.setAttribute("errorLotListIsEmpty", null);
                    request.setAttribute("lotList", lotList);
                }
                result = PathPage.USER_LOTS.getPath();
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }else{
            result= PathPage.LOGIN.getPath();
        }
        return result;
    }
}
