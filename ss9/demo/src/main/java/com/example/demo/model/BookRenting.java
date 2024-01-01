package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "book-renting")
public class BookRenting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idRenting;
    private boolean checkRenting;
    private LocalDateTime startRenting;
    private LocalDateTime endRenting;



    @ManyToOne
    @JoinColumn(name="book_id", referencedColumnName = "id")
    private Book book;

    public BookRenting() {
    }

    public BookRenting(Integer idRenting) {
        this.idRenting = idRenting;
    }

    public BookRenting(Integer idRenting, boolean checkRenting, LocalDateTime startRenting , Book book) {
        this.idRenting = idRenting;
        this.checkRenting = checkRenting;
        this.startRenting = startRenting;
        this.book = book;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRenting() {
        return idRenting;
    }

    public void setIdRenting(Integer idRenting) {
        this.idRenting = idRenting;
    }

    public boolean isCheckRenting() {
        return checkRenting;
    }

    public void setCheckRenting(boolean checkRenting) {
        this.checkRenting = checkRenting;
    }

    public LocalDateTime getStartRenting() {
        return startRenting;
    }

    public void setStartRenting(LocalDateTime startRenting) {
        this.startRenting = startRenting;
    }

    public LocalDateTime getEndRenting() {
        return endRenting;
    }

    public void setEndRenting(LocalDateTime endRenting) {
        this.endRenting = endRenting;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
