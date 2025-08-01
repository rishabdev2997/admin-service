package com.example.admin_service.dto;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class BookingSummaryDTO {
    private UUID id;
    private UUID userId;
    private UUID trainId;
    private List<String> seatNumbers;
    private String journeyDate;
    private String status;
}
