package Pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Pack.vo.TestVo;
import Pack.service.MoveService;
import Pack.service.TestService;
import Pack.vo.LogiMoveDTO;
import Pack.vo.LogiMoveDeleteList;
import Pack.vo.LogiMoveSearchDTO;
import Pack.vo.LogiMoveVo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class MainController {
	@Autowired
	TestService testService;
	@Autowired
	MoveService moveService;
	
	@GetMapping("/test")
	public List test() {
	    List<TestVo> testList = testService.selectTest();
	    System.out.println(testList);
	    return testList;
	}
	
	@GetMapping("/move")
	public List moveAll() {
		System.out.println("move all");
	    List<LogiMoveVo> moveAll = moveService.selectAll();
	    System.out.println(moveAll);

	    return moveAll;
	}
	
	@GetMapping("/search")
	public List moveSearch(LogiMoveSearchDTO logiMoveSearchDTO) {
		System.out.println("move search");
		System.out.println(logiMoveSearchDTO);
	    List<LogiMoveVo> moveSearch = moveService.selectSome(logiMoveSearchDTO);
		return moveSearch;
	}
	
	@PostMapping("/move")
	public boolean moveAdd(@RequestBody LogiMoveDTO data) {
		System.out.println("post 들어감");
		System.out.println(data); 
		int result = moveService.insert(data);
		return result==1?true:false;
	}
	
	@DeleteMapping("/move")
	public boolean moveDeletes(@RequestBody LogiMoveDeleteList logiMoveDeleteList) {
		System.out.println("delete List");
		System.out.println(logiMoveDeleteList.toString());
		int result = moveService.deletes(logiMoveDeleteList);
		return result==1?true:false;
	}
	
	@DeleteMapping("move/{instructionNo}")
	public boolean moveDelete(@PathVariable String instructionNo) {
		System.out.println(instructionNo);
		int result = moveService.delete(instructionNo);
		return result==1?true:false;
	}
	
	@PutMapping("move/{instructionNo}")
	public boolean moveChange(@PathVariable String instructionNo) {
		System.out.println(instructionNo);
		int result = moveService.change(instructionNo);
		return result==1?true:false;
	}
}
