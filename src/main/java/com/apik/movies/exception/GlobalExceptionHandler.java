package com.apik.movies.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 👇 JSP कन्ट्रोलरहरू मात्र यो प्याकेजभित्र हुनुपर्छ, REST कन्ट्रोलर्कै होइन!
@ControllerAdvice(basePackages = "com.apik.movies.webcontroller") 
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFound(ResourceNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error-page"; 
    }
}