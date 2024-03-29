package ru.nshi.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TestPrototypeService implements BeanNameAware {

    private String prototypeValue;
    private MessageService messageService;
    private String beanName;

    public TestPrototypeService() {
        System.out.println("Constructor called");
        messageService = null;
    }

    public TestPrototypeService(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    public String getPrototypeValue() {
        return prototypeValue;
    }

    public void setPrototypeValue(String prototypeValue) {
        this.prototypeValue = prototypeValue;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name + " is bean's name");
        beanName = name;
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Destroying bean " + beanName);
    }
}
