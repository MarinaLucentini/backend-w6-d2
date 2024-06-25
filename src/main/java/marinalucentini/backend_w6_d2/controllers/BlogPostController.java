package marinalucentini.backend_w6_d2.controllers;

import marinalucentini.backend_w6_d2.entities.BlogPost;
import marinalucentini.backend_w6_d2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    BlogPostService blogPostService;
//**** GET ALL****
    @GetMapping
    private List<BlogPost> getAllBlogPost(){
        return blogPostService.getBlogPostList();
    }
    // ***** POST *****
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private String postBlogPost(@RequestBody BlogPost body){
        return blogPostService.saveBlogPost(body);
    }
    // **** GET SINGLE BLOGPOST
    @GetMapping ("/{blogPostId}")
    private BlogPost getSingleBlogPost(@PathVariable int blogPostId){
        return blogPostService.findById(blogPostId);
    }
    // **** PUT
    @PutMapping("/{blogPostId}")
    private BlogPost updateBlogPost(@PathVariable int blogPostId, @RequestBody BlogPost body){
        return blogPostService.findByIdAndUpdate(blogPostId, body);
    }
    // *** DELETE
    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status Code 204
    private void findBlogPostByIdAndDelete(@PathVariable int blogPostId){
      blogPostService.findByIdAndDelete(blogPostId);
    }
}
