package com.capstone2.dku.post.domain;


import com.capstone2.dku.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Entity
@Table(appliesTo = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;

    @Column(name = "like_number")
    private int likeNumber; // 좋아요

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;

    @Builder
    public Post(String title, String type, String content) {
        this.title = title;
        this.type = type;
        this.content = content;
        this.likeNumber = 0;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
