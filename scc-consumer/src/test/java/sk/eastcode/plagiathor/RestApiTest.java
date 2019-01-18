package sk.eastcode.plagiathor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sk.eastcode.Request;
import sk.eastcode.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"sk.eastcode:scc-producer:+:stubs:6565"}, workOffline = true)
public class RestApiTest {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;


    @Test
    public void test() {
        Request request = new Request();
        request.setText("bacardi, martel, hennessy, tri slávne dynastie");

        ResponseEntity<Response> response =
                restTemplateBuilder.build().exchange("http://localhost:6565/check", HttpMethod.POST,
                        new HttpEntity(request, null),
                        Response.class);

        int expectedMatch = 100;
        int match = response.getBody().getMatch();
        Assert.assertEquals(expectedMatch, match);
    }
}
