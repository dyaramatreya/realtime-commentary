package com.cricket.commentary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "commentary_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentaryEvent {

    @Id
    private Long id;

    private String matchId;
    private Integer over;
    private Integer ball;
    private String commentary;
    private Long eventTimestamp;
}
