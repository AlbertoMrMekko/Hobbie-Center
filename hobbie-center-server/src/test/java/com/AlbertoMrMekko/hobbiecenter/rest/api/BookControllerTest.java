package com.AlbertoMrMekko.hobbiecenter.rest.api;

import com.AlbertoMrMekko.hobbiecenter.service.BookService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
public class BookControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService service;
}
