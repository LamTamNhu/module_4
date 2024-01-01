package com.example.demo.service.iml;

import com.example.demo.model.BookRenting;
import com.example.demo.repository.IBookRentingRepository;
import com.example.demo.service.IBookRentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRentingService implements IBookRentingService {
    @Autowired
    private  IBookRentingRepository iBookRentingRepository;

    @Override
    public void save(BookRenting bookRenting) {
        iBookRentingRepository.save(bookRenting);
    }

    @Override
    public BookRenting findBookRentingByIdRenting(Integer id) {
        return iBookRentingRepository.findBookRentingByIdRenting(id);
    }
}
