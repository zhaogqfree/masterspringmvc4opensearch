package com.sample.masterspringmvc4opensearch.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sample.masterspringmvc4opensearch.entity.AreaInfo;
import com.sample.masterspringmvc4opensearch.service.WeatherInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * HelloController
 * TODO
 *
 * @author ZhaoGQ
 * 2019/1/19
 * 1.0
 **/
@Controller
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private WeatherInfoService weatherInfoService;

    @RequestMapping("/")
    public String home() {
        return "layout/searchPage";
    }


    @RequestMapping("/result")
    public String hello(@RequestParam(value = "area", defaultValue = "北京") String areaName, Model model) {
        try {
            String result = weatherInfoService.weatherInfo(areaName);
            String list = JSONObject.parseObject(result).getJSONObject("showapi_res_body").getString("list");
            logger.info("\nlist: {}", list);
            List<AreaInfo> cityList = JSON.parseArray(list, AreaInfo.class);
            model.addAttribute("city", areaName);
            model.addAttribute("list", cityList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "resultPage";

    }

    @PostMapping(value = "/postSearch")
    public String postSearch(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {
        String areaName = httpServletRequest.getParameter("area");
        logger.info("areaName: {}",areaName);
        if (areaName.toLowerCase().contains("东京")) {
            redirectAttributes.addFlashAttribute("error", "Try using spring instead!");
            return "redirect:/";
        }
        redirectAttributes.addAttribute("area", areaName);
        return "redirect:result";
    }

}

