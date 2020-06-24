package com.kang.blog.dao;

import com.kang.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper{

    int saveTag(Tag tag);

    int updateTag(Tag tag);

    int deleteTag(Long id);

    Tag findTagById(Long id);

    Tag findTagByName(Long userId,String name);

    List<Tag> findAllTags();

    //后台管理展示 标签列表，不显示该标签下的博客数量
    List<Tag> findAllTag(Long userId);

    //游客页面展示标签，包含博客数量
    List<Tag> getTagsPage(Long userId);

    //暂时废弃
    List<Tag> getIndexTags();


}
