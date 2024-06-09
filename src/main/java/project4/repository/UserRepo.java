package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project4.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    boolean existsByUserName(String userName);
}
