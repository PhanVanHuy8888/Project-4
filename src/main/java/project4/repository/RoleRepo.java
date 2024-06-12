package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project4.entity.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role, String> {
}
