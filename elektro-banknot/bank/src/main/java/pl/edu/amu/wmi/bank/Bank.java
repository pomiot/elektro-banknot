/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.amu.wmi.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Patryk
 **/
public class Bank {
public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Context.xml");
        
    }
}