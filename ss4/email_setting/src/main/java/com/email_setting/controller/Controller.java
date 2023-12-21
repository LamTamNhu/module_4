package com.email_setting.controller;

import com.email_setting.model.Setting;
import com.email_setting.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private IService service;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/setting";
    }

    @GetMapping("/setting")
    public String toSettingForm(Model model) {
        System.out.println("In Get");
        List<String> languages = service.getLanguages();
        List<Integer> pageSizes = service.getPageSizes();
        Setting currentSetting = service.getSetting();
        System.out.println(currentSetting.getSignature());
        model.addAttribute("language_list", languages);
        model.addAttribute("page_list", pageSizes);
        model.addAttribute("current_setting",currentSetting);
        return "setting";
    }
    @ModelAttribute("setting")
    public Setting getSetting(){
        return service.getSetting();
    }

    @PostMapping("/setting")
    public String saveSetting(Setting newSetting) {
        if (newSetting.getSpamFilter() == null) {
            newSetting.setSpamFilter(false);
        }
        System.out.println("In Post");
        System.out.println(newSetting);
        service.saveSetting(newSetting);
        return "redirect:setting";
    }
}
