package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.BranchDTO;
import com.example.cinema_back_end.dtos.MovieDTO;
import com.example.cinema_back_end.dtos.RoomDTO;
import com.example.cinema_back_end.dtos.ScheduleDTO;
import com.example.cinema_back_end.dtos.TicketDTO;
import com.example.cinema_back_end.dtos.request.ScheduleCreateRequest;
import com.example.cinema_back_end.dtos.response.IScheduleDTO;
import com.example.cinema_back_end.dtos.response.ScheduleStatisticsDTO;
import com.example.cinema_back_end.entities.Branch;
import com.example.cinema_back_end.entities.Movie;
import com.example.cinema_back_end.entities.Room;
import com.example.cinema_back_end.entities.Schedule;
import com.example.cinema_back_end.repositories.IBranchRepository;
import com.example.cinema_back_end.repositories.IMovieRepository;
import com.example.cinema_back_end.repositories.IRoomRepository;
import com.example.cinema_back_end.repositories.IScheduleRepository;
import com.example.cinema_back_end.security.exceptions.AppException;
import com.example.cinema_back_end.security.exceptions.ErrorCode;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ScheduleService implements IScheduleService {
    @Autowired
    private IScheduleRepository scheduleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<String> getAllStartDateSchedule() {
    	LocalDate date= LocalDate.now();
        return scheduleRepository.getAllStartDateSchedule()
                .stream().filter(localDate -> localDate.compareTo(date)>=0)
                .map(localDate -> localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .collect(Collectors.toList());
    }

	@Override
	public List<ScheduleDTO> findAll() {
        return scheduleRepository.findAll()
        .stream().map(schedule -> {
        	ScheduleDTO s=modelMapper.map(schedule,ScheduleDTO.class);
        	s.setBranch(modelMapper.map(s.getBranch(), BranchDTO.class));
        	s.setMovie(modelMapper.map(s.getMovie(), MovieDTO.class));
        	s.setRoom(modelMapper.map(s.getRoom(), RoomDTO.class));
        	return s;	
        })
        .collect(Collectors.toList());
	}

	@Override
	public ScheduleDTO getById(Integer id) {
        	ScheduleDTO s=modelMapper.map(scheduleRepository.findById(id).get(),ScheduleDTO.class);
        	s.setBranch(modelMapper.map(s.getBranch(), BranchDTO.class));
        	s.setMovie(modelMapper.map(s.getMovie(), MovieDTO.class));
        	s.setRoom(modelMapper.map(s.getRoom(), RoomDTO.class));
        	return s;	
	}

	@Override
	public void update(ScheduleDTO schedule) {
		Schedule s=modelMapper.map(schedule, Schedule.class);
		s.getBranch().setId(schedule.getBranch().getId());
		s.getRoom().setId(schedule.getRoom().getId());
		s.getMovie().setId(schedule.getMovie().getId());
		scheduleRepository.save(s);
	}
	
	@Override
	public void remove(Integer id) {
		scheduleRepository.deleteById(id);	
	}

	@Override
	public List<ScheduleDTO> getSchedulesByBranchId(Integer branchId) {
		return scheduleRepository.findSchedulesByBranch_Id(branchId)
                .stream().map(schedule -> modelMapper.map(schedule,ScheduleDTO.class))
                .collect(Collectors.toList());
	}


//	Hoang add

	@Autowired
	private IMovieRepository movieRepository;

	@Autowired
	private IRoomRepository roomRepository;

	@Autowired
	private IBranchRepository branchRepository;


	public Schedule createSchedule(ScheduleCreateRequest request) {
		Schedule schedule = new Schedule();
		Movie movie = movieRepository.findById(request.getMovieId())
				.orElseThrow(() -> new AppException(ErrorCode.Movie_NOT_EXISTED));
		Branch branch = branchRepository.findById(request.getBranchId())
				.orElseThrow(() -> new AppException(ErrorCode.Brand_NOT_EXISTED));
		Room room = roomRepository.findById(request.getRoomId())
				.orElseThrow(()-> new AppException(ErrorCode.Room_NOT_EXISTED));

		schedule.setMovie(movie);
		schedule.setRoom(room);
		schedule.setBranch(branch);
		schedule.setStartDate(request.getStartDate());
		schedule.setStartTime(request.getStartTime());
		schedule.setPrice(request.getPrice());

		return scheduleRepository.save(schedule);
	}

	public Schedule updateSchedule(Integer id, IScheduleDTO scheduleDTO) {
		Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
		schedule.setStartDate(scheduleDTO.getStartDate());
		schedule.setStartTime(scheduleDTO.getStartTime());
		schedule.setPrice(scheduleDTO.getPrice());

		// Lấy movie, room, branch từ id và gán vào schedule
		schedule.setMovie(movieRepository.findById(scheduleDTO.getMovieId()).orElseThrow(() -> new RuntimeException("Movie not found")));
		schedule.setRoom(roomRepository.findById(scheduleDTO.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found")));
		schedule.setBranch(branchRepository.findById(scheduleDTO.getBranchId()).orElseThrow(() -> new RuntimeException("Branch not found")));

		return scheduleRepository.save(schedule);
	}

	public void deleteSchedule(Integer id) {
		Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
		scheduleRepository.delete(schedule);
	}
//
//    public List<Schedule> getAllSchedules() {
//        return scheduleRepository.findAll();
//    }

	//manager schedule end
	public List<Object[]> getSchedules() {
		return scheduleRepository.findAllSchedulesWithMovieAndRoom();
	}
	public List<Object[]> test() {
		return scheduleRepository.findAllSchedulesWithMovieAndRoom1();
	}
	//	public List<Object[]> getSchedulesOpen() {
//		return scheduleRepository.findAllSchedulesWithMovieAndRoomNative();
//	}
	//    Custom schedule
	public List<Object> getSchedulesWithDay(String search,LocalDate startDay, LocalDate endDay) {
		return scheduleRepository.findSchedulesFilter(search, startDay, endDay);
	}

	public ScheduleStatisticsDTO getScheduleStatistics() {
		long totalSchedules = scheduleRepository.count();
		double averagePrice = scheduleRepository.findAveragePrice();
		double maxPrice = scheduleRepository.findMaxPrice();
		double minPrice = scheduleRepository.findMinPrice();

		return ScheduleStatisticsDTO.builder()
				.totalSchedules(totalSchedules)
				.averagePrice(averagePrice)
				.maxPrice(maxPrice)
				.minPrice(minPrice)
				.build();
	}

}
