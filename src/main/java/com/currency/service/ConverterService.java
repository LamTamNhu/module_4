package com.currency.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConverterService {
    @Override
    public String convert(String type, double amount) {
        if (type.equals("USD_to_VND")) {
            return amount * 20000 + " VND";
        } else return amount / 20000 + " USD";
    }
}
