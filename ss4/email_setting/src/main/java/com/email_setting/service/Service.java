package com.email_setting.service;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements IService {
    private static final List<String> languages = new ArrayList<>();
    private static final List<Integer> pageSizes = new ArrayList<>();

    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
    }

    @Override
    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public List<Integer> getPageSizes() {
        return pageSizes;
    }
}
