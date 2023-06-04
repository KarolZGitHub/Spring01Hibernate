package pl.coderslab.entity;

import lombok.*;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "publisher")
@Data
@NoArgsConstructor

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "publisher")
    @ToString.Exclude
    private List<Book> books;
    @NIP
    @NotBlank
    private String nip;
    @REGON
    @NotBlank
    private String regon;

}
