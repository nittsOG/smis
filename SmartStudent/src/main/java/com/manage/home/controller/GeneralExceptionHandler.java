package com.manage.home.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GeneralExceptionHandler {

//    private static final Logger logger = LoggerFactory.getLogger(GeneralExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception ex) {
        // Log the exception details
//        logger.error("Exception occurred: ", ex);
        
        // Prepare the ModelAndView
        ModelAndView mav = new ModelAndView("JSP/GenericException");
        mav.addObject("msg", ex.getMessage()); // Use exception message
        return mav;
    }
}
