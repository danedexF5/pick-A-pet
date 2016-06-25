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
						.param("attention", "1")
						.param("energy", "1")
						.param("exercise", "1")
						.param("size", "1")
						.param("space", "1")
						.param("outdoor", "1")
						.param("sheds", "1")
						.param("kids", "1")
						.param("friendliness", "1")
		).andExpect(status().isOk())
				.andExpect(content().string(containsString("Chihuahua")));
	}

	@Test
	public void testChildren() throws Exception{
		Traitsscore t = traitsRepo.findByRow("outdoor", 1, 1);
		Assert.assertTrue(t.score == 5);
		t = traitsRepo.findByRow("outdoor", 1, 2);
		Assert.assertTrue(t.score == 2);

	}

}
