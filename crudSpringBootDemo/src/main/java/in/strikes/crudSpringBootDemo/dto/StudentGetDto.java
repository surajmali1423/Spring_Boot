package in.strikes.crudSpringBootDemo.dto;

import lombok.Data;

@Data
public class StudentGetDto {

    private Long id;

    private String name;

    private String roll_no;

    private String email;

    private int age;

    private String subject;
}
