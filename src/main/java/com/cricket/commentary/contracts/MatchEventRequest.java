package com.cricket.commentary.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchEventRequest {

    private Long id;

    private String matchId;
    private Integer over;
    private Integer ball;
    private String commentary;
    private Long eventTimestamp;

}
