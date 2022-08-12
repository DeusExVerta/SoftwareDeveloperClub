package com.Howard;

import java.util.Scanner;

public class ClubMemberApp {
	public static void main(String[] args) 
	{
		SoftwareDeveloperClub sdc = new SoftwareDeveloperClub();
		boolean toCont = true;
		try (Scanner sc = new Scanner(System.in)) {
			 do{
				System.out.print("Select from the following menu:\r\n" + "1: Display Members\r\n" + "2: Remove Member\r\n"
						+ "3: Add Member\r\n" + "4: Quit\r\n");
				int opt = sc.nextInt();
				sc.nextLine();
				switch (opt) {
					case 1:
						sdc.displayMembers();
						break;
					case 2:
						System.out.print("Enter index of member to remove:");
						sdc.removeMember(sc.nextInt());
						break;
					case 3:
						System.out.print("Enter Member information to add separated by commas(name,city,state,language):");
						String[] line = sc.nextLine().split(",");
						sdc.addMember(new ClubMember(line[0], line[1], line[2], line[3]));
						break;
					case 4:
						toCont = false;
						sdc.saveMemberList("newMembers.txt");
						break;
					default:
						System.out.printf("%d is not a valid option%n",opt);
				}
			 } while (toCont);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.print(ex);
		} 
	}
}
