package edu.miu.cs.cs425.fairfieldlibrarywebapi.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
@NamedQuery(name="Book.findBookByISBN", query="select b from Book b where b.isbn = ?1")
//@NamedNativeQuery(name="Book.cheapBooks", query="select * from books b where b.price < ?1")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name="isbn", nullable = false, unique = true)
    @NotBlank(message = "ISBN cannot be blank, empty or null")
    private String isbn;
    private String title;
    private LocalDate datePublished;
    private Integer numberOfCopies;
    private Double price;
    @ManyToOne
    @JoinColumn(name="publisher_id", nullable = true)
    private Publisher publisher;
    @ManyToMany
    @JoinTable(
            name = "books_authors",
            joinColumns = {@JoinColumn(name="book_id", referencedColumnName = "bookId")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "authorId")}
    )
    @ToString.Exclude
    private List<Author> authors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return bookId != null && Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
