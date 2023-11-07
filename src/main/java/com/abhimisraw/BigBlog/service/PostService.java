package com.abhimisraw.BigBlog.service;

import com.abhimisraw.BigBlog.domain.Post;
import com.abhimisraw.BigBlog.domain.PostStatus;
import com.abhimisraw.BigBlog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository ;



    public List<Post> findAllPosts(){
        return (List<Post>) postRepository.findAll();
    }

    public Optional<Post> getPostById(Long postId)  {
        Optional<Post> p = postRepository.findById(postId);
        return p ;

    }

    public void addPost(Post post) {
        post.setSlug("");
        post.setPostStatus(PostStatus.PUBLISHED);
        post.setCreatedOn(LocalDate.now());
        post.setUpdatedOn(LocalDate.now());

        postRepository.save(post);
    }
}
