package blog_app.blog_app.repository;

import blog_app.blog_app.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findById(int id);
    @Query(value = "select * from Blog where blog_name like %:keyword%", nativeQuery = true)
    List<Blog> searchByName(@Param("keyword") String name);


}
