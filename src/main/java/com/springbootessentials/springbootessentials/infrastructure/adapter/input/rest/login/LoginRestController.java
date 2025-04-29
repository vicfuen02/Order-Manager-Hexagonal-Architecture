package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.login;

import com.springbootessentials.springbootessentials.common.annotations.LogExecutionSPE;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@LogExecutionSPE
@RestController
public class LoginRestController {

    @GetMapping("/defaultLoggedIn")
    public String defaultLoggedInPage() {
        return "You have successfully logged in :)";
    }

}
