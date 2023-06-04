package pl.coderslab.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.CascadeType;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_details_id")
    private PersonDetails personDetails;


}