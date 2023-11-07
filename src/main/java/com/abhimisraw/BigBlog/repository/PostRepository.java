package com.abhimisraw.BigBlog.repository;

import com.abhimisraw.BigBlog.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post , Long> {

}
