package com.blog.repository;

import com.blog.model.BlogHasCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogHasCategoryRepository extends CrudRepository<BlogHasCategory,Long> {
    Iterable<BlogHasCategory> findAllByBlog_Id(Long id);
}
