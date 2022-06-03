package Pack.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import Pack.vo.LogiMoveDTO;
import Pack.vo.LogiMoveSearchDTO;
import Pack.vo.LogiMoveVo;

@Repository
@Mapper
public interface MoveMapper {
    List<LogiMoveVo> selectAll();
    
    LogiMoveVo selectByInstNo(String instructionNo);

	int insert(LogiMoveDTO logiImportDTO);

	List<LogiMoveVo> selectSome(LogiMoveSearchDTO logiImportSearchDTO);

	int delete(String instructionNo);

	int confirm(String instructionNo);

	int processing(String instructionNo);
}
