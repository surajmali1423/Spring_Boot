package in.suraj.Security_DB_Authentication.service;

import in.suraj.Security_DB_Authentication.entity.CustomeUserDetails;
import in.suraj.Security_DB_Authentication.entity.User;
import in.suraj.Security_DB_Authentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomeUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User  Not Found !!!")
        );

        return  new CustomeUserDetails(user);
    }
}
