package in.suraj.Security_DB_Authentication.service;

import in.suraj.Security_DB_Authentication.entity.Role;
import in.suraj.Security_DB_Authentication.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService{

    private final RoleRepository roleRepository;


    public String addRole(Role role) {
        roleRepository.save(role);

        return "Done !!!";
    }
}
