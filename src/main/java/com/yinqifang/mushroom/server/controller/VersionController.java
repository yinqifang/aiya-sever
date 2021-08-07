package com.yinqifang.mushroom.server.controller;

import com.yinqifang.mushroom.server.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chris Yin
 * @date 2021-08-06
 */
@Controller
@RequestMapping("/version")
public class VersionController {

    @Autowired
    private VersionService versionService;

    /**
     * 最新版本
     */
    @ResponseBody
    @GetMapping("/latest")
    public String latest() {
        return versionService.getLatest();
    }
}
