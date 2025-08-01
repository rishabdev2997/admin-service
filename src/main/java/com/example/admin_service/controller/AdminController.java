package com.example.admin_service.controller;

import com.example.admin_service.dto.BookingSummaryDTO;
import com.example.admin_service.dto.TrainDTO;
import com.example.admin_service.dto.UserDTO;
import com.example.admin_service.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.admin_service.dto.BookingRequestDTO;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    @PostMapping("/bookings")
    public BookingSummaryDTO createBooking(
            @RequestBody BookingRequestDTO request,
            @RequestHeader("Authorization") String token
    ) {
        return adminService.createBooking(request, token);
    }
    @GetMapping("/bookings")
    public List<BookingSummaryDTO> getAllBookings(@RequestHeader("Authorization") String token) {
        return adminService.getAllBookings(token);
    }

    @PostMapping("/bookings/{bookingId}/cancel")
    public void cancelBooking(@PathVariable UUID bookingId, @RequestHeader("Authorization") String token) {
        adminService.cancelBooking(bookingId, token);
    }

    @GetMapping("/trains")
    public List<TrainDTO> getAllTrains(@RequestHeader("Authorization") String token) {
        return adminService.getAllTrains(token);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(@RequestHeader("Authorization") String token) {
        return adminService.getAllUsers(token);
    }
}
