package in.ineuron;

import in.ineuron.comp.WisMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        //container creation
        ApplicationContext context = SpringApplication.run(Application.class, args);

        //getting a bean
        WisMessage wis = context.getBean(WisMessage.class);
        wis.printDate();
    }


    //Creating Bean of predefined classes
    @Bean
    public LocalDateTime injectTime() {
        return LocalDateTime.now();
    }


}
