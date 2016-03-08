package jugame.jiaoyi_ff.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyTest {

	
	
	@RequestMapping(value = "/test")
	public String myTest(HttpServletRequest request, Model model){
		
		model.addAttribute("key", "哈哈哈 来打我啊。。。。。。。。。。");
		return "pc:test";
	}
	
	
	public void getName(String name){
		System.out.println("测试成功:"+name);
	}
}
