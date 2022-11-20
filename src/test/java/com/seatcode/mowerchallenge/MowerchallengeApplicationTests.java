package com.seatcode.mowerchallenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.FileCopyUtils;

@SpringBootTest
@AutoConfigureMockMvc
public class MowerchallengeApplicationTests {

	private static final String OUTPUT = "1 3 N\n5 1 E";

	@Autowired
	private MockMvc mockMvc;

	@Value("classpath:MowerChallengeInput.txt")
	private Resource resourceInputFile;

	@Test
	void testMowerCommand() throws Exception {
		String commandInput = loadResourceAsString(resourceInputFile);
		Assertions.assertNotNull(commandInput);

		MvcResult mvcResult = mockMvc
				.perform(post("/mowerchallenge/mowers").content(commandInput).contentType(MediaType.TEXT_PLAIN_VALUE))
				.andDo(print()).andExpect(status().isOk()).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		Assertions.assertEquals(OUTPUT, result.trim());
	}

	private String loadResourceAsString(Resource resource) {
		try (Reader reader = new InputStreamReader(resource.getInputStream(), "UTF-8")) {
			return FileCopyUtils.copyToString(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
