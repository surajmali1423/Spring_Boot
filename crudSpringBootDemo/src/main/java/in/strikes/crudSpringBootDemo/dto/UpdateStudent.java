package in.strikes.crudSpringBootDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Data
@Getter
@Setter
public class UpdateStudent {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Min(value = 18)
    private int age;

    @NotBlank
    private String subject;
}
