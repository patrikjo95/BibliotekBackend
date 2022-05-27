package com.example.bibliotekbackend.Books;

import com.example.bibliotekbackend.Customer.Customer;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Sends request to insert a new book to database
     */
    @GetMapping ("/insertBook")
    public String insertBook(@RequestParam(value = "new_book_title") String book_title,
                           @RequestParam(value = "new_book_qty")String book_qty,
                           @RequestParam(value = "new_book_author") String book_author,
                           @RequestParam(value = "new_book_genre") String book_genre,
                           @RequestParam(value = "new_book_year") String book_year,
                           @RequestParam(value = "new_book_URL") String book_URL
    ) {
        Book book = new Book(book_title, book_qty, book_author, book_genre, book_year, book_URL);

        //System.out.println("Controller" + book);

        Map outParameters = bookService.insertBook(book);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

    }

    @GetMapping ("/search_for_a_book_everyone")
    public String search_for_a_book_everyone(@RequestParam(value = "check_book") String check_book
    ) {
        Book book = new Book(check_book);

        //System.out.println("Controller" + book);

        Map outParameters = bookService.search_for_a_book_everyone(book);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

        }

    @GetMapping ("/search_for_a_book_admin")
    public String search_for_a_book_admin(@RequestParam(value = "check_book") String check_book
    ) {
        Book book = new Book(check_book);

        //System.out.println("Controller" + book);

        Map outParameters = bookService.search_for_a_book_admin(book);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

    }

    @GetMapping ("/search_for_a_book_borrow")
    public String search_for_a_book_borrow(@RequestParam(value = "check_book") String check_book
    ) {
        Book book = new Book(check_book);

        System.out.println("Controller" + book);

        Map outParameters = bookService.search_for_a_book_borrow(book);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

    }

    /**
     * Sends request to update a new book in the database, specify ID
     */
    @PostMapping("/updateBook")
    public void updateBook(@RequestParam(value = "ID_book", defaultValue = "0") int ID_book,
                           @RequestParam(value = "book_title", defaultValue = "noTitle") String book_title,
                           @RequestParam(value = "book_qty", defaultValue = "0") int book_qty,
                           @RequestParam(value = "book_author", defaultValue = "noBook_author") String book_author,
                           @RequestParam(value = "book_genre", defaultValue = "noBook_genre") String book_genre,
                           @RequestParam(value = "book_year", defaultValue = "noBook_year") String book_year,
                           @RequestParam(value = "book_URL", defaultValue = "noBook_URL") String book_URL
    ) {
        bookService.updateBook(ID_book, book_title, book_qty, book_author, book_genre, book_year, book_URL);
    }

    /**
     * Sends request to delete a book from database by ID
     */
    @GetMapping("/deleteBookByID")
    public Map deleteBook(@RequestParam(value = "ID_book") String ID_book) {
        return bookService.deleteBook(ID_book);
    }

    /**
     * Sends request to download one book from database by ID
     */
    @GetMapping("/downloadOneBook")
    public String downloadOneBook(@RequestParam(value = "ID_book", defaultValue = "-1") int ID_book) {
        return bookService.downloadOneBook(ID_book);
    }

    /**
     * Sends request to download all books from database by ID
     */
    @GetMapping("/downloadAllBooks")
    public String downloadAllBooks() {
        return bookService.downloadAllBooks();
    }

    @GetMapping("/downloadBookByTitle")
    public String downloadBookByTitle(@RequestParam(value = "book_title", defaultValue = "noBook_title") String book_title) {
        return bookService.downloadBookByTitle(book_title);
    }

    /**
     * Sends request to download a recent book that were
     * inserted into the database
     */
    @GetMapping("/downloadMostRecentBook")
    public String downloadMostRecent() {
        return bookService.downloadMostRecentBook();
    }

    @GetMapping("/return_book")
    public String return_book(@RequestParam(value = "book_id") String book_id) {
        System.out.println("Toros" + book_id);
        Book book = new Book(book_id, null, null, null, null,null, null);

        System.out.println("Controller " + book);

        Map outParameters = bookService.return_book(book);

        Gson gson = new Gson();
        System.out.println("Toros" + book_id);
        return gson.toJson(outParameters);

    }
}
