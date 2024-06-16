package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project4.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Boolean findByName(String name);
}
