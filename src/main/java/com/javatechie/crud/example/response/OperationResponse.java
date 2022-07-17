package com.javatechie.crud.example.response;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data //for getters and setters
public class OperationResponse {
  private ResponseStatusEnum  operationStatus;
  private String  operationMessage;
  private List<String> errorMessages = new ArrayList<>();
}
