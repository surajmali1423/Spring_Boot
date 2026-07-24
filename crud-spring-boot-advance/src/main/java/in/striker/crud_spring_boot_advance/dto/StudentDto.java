package in.striker.crud_spring_boot_advance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private String name;

    private int age;

    private String email;

    private String subject;
}
