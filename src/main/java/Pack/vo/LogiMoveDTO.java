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
public class LogiMoveDTO {
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
	public LogiMoveDTO(String status, String location, String lot_no, String item_no, String item_name, float width,
			float weight, float thickness, float height, int move_amount, String from_warehouse, String to_warehouse,
			String inst_deadline, String done_date) {
		super();
		this.status = status;
		this.location = location;
		this.lot_no = lot_no;
		this.item_no = item_no;
		this.item_name = item_name;
		this.width = width;
		this.weight = weight;
		this.thickness = thickness;
		this.height = height;
		this.move_amount = move_amount;
		this.from_warehouse = from_warehouse;
		this.to_warehouse = to_warehouse;
		this.inst_deadline = inst_deadline;
		this.done_date = done_date;
		long curTime = System.currentTimeMillis();
		String makeDate = new SimpleDateFormat("YYMMddHHmmssms").format(curTime);
		this.instruction_no = makeDate;
		this.inst_reg_date = new SimpleDateFormat("YYYY-MM-dd").format(curTime);
	}
	
}
