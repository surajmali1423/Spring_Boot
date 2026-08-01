package in.strikes.crudSpringBootDemo.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationExceptionDto {


    private LocalDateTime timestamp;

    private int statusCode;

    private String error;

    private String message;

    private String path;

     Map<String , String> Errors;
}
