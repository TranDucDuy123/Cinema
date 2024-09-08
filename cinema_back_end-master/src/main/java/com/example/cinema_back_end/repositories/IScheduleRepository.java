package com.example.cinema_back_end.repositories;

import com.example.cinema_back_end.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IScheduleRepository extends JpaRepository<Schedule, Integer> {
	List<Schedule> findSchedulesByBranch_Id(Integer branchId);
    List<Schedule> findSchedulesByBranch_IdAndRoom_Id( Integer branchId,Integer movieId);
    List<Schedule> findSchedulesByBranch_IdAndRoom_IdAndMovie_Id(Integer branchId,Integer roomId,Integer movieId);
    @Query("SELECT DISTINCT s.startDate FROM Schedule s")
    List<LocalDate> getAllStartDateSchedule();





    //    Hoang add
//    List<Feedback> findByUserId(Integer userId);
    @Query("SELECT s.id, s.movie.name, s.movie.largeImageURL, s.room.name, s.startDate, s.startTime , s.price, s.branch.name FROM Schedule s")
    List<Object[]> findAllSchedulesWithMovieAndRoom();


    @Query("SELECT s.id, s.movie.name, s.movie.largeImageURL, s.room.name, s.startDate, s.startTime , s.price, s.branch.name FROM Schedule s")
    List<Object[]> findAllSchedulesWithMovieAndRoom1();
//    @Query(value = "SELECT s.id, m.name as movieName, r.name as roomName, s.start_date, s.start_time, s.price, b.name as branchName " +
//            "FROM schedule s " +
//            "JOIN movie m ON s.movie_id = m.id " +
//            "JOIN room r ON s.room_id = r.id"+
//            "JOIN branch b ON r.branch_id = b.id "+
//            "JOIN ticket t ON s.id = t.schedule_id", nativeQuery = true)
//    List<Object[]> findAllSchedulesWithMovieAndRoomNative();

    @Query("SELECT s, m.name FROM Schedule s " +
            "JOIN s.movie m " +
            "LEFT JOIN Feedback f ON f.referenceId = s.id AND f.type = 'Schedule' " +
            "WHERE m.name LIKE CONCAT('%', :search, '%') " +
            "AND s.startDate BETWEEN :startDate AND :endDate")
    List<Object> findSchedulesFilter(@Param("search") String search,
                                     @Param("startDate") LocalDate startDate,
                                     @Param("endDate") LocalDate endDate);
//    @Query("SELECT s,m.name FROM S chedule s " +
//            "JOIN movie m ON m.name LIKE CONCAT('%',:search,'%')" +
//            "WHERE s.startDate BETWEEN :startDate AND :endDate")
//    List<Object[]> findSchedulesWithinNextWeek(@Param("search") String search,@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT AVG(s.price) FROM Schedule s")
    double findAveragePrice();

    @Query("SELECT MAX(s.price) FROM Schedule s")
    double findMaxPrice();

    @Query("SELECT MIN(s.price) FROM Schedule s")
    double findMinPrice();
}