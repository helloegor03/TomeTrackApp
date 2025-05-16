package ru.helloegor03.bookmanager.service;

import ru.helloegor03.bookmanager.model.Book;
import ru.helloegor03.bookmanager.model.User;

import java.util.List;

public interface BookService {
    Book addBook(Book book, User user);
    List<Book> getBookByUser(User user);
    Book getBookById(Long id);
    Book updateBook(Book book);
    void deleteBook(Long id);
    List<Book> getBooksByUser(User user);


}
