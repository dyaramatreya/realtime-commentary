package com.cricket.commentary.service;

import com.cricket.commentary.contracts.MatchEventResponse;
import com.cricket.commentary.model.CommentaryEvent;
import com.cricket.commentary.repository.CommentaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import com.cricket.commentary.kafka.MatchEventProducer;
import com.cricket.commentary.contracts.MatchEvent;
import com.cricket.commentary.contracts.MatchEventRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentaryService {

    private final MatchEventProducer producer;
    private final CommentaryRepository repository;

    private final AtomicLong idGenerator = new AtomicLong(1);
    private final Random random = new Random();
    private int over = 0;
    private int ball = 0;

    private static final List<String> COMMENTARIES = List.of(
            "FOUR!",
            "SIX!",
            "Dot ball",
            "Single taken",
            "Two runs",
            "WICKET!",
            "Appeal turned down",
            "Excellent cover drive",
            "Beaten outside off",
            "Huge six over long on"
    );

    private void advanceBall() {
        ball++;

        if (ball > 6) {
            ball = 1;
            over++;
        }
    }

    @Scheduled(fixedRate = 10000)
    public void generateCommentary() {

        advanceBall();

        MatchEvent event = new MatchEvent(
                "match-123",
                over,
                ball,
                COMMENTARIES.get(random.nextInt(COMMENTARIES.size())),
                idGenerator.getAndIncrement()
        );

        producer.publish(event);

        System.out.println("Published: " + event);
    }

    public void createCommentary(MatchEventRequest matchEventRequest) {

        MatchEvent event = new MatchEvent(
            matchEventRequest.getMatchId(),
            matchEventRequest.getOver(),
            matchEventRequest.getBall(),
            matchEventRequest.getCommentary(),
            matchEventRequest.getId()
        );
        producer.publish(event);
    }

    public List<MatchEventResponse> getCommentaryEvents(String matchID, Long id) {
        if(id==null) {
            return repository.findAllByMatchIdOrderByIdDesc(matchID).stream().map(this::toResponse).toList();
        }
        return repository.findByMatchIdAndIdGreaterThanOrderByIdDesc(matchID, id).stream()
                .map(this::toResponse)
                .toList();
    }

    private MatchEventResponse toResponse(CommentaryEvent commentaryEvent) {
        return MatchEventResponse.builder()
                .matchId(commentaryEvent.getMatchId())
                .over(commentaryEvent.getOver())
                .ball(commentaryEvent.getBall())
                .commentary(commentaryEvent.getCommentary())
                .id(commentaryEvent.getId())
                .build();
    }
}
