package ru.specialist.spring.lab08.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.specialist.spring.lab08.service.HelloService;

import java.util.Locale;

@Component("userVM")
public class UserVM {
    @Autowired
    private HelloService helloService;

    private String userName;

    @Value("#{messageSource}")
    private MessageSource messageSource;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getHello() {
        return (getUserName() == null || getUserName().isEmpty())
                ? helloService.getHello() + "!"
                : String.format("%s, %s!", helloService.getHello(), getUserName());
    }

//    public String getHello() {
//        String hello = getMessageSource().getMessage("header_hello", null, Locale.getDefault());
//
//        return (getUserName() == null || getUserName().isEmpty() ? hello :
//                getMessageSource().getMessage("header_hello_username",
//                        new Object[]{getUserName()}, Locale.getDefault()));
//
//    }
}
