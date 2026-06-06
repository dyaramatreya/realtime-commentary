package com.cricket.commentary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.cricket.commentary.kafka.MatchEventProducer;
import com.cricket.commentary.contracts.MatchEvent;
import com.cricket.commentary.model.CommentaryEvent;

@Service
@RequiredArgsConstructor
public class CommentaryService {

    private final MatchEventProducer producer;

    public void createCommentary(CommentaryEvent commentaryEvent) {

        MatchEvent event = new MatchEvent(
                commentaryEvent.getMatchId(),
                commentaryEvent.getOver(),
                commentaryEvent.getBall(),
                commentaryEvent.getCommentary(),
                commentaryEvent.getEventTimestamp()
        );
        producer.publish(event);
    }
}
