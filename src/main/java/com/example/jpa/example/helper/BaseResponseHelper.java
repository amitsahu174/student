package com.example.jpa.example.helper;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class BaseResponseHelper<T> {

    private final String timestamp = this.getTimeStamp();
    private int status;
    private String error;
    private String message;
    private T data;

    public BaseResponseHelper(int status, String message, T data) {

        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getTimeStamp() {
        Timestamp systemtime = new Timestamp(System.currentTimeMillis());
        String timestamp = String.valueOf(systemtime);
        return timestamp;
    }
}
