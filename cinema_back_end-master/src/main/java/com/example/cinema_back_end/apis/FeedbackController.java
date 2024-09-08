package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.dtos.FeedbackDTO;
import com.example.cinema_back_end.dtos.FeedbackStatisticsDTO;
import com.example.cinema_back_end.dtos.request.ApiResponse;
import com.example.cinema_back_end.dtos.request.FeedbackRequest;
import com.example.cinema_back_end.dtos.response.FeedbackResponse;
import com.example.cinema_back_end.entities.Feedback;
import com.example.cinema_back_end.security.repo.IUserRepository;
import com.example.cinema_back_end.security.service.UserService;
import com.example.cinema_back_end.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/add/{type}")
    private ApiResponse<FeedbackResponse> addFeedback(@PathVariable String type,@RequestBody FeedbackRequest feedbackRequest, @AuthenticationPrincipal UserDetails userDetails) {
        return ApiResponse.<FeedbackResponse>builder()
                .code(200)
                .message("Added feedback")
                .result(feedbackService.addFeedback(type,feedbackRequest))
                .build();
    }
    @GetMapping("/getall")
    private ApiResponse<List<Feedback>> getFeedback() {
        return  ApiResponse.<List<Feedback>>builder()
                .code(200)
                .message("Get all feedbacks")
                .result(feedbackService.getAll())
                .build();
    }

    @GetMapping("/type/{type}")
    public ApiResponse<List<FeedbackDTO>> getFeedbacksByType(@PathVariable String type) {
        // Lấy danh sách phản hồi dựa trên loại
        List<Feedback> feedbacks = feedbackService.getFeedbacksByType(type);
        List<FeedbackDTO> feedbackDTOs = new ArrayList<>();

        // Chuyển đổi từ Feedback sang FeedbackDTO và lấy username
        for (Feedback feedback : feedbacks) {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setId(feedback.getId());
            feedbackDTO.setContent(feedback.getContent());
            feedbackDTO.setRated(feedback.getRated());
            feedbackDTO.setType(feedback.getType());
            feedbackDTO.setUserId(feedback.getUserId());
            feedbackDTO.setReferenceId(feedback.getReferenceId());

            // Lấy username từ userId
            String username = userService.getUsernameById(feedback.getUserId());
            feedbackDTO.setUsername(username);

            // Thêm vào danh sách DTO
            feedbackDTOs.add(feedbackDTO);
        }

        // Trả về ApiResponse với danh sách FeedbackDTO
        return ApiResponse.<List<FeedbackDTO>>builder()
                .code(200)
                .message("Feedbacks fetched successfully")
                .result(feedbackDTOs)
                .build();
    }
    @GetMapping("/statictics")
    public ApiResponse<List<Object[]>> getFeedbackStatistics() {
        List<Object[]> stats = feedbackService.getFeedbackStatistics();
        return ApiResponse.<List<Object[]>>builder()
                .code(200)
                .message("Feedback statistics fetched successfully")
                .result(stats)
                .build();
    }
//    lấy theo Movie
    @GetMapping("/movie/{movieId}")
    public ApiResponse<List<FeedbackDTO>> getFeedbacksForMovie(@PathVariable Integer movieId) {
        List<Feedback> feedbacks = feedbackService.getFeedbacksForMovie(movieId);
        List<FeedbackDTO> feedbackDTOs = new ArrayList<>();
//
        for (Feedback feedback : feedbacks) {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setId(feedback.getId());
            feedbackDTO.setContent(feedback.getContent());
            feedbackDTO.setRated(feedback.getRated());
            feedbackDTO.setType(feedback.getType());
            feedbackDTO.setUserId(feedback.getUserId());
            feedbackDTO.setReferenceId(feedback.getReferenceId());

            // Lấy username từ userId
            String username = userService.getUsernameById(feedback.getUserId());
            feedbackDTO.setUsername(username);
            feedbackDTOs.add(feedbackDTO);
        }
        return ApiResponse.<List<FeedbackDTO>>builder()
                .code(200)
                .result(feedbackDTOs)
                .message("Feedback for Movie")
                .build();
    }
    @GetMapping("/movie/{movieId}/statistics")
    public ApiResponse<FeedbackStatisticsDTO> getMovieFeedbackStatistics(@PathVariable Integer movieId) {
        FeedbackStatisticsDTO statistics = feedbackService.getMovieFeedbackStatistics(movieId);
        return ApiResponse.<FeedbackStatisticsDTO>builder()
                .code(200)
                .message("Movie feedback statistics fetched successfully")
                .result(statistics)
                .build();
    }

    @GetMapping("/schedule/{scheduleId}")
    public ApiResponse<List<FeedbackDTO>> getFeedbacksForSchedule(@PathVariable Integer scheduleId) {
        List<Feedback> feedbacks = feedbackService.getFeedbacksForSchedule(scheduleId);
        List<FeedbackDTO> feedbackDTOs = new ArrayList<>();

        for (Feedback feedback : feedbacks) {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setId(feedback.getId());
            feedbackDTO.setContent(feedback.getContent());
            feedbackDTO.setRated(feedback.getRated());
            feedbackDTO.setType(feedback.getType());
            feedbackDTO.setUserId(feedback.getUserId());
            feedbackDTO.setReferenceId(feedback.getReferenceId());

            // Lấy username từ userId
            String username = userService.getUsernameById(feedback.getUserId());
            feedbackDTO.setUsername(username);
            feedbackDTOs.add(feedbackDTO);
        }
        return ApiResponse.<List<FeedbackDTO>>builder()
                .code(200)
                .result(feedbackDTOs)
                .message("Feedback for Schedule")
                .build();
    }
    @DeleteMapping("/delete/{id}")
    public ApiResponse<Void> deleteFeedback(@PathVariable Integer id) {
        feedbackService.deleteFeedback(id);
        return ApiResponse.<Void>builder()
                .code(200)
                .message("Feedback deleted successfully")
                .build();
    }
}
