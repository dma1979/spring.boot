package by.dma.controller;

import by.dma.entity.Book;
import by.dma.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : Dzmitry Marudau
 * @created at : 00:25
 * @since : 2020.05
 **/
@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BookService bookService;

  @org.junit.Test
  public void shouldReturnListOfBooks() throws Exception {
    when(bookService.findAll()).thenReturn(Arrays.asList(
            new Book("123", "Spring 5 Recipes", "Marten Deinum", "Josh Long"),
            new Book("321", "Pro Spring MVC", "Marten Deinum", "Colin Yates")));
    mockMvc.perform(get("/books"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$", hasSize(2)))
           .andExpect(jsonPath("$[*].isbn", containsInAnyOrder("123", "321")))
           .andExpect(jsonPath("$[*].title",
                               containsInAnyOrder("Spring 5 Recipes", "Pro Spring MVC")));
  }

  @org.junit.Test
  public void shouldReturn404WhenBookNotFound() throws Exception {
    when(bookService.find(anyString())).thenReturn(Optional.empty());
    mockMvc.perform(get("/books/123")).andExpect(status().isNotFound());
  }

  @Test
  public void shouldReturnBookWhenFound() throws Exception {
    when(bookService.find(anyString()))
            .thenReturn(
                    Optional.of(new Book("123", "Spring 5 Recipes",
                                         "Marten Deinum", "Josh Long")));
    mockMvc.perform(get("/books/123"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.isbn", equalTo("123")))
           .andExpect(jsonPath("$.title", equalTo("Spring 5 Recipes")));
  }
}













