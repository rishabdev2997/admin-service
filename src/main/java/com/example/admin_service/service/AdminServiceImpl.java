package com.example.admin_service.service;

import com.example.admin_service.dto.BookingSummaryDTO;
import com.example.admin_service.dto.TrainDTO;
import com.example.admin_service.dto.UserDTO;
import com.example.admin_service.dto.BookingRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final RestTemplate restTemplate;

    @Value("${booking.service.url}")
    private String bookingServiceUrl;

    @Value("${user.service.url}")
    private String userServiceUrl;

    @Value("${train.service.url}")
    private String trainServiceUrl;

    private HttpHeaders createHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        return headers;
    }

    @Override
    public List<BookingSummaryDTO> getAllBookings(String token) {
        HttpEntity<Void> entity = new HttpEntity<>(createHeaders(token));
        ResponseEntity<BookingSummaryDTO[]> response = restTemplate.exchange(
                bookingServiceUrl, HttpMethod.GET, entity, BookingSummaryDTO[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public void cancelBooking(UUID bookingId, String token) {
        HttpEntity<Void> entity = new HttpEntity<>(createHeaders(token));
        restTemplate.exchange(
                bookingServiceUrl + "/" + bookingId + "/cancel", HttpMethod.POST, entity, Void.class);
    }

    @Override
    public List<TrainDTO> getAllTrains(String token) {
        HttpEntity<Void> entity = new HttpEntity<>(createHeaders(token));
        ResponseEntity<TrainDTO[]> response = restTemplate.exchange(
                trainServiceUrl, HttpMethod.GET, entity, TrainDTO[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public List<UserDTO> getAllUsers(String token) {
        HttpEntity<Void> entity = new HttpEntity<>(createHeaders(token));
        ResponseEntity<UserDTO[]> response = restTemplate.exchange(
                userServiceUrl, HttpMethod.GET, entity, UserDTO[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public BookingSummaryDTO createBooking(BookingRequestDTO request, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<BookingRequestDTO> entity = new HttpEntity<>(request, headers);
        ResponseEntity<BookingSummaryDTO> response = restTemplate.exchange(
                bookingServiceUrl, HttpMethod.POST, entity, BookingSummaryDTO.class
        );
        return response.getBody();
    }
}
