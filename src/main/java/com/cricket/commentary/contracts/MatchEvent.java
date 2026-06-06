package com.cricket.commentary.contracts;

public record MatchEvent(
        String matchId,
        Integer over,
        Integer ball,
        String commentary,
        Long eventID
) {
}