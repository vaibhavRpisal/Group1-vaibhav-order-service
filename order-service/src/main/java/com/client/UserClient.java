package com.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Dto.UserDto;


@FeignClient(name = "user-service", url = "http://localhost:9023/api/")
public interface UserClient {
	
	 @GetMapping(value = "/users/{id}")
	    public UserDto getUserById(@PathVariable Long id);


}