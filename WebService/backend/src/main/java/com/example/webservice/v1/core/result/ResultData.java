package com.example.webservice.v1.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultData <T> extends Result{
    private T data;

    public ResultData(boolean status, String message, T data) {
        super(status, message);
        this.data = data;
    }
}
