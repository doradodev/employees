import React, { useEffect, useRef, useState } from "react";
import { FormControl, InputLabel, OutlinedInput } from "@material-ui/core";
import EmployeesTable from "./EmployeesTable";
import { fetchDataAxios } from "../utils/fetchRequest";
import { ROOT_API_URL } from "../utils/constants";
import Button from "@material-ui/core/Button";

const Home = (props) => {
  const [search, setSearch] = useState("");
  const [employees, setEmployees] = useState([]);
  const inputSearch = useRef(null);

  useEffect(() => {
    const getEmployees = async () => {
      try {
        const response = fetchDataAxios(ROOT_API_URL, {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        const responseData = await response;
        setEmployees(responseData);
      } catch (error) {
        console.log(error);
      }
    };
    getEmployees();
  }, []);

  const handleSearch = (event) => {
    console.log(event.target.value);
    setSearch(event.target.value);
  };

  const handleClick = () => {
    const getEmployees = async (param) => {
      try {
        const response = fetchDataAxios(
          param ? ROOT_API_URL + param : ROOT_API_URL,
          {
            method: "GET",
            headers: {
              "Content-Type": "application/json",
            },
          }
        );
        const responseData = await response;
        if (param) {
          const data = [];
          data.push(responseData);
          setEmployees(data);
        } else {
          setEmployees(responseData);
        }
      } catch (error) {
        console.log(error);
      }
    };
    if (search) {
      getEmployees(search);
    } else {
      getEmployees();
    }
  };

  return (
    <section className="home-container">
      <div className="home-search">
        <FormControl variant="outlined">
          <InputLabel htmlFor="component-outlined">Search</InputLabel>
          <OutlinedInput
            id="component-outlined"
            ref={inputSearch}
            value={search}
            onChange={handleSearch}
            label="Search"
          />
        </FormControl>
        <Button variant="outlined" color="primary" onClick={handleClick}>
          Get Employees
        </Button>
      </div>
      <div className="home-table">
        <EmployeesTable rows={employees} />
      </div>
    </section>
  );
};

export default Home;
