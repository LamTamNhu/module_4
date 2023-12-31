package com.blog.repository;

import com.blog.model.BlogHasCategory;
import com.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IBlogHasCategoryRepository extends JpaRepository<BlogHasCategory,Long> {
    Iterable<BlogHasCategory> findAllByBlog_Id(Long id);
    void deleteBlogHasCategoriesByBlog_Id(Long id);

    Iterable<BlogHasCategory> findAllByCategory(Category category);
}
