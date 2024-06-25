package marinalucentini.backend_w6_d2.services;

import marinalucentini.backend_w6_d2.entities.Author;
import marinalucentini.backend_w6_d2.entities.BlogPost;
import marinalucentini.backend_w6_d2.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> AuthorList = new ArrayList<>();
    private Random rdm = new Random();
    public List<Author> getAuthorList(){
        return AuthorList;
    }
    public String saveAuthor(Author body){
body.setId(rdm.nextInt(10, 10000));
body.setAvatar("https://unsplash.com/it/foto/una-vista-al-tramonto-della-grande-muraglia-cinese-Zm_tEAh3gG0");
body.setDateOfBirth(LocalDate.now().plusYears(45));
AuthorList.add(body);
return String.valueOf(body.getId());
    }
    public Author findById(int id){
        Author found = null;
        for(Author user: AuthorList){
            if(user.getId() == id) found = user;
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public Author findByIdAndUpdate(int id, Author updateAuthor){
        Author found = null;

        for (Author blogPost : AuthorList) {
            if (blogPost.getId() == id) {
                found = blogPost;
                break;
            }
        }

        if (found == null) {
            throw new NotFoundException(id);
        }


        found.setName(updateAuthor.getName());
        found.setLastName(updateAuthor.getLastName());
        found.setAvatar("https://unsplash.com/it/foto/una-vista-al-tramonto-della-grande-muraglia-cinese-Zm_tEAh3gG0");
        found.setEmail(updateAuthor.getEmail());
        found.setDateOfBirth(updateAuthor.getDateOfBirth());



        return found;
    }

    public void findByIdAndDelete(int id){
        Iterator<Author> iterator = AuthorList.iterator();

        while(iterator.hasNext()){
            Author current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }}
}
