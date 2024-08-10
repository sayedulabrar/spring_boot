package com.dragon.toky.controller;

import com.dragon.toky.dto.EmployeeDto;
import com.dragon.toky.entity.Employee;
import com.dragon.toky.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Build Add Employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmploy(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee
    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDto> getEmployById(@PathVariable("id") Long employeeId){
        EmployeeDto searchedEmployee= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(searchedEmployee);
    }

    //Build Get All Employee
    public  ResponseEntity <List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> allSearchedEmployee= employeeService.getAllEmployee();
        return ResponseEntity.ok(allSearchedEmployee);
    }


    //Build Add Employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmploy(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployee= employeeService.updateEmployee(employeeId,employeeDto);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmploy(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee has been successfully deleted");
    }

}
