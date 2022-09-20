import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SoftwareDeveloperClub {
	
	String fileInputPath = "C:\\Users\\halit\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\SoftwareDevClub\\src\\members.txt";
	String fileOutputPath = "C:\\Users\\halit\\Documents\\workspace-spring-tool-suite-4-4.15.1.RELEASE\\SoftwareDevClub\\src\\membersCopy.txt";
	File fileInput = new File(fileInputPath);
	File fileOutput = new File(fileOutputPath);
	ArrayList<ClubMember> members = new ArrayList<ClubMember>();
	
	public void readFile(){
		try(Scanner input = new Scanner(fileInput)) {
			if(input.hasNextLine()) {
				input.nextLine();
			} 
			while(input.hasNextLine()) {
				String[] member = input.nextLine().split("\\*\\*");
				members.add(new ClubMember(member[0], member[1], member[2], member[3]));
			}	
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	
	public void readFileWithStream () {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileInput))) {
			String member;
			if ((member=reader.readLine()) != null) {
				reader.readLine();
			}
			
			while ((member=reader.readLine()) != null) {
				String[] memberSplit = member.split("\\*\\*");
				members.add(new ClubMember(memberSplit[0], memberSplit[1], memberSplit[2], memberSplit[3]));
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void displayMembers() {
		for (ClubMember member: members) {
			System.out.println("Member Name: " + member.getName());
			System.out.println("Location: " + member.getState() + ", " + member.getStateShort());
			System.out.println("Favorite Language: " + member.getFavLang());
			System.out.println();
		}
	}
	
	public void removeMember(int index) {
		try {
			ClubMember removedElement = members.remove(index);
			System.out.println("Removed element: " + removedElement);
		}
		catch(Exception e) {
			System.out.println("Enter an index that is in range!" + e);
		}
			
	}
	
	public void addMember(String name, String state, String stateShort, String favLang) {
		members.add(new ClubMember(name, state, stateShort, favLang));
		System.out.println("Added element: " + members.get(members.size() -1));

	}
	
	
	public void propmtMenu() {
		Scanner prompt = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.println("Select from the following menu: \r\n" +
				"1: Display Members \r\n" +
				"2: Remove Member \r\n" +
				"3: Add Member \r\n" +
				"4: Quit");
			int input = prompt.nextInt();
			prompt.nextLine();
			switch(input) {
			
			case 1:
				displayMembers();
				break;
			case 2:
				System.out.println("Enter index of the member to be removed: ");
				int index = prompt.nextInt();
				prompt.nextLine();
				removeMember(index);
				displayMembers();
				break;
			case 3:
				System.out.println("Enter name: ");
				String name = prompt.nextLine();
				System.out.println("Enter state: ");
				String state = prompt.nextLine();
				System.out.println("Enter state in short: ");
				String stateShort = prompt.nextLine();
				System.out.println("Enter favorite language: ");
				String favLang = prompt.nextLine();
				
				addMember(name, state, stateShort, favLang);
				displayMembers();
				break;	
			case 4:
				System.out.println("exiting");
				running = false;
				break;
			default:
				System.out.println("try again");
			
			}
		}
		prompt.close();
		
		
	}
}
