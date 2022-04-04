package kr.co.dw;

import java.util.Scanner;

import kr.co.command.Command;
import kr.co.command.DeleteCommand;
import kr.co.command.DeleteUICommand;
import kr.co.command.EndCommand;
import kr.co.command.InsertCommand;
import kr.co.command.InsertUICommand;
import kr.co.command.ListCommand;
import kr.co.command.UpdateCommand;
import kr.co.command.UpdateUICommand;

public class Process {

		public Process() {
			Scanner sc = new Scanner(System.in);
			boolean isTrue = true;
			
			Command[] com = {
					new InsertUICommand(),
					new UpdateUICommand(),
					new DeleteUICommand(),
					new ListCommand(),
					new EndCommand()

			};
			
			Command[] com2 = {
					new InsertCommand(),
					new UpdateCommand(),
					new DeleteCommand()
			};
			
			while (isTrue) {
				System.out.println("메뉴를 선택하세요");
				System.out.println("0: 입력, 1: 수정, 2: 삭제, 3: 조회, 4: 종료");
				int menu = sc.nextInt();
				sc.nextLine();
				
				
				isTrue = com[menu].execute(sc);
				
				try {
					com2[menu].execute(sc);
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					
				}
			}
			
			
			
		sc.close();
			}
		}





