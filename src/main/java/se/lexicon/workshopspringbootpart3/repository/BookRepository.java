package se.lexicon.workshopspringbootpart3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.workshopspringbootpart3.entity.Book;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    Book findBookByIsbnIgnoreCase(String isbn);
    Book findBookByTitleContains(String title);
    List<Book> findBooksByMaxLoanDaysLessThan(int days);

    @Query("select b from Book b join BookLoan l where l.returned = false")
    List<Book> findBooksCurrentlyOnLoan();

    @Query("select b from Book b join BookLoan l where l.returned = false and l.dueDate < CURRENT_DATE")
    List<Book> findOverdueBooks();

    @Query("select b from Book b join BookLoan l where l.loanDate between :date1 and :date2")
    List<Book> findBooksByLoansBetween(@Param("date1") LocalDate date1, @Param("date2") LocalDate date2);
}
