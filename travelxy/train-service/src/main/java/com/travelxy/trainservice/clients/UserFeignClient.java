package com.travelxy.trainservice.clients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.travelxy.trainservice.models.User;


@FeignClient("zuul-gateway")
public interface UserFeignClient {
	@GetMapping("user-service/users/username/{username}")
	public User getUserByUsername(@PathVariable(name = "username") String username);
	
}
