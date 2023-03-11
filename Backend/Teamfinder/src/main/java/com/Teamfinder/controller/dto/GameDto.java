package com.Teamfinder.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GameDto {
    private Long id;
    private String name;
    private String filename;
}