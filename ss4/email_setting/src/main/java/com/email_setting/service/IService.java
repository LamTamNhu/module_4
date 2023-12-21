package com.email_setting.service;

import com.email_setting.model.Setting;

import java.util.List;

public interface IService {
    List<String> getLanguages();

    List<Integer> getPageSizes();

    void saveSetting(Setting setting);
    Setting getSetting();
}
