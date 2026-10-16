package in.suraj.Security_DB_Authentication.controller;

import in.suraj.Security_DB_Authentication.dto.UserRegisterRequestDto;
import in.suraj.Security_DB_Authentication.dto.UserRegisterResponseDto;
import in.suraj.Security_DB_Authentication.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {


    private final AuthService authService;

    @GetMapping("/Hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto>register(
            @RequestBody UserRegisterRequestDto userRegisterRequestDto){
        return ResponseEntity.ok(authService.registerUser(userRegisterRequestDto));
    }

}
