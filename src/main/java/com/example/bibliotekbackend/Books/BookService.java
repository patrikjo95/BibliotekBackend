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
     * Sends information to DAO class for updating one book.
     */
    public void updateBook(int ID_book, String book_title, int book_qty, String book_author, String book_genre, String book_year, String book_URL) {
        bookDao.updateBook(ID_book, book_title, book_qty, book_author, book_genre, book_year, book_URL);
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

    /**
     * @param ID_book
     * @return gson String regarding info about one book, based on ID, sends it to DAO class.
     */
    public String downloadOneBook(int ID_book) {
        Gson gson = new Gson();
        book = bookDao.downloadOneBookByID(ID_book);
        String bookString = gson.toJson(book);
        return bookString;
    }

    public String downloadBookByTitle(String book_title) {
        return bookDao.downloadBookByTitle(book_title);
    }


    /**
     * @return gson String with information regarding all books, sends it to DAO class.
     */
    public String downloadAllBooks() {
        books = bookDao.downloadAllBooks();
        Gson gson = new Gson();
        String bookListString = gson.toJson(books);
        return bookListString;
    }

    /**
     * assigns to 'book' object, the book with highest ID, by using the newlyAddedBook() method, then...
     * returns a gson String with information regarding this most recently added book to the DAO class.
     *
     * @return please see above.
     */
    public String downloadMostRecentBook() {
        book = bookDao.newlyAddedBook();
        Gson gson = new Gson();
        return gson.toJson(book);
    }

    public Map return_book(Book book) {
        System.out.println("Toros" + book);
        return bookDao.return_book(book.getID_book());
    }

    public Map allBorrowedBooksReport(Book book) {
        System.out.println("Toros" + book);
        return bookDao.allBorrowedBooksReport(book.getCheck_book());
    }
}
