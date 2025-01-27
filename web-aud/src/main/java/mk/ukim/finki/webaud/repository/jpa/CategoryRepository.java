package mk.ukim.finki.webaud.repository.jpa;

import mk.ukim.finki.webaud.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByNameLike(String text);
    void deleteByName(String name);
}
