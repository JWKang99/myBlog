package com.kang.blog.service.impl;

import com.kang.blog.dao.CategoryRepository;
import com.kang.blog.dao.TagRepository;
import com.kang.blog.exception.NotFoundException;
import com.kang.blog.po.Category;
import com.kang.blog.po.Tag;
import com.kang.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;
    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    @Transactional
    public Tag getTag(Long id) {
        return tagRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }


    @Override
    @Transactional
    public Tag updateTag(Long id, Tag tag) {
        Tag findRes = tagRepository.getOne(id);
        if(findRes == null){
            throw new NotFoundException("该类型不存在");
        }
        BeanUtils.copyProperties(tag,findRes);
        return tagRepository.save(findRes);
    }

    @Override
    @Transactional
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagRepository.findAllById(convertToList(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        //按照tag对象的属性blogs.size降序
        Sort sort = Sort.by(Sort.Order.desc( "blogs.size"));
        Pageable pageable = PageRequest.of(0, size, sort);
        return tagRepository.findTop(pageable);
    }

    private List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids!=null){
            String[] idArray = ids.split(",");
            for(int i=0;i<idArray.length;i++){
                list.add(new Long(idArray[i]));
            }
        }
        return list;
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

}
