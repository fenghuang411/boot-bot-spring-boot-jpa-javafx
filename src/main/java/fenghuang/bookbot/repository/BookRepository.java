package fenghuang.bookbot.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fenghuang.bookbot.model.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Collection<Book> findByTags(Collection tags);

    Collection<Book> findByStatuses(Collection statuses);
}
