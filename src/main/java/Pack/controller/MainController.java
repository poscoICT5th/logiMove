package Pack.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import Pack.vo.TestVo;
import Pack.service.AutoIncrese;
import Pack.service.MoveService;
import Pack.service.TestService;
import Pack.vo.LogiMoveDTO;
import Pack.vo.LogiMoveList;
import Pack.vo.LogiMoveMulti;
import Pack.vo.LogiMoveMultiDTO;
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
	@Autowired
	RabbitTemplate rabbitTemplate;
	
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
		if (result > 0) {
			rabbitTemplate.convertAndSend("posco", "move.Inventory.process", data);
		}
		return result==1?true:false;
	}
	
	@PostMapping("/move/multi")
	public boolean moveAdds(@RequestBody LogiMoveMulti logiMoveMulti) {
		System.out.println("post 들어감");
		System.out.println(logiMoveMulti); 
		int result = moveService.inserts(logiMoveMulti);
		RestTemplate restTemplate = new RestTemplate();
		AutoIncrese.setNum();
		if (result > 0) {
			for (LogiMoveMultiDTO logiMoveMultiDTO : logiMoveMulti.getLogiMoveList()) {
			rabbitTemplate.convertAndSend("posco", "move.Inventory.process", logiMoveMultiDTO);
			restTemplate.getForEntity("http://35.77.54.132:8080/hotline/send/type/"+"이동"+"/topic/" + logiMoveMultiDTO.getFrom_warehouse(), String.class);
			}
		}
		return result>0?true:false;
	}
	
	@DeleteMapping("/move")
	public boolean moveDeletes(@RequestBody LogiMoveList logiMoveList) {
		System.out.println("delete List");
		System.out.println(logiMoveList.toString());
		int result = moveService.cancels(logiMoveList);
		if (result > 0) {
			for (String instructionNo : logiMoveList.getLogiMoveList()) {
				LogiMoveVo deleteMoveDTO = moveService.selectByInstNo(instructionNo);
				rabbitTemplate.convertAndSend("posco", "move.Inventory.done", deleteMoveDTO);
			}
		}
		return result==1?true:false;
	}
	
	@PutMapping("/move/rollback")
	public boolean importRollbacks(@RequestBody LogiMoveList logiMoveList) {
		System.out.println("rollback List");
		System.out.println(logiMoveList);
		int result = moveService.rollback(logiMoveList);
		if (result > 0) {
			for (String instructionNo : logiMoveList.getLogiMoveList()) {
				LogiMoveVo rollbackMoveDTO = moveService.selectByInstNo(instructionNo);
				rabbitTemplate.convertAndSend("posco", "move.Inventory.process", rollbackMoveDTO);
			}
		}
		return result==1?true:false;
	}
	
	@DeleteMapping("move/{instructionNo}")
	public boolean moveDelete(@PathVariable String instructionNo) {
		System.out.println(instructionNo);
		LogiMoveVo moveDeleteData = moveService.selectByInstNo(instructionNo);
		int result = moveService.delete(instructionNo);
		if (result > 0 ) {
			rabbitTemplate.convertAndSend("posco", "move.Inventory.done", moveDeleteData);
		}
		return result==1?true:false;
	}
	
	@PutMapping("move/{instructionNo}")
	public boolean moveChange(@PathVariable String instructionNo) {
		System.out.println(instructionNo);
		int result = moveService.change(instructionNo);
		return result==1?true:false;
	}
	
	@GetMapping("/lotno/{lotNo}")
	public LogiMoveVo selectByLotNo(@PathVariable String lotNo) {
		System.out.println(lotNo);
		LogiMoveVo result = moveService.selectByLotNo(lotNo);
		return result;
	}
}
