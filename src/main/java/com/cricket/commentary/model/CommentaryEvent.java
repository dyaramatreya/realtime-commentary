package com.cricket.commentary.model;

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

    public String getMatchId() {
        return matchId;
    }

    public Integer getOver() {
        return over;
    }

    public Integer getBall() {
        return ball;
    }

    public String getCommentary() {
        return commentary;
    }

    public Long getEventTimestamp() {
        return eventTimestamp;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }
}
