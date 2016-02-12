/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Teachers;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This class is for making CRUD operations to teacher table
 * @author Ohjelmistokehitys
 */
public class teacherDAO {
    
    /**
     * Adds new teacher into database
     * @param teach
     */
    public static void addTeacher(Teachers teach) throws Exception{
        //create session to database
        Session session = HibernateUtil.getSessionFactory().openSession();
        //transaction in order to write to database
        Transaction transaction = session.beginTransaction();
        //add teacher to database
        session.save(teach);
        //end transaction
        transaction.commit();
        //release session
        session.close();
    }
    
    public static List<Teachers> getTeachers() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createQuery("from Teachers");
        List<Teachers> lst = query.list();
        
        session.close();
        
        return lst;
    }
}
