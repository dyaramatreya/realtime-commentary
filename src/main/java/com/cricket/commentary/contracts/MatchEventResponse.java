package com.cricket.commentary.contracts;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MatchEventResponse {
    private Long id;

    private String matchId;
    private Integer over;
    private Integer ball;
    private String commentary;
    private Long eventTimestamp;
}
