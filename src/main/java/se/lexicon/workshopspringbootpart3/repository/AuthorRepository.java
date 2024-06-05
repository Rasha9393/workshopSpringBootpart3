package se.lexicon.workshopspringbootpart3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.workshopspringbootpart3.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,String> {
    List<Author> findAuthorsByFirstName(String firstName);
    List<Author> findAuthorsByLastName(String lastName);

    @Query("select a from Author a where a.firstName = :keyword or a.lastName = :keyword")
    List<Author> findAuthorsByKeyword(String keyword);



    @Query("select a from Author a join Book b where b.id = :bookId")
    List<Author> findAuthorsByBookId(int bookId);

    @Modifying
    @Query("update Author a set a.firstName = :firstName,a.lastName = :lastName where a.id =:authorId")
    void updateAuthorName(@Param("authorId") int id, String firstName, String lastName);

    @Modifying
    @Query("delete from Author a where a.id = :authorId")
    void deleteAuthorById(@Param("authorId") int id);

}

