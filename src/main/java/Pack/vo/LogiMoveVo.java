package Pack.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
public class LogiMoveVo {
	String status;
	String location;
	String instruction_no;
	String lot_no;
	String item_no;
	String item_name;
	float width;
	float weight;
	float thickness;
	float height;
	int move_amount;
	String from_warehouse;
	String to_warehouse;
	String inst_reg_date;
	String inst_deadline;
	String done_date;
}
