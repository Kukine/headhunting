package hr.fer.ris.headhunting.hh.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String adress;

//    @ManyToMany(mappedBy = "previousOrganizations",fetch = FetchType.LAZY)
//    private List<Employee> previousEmployees;
}
