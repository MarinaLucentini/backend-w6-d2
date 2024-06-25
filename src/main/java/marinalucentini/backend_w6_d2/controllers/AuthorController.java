package marinalucentini.backend_w6_d2.controllers;

import marinalucentini.backend_w6_d2.entities.Author;
import marinalucentini.backend_w6_d2.entities.BlogPost;
import marinalucentini.backend_w6_d2.services.AuthorService;
import marinalucentini.backend_w6_d2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;
//**** GET ALL****
    @GetMapping
    private List<Author> getAllAuthor(){
        return authorService.getAuthorList();
    }
    // ***** POST *****
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private String postAuthor(@RequestBody Author body){
        return authorService.saveAuthor(body);
    }
    // **** GET SINGLE BLOGPOST
    @GetMapping ("/{authorId}")
    private Author getSingleAuthor(@PathVariable int authorId){
        return authorService.findById(authorId);
    }
    // **** PUT
    @PutMapping("/{authorId}")
    private Author updateAuthor(@PathVariable int authorId, @RequestBody Author body){
        return authorService.findByIdAndUpdate(authorId, body);
    }
    // *** DELETE
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204
    private void findAuthorByIdAndDelete(@PathVariable int authorId){
      authorService.findByIdAndDelete(authorId);
    }
}
