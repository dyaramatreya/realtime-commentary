package com.cricket.commentary.service;

import com.cricket.commentary.contracts.MatchEventResponse;
import com.cricket.commentary.model.CommentaryEvent;
import com.cricket.commentary.repository.CommentaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.cricket.commentary.kafka.MatchEventProducer;
import com.cricket.commentary.contracts.MatchEvent;
import com.cricket.commentary.contracts.MatchEventRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentaryService {

    private final MatchEventProducer producer;
    private final CommentaryRepository repository;

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
