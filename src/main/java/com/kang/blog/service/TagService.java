package com.kang.blog.service;

import com.kang.blog.entity.Tag;

import java.util.List;

public interface TagService {
    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(Long userId,String name);

    List<Tag> getIndexTags();

    List<Tag> getAllTags();

    //根据登录的用户id查找对应的所有tag，用于后台标签管理
    List<Tag> getAllTag(Long userId);

    //根据当前8080/1 的博主id，访问该播主的标签，其中包含该标签下的博客数量
    List<Tag> getTagsPage(Long userId);

    int updateTag(Long id, Tag tag);

    void deleteTag(Long id);

    List<Tag> listTag(String ids);
}
