package com.masglobal.employees.repository;

import com.masglobal.employees.apis.ApiAdapter;
import com.masglobal.employees.vo.EmployeeDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeesRepository  {


    public ArrayList<EmployeeDTO> getEmployees () {
        Call<ArrayList<EmployeeDTO>> call = ApiAdapter.getApiService().getEmployees();
        try {
           Response<ArrayList<EmployeeDTO>> response = call.execute();
            return response.body();
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public EmployeeDTO findById (int id) {
        Call<ArrayList<EmployeeDTO>> call = ApiAdapter.getApiService().getEmployees();
        try {
            Response<ArrayList<EmployeeDTO>> response = call.execute();
            List<EmployeeDTO> list = response.body().stream().filter(e -> e.getId()==(id)).collect(Collectors.toList());
            return !list.isEmpty() ? list.get(0) : null;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


}
