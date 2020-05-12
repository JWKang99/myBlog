package com.kang.blog.dao;

import com.kang.blog.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    //查询ParentComment为空的
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);


}
