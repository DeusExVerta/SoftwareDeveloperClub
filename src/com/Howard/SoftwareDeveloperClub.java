package com.Howard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * specialized wrapper for an array list to store a list of members.
 */
public class SoftwareDeveloperClub {
	private List<ClubMember> members = new ArrayList<>();
	
	/*
	 * populate internal ArrayList by reading from the file.
	 */
	public SoftwareDeveloperClub() {
		File f = new File("./members.txt");	
		try(InputStream reader = new FileInputStream(f);)
		{
			//drop header line
			if(reader.available()>0)
				this.readLine(reader);
			while(reader.available()>0) 
			{
				String[] line = this.readLine(reader).split("\\*\\*");
				members.add(new ClubMember(line[0],line[1],line[2],line[3]));
			}
		}catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
	/*
	 * display the contents of the internal ArrayList
	 */
	public void displayMembers() 
	{
		for(ClubMember cm:members) 
		{
			System.out.println(cm);
			System.out.println();
		}
	}
	
	/*
	 * pass through methods remove and add
	 */
	public boolean removeMember(int index) 
	{
		return members.remove(index)!=null;
	}
	
	public boolean addMember(ClubMember cm) 
	{
		return members.add(cm);
	}
	
	/*
	 * Saves the content of the member list to the file specified by fname
	 */
	public void saveMemberList(String fname) 
	{
		File f = new File(fname);
		try (OutputStream fw = new FileOutputStream(f))
		{
			if(f.canWrite()) {
				fw.write("NAME**CITY**STATE**FAVORITE PROGRAMMING LANGUAGE".getBytes());
				for(ClubMember cm:members) 
				{
					fw.write(cm.saveString().getBytes());
				}
			}
		}catch (FileNotFoundException ex) 
		{
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * reads a line of characters up to the first newline character or the end of the file
	 * returns a string of all the characters excluding the newline.
	 */
	public String readLine(InputStream fis) 
	{
		int b;
		StringBuilder sb = new StringBuilder();
		try {
			while((b=fis.read())!='\n'&&b!=-1) 
			{
				sb.append((char)b);
			}
		}catch(IOException ex) 
		{
			System.out.println(ex);
		}
		return sb.toString();
	}
}
