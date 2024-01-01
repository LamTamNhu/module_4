package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BookRenting;
import com.example.demo.service.IBookRentingService;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Random;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookRentingService iBookRentingService;


    @ModelAttribute("bookReturn")
    public BookRenting bookRenting() {
        return new BookRenting();
    }

    @RequestMapping("")
    public ModelAndView findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "size", defaultValue = "3") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> list = iBookService.findAll(pageable);
        return new ModelAndView("/home", "list", list);
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailBook(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("/formDetail");
        Book book = iBookService.findById(id);
        modelAndView.addObject("book", book);
        if (book.getQuantity() < 1) {
            System.out.println("qua roi");
            modelAndView.addObject("error", "Sách đã cho mượn hết");
        }
        return modelAndView;
    }

    @GetMapping("/renting/{id}")
    public String rentingHandle(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Book book = iBookService.findById(id);
        int randomNumber;
        LocalDateTime startRenting;
        Random random = new Random();
        randomNumber = random.nextInt(99999) + 1;
        startRenting = LocalDateTime.now();
        BookRenting bookRenting = new BookRenting(randomNumber, false, startRenting, book);
        iBookRentingService.save(bookRenting);
        book.setQuantity(book.getQuantity() - 1);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Mượn sách " + book.getTitle() + " thành công!");
        return "redirect:/";
    }

    @GetMapping("/returnBook")
    public String returnBookHandle(@RequestParam("idRenting") Integer idRenting) {
        System.out.println(idRenting + "-----------------------------------------------------------------------");
        BookRenting bookRenting1 = iBookRentingService.findBookRentingByIdRenting(idRenting);

        if (bookRenting1 != null) {
            Book book = iBookService.findById(bookRenting1.getBook().getId());
            LocalDateTime localDateTime = LocalDateTime.now();
            book.setQuantity(book.getQuantity() + 1);

            bookRenting1.setCheckRenting(true);
            bookRenting1.setEndRenting(localDateTime);
            iBookService.save(book);
            iBookRentingService.save(bookRenting1);
        } else {
            System.out.println("loi roi alo");
            return "redirect:/";
        }


        return "redirect:/";
    }


}
