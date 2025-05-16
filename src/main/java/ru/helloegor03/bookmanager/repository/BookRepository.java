package ru.helloegor03.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.helloegor03.bookmanager.model.Book;
import ru.helloegor03.bookmanager.model.User;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUser(User user);
}
