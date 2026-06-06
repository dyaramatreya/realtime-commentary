package com.cricket.commentary.kafka;

import com.cricket.commentary.contracts.MatchEvent;
import com.cricket.commentary.model.CommentaryEvent;
import com.cricket.commentary.repository.CommentaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MatchEventConsumer {

    private final CommentaryRepository repository;

    @KafkaListener(
            topics = "match-events",
            groupId = "commentary-consumer-group"
    )
    public void consume(MatchEvent event) {
        log.info(
                "Received event match={} over={} ball={}",
                event.matchId(),
                event.over(),
                event.ball()
        );

        CommentaryEvent eventEntity = CommentaryEvent.builder()
                .matchId(event.matchId())
                .over(event.over())
                .ball(event.ball())
                .commentary(event.commentary())
                .id(event.eventID())
                .build();

        try {
            repository.save(eventEntity);
        } catch (Exception ex) {
            log.error("Failed to persist event", ex);
        }
    }
}
