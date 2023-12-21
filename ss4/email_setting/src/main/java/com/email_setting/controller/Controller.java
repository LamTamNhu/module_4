package com.email_setting.controller;

import com.email_setting.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private IService service;
    @GetMapping("/")
    public String redirect(){
        return "redirect:/setting";
    }
    @GetMapping("/setting")
    public String toSettingForm(Model model){
        List<String> languages = service.getLanguages();
        List<Integer> pageSizes = service.getPageSizes();
        model.addAttribute("language_list",languages);
        model.addAttribute("page_list",pageSizes);
        return "setting";
    }
}
