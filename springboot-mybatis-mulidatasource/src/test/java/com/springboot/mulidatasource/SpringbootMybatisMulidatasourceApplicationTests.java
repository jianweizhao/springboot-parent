package com.springboot.mulidatasource;

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
@SpringBootTest(classes =SpringbootMybatisMulidatasourceApplication.class )
@AutoConfigureMockMvc
public class SpringbootMybatisMulidatasourceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void 多数据元添加数据() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/addUser").accept(MediaType.APPLICATION_JSON)
				.param("userName","zhanran")
				.param("userEmail","zhanran_413@163.com")
				.param("nikcName","zr")
				.param("regTime","2017-10-20")
				.param("userPasswd","12345"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void 多数据源查询所有数据() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllUser").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}
}
