package com.unreview.controller;

import com.unreview.service.interfaces.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/test")
public class TestController {

    @Autowired
    private ITestService service;

    @RequestMapping(value = "my",method = RequestMethod.GET)
    public Integer getData()
    {

        return service.get();
    }
}
