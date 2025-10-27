package dev.jeandlcr.ecommerce.core.responses;

import java.util.List;

public class Response<T> {

    private boolean success;
    private String message;
    private T data;
    private long timestamp;
    private int totalRows;

    public Response() {
        this.timestamp = System.currentTimeMillis();
    }

    public Response(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();

        if (data instanceof List<?>) {
            this.totalRows = ((List<?>) data).size();
        }
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(true, "Operation successful", data);
    }

    public static <T> Response<T> success(String message, T data) {
        return new Response<>(true, message, data);
    }

    public static <T> Response<T> error(String message) {
        return new Response<>(false, message, null);
    }

    public static <T> Response<T> error(String message, T data) {
        return new Response<>(false, message, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }
}
