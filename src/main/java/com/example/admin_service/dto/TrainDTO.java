package com.example.admin_service.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class TrainDTO {
    private UUID id;
    private String trainNumber;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
}
