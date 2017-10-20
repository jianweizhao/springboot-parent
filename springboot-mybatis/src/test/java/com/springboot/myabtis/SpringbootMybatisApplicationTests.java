package com.springboot.myabtis;

import com.springboot.mybatis.SpringbootMybatisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootMybatisApplication.class})
@AutoConfigureMockMvc
public class SpringbootMybatisApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void 测试添加用户() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/addUser").accept(MediaType.APPLICATION_JSON)
		.param("userName","zhaojianwei")
		.param("userEmail","zhaojw_420@163.com")
		.param("nickName","zhaojw")
		.param("regTime","2017-10-20")
		.param("userPasswd","12345"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void initTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/init").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

}
