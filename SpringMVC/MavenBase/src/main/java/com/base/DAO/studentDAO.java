/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.DAO;

import com.base.models.Students;
import com.base.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ohjelmistokehitys
 */
public class studentDAO {
    
        public static void addStudent(Students students) throws Exception{
        //create session to database
        Session session = HibernateUtil.getSessionFactory().openSession();
        //transaction in order to write to database
        Transaction transaction = session.beginTransaction();
        //add teacher to database
        session.save(students);
        //end transaction
        transaction.commit();
        //release session
        session.close();
    }
    
        public static List<Students> getStudents() throws Exception{
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Query query = session.createQuery("from Students");
        List<Students> lst = query.list();
        
        session.close();
        
        return lst;
    }
    
}
