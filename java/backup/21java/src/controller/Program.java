package controller;

import static model.logic.Utils.*;
import static view.Output.*;

import model.entity.groups.ITCompany;

public class Program {
	private static final String MENU = "\n1 - View all project teams\n" + "2 - Create a new team\n"
			+ "3 - View 'current' employees\n" + "4 - Show employee by id\n" + "5 - View candidats list\n"
			+ "6 - Search new Developer candidats\n" + "7 - Interview developer candidats and add suitable\n"
			+ "8 - Search new QA candidats\n" + "9 - Interview QA candidats and add suitable\n"
			+ "10 - Set current PM\n" + "11 - Set current DevHR\n" + "12 - Set current QAHR\n"
			+ "13 - Fire Employee by id\n" + "14 - Dissolve Project team by name\n"
			+ "15 - Move an employee to other Project team\n"
			+ "16 - Show accounting\n" + "\nEnter desirable action : ";
	private static final String INP_ID = "\nEnter desirable id : ";

	public static void main(String... args) {
		ITCompany epam = new ITCompany("epam", "MyArray");
		while (true) {
			switch (readInt(MENU)) {
			case 1:
				epam.showMembers();
				break;
			case 2:
				epam.createProjTeam(readStr("\nEnter name of projectTeam:"), 90900, 20, 2, 2, 3);
				break;
			case 3:
				epam.showCurrents();
				break;
			case 4:
				epam.showEmployeeById(readInt("\nEnter desirable id : "));
				break;
			case 5:
				epam.viewAspirants();
				break;
			case 6:
				epam.addDevsToAspirants(10);
				break;
			case 7:
				epam.addDevsToTeam(readStr("\nEnter name of projectTeam:"), readInt("\nEnter desirable number : "));
				break;
			case 8:
				epam.addQAsToAspirants(10);
				break;
			case 9:
				epam.addQAsToTeam(readStr("\nEnter name of projectTeam:"), readInt("\nEnter desirable number : "));
				break;
			case 10:
				epam.setCurrentPM(readInt("\nEnter desirable id : "));
				break;
			case 11:
				epam.setCurrentDevHR(readInt("\nEnter desirable id : "));
				break;
			case 12:
				epam.setCurrentQAHR(readInt("\nEnter desirable id : "));
				break;
			case 13:
				epam.fireEmployee(readInt("\nEnter desirable id : "));
				break;
			case 14:
				epam.dissolveProjectTeam(readStr("\nEnter name of projectTeam:"));
				break;
			case 15:
				epam.moveEmployeeToOtherTeam(readStr("\nEnter name of projectTeam:"),
						readInt("\nEnter desirable id : "));
				break;
			case 16:
				epam.showAccounting();
				break;
			default:
				System.exit(-32);
			}
		}
	}

}