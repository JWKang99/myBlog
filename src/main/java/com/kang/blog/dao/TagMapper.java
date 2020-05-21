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

    Tag findTagByName(String name);

    List<Tag> findAllTags();

    List<Tag> getIndexTags();


}
