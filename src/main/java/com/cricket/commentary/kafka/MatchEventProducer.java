package com.cricket.commentary.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cricket.commentary.contracts.MatchEvent;

@Service
@RequiredArgsConstructor
public class MatchEventProducer {

    private final KafkaTemplate<String, MatchEvent> kafkaTemplate;

    private static final String TOPIC = "match-events";

    public void publish(MatchEvent event) {
        kafkaTemplate.send(TOPIC, event.matchId(), event);
    }
}
