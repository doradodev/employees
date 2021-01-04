package com.masglobal.employees.service.contract;

import com.masglobal.employees.service.impl.HourlyContract;
import com.masglobal.employees.service.impl.MonthlyContract;
import com.masglobal.employees.service.interfaces.Contract;
import com.masglobal.employees.vo.EmployeeDTO;
import org.springframework.stereotype.Component;

/**
 * <h1>FactoryContract</h1>
 *
 * <p>FactoryContract allows create a contract extends AbstractContract</p>
 *
 * @author cristiandaviddorado
 * */
@Component
public class FactoryContract extends AbstractContract{

    @Override
    public Contract createContract(EmployeeDTO employeeDTO) {
        if(employeeDTO.getContractTypeName().equals("HourlySalaryEmployee")){
            return HourlyContract.builder().hourlySalary(employeeDTO.getHourlySalary()).build();
        }else{
            return MonthlyContract.builder().monthlySalary(employeeDTO.getMonthlySalary()).build();
        }
    }
}
