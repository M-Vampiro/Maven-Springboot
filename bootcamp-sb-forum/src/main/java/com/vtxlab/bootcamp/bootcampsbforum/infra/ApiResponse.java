package com.vtxlab.bootcamp.bootcampsbforum.infra;

// chain methods
// ApiResponse.<User>builder().code(xxx).message(xxx).data(xxx).build();

// ApiResponse is for serialization, getter & setter are required.
// For deserialization (RestTemplate call -> objectmapper), only getter is required.
// For deserialization (controller(spring) -> objectmapper), No getter & setter is required.

// RestTemplate.getForObject() is similar to redisHelper.get(key)

// RedisTemplate

// @Getter
// @Builder
public class ApiResponse<T> {

  // NO getter, setter, empty constructor

  private String code;

  private String message;

  private T data;

  public ApiResponse(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static <T> ApiResponseBuilder<T> builder() { // user self-define T
    return new ApiResponseBuilder<>();
  }

  // builder
  public static class ApiResponseBuilder<T> {

    private String code;
    private String message;
    private T data;

    public ApiResponseBuilder<T> code(String code) { // instance method
      this.code = code;
      return this;
    }

    public ApiResponseBuilder<T> message(String message) { // instance method
      this.message = message;
      return this;
    }

    public ApiResponseBuilder<T> message(T data) { // instance method
      this.data = data;
      return this;
    }

    public ApiResponse<T> build() { // instance method -> this
      return new ApiResponse<>(this);
    }
  }

}