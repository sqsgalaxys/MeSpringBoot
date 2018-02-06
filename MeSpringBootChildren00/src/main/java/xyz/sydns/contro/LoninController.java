package xyz.sydns.contro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by sqsgalaxys (AT) gmail (DOT) com
 * on 01/02/2018.
 *
 * @author sqsgalaxys
 */
@RestController
public class LoninController {
    @RequestMapping("/work")
    public String work() {
        return ("上班时间 : " + new Date());
    }

    @RequestMapping("/exit_work")
    public String exitWork() {
        return (new Date()).toString();
    }
}
