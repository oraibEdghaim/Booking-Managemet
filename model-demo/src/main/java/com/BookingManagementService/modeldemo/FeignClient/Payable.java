package com.BookingManagementService.modeldemo.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PaymentFeignClient",url = "http://PAYMENT-SYSTEM/Payment")
public interface Payable {

    @PostMapping("/pay")
    public String pay(@RequestParam String serviceName, @RequestParam double price, @RequestParam String currency);

}
