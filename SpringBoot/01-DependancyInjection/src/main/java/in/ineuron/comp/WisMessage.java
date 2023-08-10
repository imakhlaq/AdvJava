package in.ineuron.comp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WisMessage {

    /*

    @Autowired
    private LocalDateTime time;
    */

    private final LocalDateTime time;

    //constructor injection of LocalDateTime Bean
    @Autowired
    WisMessage(LocalDateTime timme) {
        this.time = timme;
    }


    public void printDate() {
        System.out.println(time);
    }

}
