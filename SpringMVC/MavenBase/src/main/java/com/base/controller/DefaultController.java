
package com.base.controller;

import com.base.DAO.teacherDAO;
import com.base.models.Teachers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(ModelMap map){
        
        return "index";
    }
   @RequestMapping(value="/second", method=RequestMethod.GET)
    public String second(ModelMap map){
        
        map.addAttribute("teacher", new Teachers());
        try {
           map.addAttribute("teachers", teacherDAO.getTeachers());
       } catch (Exception e) {
           e.printStackTrace();
       }
        
//        Teachers s = new Teachers();
//        s.setTName("Jimmy Gambina");
//        s.setTSubject("Programming");
//        s.setEmail("jg@jg.com");
//        s.setPhone("2345234");
//        try {
//           teacherDAO.addTeacher(s);
//       } catch (Exception e) {
//       }
        
        return "second";
    }
    @RequestMapping(value="/teacher", method=RequestMethod.POST)
    public String addNewTeacher(@ModelAttribute("teacher") Teachers teach, ModelMap map){
        try {
            teacherDAO.addTeacher(teach);
            map.addAttribute("save_info", "teacher added");
        } catch (Exception e) {
            map.addAttribute("save_info", "Database error");
            e.printStackTrace();
        }
        System.out.println(teach.getTName());
        return "second";
    }
}
