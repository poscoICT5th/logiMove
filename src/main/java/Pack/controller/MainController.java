package Pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Pack.mapper.TestService;
import Pack.vo.TestVo;
import Pack.vo.LogiMoveVo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class MainController {
	@Autowired
	TestService testService;
	
	@GetMapping("/test")
	public List test() {
		System.out.println(111);
	    ModelAndView mav = new ModelAndView("test");

	    List<TestVo> testList = testService.selectTest();
	    System.out.println(testList);
	    mav.addObject("list", testList);

	    return testList;
	}
	
	@GetMapping("/warehouse")
	public List warehouse() {
		System.out.println(111);
	    ModelAndView mav = new ModelAndView("warehouse");

	    List<LogiMoveVo> testList = testService.selectAll();
	    System.out.println(testList);
	    mav.addObject("list", testList);

	    return testList;
	}
}
