package com.example.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@Tag(name = "BankPro API", description = "Core Banking Microservice Endpoints")
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @GetMapping("/")
    @Operation(summary = "Health Check", description = "Verify if the service is online")
    public String hello() {
        return "BankPro Inventory Management System is Online!";
    }

    @GetMapping("/accounts")
    @Operation(summary = "Get Accounts", description = "Retrieve all banking accounts")
    public List<String> getAccounts() {
        return Arrays.asList("Checking - 1234", "Savings - 5678", "Investment - 9012");
    }

    @GetMapping("/customers")
    @Operation(summary = "Get Customers", description = "Retrieve list of BankPro customers")
    public List<String> getCustomers() {
        return Arrays.asList("John Doe", "Jane Smith", "Dipesh Patel");
    }
}
