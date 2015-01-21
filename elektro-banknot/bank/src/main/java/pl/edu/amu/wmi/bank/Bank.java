/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.amu.wmi.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.edu.amu.wmi.bank.billing.Accounts;
import pl.edu.amu.wmi.bank.services.SendPublicKeyService;

/**
 * @author Patryk
 */
public class Bank {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("Context.xml");

        SendPublicKeyService keySender = (SendPublicKeyService) context.getBean("sendPublicKeyToShopService");

        keySender.sendPublicKey();

        Accounts accounts = (Accounts) context.getBean("accounts");

        System.out.println(accounts);

    }
}