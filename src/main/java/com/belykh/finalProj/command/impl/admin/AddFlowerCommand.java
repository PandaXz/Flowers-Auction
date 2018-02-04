package com.belykh.finalProj.command.impl.admin;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.controller.AuctionServlet;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.FlowerService;
import com.belykh.finalProj.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFlowerCommand implements ActionCommand {
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
