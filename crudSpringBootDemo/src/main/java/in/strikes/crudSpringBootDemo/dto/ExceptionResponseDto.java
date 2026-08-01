package in.strikes.crudSpringBootDemo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDto {

    private LocalDateTime timestamp;

    private int statusCode;

    private String error;

    private String message;

    private String path;
}
