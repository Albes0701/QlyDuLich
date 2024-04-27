package test;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
//		String tenkh_tmp="Nguyễn Văn A";
//		String[] parts = tenkh_tmp.split(" ");
//		for(int i=0;i<parts.length;i++) {
//			System.out.println(parts[i]);
//		}
//		String tenkh=parts[parts.length-1];
//		System.out.println(tenkh);
//		String hokh="";
//		for(int i=0;i<parts.length-1;i++) {
//			hokh=hokh+" "+parts[i];
//		}
//		hokh=hokh.trim();
//		System.out.println(hokh);
		
		
		Random random = new Random();
        StringBuilder randomLetters = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            randomLetters.append(randomChar);
        }

        System.out.println("Random letters: " + randomLetters.toString());
		
		
		
		
	}
}
