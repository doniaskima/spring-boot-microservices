package com.programmingtechie.orderservice.client;

import com.programmingtechie.orderservice.dto.InventoryResponse;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The @FeignClient annotation is used to declare a REST client in a Spring Cloud application.
 * This specific instance creates a client for the "inventory-service".
 * When you use this client in your application, Spring will automatically handle 
 * the creation of HTTP requests to the service and map the responses back to your client.
 * 
 * 'name' attribute specifies the name of the service with which this client will communicate.
 * In a microservices environment, this typically corresponds to the name of the service 
 * as registered in a service discovery like Eureka or Consul.
 * 
 * It enables Spring to use Ribbon for client-side load balancing and to use Hystrix for 
 * circuit breaking, if these are included in the project.
 */
@FeignClient(name = "inventory-service")
@Retry(name = "inventory")
public interface InventoryClient {
    @GetMapping("/api/inventory")
    List<InventoryResponse> checkStock(@RequestParam List<String> skuCode);
}
