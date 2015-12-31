package fenghuang.bookbot.service;

import java.util.Collection;

import fenghuang.bookbot.model.Book;
import fenghuang.bookbot.model.Status;
import fenghuang.bookbot.model.Tag;

public interface BookBotService {
    Collection<Status> findAllStatus();

    Collection<Tag> findAllTags();

    Collection<Book> findAllBooks();

    void addBook(Book book);

    void deleteBook(Book book);

    Book findBookById(int id);

    Collection<Book> findBookByTag(Tag tag);

    Collection<Book> findBookByStatus(Status status);
}
