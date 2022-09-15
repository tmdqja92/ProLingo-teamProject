package net.softsociety.testboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {
	
	@GetMapping("/pages-sign-in")
	public String sign_in() {
		log.debug("called Sign_In");
		return "pages-sign-in";
	}
}
