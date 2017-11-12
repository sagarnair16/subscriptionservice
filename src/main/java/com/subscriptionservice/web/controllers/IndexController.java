/**
 * 
 */
package com.subscriptionservice.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sagar
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}

}
