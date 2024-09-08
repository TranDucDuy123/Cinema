package com.example.cinema_back_end.repositories;

import com.example.cinema_back_end.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
//    List<Feedback> findByUserId(Integer userId);
    @Query("SELECT f.type, COUNT(f), AVG(f.rated) FROM Feedback f GROUP BY f.type")
    List<Object[]> getFeedbackStatistics();

    List<Feedback> findByType(String type);

    // Tìm tất cả feedback theo referenceId và type
    List<Feedback> findByReferenceIdAndType(Integer referenceId, String type);

    Long countByReferenceIdAndType(Integer referenceId, String type);

    @Query("SELECT SUM(f.rated) FROM Feedback f WHERE f.referenceId = :referenceId AND f.type = :type")
    Integer sumRatedByReferenceIdAndType(@Param("referenceId") Integer referenceId, @Param("type") String type);

    @Query("SELECT AVG(f.rated) FROM Feedback f WHERE f.referenceId = :referenceId AND f.type = :type")
    Double findAverageRatingByReferenceIdAndType(@Param("referenceId") Integer referenceId, @Param("type") String type);


}
