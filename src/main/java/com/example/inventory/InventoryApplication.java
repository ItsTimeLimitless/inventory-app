package com.example.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@OpenAPIDefinition(
    info = @Info(
        title = "BankPro Core Banking API",
        version = "2.0.1",
        description = "Official REST API for BankPro Financial Services. This API handles core banking operations including account management, customer data, and transaction processing.",
        contact = @Contact(
            name = "BankPro DevOps Team",
            url = "https://bankpro.com/support",
            email = "devops@bankpro.com"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html"
        )
    )
)
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Tag(name = "System Health", description = "Monitoring and status endpoints")
    @GetMapping("/")
    @Operation(summary = "Service Status", description = "Returns the current operational status of the BankPro microservice.")
    public String hello() {
        return "BankPro Core Banking System is OPERATIONAL";
    }

    @Tag(name = "Account Controller", description = "Endpoints for managing bank accounts and balances")
    @GetMapping("/accounts")
    @Operation(summary = "List All Accounts", description = "Retrieves a comprehensive list of all active accounts in the system.")
    public List<String> getAccounts() {
        return Arrays.asList("Checking - 1234", "Savings - 5678", "Investment - 9012");
    }

    @Tag(name = "Customer Controller", description = "Endpoints for managing customer profiles")
    @GetMapping("/customers")
    @Operation(summary = "List All Customers", description = "Retrieves the official registry of BankPro customers.")
    public List<String> getCustomers() {
        return Arrays.asList("John Doe", "Jane Smith", "Dipesh Patel");
    }
}
