package com.neitdisc.demo.entity.pojo;

/**
 * @author WHLiang
 * @date 2019/8/21 11:55
 */
public class Response<T> {
    /**
     * 状态码(success:0,error:1,后期自增)
     */
    private String code;
    /**
     * 用的着就写吧
     */
    private String msg;
    /**
     * 返回的数据(查询)
     */
    private T data;
    /**
     * 页码
     */
    private int pageNum;
    /**
     * 分页时候总条数
     */
    private int total;

    private Response(String code, String msg, T data, int pageNum, int total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.pageNum = pageNum;
        this.total = total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static <T> Response<T> create(String code, String msg, T data, int pageNum, int total) {
        return new Response<>(code, msg, data, pageNum, total);
    }

    public static <T> Response<T> success() {
        return new Response<>("0", "", null, 1, 0);
    }

    public static <T> Response<T> success(String msg) {
        return new Response<>("0", msg, null, 1, 0);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>("0", "", data, 1, 0);
    }

    public static <T> Response<T> success(T data, int pageNum, int total) {
        return new Response<>("0", "", data, pageNum, total);
    }

    public static <T> Response<T> success(String msg, T data) {
        return new Response<>("0", msg, data, 1, 0);
    }

    public static <T> Response<T> success(String msg, T data, int pageNum, int total) {
        return new Response<>("0", msg, data, pageNum, total);
    }

    public static <T> Response<T> error() {
        return new Response<>("1", "", null, 1, 0);
    }

    public static <T> Response<T> error(String msg) {
        return new Response<>("1", msg, null, 1, 0);
    }

    public static <T> Response<T> error(T data) {
        return new Response<>("1", "", data, 1, 0);
    }

    public static <T> Response<T> error(T data, int pageNum, int total) {
        return new Response<>("1", "", data, pageNum, total);
    }

    public static <T> Response<T> error(String msg, T data) {
        return new Response<>("1", msg, data, 1, 0);
    }

    public static <T> Response<T> error(String msg, T data, int pageNum, int total) {
        return new Response<>("1", msg, data, pageNum, total);
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", pageNum=" + pageNum +
                ", total=" + total +
                '}';
    }
}

