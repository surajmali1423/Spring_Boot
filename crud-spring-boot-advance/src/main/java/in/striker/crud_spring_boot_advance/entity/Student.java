package in.striker.crud_spring_boot_advance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student_DB")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 30)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false , length = 40)
    private String subject;

    @Column(nullable = false)
    private boolean delete;
}
