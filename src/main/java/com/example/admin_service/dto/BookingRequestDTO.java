package com.example.admin_service.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class BookingRequestDTO {
    private UUID userId;
    private UUID trainId;
    private List<String> seatNumbers;
    private LocalDate journeyDate;
}
