package com.masglobal.employees.resources;


import com.google.gson.Gson;
import com.masglobal.employees.service.services.EmployeesService;
import com.masglobal.employees.vo.EmployeeDTO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class which represents employee's web service
 * **/

@RestController
@RequestMapping("/api/employee")
@Api(tags = "employee")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class EmployeeResource {

    private final EmployeesService employeesService;

    @Autowired
    public EmployeeResource(EmployeesService employeesService){
        this.employeesService = employeesService;
    }

    @ApiOperation(
            value = "Return Employee List",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return Employee List"),})
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<EmployeeDTO>>findAll() {

        return new ResponseEntity<>(employeesService.getEmployees(), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return one employee"),})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findById(@ApiParam(value = "ID of person to return", required = true) @PathVariable("id") String id) {
        EmployeeDTO employee = null;
        if (isValidInteger(id)) {
            employee = employeesService.findById(Integer.parseInt(id));
            if (employee != null) {
                return new ResponseEntity<>(employee, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new EmployeeDTO(), HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(new EmployeeDTO(), HttpStatus.BAD_REQUEST);
    }

    boolean isValidInteger(String integerValue) {
        try {
            Integer.parseInt(integerValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
