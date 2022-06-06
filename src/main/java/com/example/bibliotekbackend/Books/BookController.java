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

        Map outParameters = bookService.insertBook(book);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

    }

    @GetMapping ("/search_for_a_book_everyone")
    public String search_for_a_book_everyone(@RequestParam(value = "check_book") String check_book
    ) {
        Book book = new Book(check_book);

        Map outParameters = bookService.search_for_a_book_everyone(book);

        Gson gson = new Gson();

        return gson.toJson(outParameters);

        }

    @GetMapping ("/search_for_a_book_admin")
    public String search_for_a_book_admin(@RequestParam(value = "check_book") String check_book
    ) {
        Book book = new Book(check_book);

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
     * Sends request to delete a book from database by ID
     */
    @GetMapping("/delete_book_ID")
    public Map delete_book_ID(@RequestParam(value = "ID_book") String ID_book) {
        return bookService.delete_book_ID(ID_book);
    }

    @GetMapping("/delete_book_ISBN")
    public Map delete_book_ISBN(@RequestParam(value = "selected_ISBN_book") String ISBN_book) {
        return bookService.delete_book_ISBN(ISBN_book);
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

    @GetMapping ("/select_all_borrowed_books")
    public String select_all_borrowed_books(
    ) {

        Map outParameters = bookService.select_all_borrowed_books();

        Gson gson = new Gson();

        return gson.toJson(outParameters);

    }


    @GetMapping ("/show_popular_books_view")
    public String popular_books(@RequestParam(value = "book_genre") String book_genre) {
        System.out.println("Toros " + book_genre);
        Book book = new Book(null, null, null, book_genre, null, null);
        System.out.println("Controller " + book);
        Map outParameters = bookService.popular_books(book_genre);
        Gson gson = new Gson();
        System.out.println("Toros" + book_genre);
        return gson.toJson(outParameters);
    }

    @GetMapping("/search_for_a_book_qty")
    public String search_for_a_book_qty(@RequestParam(value = "check_book") String check_book){

        Map outParameters = bookService.search_for_a_book_qty(check_book);

        Gson gson = new Gson();

        return gson.toJson(outParameters);
    }

    @GetMapping("/update_book")
    public String update_book(@RequestParam(value = "ISBN_book_live") String ISBN_book, @RequestParam(value = "qty_book") String book_qty){

        Map outParameters = bookService.update_book(ISBN_book, book_qty);

        Gson gson = new Gson();

        return gson.toJson(outParameters);
    }

    @GetMapping("/yes_delete")
    public Map yes_delete(@RequestParam(value = "ISBN") String ISBN_book) {
        return bookService.yes_delete(ISBN_book);
    }
}
