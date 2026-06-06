package com.cricket.contracts;

public record MatchEvent(
        String matchId,
        Integer over,
        Integer ball,
        String commentary,
        Long eventID
) {
}