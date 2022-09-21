package blog_app.blog_app.repository;

import blog_app.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findById(int id);
    @Query(value = "select * from blog where blog_name like %:keyword%", nativeQuery = true)
    Page<Blog> searchByName(@Param("keyword") String name);

    @Query(value = "select * from blog order by date_created ASC ", nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);


}
