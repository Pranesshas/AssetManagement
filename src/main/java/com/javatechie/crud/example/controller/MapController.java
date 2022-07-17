package com.javatechie.crud.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.model.MapDTO;
import com.javatechie.crud.example.response.OperationResponse;
import com.javatechie.crud.example.response.ResponseStatusEnum;
import com.javatechie.crud.example.service.MapService;
import com.javatechie.crud.example.service.UserService;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
public class MapController {

    @Autowired
    MapService mapService;
    
    @PostMapping("/mapUser")
    public OperationResponse mapUser(@RequestBody MapDTO mapDTO) {
        boolean userMapSuccess= mapService.saveMap(mapDTO);
        OperationResponse resp=new OperationResponse();
        if (userMapSuccess == true) {
			resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
			resp.setOperationMessage("User Added");
		} else {
			resp.setOperationStatus(ResponseStatusEnum.ERROR);
			resp.setOperationMessage("Unable to add user");
		}
		return resp;

}

@PostMapping("/unassignUser")
public OperationResponse unAssignUser(@RequestBody MapDTO mapDTO){

    boolean userUnassignSuccess= mapService.unassignUserMap(mapDTO);
    OperationResponse resp=new OperationResponse();
    if (userUnassignSuccess == true) {
        resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
        resp.setOperationMessage("User Added");
    } else {
        resp.setOperationStatus(ResponseStatusEnum.ERROR);
        resp.setOperationMessage("Unable to add user");
    }
    return resp;
}

}