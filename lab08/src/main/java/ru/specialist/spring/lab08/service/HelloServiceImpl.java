package ru.specialist.spring.lab08.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String getHello() {
        int h = LocalTime.now().getHour();

        if (h >= 0 && h < 6) return "Доброй ночи";
        if (h >= 6 && h < 12) return "Доброе утро";
        if (h >= 12 && h < 18) return "Добрый день";
        return "Добрый вечер";
    }
}
