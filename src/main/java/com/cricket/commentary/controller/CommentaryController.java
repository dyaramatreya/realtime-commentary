package com.cricket.commentary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.commentary.contracts.MatchEventRequest;
import com.cricket.commentary.service.CommentaryService;

@RestController
@RequiredArgsConstructor
public class CommentaryController {

    private final CommentaryService commentaryService;

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
