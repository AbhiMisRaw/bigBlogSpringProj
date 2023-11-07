package com.abhimisraw.BigBlog.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "comment_id")
        private Long id ;
        @NotNull
        private String title ;
//        private String description ;


        @Column(name = "author_name")
        private String authorName ;

        @NotNull
        private String body ;


        @Column(name = "created_on")
        private LocalDate createdOn ;

        @Column(name="updated_on")
        private LocalDate updatedOn ;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id")
        private Post post;


}
