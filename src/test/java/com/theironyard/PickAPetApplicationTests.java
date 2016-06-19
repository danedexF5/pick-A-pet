package com.theironyard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PickAPetApplication.class)
@WebAppConfiguration
public class PickAPetApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	WebApplicationContext wap;

	@Autowired
			TraitsRepo traitsRepo;

	MockMvc mockMvc;

	@Before
	public void before() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}

	@Test
	public void testCorrectSize() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.post("/")
						.param("q1", "1")
						.param("q2", "1")
						.param("q3", "1")
						.param("q4", "1")
						.param("q5", "1")
						.param("q6", "1")
						.param("q7", "1")
						.param("q8", "1")
						.param("q9", "1")
		).andExpect(status().isOk())
				.andExpect(content().string(containsString("Chihuahua")));
	}

	@Test
	public void testChildren() throws Exception{
		Traitsscore t = traitsRepo.findByRow(6, 1, 1);
		Assert.assertTrue(t.score == 5);
		t = traitsRepo.findByRow(6, 1, 2);
		Assert.assertTrue(t.score == 2);

	}

}
