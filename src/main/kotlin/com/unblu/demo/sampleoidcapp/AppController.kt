package com.unblu.demo.sampleoidcapp

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal

@Controller
class AppController {

    @GetMapping("/")
    fun index(@AuthenticationPrincipal user: Principal,
              model: Model): String {
        model["user"] = extractName(user)
        return "index"
    }

    private fun extractName(user: Principal): String {
        return if (user is OAuth2AuthenticationToken) {
            (user.principal as DefaultOidcUser).fullName
        } else {
            user.name
        }
    }

}