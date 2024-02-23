package com.vtxlab.bootcamp.bootcampsbforum.infra;

// chain methods
// ApiResponse.<User>builder().code(xxx).message(xxx).data(xxx).build();

// ApiResponse is for serialization, getter & setter are required.
// For deserialization (RestTemplate call -> objectmapper), only getter is required.
// For deserialization (controller(spring) -> objectmapper), No getter & setter is required.

// RestTemplate.getForObject() is similar to redisHelper.get(key)

// RedisTemplate

public class ApiResponse<T> {

  private String code;

  private String message;

  private T data;

  private ApiResponse(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static <T> ApiResponseBuilder<T> builder() { // user self-define T
    return new ApiResponseBuilder<>();
  }

  // builder
  public static class ApiResponseBuilder<T> {

    private String code;
    private String message;
    private T data;

    public ApiResponseBuilder<T> ok() {
      this.code = Syscode.OK.getCode();
      this.message = Syscode.OK.getMessage();
      return this;
    }

    public ApiResponseBuilder<T> status(Syscode syscode) {
      this.code = syscode.getCode();
      this.message = syscode.getMessage();
      return this;
    }

    public ApiResponseBuilder<T> data(T data) { // instance method
      this.data = data;
      return this;
    }

    public ApiResponse<T> build() { // instance method -> this
      return new ApiResponse<>(this);
    }

  }

}
