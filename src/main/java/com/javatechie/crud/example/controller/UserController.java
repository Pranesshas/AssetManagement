package com.javatechie.crud.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.response.DashboardData;
import com.javatechie.crud.example.response.Metric;
import com.javatechie.crud.example.response.OperationResponse;
import com.javatechie.crud.example.response.ResponseStatusEnum;
import com.javatechie.crud.example.service.UserService;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public OperationResponse addUser(@RequestBody User user) {
        
        boolean userAddSuccess= userService.saveUser(user);
        OperationResponse resp = new OperationResponse();
		if (userAddSuccess == true) {
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("User Added");
		} else {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to add user");
		}
		return resp;
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/project")
    public List<String> getProjects(){
        return userService.getProjects();
    }
    
    @GetMapping(value = "/{project}")   
public List<User> getProjectNames(@PathVariable("project") String project){
    return userService.getProjectNames(project);
}

@GetMapping("/dashboard")
    public List<DashboardData> getDashboardData(){
        return userService.getDashboardData(0);
    }

    @GetMapping("/dashboard/metrics")
    public Metric getDashboardMetric(){
        return userService.getDashboardMetric();
    }

    
}
