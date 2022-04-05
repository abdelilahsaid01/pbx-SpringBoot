package com.weenko.pbx.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController
{
	
	private final static Logger logger = LoggerFactory.getLogger(MyErrorController.class);
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		logger.info("Received error: "+status+" for "+request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
		
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "errors/error_404";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "errors/error_500";
			}
		}
		return "errors/error_500";
	}
	
	@Override
    public String getErrorPath() {
        return "/error";
    }
}