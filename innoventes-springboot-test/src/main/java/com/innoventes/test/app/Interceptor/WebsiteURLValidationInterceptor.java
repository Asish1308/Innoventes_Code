package com.innoventes.test.app.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;

import org.springframework.web.servlet.HandlerInterceptor;

import ch.qos.logback.core.boolex.Matcher;

public class WebsiteURLValidationInterceptor implements HandlerInterceptor {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("POST".equalsIgnoreCase(request.getMethod())) {           
            String websiteURL = request.getParameter("webSiteURL");
            if (!isValidURL(websiteURL)) {
                request.setAttribute("webSiteURL", null);
            }
        }
        return true;
    }

	private boolean isValidURL(String url) {
	    if (url == null || url.isBlank()) {
	        return false;
	    }
	    String regex = "^(https?|ftp)://[a-zA-Z0-9+&@#/%?=~_|!:,.;-]*[a-zA-Z0-9+&@#/%=~_|]$";
	    
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(url);
	    
	    // Return true if the URL matches the pattern, false otherwise
	    return matcher.matches(regex);
	}
    

 
}
