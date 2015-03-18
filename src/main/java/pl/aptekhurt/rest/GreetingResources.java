package pl.aptekhurt.rest;

import java.util.concurrent.atomic.AtomicLong;
import javax.enterprise.inject.Produces;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.aptekhurt.entity.Greeting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@RestController
public class GreetingResources {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    	@GET
	@Path("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}