package com.abhimisraw.BigBlog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull
    @Size(min = 5, max = 50 , message = "Title must be 5 to 50 characters long")
    private String title ;
    @NotNull
    @Size(min = 5, max = 50 , message = "Description must be 5 to 50 characters long")
    private String description ;
    @NotNull
    @Size(min = 50, max = 5000 , message = "body must be 50 to 5000 characters long")
    private String body ;

    private String slug ;

    @Column(name = "post_status")
    private PostStatus postStatus ;
    @Column(name = "created_on")
    private LocalDate createdOn ;
    @Column(name = "updated_on")
    private LocalDate updatedOn ;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> commentList;
}
