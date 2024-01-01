package com.example.demo.repository;

import com.example.demo.model.BookRenting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBookRentingRepository extends JpaRepository<BookRenting,Integer> {

    BookRenting findBookRentingByIdRenting(Integer id);
}
