package com.kang.blog.service.impl;

import com.kang.blog.dao.BlogRepository;
import com.kang.blog.exception.NotFoundException;
import com.kang.blog.po.Blog;
import com.kang.blog.po.Category;
import com.kang.blog.service.BlogService;
import com.kang.blog.utils.MarkDownUtils;
import com.kang.blog.utils.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vo.BlogQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    @Transactional
    public Blog getBlog(Long id) {
        return blogRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Blog getAndConvert(Long id) {
        Blog blog = blogRepository.getOne(id);
        if(blog==null){
            throw new NotFoundException("该博客不存在");
        }
        Blog bTemp = new Blog();
        BeanUtils.copyProperties(blog,bTemp);
        String content = blog.getContent();
        String html = MarkDownUtils.markdownToHtmlExtensions(content);
        //如果直接使用blog.setContent(content)的话，hibernate会直接操作数据库
        bTemp.setContent(html);
        return bTemp;
    }

    /**
     * Specification 动态查询，
     * param root
     * param criteriaQuery
     * param criteriaBuilder
     * @param pageable
     * @param blogQuery
     * @return
     */
    @Override
    @Transactional
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                //标题模糊查询
                if(!"".equals(blogQuery.getTitle())&&blogQuery.getTitle()!=null){
                    predicates.add(criteriaBuilder.like(root.<String>get("title"),"%"+blogQuery.getTitle()+"%"));
                }
                //分类查询
                if(blogQuery.getCategoryId()!=null){
                    predicates.add(criteriaBuilder.equal(root.<Category>get("category").get("id"),blogQuery.getCategoryId()));
                }
                //推荐查询
                if(blogQuery.isRecommended()){
                    predicates.add(criteriaBuilder.equal(root.<Boolean>get("recommended"),blogQuery.isRecommended()));
                }
                criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        },pageable);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> listBlog(String query, Pageable pageable) {
        return blogRepository.findByQuery(query,pageable);
    }

    @Override
    @Transactional
    public Blog saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        System.out.println(blog);
        return blogRepository.save(blog);
    }

    @Override
    @Transactional
    public Blog updateBlog(Long id, Blog blog) {
        Blog findRes = blogRepository.getOne(id);
        if(findRes == null){
            throw new NotFoundException("该博客不存在");
        }
        //过滤掉blog中属性为空的属性，只复制有值的属性，不会覆盖createTime
        BeanUtils.copyProperties(blog, findRes, MyBeanUtils.getNullPropertyNames(blog));
        findRes.setUpdateTime(new Date());
        return blogRepository.save(findRes);
    }

    @Override
    @Transactional
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> listRecommendBlogTop(Integer size) {
        //按照tag对象的属性blogs.size降序
        Sort sort = Sort.by(Sort.Order.desc( "updateTime"));
        //取第一页
        Pageable pageable = PageRequest.of(0, size, sort);
        return blogRepository.findTop(pageable);
    }
}
