package in.strikes.crudSpringBootDemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 60)
    private String name;

    @Column(nullable = false , unique = true)
    private String roll_no;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false , length = 80)
    private String subject;

    @Column(nullable = false)
    private boolean deleted;
}
