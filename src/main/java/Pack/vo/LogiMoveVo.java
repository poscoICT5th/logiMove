package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class LogiMoveVo {
	String location;
	String warehouse_code;
	String purpose;
	String warehouse_code_desc;
	String use;
	int maximum_weight;
	int maxinum_count;
	String inventory_using;
	String remarks;
	
	
}
