package project4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project4.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
//    Boolean findByName(String name);

    @Query("SELECT c.id from Category c WHERE c.name = :name")
    int findIdByName(@Param("name") String name);
}
