package com.kang.blog.dao;

import com.kang.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper{

    //查询ParentComment为空的
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId);

    List<Comment> getAllReplies(Long id);

    //根据博客id找评论
    Comment findById(Long id);

    int saveComment(Comment comment);


}
