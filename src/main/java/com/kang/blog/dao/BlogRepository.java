package com.kang.blog.dao;

import com.kang.blog.po.Blog;
import com.kang.blog.po.Category;
import com.kang.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

    @Query("select b from t_blog b where b.recommended = true")
    List<Blog> findTop(Pageable pageable);

    // ?1表示第一个参数，即query
    @Query("select b from t_blog b where b.title like ?1 or b.content like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);
}
