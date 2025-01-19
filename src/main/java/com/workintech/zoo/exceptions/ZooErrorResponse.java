package com.workintech.zoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class ZooErrorResponse {
    private int status;
    private String message;
        private long timestamp;
}