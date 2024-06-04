package se.lexicon.workshopspringbootpart3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString


@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Setter private LocalDate loanDate;

    @Column
    @Setter private LocalDate dueDate;

    @Column
    @Setter private boolean returned;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "appuser_id")
    @Setter private AppUser borrower;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id")
    @Setter private Book book;
}