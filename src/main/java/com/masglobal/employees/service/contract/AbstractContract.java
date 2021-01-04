package com.masglobal.employees.service.contract;

import com.masglobal.employees.service.interfaces.Contract;
import com.masglobal.employees.vo.EmployeeDTO;

/**
 * <h1>AbstractContract</h1>
 *
 * <p>AbstractContract is an abstract class which handle the contract creation to every employee</p>
 * @author cristiandaviddorado
 * */

public abstract class AbstractContract {

    public abstract Contract createContract(EmployeeDTO employeeDTO);
}
