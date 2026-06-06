package com.cricket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CommentaryEvent {

    @Id
    @GeneratedValue
    private Long id;

    private String matchId;
    private Integer over;
    private Integer ball;
    private String commentary;
    private Long eventTimestamp;
}
