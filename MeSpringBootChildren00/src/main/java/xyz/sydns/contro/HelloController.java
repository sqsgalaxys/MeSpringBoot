package xyz.sydns.contro;

import xyz.sydns.entity.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sydns.entity.Demo;

/**
 * 最简单的控制类
 *
 * @author Lidy sqsgalaxys
 */
@RestController
public class HelloController {

    /**
     * Spring Boto默认使用的的json解析框架是jackson
     * 自动将对象解析成json数据
     *
     * @return json demo
     */
    @RequestMapping("/test")
    public Demo getDemo() {
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("test");
        return demo;
    }


    /**
     * <pre> @RestController </pre>
     * 返回 字符串
     * Content-Type: text/html;charset=ISO-8859-1
     * Content-Language: en
     *
     * @return string
     */
    @RequestMapping("/string")
    public String getDemoExx() {
        return "string";
    }


}