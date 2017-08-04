package hello;

import java.util.concurrent.atomic.AtomicLong;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! You Are %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/test")
    public Greeting test(@RequestParam(value="name", defaultValue="World") String name ,@RequestParam(value="age", defaultValue="10") String age  ) {
        System.out.println(  "被调用方法test入参name："+name +"  age:"+age);
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name,age));
    }
}