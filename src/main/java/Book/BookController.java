package Book;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

//@RestController
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/")
    public String redirectRoot(){
     return "redirect:/books";
    }

    @PostMapping("/books/add")
    public String add(@Valid Book book, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            System.out.println(result.hasErrors());
            System.out.println("error occured");
            attr.addFlashAttribute("org.springframework.validation.BindingResult.book", result);
            attr.addFlashAttribute("book", book);
            return "redirect:/books/add";
        }
        else{
            bookService.add(book);
            return "redirect:/books";
        }
    }

    @GetMapping("/books")
    public String getAll(Model model){
        model.addAttribute("books", bookService.getAll());
        return "bookList";
    }



    @GetMapping("/books/add")
    public String viewAdd(@ModelAttribute("book") Book book, Model model) {
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }

    @GetMapping("/books/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.get(id));
        model.addAttribute("msg", "Update");
        return "bookDetail";
    }

    @PutMapping("/books/{id}")
    public String update(Book book, @PathVariable int id) {
        bookService.update(book); // car.id already set by binding
        return "redirect:/books";
    }

    @PostMapping(value="/books/delete")
    public String delete(int bookId) {
        bookService.delete(bookId);
        return "redirect:/books";
    }
}
