package com.stafffmanagement.staffmanagement.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class PortalUserResource {
    @GetMapping()
    public  String showUser(){
        return "User Authenticated";
    }
}
