/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.controller;

import com.base.DAO.studentDAO;
import com.base.models.Students;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ohjelmistokehitys
 */
@Controller
public class StudentController {
    
    @RequestMapping(value="/admin/student", method=RequestMethod.GET)
    public String RenderStudent(ModelMap map){
        map.addAttribute("isLogged", true);
        map.addAttribute("student", new Students());
        try {
           map.addAttribute("student", studentDAO.getStudents());
       } catch (Exception e) {
           e.printStackTrace();
       }
        return "student";
    }
    
    @RequestMapping(value="/admin/student", method=RequestMethod.POST)
    public String addNewStudent(@ModelAttribute("student") Students student, ModelMap map){
        map.addAttribute("isLogged", true);
        try {
            studentDAO.addStudent(student);
            map.addAttribute("students", studentDAO.getStudents());
        } catch (Exception e) {
            //map.addAttribute("save_info", "Database error");
            e.printStackTrace();
        }
        //System.out.println(student.getSName());
        return "redirect:/admin/student";
    }
    
}
