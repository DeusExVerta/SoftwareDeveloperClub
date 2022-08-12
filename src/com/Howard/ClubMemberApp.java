package com.Howard;

import java.util.Scanner;

public class ClubMemberApp {
	public static void main(String[] args) 
	{
		//initialize our empty sdc
		SoftwareDeveloperClub sdc = new SoftwareDeveloperClub();
		
		//try with resources (Scanner)
		try (Scanner sc = new Scanner(System.in)) {
			
			//loop sentinel flag
			boolean toCont = true;
			/*
			 * loop until flag is false(user selects quit option):
			 * 	Display Menu String
			 * 	Get user input
			 * 		if input=1
			 * 			display the contents of the memberlist
			 * 		if input=2
			 * 			remove a single member by index
			 * 		if input=3
			 * 			add a member using a comma delimited string. TODO: ensure user input is valid
			 * 		if input=4 (QuitOption)
			 * 			save the contents of the sdc to a file and set loop flag to false.
			 * 		else
			 * 			inform user of bad input.
			 */
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
						
						try
						{
							sdc.addMember(new ClubMember(line[0], line[1], line[2], line[3]));
						}
						catch (ArrayIndexOutOfBoundsException ex) {
							System.out.println("Insufficient information to initialize a member");
							System.out.print(ex);
						}
						
						break;
						
					case 4:
						toCont = false;
						sdc.saveMemberList("newMembers.txt");
						break;
						
					default:
						System.out.printf("%d is not a valid option%n",opt);
				}
			 } while (toCont);
		} 
	}
}
