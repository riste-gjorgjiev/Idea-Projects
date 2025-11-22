package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
    public List<Author> authors = new ArrayList<>();
    private static Long authorIdCounter = 1L;

    private static Long nextAuthorId(){
        return authorIdCounter++;
    }

    @PostConstruct
    public void init(){
        authors.add(new Author(nextAuthorId(), "Cormac", "McCarthy", "USA", "Cormac McCarthy was an American author who wrote twelve novels, two plays, five screenplays, and three short stories, spanning the Western, post-apocalyptic, and Southern Gothic genres."));
        authors.add(new Author(nextAuthorId(), "Franz", "Kafka", "Czech Republic", "Franz Kafka was a German-language Jewish Czech writer and novelist born in Prague, in the Austro-Hungarian Empire."));
        authors.add(new Author(nextAuthorId(), "Stephen", "King", "USA", "Stephen Edwin King is an American author. Dubbed the \"King of Horror\", he is widely known for his horror novels and has also explored other genres, among them suspense, crime, science-fiction, fantasy, and mystery. "));
    }
    public List<Author> findAll(){
        return authors;
    }
}
