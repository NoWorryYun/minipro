package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhonbookApp {

	public static void main(String[] args) throws IOException {

		List<Person> person = new ArrayList<Person>();
		Reader isr = new FileReader("./phoneDB.txt");
		BufferedReader br = new BufferedReader(isr);
		Scanner sc = new Scanner(System.in);

		while (true) {
			Person p = new Person();
			String str = br.readLine();
			if (str == null) {
				break;
			}
			String[] pArray = str.split(",");
			p.setName(pArray[0]);
			p.setHp(pArray[1]);
			p.setCompany(pArray[2]);
			person.add(p);
		}

		Writer fw = new FileWriter("./PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		System.out.println("********************************************");
		System.out.println("************ 전화번호 관리 프로그램	************");
		System.out.println("********************************************");
		while (true) {

			System.out.println("");
			System.out.println("1. 리스트   2. 등록   3. 삭제   4. 검색   5.종료");
			System.out.println("--------------------------------------------");
			System.out.print(">>메뉴번호 : ");
			int num = sc.nextInt();

			if (num == 5) {
				System.out.println("*******************************************");
				System.out.println("**************    감사합니다    **************");
				System.out.println("*******************************************");
				break;
			} else if (num == 1) {
				for (int i = 0; i < person.size(); i++) {
					System.out.print((i + 1) + ".   ");
					person.get(i).showInfo();
				}
			} else if (num == 2) {
				while (true) {
					Person p = new Person();
					String str = br.readLine();
					if (str == null) {
						break;
					}
					String[] pArray = str.split(",");
					p.setName(pArray[0]);
					p.setHp(pArray[1]);
					p.setCompany(pArray[2]);
					person.add(p);
				}
				Person p = new Person();
				System.out.println("<2.등록>");
				sc.nextLine(); // sc.next 오류
				System.out.print(">이름: ");
				p.setName(sc.nextLine());

				System.out.print(">휴대전화: ");
				p.setHp(sc.nextLine());

				System.out.print(">회사전화: ");
				p.setCompany(sc.nextLine());

				person.add(p);

				for (Person s : person) {
					String saveStr = s.getName() + "," + s.getHp() + "," + s.getCompany();
					bw.write(saveStr);
					bw.newLine();
				}
				System.out.println("[등록되었습니다.]");

			} else if (num == 3) {
				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");
				person.remove((sc.nextInt() - 1));

				for (Person s : person) {
					String saveStr = s.getName() + "," + s.getHp() + "," + s.getCompany();
					bw.write(saveStr);
					bw.newLine();
				}

				System.out.println("삭제되었습니다.");

			} else if (num == 4) {
				System.out.println("<4.검색>");
				System.out.print("이름: ");
				sc.nextLine();
				String typing = sc.nextLine();
				char searcher = typing.charAt(0);
				for (int i = 0; i < person.size(); i++) {
					String[] pName = person.get(i).getName().split("");
					
					char search01 = pName[0].charAt(0);
					char search02 = pName[1].charAt(0);
					char search03 = pName[2].charAt(0);
					
					if (searcher == search01 || searcher == search02 || searcher == search03) {
						person.get(i).showInfo();
					}
				}

			} else {
				System.out.println("[다시 입력해 주세요]");
			}

			System.out.println("");

		}
		bw.close();
		sc.close();
		br.close();
	}
}
