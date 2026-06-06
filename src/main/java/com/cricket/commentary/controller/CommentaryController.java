package com.cricket.commentary.controller;

import com.cricket.commentary.contracts.CommentaryResponse;
import com.cricket.commentary.contracts.MatchEventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.commentary.contracts.MatchEventRequest;
import com.cricket.commentary.service.CommentaryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentaryController {

    private final CommentaryService commentaryService;

    @GetMapping("/commentary")
    public CommentaryResponse getCommentaryEvents(@RequestParam String matchId, @RequestParam(required = false) Long lastReadEventID) {
        return new CommentaryResponse(commentaryService.getCommentaryEvents(matchId, lastReadEventID));
    }

    @PostMapping("/commentary")
    public void createCommentary() {

        MatchEventRequest eventRequest = new MatchEventRequest();

        eventRequest.setMatchId("match-123");
        eventRequest.setOver(15);
        eventRequest.setBall(4);
        eventRequest.setCommentary("FOUR!");
        eventRequest.setId(21L);

        commentaryService.createCommentary(eventRequest);
    }
}
