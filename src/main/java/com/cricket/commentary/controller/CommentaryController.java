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

        MatchEventRequest event = new MatchEventRequest();

        event.setMatchId("match-123");
        event.setOver(15);
        event.setBall(4);
        event.setCommentary("FOUR!");

        commentaryService.createCommentary(event);
    }
}
