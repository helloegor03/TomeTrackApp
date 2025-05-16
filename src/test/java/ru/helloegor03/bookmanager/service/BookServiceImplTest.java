package ru.helloegor03.bookmanager.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.helloegor03.bookmanager.model.Book;
import ru.helloegor03.bookmanager.model.User;
import ru.helloegor03.bookmanager.repository.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookServiceImplTest {
    private BookRepository bookRepository;
    private BookServiceImpl bookService;
    private User user;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookServiceImpl(bookRepository);

        user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setPassword("password");

    }
    @Test
    void testAddBook(){
        Book book = new Book();
        book.setTitle("mybook");
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Book savedBook = bookService.addBook(book, user);

        assertEquals("Test Book", savedBook.getTitle());
        assertEquals(user, savedBook.getUser());

        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testUpdateBook() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Updated Book");

        when(bookRepository.save(book)).thenReturn(book);

        Book updated = bookService.updateBook(book);

        assertEquals("Updated Book", updated.getTitle());
        verify(bookRepository).save(book);
    }

    @Test
    void testDeleteBook() {
        Long bookId = 123L;

        bookService.deleteBook(bookId);

        verify(bookRepository, times(1)).deleteById(bookId);
    }
}
