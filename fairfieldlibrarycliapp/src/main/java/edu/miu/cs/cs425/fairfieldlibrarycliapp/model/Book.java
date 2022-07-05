package edu.miu.cs.cs425.fairfieldlibrarycliapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(name="isbn", nullable = false, unique = true)
    @NotBlank(message = "ISBN cannot be blank, empty of null")
    private String isbn;
    private String title;
    private LocalDate datePubished;
    private Integer numberOfCopies;
    private Double price;
    @ManyToOne
    @JoinColumn(name="publisher_id", nullable = true)
    private Publisher publisher;

}
