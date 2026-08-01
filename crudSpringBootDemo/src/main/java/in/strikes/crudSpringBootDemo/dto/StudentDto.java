package in.strikes.crudSpringBootDemo.dto;


import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentDto {

    @NotBlank(message = "Name Cannot Null/Empty Or Blank.")
    @Size(min = 2 , max = 50, message = "Student Name Must Be Within 2 To 50 Long")
    private String name;

    @NotBlank(message = "Roll Number Is Required.")
    private String roll_no;

    @NotBlank(message = "Email Cannot Be Empty.")
    @Email(message = "Student Email Must Be Valid.")
    private String email;

    @NotNull(message = "the Age Is Requires.")
    @Min(value = 18 , message = "Your Age Must Be 18+.")
    private Integer age;

    @NotBlank(message = "Subject Should Be Required.")
    private String subject;
}
