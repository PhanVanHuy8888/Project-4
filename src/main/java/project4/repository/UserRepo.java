package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project4.entity.User;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    boolean existsByUserName(String userName);

    User findByEmail(String userName);
    User findByUserName(String userName);

    @Query("SELECT u.id FROM User u WHERE u.userName = :username")
    String findIdByUserName(@Param("username") String username);

}
