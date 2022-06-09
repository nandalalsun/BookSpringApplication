package Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookRestController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books", produces = "application/json")
    public ResponseEntity<?> getAll() {
        return  ResponseEntity.ok().body(bookService.getAll());
    }

    @GetMapping(value = "/books/{id}", produces = "application/json")
    public Book get(@PathVariable int id) {
        return bookService.get(id);
    }

//    @PostMapping(value = "/books", consumes = "application/json")
//    public RedirectView add(@RequestBody Book book) {
//        bookService.add(book);
//        return new RedirectView("redirect:/books");
//    }

    @PostMapping(value = "/books", consumes = "application/json")
    public ResponseEntity<?> add(@RequestBody Book book) {

        return ResponseEntity.created(null).body(bookService.add(book));
    }

    @PostMapping(value = "/books/{id}", consumes = "application/json")
    public void update(@RequestBody Book book) {
        bookService.update(book);
    }
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }
}
