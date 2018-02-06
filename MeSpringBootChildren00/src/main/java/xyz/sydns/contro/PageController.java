package xyz.sydns.contro;

import org.jscience.physics.amount.Amount;
import org.jscience.physics.model.RelativisticModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.measure.quantity.Mass;
import java.util.Map;

import static javax.measure.unit.SI.KILOGRAM;

/**
 * Created by sqsgalaxys (AT) gmail (DOT) com
 * on 30/01/2018.
 *
 * @author sqsgalaxys
 */

@Controller
public class PageController {


    /**
     * 此处注意的一点是，
     * 一定要使用@Controller这个注解才可以跳转到对应的模板中，
     * 如果使用上一篇中的@RestController，页面只返回index这个字符串，
     * 这个注解等同于使用@ResponseBody，大家在使用时一定要注意。
     * https://my.oschina.net/wangxincj/blog/807909
     * <p>
     * <pre> @RestController  @Controller </pre>
     *
     * @param model todo
     * @return science page
     */
    @RequestMapping("/science")
    String science(Map<String, Object> model) {
        RelativisticModel.select();
        Amount<Mass> m = Amount.valueOf("12 GeV").to(KILOGRAM);
        model.put("science", "E=mc^2: 12 GeV = " + m.toString());
        return "science";
    }

}
