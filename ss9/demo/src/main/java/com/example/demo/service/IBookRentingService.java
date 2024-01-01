package com.example.demo.service;

import com.example.demo.model.BookRenting;

public interface IBookRentingService {
    void save(BookRenting bookRenting);
    BookRenting findBookRentingByIdRenting(Integer id);
}
