package Pack.vo;

import java.text.SimpleDateFormat;

import Pack.service.AutoIncrese;
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
public class LogiMoveMultiDTO {
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
	String after_lot_no;
	public LogiMoveMultiDTO(String status, String lot_no, String item_code, String item_name, int amount, String unit,
			float weight, float width, float thickness, float height, String location, String warehouse_code,
			String to_warehouse, String inst_deadline, String done_date, String after_lot_no) {
		super();
		long curTime = System.currentTimeMillis();
		String makeDate = new SimpleDateFormat("YYMMddHHmmssSSS").format(curTime)+ AutoIncrese.getNum();
		this.instruction_no = makeDate;
		this.status = "이동예정";
		this.lot_no = lot_no;
		this.item_code = item_code;
		this.item_name = item_name;
		this.move_amount = amount;
		this.unit = unit;
		this.weight = weight;
		this.width = width;
		this.thickness = thickness;
		this.height = height;
		this.location = location;
		this.from_warehouse = warehouse_code;
		this.to_warehouse = to_warehouse;
		this.inst_reg_date = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(curTime);
		this.inst_deadline = inst_deadline;
		this.done_date = done_date;
		this.after_lot_no = makeDate;
	}
	
}
