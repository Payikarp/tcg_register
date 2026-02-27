package com.tcg_card_register.Tcg_Register.dto;

import java.time.Instant;

public record ExceptionDTO(
    Instant timestamp,
    int status,
    String error
)
{ }
