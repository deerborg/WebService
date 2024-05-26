package com.example.webservice.v1.core.utilites;

import com.example.webservice.v1.core.result.Result;
import com.example.webservice.v1.core.result.ResultData;

public class ResultHelper {
    public static <T>ResultData<T> CREATED(T data){
        return new ResultData<>(true,Message.CREATED_MODEL,data);
    }
    public static Result NOT_UNIQUE(){
        return new Result(false,Message.NOT_UNIQUE);
    }
    public static Result NOT_FOUND(){
        return new Result(false,Message.NOT_FOUND);
    }
    public static Result NOY_YOUR_ID(){
        return new Result(false,Message.NOT_YOUR_ID);
    }
}
