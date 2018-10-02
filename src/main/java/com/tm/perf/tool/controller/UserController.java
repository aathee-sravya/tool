package com.tm.perf.tool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tm.perf.tool.api.request.LoginRequest;
import com.tm.perf.tool.api.response.CreateUserResponse;
import com.tm.perf.tool.service.UserService;

@RestController
@Configuration
@RequestMapping("user")
public class UserController {
    
    @Autowired
    UserService userService;
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
//    @RequestMapping(value = {"/createUser"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
//    public @ResponseBody CreateUserResponse createUser(@RequestBody CreateUserRequest createUserReq) {
//        LOGGER.info("UserController.createUser() - request:" + createUserReq);
//        CreateUserResponse response = walletService.createUser(createUserReq);
//        LOGGER.info("UserController.createUser() - response:" + response);
//        return response;
//    }
    
    @RequestMapping(value = {"/loginUser"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    public @ResponseBody CreateUserResponse loginUser(@RequestBody LoginRequest loginRequest) {
        LOGGER.info("UserController.loginUser() - request:" + loginRequest);
        CreateUserResponse response = userService.loginUser(loginRequest);
        LOGGER.info("UserController.loginUser() - response:" + response);
        return response;
    }
    
//    @RequestMapping(value = {"/getUserInfo"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
//    public @ResponseBody CreateUserResponse getUserInfo(@RequestParam CreateUserRequest createUserReq) {
//        LOGGER.info("UserController.createUser() - request:" + createUserReq);
//        CreateUserResponse response = walletService.createUser(createUserReq);
//        LOGGER.info("UserController.createUser() - response:" + response);
//        return response;
//    }
//    
//    @RequestMapping(value = {"/getUserRoles"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
//    public @ResponseBody CreateUserResponse getUserRoles(@RequestParam CreateUserRequest createUserReq) {
//        LOGGER.info("UserController.createUser() - request:" + createUserReq);
//        CreateUserResponse response = walletService.createUser(createUserReq);
//        LOGGER.info("UserController.createUser() - response:" + response);
//        return response;
//    }
//    
//    @RequestMapping(value = {"/getUserRoutes"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
//    public @ResponseBody CreateUserResponse getUserRoutes(@RequestParam CreateUserRequest createUserReq) {
//        LOGGER.info("UserController.createUser() - request:" + createUserReq);
//        CreateUserResponse response = walletService.createUser(createUserReq);
//        LOGGER.info("UserController.createUser() - response:" + response);
//        return response;
//    }
}
