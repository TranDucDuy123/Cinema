package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.FeedbackStatisticsDTO;
import com.example.cinema_back_end.dtos.request.FeedbackRequest;
import com.example.cinema_back_end.dtos.response.FeedbackResponse;
import com.example.cinema_back_end.entities.Feedback;
import com.example.cinema_back_end.entities.User;
import com.example.cinema_back_end.repositories.FeedbackRepository;
import com.example.cinema_back_end.security.exceptions.AppException;
import com.example.cinema_back_end.security.exceptions.ErrorCode;
import com.example.cinema_back_end.security.repo.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    IUserRepository userRepository;

//    FeedbackMapper mapper;

    public FeedbackResponse addFeedback(String type,FeedbackRequest request) {
        var authen = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authen.getName())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Feedback feedback = new Feedback();
        switch (type){
            case "movie":
                feedback.setType("movie");
                feedback.setContent(request.getContent());
                feedback.setRated(request.getRated());
                feedback.setUserId(request.getUserId());
                feedback.setReferenceId(request.getReferenceId());
                if (request.getReferenceId() == null){
                    throw new AppException(ErrorCode.MIX_FIELD_FEEDBACK);
                }
                break;
            case "schedule":
                feedback.setType("schedule");
                feedback.setContent(request
                        .getContent());
                feedback.setRated(request.getRated());
                feedback.setUserId(request.getUserId());
                feedback.setReferenceId(request.getReferenceId());
                if (request.getReferenceId() == null){
                    throw new AppException(ErrorCode.MIX_FIELD_FEEDBACK);
                }
                break;
            case "service":
                feedback.setType("service");
                feedback.setContent(request.getContent());
                feedback.setRated(request.getRated());
                feedback.setUserId(request.getUserId());
                break;
            case "web":
                feedback.setType("web");
                feedback.setContent(request.getContent());
                feedback.setRated(request.getRated());
                feedback.setUserId(request.getUserId());
                break;
            default:
                throw new AppException(ErrorCode.MIX_FIELD_FEEDBACK);
        }
        feedbackRepository.save(feedback);
        FeedbackResponse feedbackResponse = new FeedbackResponse().builder()
                .id(feedback.getId())
                .content(request.getContent())
                .type(type)
                .rated(request.getRated())
                .referenceId(request.getReferenceId())
                .userId(request.getUserId())
                .username(user.getUsername())
//                .content(authen.getName())
                .build();
        return feedbackResponse;
    }
    public List<Feedback> getAll(){
        return feedbackRepository.findAll();
//        var result = feedbackRepository.findAll();
//        return result.stream().map(mapper::toFeedbackResponse).toList();
    }
//   fype feedback
    public List<Feedback> getFeedbacksByType(String type) {
        return feedbackRepository.findByType(type);
    }
//    statictics
    public List<Object[]> getFeedbackStatistics() {
       return feedbackRepository.getFeedbackStatistics();
    }

    // Lấy tất cả feedback liên quan đến một phim dựa trên referenceId và type

//    lấy theo id Movie
    public List<Feedback> getFeedbacksForMovie(Integer movieId) {
        return feedbackRepository.findByReferenceIdAndType(movieId, "movie");
    }
    public FeedbackStatisticsDTO getMovieFeedbackStatistics(Integer movieId) {
        Long totalFeedbacks = feedbackRepository.countByReferenceIdAndType(movieId, "movie");
        Integer totalRated = feedbackRepository.sumRatedByReferenceIdAndType(movieId, "movie");
        Double averageRating = feedbackRepository.findAverageRatingByReferenceIdAndType(movieId, "movie");

        return new FeedbackStatisticsDTO(totalFeedbacks, totalRated, averageRating);
    }
    public List<Feedback> getFeedbacksForSchedule(Integer scheduleId) {
        return feedbackRepository.findByReferenceIdAndType(scheduleId, "schedule");
    }
    public void deleteFeedback(Integer id) {
        if (!feedbackRepository.existsById(id)) {
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
        feedbackRepository.deleteById(id);
    }
}
