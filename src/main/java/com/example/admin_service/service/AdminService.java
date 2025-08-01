package com.example.admin_service.service;

import com.example.admin_service.dto.BookingSummaryDTO;
import com.example.admin_service.dto.TrainDTO;
import com.example.admin_service.dto.UserDTO;
import com.example.admin_service.dto.BookingRequestDTO;

import java.util.List;
import java.util.UUID;

public interface AdminService {
    List<BookingSummaryDTO> getAllBookings(String token);
    void cancelBooking(UUID bookingId, String token);
    List<TrainDTO> getAllTrains(String token);
    List<UserDTO> getAllUsers(String token);
    BookingSummaryDTO createBooking(BookingRequestDTO request, String token);
}
