/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.controller;

import com.base.DAO.studentDAO;
import com.base.models.Students;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Ohjelmistokehitys
 */
@Controller
public class StudentController {
    
    @RequestMapping(value="/admin/student", method=RequestMethod.GET)
    public String RenderStudent(ModelMap map){
        map.addAttribute("isLogged", true);
        map.addAttribute("students", new Students());
        try {
           map.addAttribute("students", studentDAO.getStudents());
       } catch (Exception e) {
           e.printStackTrace();
       }
        return "student";
    }
    
    @RequestMapping(value="/admin/addstudent", method=RequestMethod.POST)
    public String addNewStudent(@ModelAttribute("students") Students students, ModelMap map){
        map.addAttribute("isLogged", true);
        try {
            studentDAO.addStudent(students);
            map.addAttribute("save_info", "student added");
        } catch (Exception e) {
            map.addAttribute("save_info", "Database error");
            e.printStackTrace();
        }
        System.out.println(students.getSName());
        return "student";
    }
    
}
