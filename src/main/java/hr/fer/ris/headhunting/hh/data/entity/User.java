package hr.fer.ris.headhunting.hh.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(generator = "hilo-strategy")
    @org.hibernate.annotations.GenericGenerator(name="hilo-strategy", strategy = "hilo")
    @Column(name = "id", insertable = false, updatable = false, nullable = false, unique = true)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String password;
}
