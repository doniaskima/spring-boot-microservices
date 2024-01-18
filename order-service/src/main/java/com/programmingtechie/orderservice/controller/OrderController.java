package com.programmingtechie.orderservice.controller;

import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * The @RestController annotation indicates that this class is a controller in a Spring MVC application.
 * It combines @Controller and @ResponseBody annotations, which means it's ready to handle web requests and
 * the return values of the methods will be automatically serialized to JSON and returned in the HTTP response body.
 */
@RestController

/**
 * The @RequestMapping("/api/order") annotation specifies that all the handler methods in this controller 
 * will be mapped to URLs that start with '/api/order'. It defines the base URI for the order-related operations.
 */
@RequestMapping("/api/order")

/**
 * The @RequiredArgsConstructor annotation from Lombok automatically generates a constructor with 
 * required arguments. Required arguments are final fields and fields with constraints such as @NonNull.
 */
@RequiredArgsConstructor
public class OrderController {

    // Injection of the OrderService using constructor-based dependency injection.
    private final OrderService orderService;

    /**
     * The @PostMapping annotation indicates that this method will handle HTTP POST requests.
     * This method is used to place a new order.
     *
     * @ResponseStatus(HttpStatus.CREATED) sets the HTTP status code to '201 Created' when the method completes successfully.
     *
     * @CircuitBreaker(name="inventory", fallbackMethod = "fallbackMethod") enables circuit breaker pattern.
     * It will redirect calls to 'fallbackMethod' if calls to 'inventory' service are failing.
     *
     * @TimeLimiter(name="inventory") enforces a time limit on the method execution. If the time limit is exceeded,
     * the method is considered as failed (relevant in asynchronous systems).
     *
     * @Retry(name = "inventory") indicates that if a call fails, it should be retried as configured under the 'inventory' settings.
     *
     * @param orderRequest is the body of the request, containing order details.
     * @return a CompletableFuture which, when completed, will contain the result of the order placement.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name="inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name="inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        return CompletableFuture.supplyAsync(()->orderService.placeOrder(orderRequest));
    }

    /**
     * The fallback method for the circuit breaker.
     * It's invoked when calls to the 'inventory' service fail and the circuit breaker is opened.
     *
     * @param runtimeException the exception that caused the fallback to be triggered.
     * @return a CompletableFuture with a default message indicating an error.
     */
    public CompletableFuture<String> fallbackMethod(RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()-> "Oops! Something went wrong, please try again later!");
    }
}
