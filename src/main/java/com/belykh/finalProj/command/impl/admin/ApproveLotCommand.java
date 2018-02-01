package com.belykh.finalProj.command.impl.admin;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.exception.ServiceException;
import com.belykh.finalProj.service.LotService;
import com.belykh.finalProj.service.ServiceFactory;
import com.belykh.finalProj.util.ParameterValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;

public class ApproveLotCommand implements ActionCommand {

    private static final String PARAM_HEADER_REFERER = "referer";

    private static final String PARAM_NAME_SERVLET = "auction?";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String result = null;
        String lotId = request.getParameter("id");

        ParameterValidator validator = ParameterValidator.getInstance();

        if(validator.validateId(lotId)) {
            LotService service = ServiceFactory.getInstance().getLotService();
            try {
                service.approveLot(Long.decode(lotId));
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        }

        try {
            URL url = new URL(request.getHeader(PARAM_HEADER_REFERER));

            request.setAttribute("redirect", PARAM_NAME_SERVLET + url.getQuery());

        } catch (MalformedURLException e) {
            throw new CommandException(e);
        }

        result = PathPage.MAIN.getPath();
        return result;
    }
}
