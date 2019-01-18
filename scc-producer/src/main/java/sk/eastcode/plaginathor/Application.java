package sk.eastcode.plaginathor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @PostMapping("/check")
    public Response check(@RequestBody Request request) {
        Response response = new Response();
        response.setMatch(0);
        if (request.getText().equals("bacardi, martel, hennessy, tri slávne dynastie")) {
            response.setMatch(100);
        }
        return response;
    }


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}