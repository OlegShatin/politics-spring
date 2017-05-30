package ru.kpfu.itis.group11501.shatin.politics_web_project.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lenovo on 18.03.2017.
 */

@Controller
@PreAuthorize("isAnonymous()")
public class LoginPageController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String doGet() {
        return "login";
    }

}