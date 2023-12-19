package com.example.dictionary.service;

import com.example.dictionary.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service implements IService{
    @Autowired
    private IRepository repository;
    @Override
    public String translate(String word) {
        return repository.translate(word);
    }
}
