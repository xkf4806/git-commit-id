package com.example.spring.gitcommitid;

import com.example.spring.gitcommitid.domain.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * @author xinj.x
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class LiveTest {
  private static final String API_ROOT = "http://localhost:8081/api/books";

  private Book createRandomBook() {
    Book book = new Book();
    book.setTitle(randomAlphabetic(10));
    book.setAuthor(randomAlphabetic(15));
    return book;
  }
  private String createBookAsUri(Book book) {
    Response response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(book)
            .post(API_ROOT);
    return API_ROOT + "/" + response.jsonPath().get("id");
  }
}
