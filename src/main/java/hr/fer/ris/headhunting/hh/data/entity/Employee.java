package hr.fer.ris.headhunting.hh.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Data
public class Employee extends User{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private String userId;

    private String description;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "user"
    )
    private List<Experience> experienceList;

//    @ManyToMany
//    @JoinTable(name = "employee_organization_map",
//            joinColumns = @JoinColumn(name ="user_id"),
//            inverseJoinColumns = @JoinColumn(name = "organization_id"))
//    private List<Organization> previousOrganizations;
}
