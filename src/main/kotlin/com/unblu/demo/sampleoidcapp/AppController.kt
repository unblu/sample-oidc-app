package com.unblu.demo.sampleoidcapp

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AppController {

	@GetMapping("/")

	fun index(@AuthenticationPrincipal user: UserDetails,
			  model: Model): String {
		model["user"] = user.username
		return "index"
	}

}