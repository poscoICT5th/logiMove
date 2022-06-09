package Pack.vo;

import java.text.SimpleDateFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString 
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class LogiMoveSearchDTO {
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
