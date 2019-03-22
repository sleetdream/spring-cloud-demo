package com.example.controller;

import com.example.consts.ResultConsts;
import com.example.exception.DefaultException;
import com.example.validator.PwdCheck;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

@Validated
@RestController
@RequestMapping(value="/demo")
public class DemoController {

    @GetMapping(value = "/email")
    public String email(@Email(message = "邮件格式错误") String email){
        return "ok";
    }

    @GetMapping(value = "/pwd")
    public String pwd(@PwdCheck(message = "密码格式错误" ) String pwd)  {
        return "ok";
    }

    @GetMapping(value = "/err")
    public String err(){
        throw new DefaultException(0,"Error");
    }

    @GetMapping(value = "/error")
    public Integer error(){
        return 0/0;
    }

    @GetMapping(value = "/ok")
    public ResultConsts ok(){
        return ResultConsts.OK;
    }

    @GetMapping(value = "/isnull")
    public String isnull(){
        return null;
    }

    @GetMapping(value = "/blank")
    public String isblank(){
        return "";
    }
}
