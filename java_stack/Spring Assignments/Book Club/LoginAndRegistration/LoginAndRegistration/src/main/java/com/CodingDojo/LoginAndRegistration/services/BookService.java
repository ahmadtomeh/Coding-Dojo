package com.CodingDojo.LoginAndRegistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingDojo.LoginAndRegistration.models.Book;
import com.CodingDojo.LoginAndRegistration.models.User;
import com.CodingDojo.LoginAndRegistration.repositories.BookRepository;
@Service
public class BookService {
	@Autowired
    private BookRepository bookRepo;
	
	public BookService (BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBooks = bookRepo.findById(id);
		if (optionalBooks.isPresent()) {
			return optionalBooks.get();
		} else {
			return null;
		}
	}
	
	public Book updateBook(Book book) {
		Optional<Book> obook = bookRepo.findById(book.getId());
		Book a = obook.get();
		a = book;
		bookRepo.save(a);
		return bookRepo.save(book);
	}
	
	public void deleteBook(Long id) {
		Optional<Book> optionalBooks = bookRepo.findById(id);
		if (optionalBooks.isPresent()) {
			bookRepo.deleteById(id);
		}
	}
	public List <Book> notborrow(){
		return bookRepo.findByuserborrow(null);
	}
	
	public List <Book> borrowed(User user){
		return bookRepo.findByuserborrow(user);
	}
}
