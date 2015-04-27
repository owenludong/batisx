/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author owenludong.lud
 * @version $Id: BatisXController, v 0.1  2015/4/18 17:27  owenludong.lud Exp $$
 */
@Controller
public class BatisXController {

    @RequestMapping("test.htm")
    @ResponseBody
    public String test() {
        return "hello world";
    }

    @RequestMapping("connDb.htm")
    @ResponseBody
    public String connDb(String dbUrl,String username,String password) {
        //return "dbUrl["+dbUrl+"],username ["+username+"],password ["+password+"] connect success";
        return null;
    }
}
