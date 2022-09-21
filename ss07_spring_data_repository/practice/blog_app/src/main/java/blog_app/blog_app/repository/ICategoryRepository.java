package blog_app.blog_app.repository;

import blog_app.blog_app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(int id);

}
