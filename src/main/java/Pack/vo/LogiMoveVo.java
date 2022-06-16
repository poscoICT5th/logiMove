package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class LogiMoveVo {
	String instruction_no;
	String status;
	String lot_no;
	String item_code;
	String item_name;
	int move_amount;
	String unit;
	float weight;
	float width;
	float thickness;
	float height;
	String location;
	String from_warehouse;
	String to_warehouse;
	String inst_reg_date;
	String inst_deadline;
	String done_date;
}
