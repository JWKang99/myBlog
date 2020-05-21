package com.kang.blog.service.impl;

import com.kang.blog.dao.TagMapper;
import com.kang.blog.exception.NotFoundException;
import com.kang.blog.entity.Tag;
import com.kang.blog.service.TagService;
import com.kang.blog.utils.String2List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public int saveTag(Tag tag) {
        return tagMapper.saveTag(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagMapper.findTagById(id);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagMapper.findAllTags();
    }

    @Override
    public int updateTag(Long id, Tag tag) {
        Tag findRes = tagMapper.findTagById(id);
        if(findRes == null){
            throw new NotFoundException("该类型不存在");
        }
        BeanUtils.copyProperties(tag,findRes);
        return tagMapper.updateTag(findRes);
    }

    @Override
    public void deleteTag(Long id) {
        tagMapper.deleteTag(id);
    }

    @Override
    public List<Tag> listTag(String ids) {
        List<Long> longs = String2List.convertToList(ids);
        List<Tag> tags = new ArrayList<>();
        for(Long id : longs){
            tags.add(getTag(id));
        }
        return tags;
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.findTagByName(name);
    }

    @Override
    public List<Tag> getIndexTags() {
        return tagMapper.getIndexTags();
    }

}
