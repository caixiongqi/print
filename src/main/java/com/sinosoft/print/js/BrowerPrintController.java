package com.sinosoft.print.js;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "brower")
public class BrowerPrintController {
	
	@RequestMapping(value = "/print")
	public String toPage() {
		return "BrowerPrint";
	}
}
