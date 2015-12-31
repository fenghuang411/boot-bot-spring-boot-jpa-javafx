package fenghuang.bookbot.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fenghuang.bookbot.model.Book;
import fenghuang.bookbot.model.Status;
import fenghuang.bookbot.model.Tag;
import fenghuang.bookbot.repository.BookRepository;
import fenghuang.bookbot.repository.StatusRepository;
import fenghuang.bookbot.repository.TagRepository;

@Service
public class BookBotServiceBean implements BookBotService {

    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Collection<Status> findAllStatus() {
	return statusRepository.findAll();
    }

    @Override
    public Collection<Tag> findAllTags() {
	return tagRepository.findAll();
    }

    @Override
    public Collection<Book> findAllBooks() {
	return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
//	book.getTags().forEach(t -> tagRepository.save(t));
	bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
	bookRepository.delete(book);
    }

    @Override
    public Book findBookById(int id) {
	return bookRepository.getOne(id);
    }

    @Override
    public Collection<Book> findBookByTag(Tag tag) {
	if (tagRepository.findOne(tag.getId()) != null) {
	    return bookRepository.findByTags(Arrays.asList(tag));
	}
	return null;
    }

    @Override
    public Collection<Book> findBookByStatus(Status status) {
	if (statusRepository.findOne(status.getId()) != null) {
	    return bookRepository.findByStatuses(Arrays.asList(status));
	}
	return null;
    }

}
