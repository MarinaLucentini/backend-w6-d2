package marinalucentini.backend_w6_d2.services;

import marinalucentini.backend_w6_d2.entities.BlogPost;
import marinalucentini.backend_w6_d2.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPostList = new ArrayList<>();
    private Random rdm = new Random();
    public List<BlogPost> getBlogPostList(){
        return blogPostList;
    }
    public String saveBlogPost(BlogPost body){
body.setId(rdm.nextInt(10, 10000));
body.setCover("https://unsplash.com/it/foto/una-vista-al-tramonto-della-grande-muraglia-cinese-Zm_tEAh3gG0");
body.setReadingTime(LocalTime.of(0, LocalTime.now().getMinute()));
blogPostList.add(body);
return String.valueOf(body.getId());
    }
    public BlogPost findById(int id){
        BlogPost found = null;
        for(BlogPost user: blogPostList){
            if(user.getId() == id) found = user;
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost updateBlogPost){
        BlogPost found = null;

        for (BlogPost blogPost : blogPostList) {
            if (blogPost.getId() == id) {
                found = blogPost;
                break;
            }
        }

        if (found == null) {
            throw new NotFoundException(id);
        }


        found.setTitle(updateBlogPost.getTitle());
        found.setCathegory(updateBlogPost.getCathegory());
        found.setCover("https://unsplash.com/it/foto/una-vista-al-tramonto-della-grande-muraglia-cinese-Zm_tEAh3gG0");
        found.setBody(updateBlogPost.getBody());


        LocalTime now = LocalTime.now();
        LocalTime readingTime = LocalTime.of(0, now.getMinute());
        found.setReadingTime(readingTime);

        return found;
    }

    public void findByIdAndDelete(int id){
        Iterator<BlogPost> iterator = blogPostList.iterator();

        while(iterator.hasNext()){
            BlogPost current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }}
}
