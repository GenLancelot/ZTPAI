package com.Teamfinder.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AfterLoginDto {
    private Long id;
    private boolean isAdmin;
}
