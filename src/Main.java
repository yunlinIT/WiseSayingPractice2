import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int lastId = 0; // ●
		List<Wisesaying> wisesayings = new ArrayList<>();
		
		System.out.println("==명언 앱 실행==");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("등록")) {
				int id = lastId + 1; // ●
				String regDate = Util.regDate();  // ●
				System.out.print("명언 : ");
				String content = sc.nextLine();
				System.out.print("작가 : ");
				String author = sc.nextLine();
				
				Wisesaying wisesaying = new Wisesaying(id, regDate, content, author);
				wisesayings.add(wisesaying);
				
				System.out.printf("%d번 명언이 등록되었습니다.\n", id);
				lastId++; // ●
			} else if (cmd.equals("목록")) {
				System.out.println("번호   /   작가   /   명언");
				System.out.println("===========================");
				
				for (int i = wisesayings.size() - 1; i >= 0; i--) { // ●
					Wisesaying ws = wisesayings.get(i); // 
					System.out.printf("%d     /    %s    /   %s\n", ws.getId(), ws.getAuthor(), ws.getContent()); // ●
				}
			} else if (cmd.startsWith("삭제?id=")) {
				String[] cmdDiv = cmd.split("=");
				int id = Integer.parseInt(cmdDiv[1]);
				
				Wisesaying foundWisesaying = null; // ●
				
				for (int i = 0; i <= wisesayings.size() - 1; i++) { // ●
					Wisesaying ws = wisesayings.get(i); // ●
					if (ws.getId() == id) { // ●
						foundWisesaying = ws; // ●
						break; //
					}
				}
				if(foundWisesaying == null) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
					continue; // ●
				}
				wisesayings.remove(foundWisesaying); // ●
				System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
						
			} else if (cmd.startsWith("수정?id=")) {
				String[] cmdDiv = cmd.split("=");
				int id = Integer.parseInt(cmdDiv[1]);
				
				Wisesaying foundWisesaying = null; // ●
				
				for (int i = 0; i <= wisesayings.size() - 1; i++) { // ●
					Wisesaying ws = wisesayings.get(i); // ●
					if (ws.getId() == id) { // ●
						foundWisesaying = ws; // ●
						break; //
					}
				}
				if(foundWisesaying == null) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
					continue; // ●
				}
				System.out.printf("명언(기존) : %s\n", foundWisesaying.getContent());
				System.out.printf("작가(기존) : %s\n", foundWisesaying.getAuthor());
				System.out.print("명언 : ");
				String newContent = sc.nextLine();
				System.out.print("작가 : ");
				String newAuthor = sc.nextLine();
				
				foundWisesaying.setContent(newContent);
				foundWisesaying.setAuthor(newAuthor);
				
				// 리스트에 또 안담아도 됨!
				
				System.out.printf("%d번 명언이 수정되었습니다.\n", id);
			} else if (cmd.startsWith("상세보기?id=")) {
				String[] cmdDiv = cmd.split("=");
				int id = Integer.parseInt(cmdDiv[1]);
				
				Wisesaying foundWisesaying = null; // ●
				
				for (int i = 0; i <= wisesayings.size() - 1; i++) { // ●
					Wisesaying ws = wisesayings.get(i); // ●
					if (ws.getId() == id) { // ●
						foundWisesaying = ws; // ●
						break; //
					}
				}
				if(foundWisesaying == null) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
					continue; // ●
				}
				System.out.printf("번호 : %d\n", foundWisesaying.getId());
				System.out.printf("날짜 : %s\n", foundWisesaying.getRegDate());
				System.out.printf("작가 : %s\n", foundWisesaying.getAuthor());
				System.out.printf("내용 : %s\n", foundWisesaying.getContent());
						
			} else {
				System.out.println("명령어를 제대로 입력해주세요.");
			}
		}

	}

}
