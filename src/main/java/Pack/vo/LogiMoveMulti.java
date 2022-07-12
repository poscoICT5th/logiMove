package Pack.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LogiMoveMulti {
	List<LogiMoveMultiDTO> logiMoveList;
	String to_warehouse;
	String inst_deadline;
}
