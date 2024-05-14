package art.dborg.webservice.v1.core.utilites;

import art.dborg.webservice.v1.core.result.Result;
import art.dborg.webservice.v1.core.result.ResultData;
import org.springframework.http.HttpStatus;

public class ResultHelper {

    public static <T> ResultData<T> CREATED(T data) {
        return new ResultData<>(true, Message.CREATED, HttpStatus.CREATED.toString(), data);
    }


    public static <T> ResultData<T> OK(T data) {
        return new ResultData<>(true, Message.OK, HttpStatus.OK.toString(), data);
    }


    public static <T> ResultData<T> DELETE(T data) {
        return new ResultData<>(true, Message.DELETED, "200", data);
    }


    public static <T> ResultData<T> ERROR(T data) {
        return new ResultData<>(false, Message.NOT_NULL_MESSAGE, "409", data);
    }

    public static Result NOT_FOUND_ID() {
        return new Result(false, Message.NOT_FOUND_ID, "404");
    }


    public static Result NULL_POINTER() {
        return new Result(false, Message.NULL_POINTER, "500");
    }

    public static Result NULL_VALUES() {
        return new Result(false, Message.NULL_VALUES, "404");
    }


    public static Result NOT_FOUND() {
        return new Result(false, Message.NOT_FOUND, "404");
    }


    public static Result UPDATE_NOT_FOUND_ID() {
        return new Result(false, Message.UPDATE_NOT_FOUND_ID, "404");
    }


    public static Result NOT_UNIQUE() {
        return new Result(false, Message.NOT_UNIQUE, "415");
    }


    public static Result SAME_VALUES() {
        return new Result(false, Message.SAME_VALUES, "409");
    }


    public static Result RESOURCE_NOT_FOUND() {
        return new Result(false, Message.RESOURCE_NOT_FOUND, "409");
    }


    public static Result UNREADABLE() {
        return new Result(false, Message.UNREADABLE, "502");
    }


    public static Result MISSING_PARAMETER() {
        return new Result(false, Message.MISSING_PARAMETER, "502");
    }

}
