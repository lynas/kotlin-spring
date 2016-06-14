package com.lynas.controller

import com.lynas.model.AppUser
import com.lynas.service.AppUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class HomeController @Autowired constructor(val appUserService: AppUserService){

    @RequestMapping(value = "/")
    fun home():String{
        return "home"
    }
    @RequestMapping(value = "/addUser")
    fun addUser():String{
        appUserService.add(AppUser(4,"n7","p7","R7"))
        return "redirect:/"
    }



}