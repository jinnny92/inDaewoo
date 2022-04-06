package kr.co.dw.MMScommand;

import java.util.Scanner;

public interface MMSCommand {
	public abstract boolean execute(Scanner sc);

	boolean process(Scanner sc);

}
