package ru.itvitality.sbrf.cu.sfc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;

@Service
public class PrintHello {

    public MessageSource messageSource;

    @Value("${hello.user}")
    public String username;
    @Value("${default.agen}")
    public String testText;
    @Value("${hello.user.EN}")
    public String hello;

    public void printHelloQA(){
        System.out.println(messageSource.getMessage("hello.user", new String[] {"Ivan777"}, Locale.ENGLISH));
    }

    public void printOneWord(){
        System.out.println(testText);
    }

    //https://stackoverflow.com/questions/15605107/how-can-i-use-parameters-in-a-messages-properties-file
    public void printHello(){
        Properties p = new Properties();
        p.setProperty("messages.myMessage", hello);
        String s = MessageFormat.format(
                p.getProperty("messages.myMessage"), new String[] {"Ivan777"}, Locale.ENGLISH);
        System.out.println(s);
    }


}