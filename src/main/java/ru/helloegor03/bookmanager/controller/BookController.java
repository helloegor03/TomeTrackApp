package ru.helloegor03.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.helloegor03.bookmanager.config.UserDetailsImplementation;
import ru.helloegor03.bookmanager.model.Book;
import ru.helloegor03.bookmanager.model.User;
import ru.helloegor03.bookmanager.service.BookService;
import ru.helloegor03.bookmanager.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final UserService userService;
    @Autowired
    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public String viewBooks(Model model, @AuthenticationPrincipal UserDetailsImplementation userDetails) {
        if (userDetails == null) {
            return "redirect:/login";
        }
        User user = userService.getUserById(userDetails.getId());
        List<Book> books = bookService.getBooksByUser(user);
        model.addAttribute("books", books);
        model.addAttribute("newBook", new Book());
        return "books";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("newBook") Book book,
                          @AuthenticationPrincipal(expression = "user") User user) {
        bookService.addBook(book, user);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
