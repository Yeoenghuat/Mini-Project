package com.govtech.miniproject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MiniprojectApplicationTests {

    /**
     * Retrieve amount of users that falls within the salary range
     *
     * @throws Exception
     */
    @Test
    public void Success_CountNoofUsersWithinSalaryRange_Test() throws Exception {
        RestAssured
                .given()
                .when()
                    .get("users")
                .then()
                    .contentType(ContentType.JSON)
                    .statusCode(HttpStatus.OK.value())
                    .body("results.size()", is(5));
    }

    /**
     * Check retrieved list does not contains user outside of salary range
     */
    @Test
    public void Fail_UserOutsideofSalaryRange_Test() throws Exception {
        RestAssured
                .given()
                .when()
                    .get("users")
                .then()
                    .contentType(ContentType.JSON)
                    .statusCode(HttpStatus.OK.value())
                    .body("results.name",  not(hasItem("Jane")));
    }

    /**
     * Check retrieved list contains user within the salary range
     */
    @Test
    public void Success_UserWithinSalaryRange_Test() throws Exception {
        RestAssured
                .given()
                .when()
                    .get("users")
                .then()
                    .contentType(ContentType.JSON)
                    .statusCode(HttpStatus.OK.value())
                    .body("results.name",  hasItem("Tom"));
    }

}

