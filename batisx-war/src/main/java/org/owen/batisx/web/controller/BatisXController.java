/**
 * owen.org Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package org.owen.batisx.web.controller;

import org.owen.batisx.entity.DataBaseVo;
import org.owen.batisx.service.BatisXService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author owenludong.lud
 * @version $Id: BatisXController, v 0.1  2015/4/18 17:27  owenludong.lud Exp $$
 */
@Controller
public class BatisXController {

    @Resource
    private BatisXService batisXService;
    private static final Logger logger = LoggerFactory.getLogger(BatisXController.class);

    @RequestMapping("test.htm")
    @ResponseBody
    public String test() {
        return "hello world";
    }

    @RequestMapping("connDb.htm")
    public ModelAndView connDb(String dbUrl, String username, String password) {
        ModelAndView modelAndView = new ModelAndView("tables");

        try {
            DataBaseVo dataBaseVo = batisXService.connectDB(dbUrl, username, password);
            modelAndView.addObject("database", dataBaseVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            modelAndView.addObject("failMsg", e.getMessage());
        }
        return modelAndView;
    }
}
