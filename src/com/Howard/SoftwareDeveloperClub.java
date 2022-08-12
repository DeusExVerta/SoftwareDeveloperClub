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

public class SoftwareDeveloperClub {
	private List<ClubMember> members = new ArrayList<>();
	public SoftwareDeveloperClub() {
		File f = new File("./members.txt");	
		try(InputStream reader = new FileInputStream(f);)
		{
			//drop header line
			if(reader.available()>0)
				this.readLine(reader);
				//reader.nextLine();
			while(reader.available()>0) 
			{
				String[] line = this.readLine(reader).split("\\*\\*");
				members.add(new ClubMember(line[0],line[1],line[2],line[3]));
			}
		}catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
	public void displayMembers() 
	{
		for(ClubMember cm:members) 
		{
			System.out.println(cm);
		}
		System.out.println();
	}
	
	public boolean removeMember(int index) 
	{
		return members.remove(index)!=null;
	}
	
	public boolean addMember(ClubMember cm) 
	{
		return members.add(cm);
	}
	
	public void saveMemberList(String fname) 
	{
		File f = new File(fname);
		try (OutputStream fw = new FileOutputStream(f))
		{
			if(f.canWrite()) {
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
