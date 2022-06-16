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
	String item_code;
	String item_name;
	float min_weight;
	float max_weight;
	float min_thickness;
	float max_thickness;
	float min_height;
	float max_height;
	double min_width;
	double max_width;
	int min_move_amount;
	int max_move_amount;
	String from_warehouse;
	String to_warehouse;
	String inst_reg_date;
	String inst_deadline;
	String done_date;
}
