package com.belykh.finalProj.command.impl.lot;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.entity.LotHeader;
import com.belykh.finalProj.entity.dbo.LotState;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.manager.ConfigurationManager;
import com.belykh.finalProj.service.LotService;
import com.belykh.finalProj.service.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserLotListCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UserLotListCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        String stateString = request.getParameter("state");
        if(stateString==null){
            stateString = LotState.ACCEPTED.name();
        }
        LotState state=null;
        try {
            state = LotState.valueOf(stateString.toUpperCase());
        }catch (IllegalArgumentException e){
            LOGGER.log(Level.ERROR, e);
        }
        HttpSession session = request.getSession(false);
        if(session!=null&&state!=null) {
            Long userId = (Long)session.getAttribute("userId");
            LotService service = ServiceFactory.getInstance().getLotService();
            try {
                List<LotHeader> lotList = service.findLotHeadersByStateAndOwnerId(userId,state);
                if (lotList.isEmpty()) {
                    request.setAttribute("lotList", null);
                    request.setAttribute("errorLotListIsEmpty", AuctionServlet.messageManager.getProperty("message.errorLotListIsEmpty"));
                } else {
                    request.setAttribute("errorLotListIsEmpty", null);
                    request.setAttribute("lotList", lotList);
                }
                result = ConfigurationManager.getProperty("path.page.user_lot_list");
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }else{
            result= ConfigurationManager.getProperty("path.page.login");
        }
        return result;
    }
}
