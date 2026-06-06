package com.cricket.commentary.repository;

import com.cricket.commentary.model.CommentaryEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaryRepository extends JpaRepository<CommentaryEvent, Long> {
    List<CommentaryEvent> findByMatchIdAndIdGreaterThanOrderById(String matchId, Long  id);
}
