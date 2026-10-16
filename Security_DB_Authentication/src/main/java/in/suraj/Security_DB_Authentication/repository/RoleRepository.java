package in.suraj.Security_DB_Authentication.repository;

import in.suraj.Security_DB_Authentication.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role , Long> {
    Optional<Role> findByName(String roleUser);
}
