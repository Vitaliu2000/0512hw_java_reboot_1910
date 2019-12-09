package ru.itvitality.sbrf.cu.sfc;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import ru.itvitality.sbrf.cu.sfc.domain.Person;
import ru.itvitality.sbrf.cu.sfc.service.PersonService;
import ru.itvitality.sbrf.cu.sfc.service.PrintHello;

@PropertySource("classpath:application.properties")//Путь к файлу c проперти
@Configuration
@ComponentScan
@Service
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        PersonService service = context.getBean(PersonService.class);
        PrintHello service2 = context.getBean(PrintHello.class);

        Person ivan = service.getByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());

        service2.printOneWord();
        service2.printHello();
    }

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms =
                new ReloadableResourceBundleMessageSource();
        ms.setBasename("application.properties");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
