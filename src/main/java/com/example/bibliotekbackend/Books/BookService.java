package com.example.bibliotekbackend.Books;

import com.example.bibliotekbackend.Customer.Customer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    Book book;

    ArrayList<Book> books;

    /**
     * Sends information to DAO class for inserting one new book.
     */
    public Map insertBook(Book book) {
        return bookDao.insertBook(book.getBook_title(), book.getBook_qty(), book.getBook_author(), book.getBook_genre(), book.getBook_year(), book.getBook_URL());
    }


    public Map search_for_a_book_everyone(Book book) {
        return bookDao.search_for_a_book_everyone(book.getCheck_book());
    }

    public Map search_for_a_book_admin(Book book) {
        return bookDao.search_for_a_book_admin(book.getCheck_book());
    }

    public Map search_for_a_book_borrow(Book book) {
        return bookDao.search_for_a_book_borrow(book.getCheck_book());
    }

    /**
     * Sends information to DAO class for deleting one book using ID_book
     */
    public Map delete_book_ID(String ID_book) {
        return bookDao.delete_book_ID(ID_book);
    }

    public Map delete_book_ISBN(String ISBN_book) {
        return bookDao.delete_book_ISBN(ISBN_book);
    }


    public Map return_book(Book book) {
        return bookDao.return_book(book.getID_book());
    }

    public Map select_all_borrowed_books() {
        return bookDao.select_all_borrowed_books();
    }


    public Map popular_books(String book_genre) {
        return bookDao.popular_books(book_genre);
    }

    public Map search_for_a_book_qty(String check_book){
        return bookDao.search_for_a_book_qty(check_book);
    }

    public Map update_book(String ISBN_book, String book_qty){
        return bookDao.update_book(ISBN_book, book_qty);
    }
}
