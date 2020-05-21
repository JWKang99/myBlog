package com.kang.blog.service;

import com.kang.blog.entity.Tag;

import java.util.List;

public interface TagService {
    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getIndexTags();

    List<Tag> getAllTags();

    int updateTag(Long id, Tag tag);

    void deleteTag(Long id);

    List<Tag> listTag(String ids);
}
