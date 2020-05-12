package com.kang.blog.service.impl;

import com.kang.blog.dao.CommentRepository;
import com.kang.blog.po.Comment;
import com.kang.blog.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    private List<Comment> tempReplies = new ArrayList<>();

    /**
     * 迭代查找每一级评论
     * @param comment
     */
    private void recursively(Comment comment){
        tempReplies.add(comment);//根评论结点添加在临时集合中
        if(comment.getReplyComment().size()>0){
            List<Comment> replies = comment.getReplyComment();
            for(Comment reply : replies){
                tempReplies.add(reply);
                if(reply.getReplyComment().size()>0){
                    recursively(reply);
                }
            }
        }
    }

    /**
     * 合并每个顶级评论的子评论
     * @param comments 顶级评论结点集合
     */
    private void combineChildren(List<Comment> comments){
        for(Comment comment: comments){
            //获取顶级评论的所有子评论结点
            List<Comment> replies = comment.getReplyComment();
            //迭代子节点的子节点...直到叶节点
            for(Comment reply : replies){
                recursively(reply);
            }
            //把所有子孙结点合并到一个集合中，即一层
            comment.setReplyComment(tempReplies);
            tempReplies = new ArrayList<>();
        }
    }

    /**
     * 循环每个顶级的评论结点
     * @param comments 顶级评论结点
     * @return
     */
    private List<Comment> eachComment(List<Comment> comments){
        //把comments复制到新的集合里，避免原有集合发生变化导致数据库发生变化
        List<Comment> commentsView = new ArrayList<>();
        for(Comment comment : comments){
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并评论的各层子代到第一级下的子代集合中
        combineChildren(commentsView);
        return commentsView;
    }

    @Override
    @Transactional
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = Sort.by(Sort.Direction.DESC,"createTime");
        //comments为所有的顶层评论,即parentComment为空
        List<Comment> comments = commentRepository.findByBlogIdAndParentCommentNull(blogId,sort);
        //返回的是一个副本集合，并没有在原本的comments上做修改
        return eachComment(comments);
    }

    @Override
    @Transactional
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if(parentCommentId!=-1){
            //建立评论子父级关系
            comment.setParentComment(commentRepository.findById(parentCommentId).get());
        }else{
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }
}
