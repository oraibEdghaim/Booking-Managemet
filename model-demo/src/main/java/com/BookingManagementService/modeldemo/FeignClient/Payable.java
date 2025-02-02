package com.BookingManagementService.modeldemo.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="Payment-System")
        //(name = "PaymentFeignClient",url = "http://localhost:9090/Payment")
public interface Payable {

    @PostMapping("/Payment/pay")
    public String pay(@RequestParam String serviceName, @RequestParam double price, @RequestParam String currency);

}
