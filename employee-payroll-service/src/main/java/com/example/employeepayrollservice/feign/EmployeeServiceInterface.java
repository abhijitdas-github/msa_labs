package com.example.employeepayrollservice.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.employeepayrollservice.JsonEntity;

//@FeignClient(name="employee-service", url="http://localhost:8001")
//Direct communication so using port number in the url

//Feign with ribbon - communicate via load balancer. Ribbon(Load balancer)
//@FeignClient(name="employee-service")
//@RibbonClient(name="employee-service")

////Zool edge server controls the load balancing by picking available instances from Eureka
//@FeignClient(name="zuul-edge-server")

@FeignClient(name="zuul-edge-server")
public interface EmployeeServiceInterface {

	@RequestMapping(value="/EmployeeService/employee/{empId}", method=RequestMethod.GET)
	public JsonEntity getEmployeeDetail(@PathVariable Long empId);
		
}
