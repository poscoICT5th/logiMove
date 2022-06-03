package Pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.mapper.MoveMapper;
import Pack.vo.LogiMoveDTO;
import Pack.vo.LogiMoveSearchDTO;
import Pack.vo.LogiMoveVo;

@Service
public class MoveService {
    @Autowired
    public MoveMapper moveMapper;

    public List<LogiMoveVo> selectAll() {
        return moveMapper.selectAll();
    }
    
    public LogiMoveVo selectByInstNo(String instructionNo) {
    	return moveMapper.selectByInstNo(instructionNo);
    }

    public List<LogiMoveVo> selectSome(LogiMoveSearchDTO logiMoveSearchDTO) {
    	return moveMapper.selectSome(logiMoveSearchDTO);
    }

	public int insert(LogiMoveDTO logiMoveDTO) {
		System.out.println(4444);
		System.out.println(logiMoveDTO);
		return moveMapper.insert(logiMoveDTO);
	}

	public int delete(String instructionNo) {
		return moveMapper.delete(instructionNo);
	}

	public int change(String instructionNo) {
		String curStatus = moveMapper.selectByInstNo(instructionNo).getStatus();
		if (curStatus.equals("이동중")) {
			System.out.println("이동예정인 친구 들어옴");
			return moveMapper.confirm(instructionNo);			
		} else {
			System.out.println("이동중인 친구 들어옴");
			return moveMapper.processing(instructionNo);						
		}
	}
}
