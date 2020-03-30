package controller;

import static model.logic.Utils.*;
import static view.Output.*;
import model.entity.*;
import model.entity.groups.ITCompany;
import model.entity.groups.ProjectTeam;
import model.factory.AccountantFactory;
import model.factory.BossFactory;
import model.factory.DevHRFactory;
import model.factory.PMFactory;
import model.factory.QAHRFactory;
import model.logic.MyArray;
import model.logic.Storable;

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
		ITCompany epam = new ITCompany("epam", "MyList");
		ProjectTeam pt = new ProjectTeam("Mario");
		DevHR dhr = (DevHR) new DevHRFactory().create(1).get(0);
		Boss boss = (Boss) new BossFactory().create(1).get(0);
		PM pm = (PM) new PMFactory().create(1).get(0);
		Accountant ac = (Accountant) new AccountantFactory().create(1).get(0);
		QAHR qahr = (QAHR) new QAHRFactory().create(1).get(0);
		dhr.setPlaceOfWork(epam);
		dhr.setProject(pt);
		Storable<Employee> st = new MyArray();
		st.add(dhr);
		st.add(boss);
		st.add(pm);
		st.add(ac);
		st.add(qahr);
		dhr.setIdToEmployee(st);
		dhr.setPlaceOfWorkToEmployee(st);
		dhr.setProjectToEmployee(st, pt);
		pt.setMember(st);
		epam.getTeams().add(pt);
		
		
		((DevHR) epam.getTeams().get(0).getMember().get(0)).createProjTeam("Hekk", 34435,5, 1, 1, 1);		
		((Boss) epam.getTeams().get(0).getMember().get(1)).showMembers();
		
		((QAHR) epam.getTeams().get(0).getMember().get(4)).searchApplyers(5);
		((DevHR) epam.getTeams().get(0).getMember().get(0)).searchApplyers(10);
		((DevHR) epam.getTeams().get(0).getMember().get(0)).showAspirants();
		
		 
		 
		((DevHR) epam.getTeams().get(0).getMember().get(0)).interview(3, "Hekk");
		((QAHR) epam.getTeams().get(0).getMember().get(4)).interview(7, "Mario");
		((Boss) epam.getTeams().get(0).getMember().get(1)).showMembers();
		((DevHR) epam.getTeams().get(0).getMember().get(0)).showAspirants();
		((Boss) epam.getTeams().get(0).getMember().get(1)).sort("Hekk", "age");
		((Boss) epam.getTeams().get(0).getMember().get(1)).showMembers();
		((Boss) epam.getTeams().get(0).getMember().get(1)).compelToWork();
		
		/*while (true) {
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
		}*/
	}

}