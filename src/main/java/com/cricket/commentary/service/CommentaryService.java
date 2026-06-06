package com.cricket.commentary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.cricket.commentary.kafka.MatchEventProducer;
import com.cricket.commentary.contracts.MatchEvent;
import com.cricket.commentary.contracts.MatchEventRequest;

@Service
@RequiredArgsConstructor
public class CommentaryService {

    private final MatchEventProducer producer;

    public void createCommentary(MatchEventRequest matchEventRequest) {

        MatchEvent event = new MatchEvent(
                matchEventRequest.getMatchId(),
                matchEventRequest.getOver(),
                matchEventRequest.getBall(),
                matchEventRequest.getCommentary(),
                matchEventRequest.getEventTimestamp()
        );
        producer.publish(event);
    }
}
