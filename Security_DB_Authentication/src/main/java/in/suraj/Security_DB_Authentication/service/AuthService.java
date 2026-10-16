package in.suraj.Security_DB_Authentication.service;

import in.suraj.Security_DB_Authentication.dto.UserRegisterRequestDto;
import in.suraj.Security_DB_Authentication.dto.UserRegisterResponseDto;
import in.suraj.Security_DB_Authentication.entity.Role;
import in.suraj.Security_DB_Authentication.entity.User;
import in.suraj.Security_DB_Authentication.repository.RoleRepository;
import in.suraj.Security_DB_Authentication.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    public UserRegisterResponseDto  registerUser(
            UserRegisterRequestDto userRegisterRequestDto) {

         User user = new User();
         user.setUsername(userRegisterRequestDto.getUsername());

         String encodedPasswords =
                 passwordEncoder.encode(userRegisterRequestDto.getPassword());
         user.setPassword(encodedPasswords);

         user.setEnable(true);

         Role role  = roleRepository.findByName("ROLE_USER").orElseThrow(
                 () -> new EntityNotFoundException("Role Not Found !!!")
         );
         user.getRoles().add(role);

         userRepository.save(user);

         UserRegisterResponseDto register = modelMapper.map(user , UserRegisterResponseDto.class);
         register.setMsg("User registered successfully");

         return register;
    }
}
