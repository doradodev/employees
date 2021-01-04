package com.masglobal.employees.apis;


import retrofit2.Call;
import retrofit2.http.GET;
import com.masglobal.employees.vo.EmployeeDTO;

import java.util.ArrayList;

public interface ApiService {

    @GET("employees")
    Call<ArrayList<EmployeeDTO>> getEmployees();

}
