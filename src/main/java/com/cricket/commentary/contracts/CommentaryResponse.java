package com.cricket.commentary.contracts;

import java.util.List;

public record CommentaryResponse(
        List<MatchEventResponse> events
) {
}
