package com.labthree.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.labthree.lab3.services.EmployeeService;

@Controller
public class MainController {


    EmployeeService employeeService;


    //Dependecy Injection
    //
    //@Autowired
    public MainController(EmployeeService employeeService){
        super();
        this.employeeService = employeeService;

        /*Add some employee to employee list


         * Choose any employee and department names
         * add some template pages to match the department you choose
        */


        employeeService.addEmployee("olivia", "orders");
        employeeService.addEmployee("ollie", "orders");
        employeeService.addEmployee("rachel", "repairs");
        employeeService.addEmployee("ralph", "repairs");
        employeeService.addEmployee("sam", "sales");
        employeeService.addEmployee("sue", "sales");
    }


    @GetMapping("/check")
    public String getOrders(@RequestParam String userId, Model model) {
        model.addAttribute("userId", userId);
        // if ("olivia".equals(userId) || "ollie".equals(userId)) {
        //     return "orders";
        // }

        // else if ("rachel".equals(userId) || "ralph".equals(userId)) {
        //     return "repairs";
        // }

        // else if ("sam".equals(userId) || "sue".equals(userId)) {
        //     return "sales";
        // }

        // else {
        //     return "empty";
        // }

        String department = employeeService.findDepartment(userId);
        if(department == null)
        model.addAttribute("department", "empty");
        else
        model.addAttribute("department", department);
        if (department == null){
            return "empty";
        }
        else return "/" + department;

    }

    

}
