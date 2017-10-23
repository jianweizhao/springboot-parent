package com.springboot.mq;

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
@SpringBootTest(classes =SpringbootDataJpaApplication.class )
@AutoConfigureMockMvc
public class SpringbootDataJpaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void 测试添加数据() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/addUser").accept(MediaType.APPLICATION_JSON)
				.param("userName","zhaojw")
				.param("passWord","123456")
				.param("userEmail","zhaojw_420@163.com")
				.param("nickName","zjw")
				.param("regTime","2017-10-18"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void 测试查询所有数据() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/getUsers").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void 测试根据id查询数据() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/getUserById").accept(MediaType.APPLICATION_JSON)
				.param("id","1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void 测试根据名称查询数据() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/getUserByName").accept(MediaType.APPLICATION_JSON)
				.param("name","zhaojw"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void 测试删除数据() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteUser").accept(MediaType.APPLICATION_JSON)
				.param("id","1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void 测试根据名称或者邮箱查询数据() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/getUsersByNickNameOrEmail").accept(MediaType.APPLICATION_JSON)
				.param("nickName","zjw").param("userEmail","ss"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void 测试模糊查询数据() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/findByUserNameLike").accept(MediaType.APPLICATION_JSON)
				.param("userName","zhao"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void 测试自定义sql更新() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/modifyUser").accept(MediaType.APPLICATION_JSON)
				.param("userName","zhaojwzr")
				.param("id","2"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void testDeleteByUserId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteByUserId").accept(MediaType.APPLICATION_JSON)
				.param("id","2"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}

	@Test
	public void testModifyFindUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/modifyFindUser").accept(MediaType.APPLICATION_JSON)
				.param("userName","zhao"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
	}
}
