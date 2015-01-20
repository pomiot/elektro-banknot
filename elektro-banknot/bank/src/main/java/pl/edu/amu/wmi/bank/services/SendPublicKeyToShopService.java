package pl.edu.amu.wmi.bank.services;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.security.PublicKey;

/**
 * Created by Tomasz on 2015-01-20.
 */
public class SendPublicKeyToShopService {

    JmsTemplate jmsTemplate;

    Destination bankPublicKeyQueueForCustomer;
    Destination bankPublicKeyQueueForShop;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setBankPublicKeyQueueForCustomer(Destination bankPublicKeyQueueForCustomer) {
        this.bankPublicKeyQueueForCustomer = bankPublicKeyQueueForCustomer;
    }

    public void setBankPublicKeyQueueForShop(Destination bankPublicKeyQueueForShop) {
        this.bankPublicKeyQueueForShop = bankPublicKeyQueueForShop;
    }

    public void sendPublicKey(final PublicKey key){

        jmsTemplate.send(bankPublicKeyQueueForShop, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                ObjectMessage message = session.createObjectMessage();
                message.setObject(key);

                System.out.println("Bank: wysyłam swój publiczny klucz do sklepu");

                return message;
            }
        });

        jmsTemplate.send(bankPublicKeyQueueForCustomer, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                ObjectMessage message = session.createObjectMessage();
                message.setObject(key);

                System.out.println("Bank: wysyłam swój publiczny klucz do klienta");

                return message;
            }
        });
    }
}