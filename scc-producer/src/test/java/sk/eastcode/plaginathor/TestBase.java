package sk.eastcode.plaginathor;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class TestBase {
    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(new Application());
    }
}
