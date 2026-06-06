package com.cricket.commentary.controller;

import com.cricket.commentary.model.CommentaryEvent;
import com.cricket.commentary.service.CommentaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentaryController {

    private final CommentaryService commentaryService;

    @PostMapping("/commentary")
    public void createCommentary() {

        CommentaryEvent event = new CommentaryEvent();

        event.setMatchId("match-123");
        event.setOver(15);
        event.setBall(4);
        event.setCommentary("FOUR!");

        commentaryService.createCommentary(event);
    }
}
