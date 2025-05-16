package ru.helloegor03.bookmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.helloegor03.bookmanager.model.Book;
import ru.helloegor03.bookmanager.model.User;
import ru.helloegor03.bookmanager.repository.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book, User user) {
        book.setUser(user);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBookByUser(User user) {
        return bookRepository.findByUser(user);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Книга не найдена"));
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public List<Book> getBooksByUser(User user) {
        return bookRepository.findByUser(user);
    }
}
