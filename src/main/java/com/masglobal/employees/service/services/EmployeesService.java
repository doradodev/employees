package com.masglobal.employees.service.services;


import com.masglobal.employees.repository.EmployeesRepository;
import com.masglobal.employees.service.contract.AbstractContract;
import com.masglobal.employees.vo.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *<h1>EmployeesService</h1>
 * <p>This class contains the logic to put a contract to each employee</p>
 * @author cristiandaviddorado
 * */

@Service
public class EmployeesService {
    private AbstractContract contract;
    private EmployeesRepository employeesRepository;

    @Autowired
    EmployeesService(AbstractContract contract, EmployeesRepository employeesRepository){
        this.contract = contract;
        this.employeesRepository = employeesRepository;
    }

    /**
     *  it retrieves all employees and then get the specific contract
     *  Big-O O(n) time, take n steps to calculate and assign the Contract Salary
     *  calculator to each EmployeeDTO
     *
     * @return list
     */

    public List<EmployeeDTO> getEmployees() {
        ArrayList<EmployeeDTO> list = employeesRepository.getEmployees();
        list.stream().forEach(el -> el.setContract(contract.createContract(el)));
        return list;
    }

    public EmployeeDTO findById(int id) {
        ArrayList<EmployeeDTO> EmployeesList = employeesRepository.getEmployees();
        List<EmployeeDTO> list = EmployeesList.stream().filter(e -> e.getId()==(id)).collect(Collectors.toList());
        if(!list.isEmpty()){
            list.get(0).setContract(contract.createContract(list.get(0)));
        }
        return !list.isEmpty() ? list.get(0) : null;
    }
}
