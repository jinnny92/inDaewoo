package kr.co.dw;

public class MainEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = new Integer(3); //오토언박싱 (박스에서 자동으로 풀렸다는 의미
		Integer b = 4; //오토바싱 => 박싱 = 객체화 됐다는 뜻
		//Wrapper class는 이게 가능하다 기본자료형 = 참조자료형
		
		Character c = '4';
		char d = new Character('a');
		
		
		String msg = "true";
		
		 boolean e = Boolean.parseBoolean(msg);
		 msg = "345";
		 int f = Integer.parseInt(msg);
		 
		 msg = "a";
		// char g = Character.parseChar(msg); 유일하게 안되기 때문에 아래와 같이 변환
		 char g = msg.charAt(0);
		 
		 //자료형이 기본자료형이고 그 값이 래퍼클래스가 들어가도 인식됨 오토언박싱
		 // 자료형이 래퍼클래스이고 기본자료형 값이 들어가도 인식됨 오토박싱
		 //각각의 래퍼클래스에 parse+자료형 단 Character은 parse 사용불가 대신 CharAt(0);을 쓴다
		
	}

}
