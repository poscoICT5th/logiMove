package Pack.service;

import org.springframework.stereotype.Service;

@Service
public class AutoIncrese {
	static int num = 0;
	
	public static String getNum() {
		System.out.println(num);
		return Integer.toString(AutoIncrese.num++);
	}
	
	public static void setNum() {
		AutoIncrese.num = 0;
	}
}
