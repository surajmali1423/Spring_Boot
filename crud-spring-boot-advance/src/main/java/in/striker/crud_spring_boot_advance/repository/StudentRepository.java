package in.striker.crud_spring_boot_advance.repository;

import in.striker.crud_spring_boot_advance.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

    Optional<Student> findByIdAndDeleteFalse(Long id);

    List<Student> findAllByDeleteFalse();
}
