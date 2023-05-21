package com.mar.telegram.db.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@With
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "action_post")
public class ActionPost {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "action_post_seq")
    private Long id;

    @OneToOne
    private PostInfo post;

    @Column(name = "action", nullable = false)
    private ActionEnum action;

    @ManyToOne
    @JoinColumn(name="user_info_id", nullable = false)
    private UserInfo userInfo;

}
