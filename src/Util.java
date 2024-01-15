import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {    
	public static String regDate() {            
		LocalDateTime now = LocalDateTime.now();           
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss"));
		return formatedNow; 
	}
}
