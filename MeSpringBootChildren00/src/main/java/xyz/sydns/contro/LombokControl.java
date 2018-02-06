package xyz.sydns.contro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sydns.entity.Lombok;

/**
 * Created by sqsgalaxys (AT) gmail (DOT) com
 * on 30/01/2018.
 *
 * @author sqsgalaxys
 */
@RestController
public class LombokControl {

    @RequestMapping("/lombok")
    public Lombok returnLombok() {
        Lombok lombok = new Lombok();
        lombok.setTest0(0);
        lombok.setTest1("1");
        lombok.setTest2("2");
        return lombok;
    }
}
