package com.mercadolibre.be_java_hisp_w23_g2.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void getFollowersCountSeller() {
  }

  @Test
  void getFollowersUser() {
  }

}
