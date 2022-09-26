package com.example_blog.repository;


import com.example_blog.dto.IBlogDto;
import com.example_blog.model.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogsRepository extends JpaRepository<Blogs,Integer> {

    Blogs findById(int id);

    @Query(value = "select * from blogs where name_blog like %:keyword% ",nativeQuery = true)
    Page<Blogs> searchByName(@Param("keyword") String name, Pageable pageable);

    @Query(value = "select  * from blogs order by date_created DESC ",nativeQuery = true)
    Page<Blogs> findAll(Pageable pageable);
    @Query(value = "select b.name_blog as nameBlog, c.name_category as nameCategory from blogs b join category c on b.category_id=c.id",nativeQuery = true )
    List<IBlogDto> showList();

    @Query(value = "select *from blogs where category_id =:key",nativeQuery = true)
    List<Blogs> sarchBlogsByCategory(@Param("key") int id);
}
