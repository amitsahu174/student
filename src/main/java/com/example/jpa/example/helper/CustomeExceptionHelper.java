package com.example.jpa.example.helper;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomeExceptionHelper extends RuntimeException {
    String errorMsg;
}
