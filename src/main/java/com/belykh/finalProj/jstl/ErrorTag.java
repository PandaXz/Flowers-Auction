package com.belykh.finalProj.jstl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class ErrorTag.
 */
public class ErrorTag extends TagSupport{

    private String errorMessage;

    /**
     * Sets the error message.
     *
     * @param errorMessage the new error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /* (non-Javadoc)
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    @Override
    public int doStartTag() throws JspException {
        try {
            StringBuffer buffer = new StringBuffer();
            if(errorMessage!=null&&!errorMessage.isEmpty()) {
                buffer.append("<div class=\"alert-danger alert\">");
                buffer.append(this.errorMessage);
                buffer.append("</div>");
            }else {
                buffer.append("<br/>");
            }
            pageContext.getOut().print(buffer);
        } catch(IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }
        return SKIP_BODY;
    }
}
