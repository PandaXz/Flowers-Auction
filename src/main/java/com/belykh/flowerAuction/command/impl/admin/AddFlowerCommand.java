package com.belykh.flowerAuction.command.impl.admin;

import com.belykh.flowerAuction.command.ActionCommand;
import com.belykh.flowerAuction.constant.PathPage;
import com.belykh.flowerAuction.controller.AuctionServlet;
import com.belykh.flowerAuction.exception.CommandException;
import com.belykh.flowerAuction.exception.ServiceException;
import com.belykh.flowerAuction.service.FlowerService;
import com.belykh.flowerAuction.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class AddFlowerCommand.
 */
public class AddFlowerCommand implements ActionCommand {
    
    /* (non-Javadoc)
     * @see com.belykh.flowerAuction.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

        String flowerName = request.getParameter("flowerName");

        ParameterValidator validator = ParameterValidator.getInstance();
        if(flowerName!=null) {
            if (validator.validateName(flowerName)) {
                FlowerService service = serviceFactory.getFlowerService();
                try {
                    if (!service.addFlower(flowerName)) {
                        request.setAttribute("errorAddMessage", AuctionServlet.messageManager.getProperty("message.errorAddFlowerMessage"));
                    }
                } catch (ServiceException e) {
                    throw new CommandException(e);
                }
            } else {
                request.setAttribute("errorAddMessage", AuctionServlet.messageManager.getProperty("message.errorAddFlowerMessage"));
            }
        }
        return PathPage.ADD_FLOWER.getPath();
    }
}
