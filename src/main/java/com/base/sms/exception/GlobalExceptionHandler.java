package com.base.sms.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public String handleTypeMismatch(MethodArgumentTypeMismatchException ex, Model model) {
		model.addAttribute("error", "Invalid Input : please enter a valid number.");
		return "error";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleNotFound(NoHandlerFoundException ex, Model model) {
		model.addAttribute("error", "Invalid Input : please enter a valid number.");
		return "error";
	}

	@ExceptionHandler(Exception.class)
	public String handleGlobalException(Exception ex, Model model) {
		model.addAttribute("error", "Something went wrong. Please try again later");
		return "error";
	}
}
