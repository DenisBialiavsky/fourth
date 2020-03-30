package model.entity.groups;

import model.*;
import model.entity.*;
import model.logic.*;
import static view.Output.*;
import java.util.*;

import static model.logic.MyFactory.*;
import static model.logic.Utils.*;

public class ITCompany extends Group{
	private final int MIN_ID = 1000;
	private final int MAX_ID = 9999;
	private final static int DEFAULT_NUM_OF_EMPLOYEES = 1;
	static final private int DEF_TERM = 12;
	static final private int DEF_BUDGET = 150000;
	private final static String DEF_TEAM_NAME = "DEFAULT";
	private final static String DEF_COMPANY_NAME = "DEFAULT COMPANY NAME";
	private final static String DEFAULT_STORABLE_TYPE = "MyList";
	
	
	
	
	private Storable<ProjectTeam> teams;
	private Storable<Employee> aspirants;
	
	
	
	
	private int[] spareIds;
	private int[] reservedIds;
	private Employee currentPM;
	private Employee currentDevHR;
	private Employee currentQAHR;
	private Employee currentBoss;

	{
		spareIds = new int[MAX_ID - MIN_ID];
		reservedIds = new int[MAX_ID - MIN_ID];
		for (int i = 0, j = MIN_ID; j < MAX_ID; i++, j++) {
			spareIds[i] = j;
		}
	}

	public ITCompany() {
		this(DEF_COMPANY_NAME, DEFAULT_STORABLE_TYPE);
	}

	public ITCompany(String name, String type) {
		setName(name);
		teams = (type.equalsIgnoreCase("myarray")) ? new MyArray() : new MyList();
		aspirants = (type.equalsIgnoreCase("myarray")) ? new MyArray() : new MyList();
		ProjectTeam defaultTeam = new ProjectTeam(DEF_TEAM_NAME, DEF_BUDGET, DEF_TERM);
		defaultTeam.getMember().add(createBoss());
		defaultTeam.getMember().addAll(createPM(DEFAULT_NUM_OF_EMPLOYEES));
		defaultTeam.getMember().addAll(createDevHR(DEFAULT_NUM_OF_EMPLOYEES));
		defaultTeam.getMember().addAll(createQAHR(DEFAULT_NUM_OF_EMPLOYEES));
		currentBoss = defaultTeam.getMember().get(0);
		currentPM = defaultTeam.getMember().get(1);
		currentDevHR = defaultTeam.getMember().get(2);
		currentQAHR = defaultTeam.getMember().get(3);
		teams.add(defaultTeam);
		setIdToEmployee((teams.get(0)).getMember());
		setPlaceOfWorkToEmployee((teams.get(0)).getMember());
	}

	public void setIdToEmployee(Storable<Employee> storable) {
		for (int i = 0; i < storable.size(); i++) {
			if (storable.get(i).getId() == 0) {
				int newId = spareIds[rand(0, spareIds.length - 1)];
				storable.get(i).setId(newId);
				reservedIds = addElem(reservedIds, newId);
				spareIds = Utils.delElem(spareIds, searchIndexByValue(spareIds, newId));

			}
		}
	}

	public void setPlaceOfWorkToEmployee(Storable<Employee> storable) {
		for (int i = 0; i < storable.size(); i++) {
			storable.get(i).setPlaceOfWork(getName());
		}
	}



	public void createProjTeam(String name, int budget, int term, int nPM, int nDevHR, int nQAHR) {
		ProjectTeam newTeam = new ProjectTeam(name, budget, term);
		newTeam.getMember().addAll(createPM(nPM));
		newTeam.getMember().addAll(createDevHR(nDevHR));
		newTeam.getMember().addAll(createQAHR(nQAHR));
		teams.add(newTeam);
		setIdToEmployee(teams.get(teams.size() - 1).getMember());
		setPlaceOfWorkToEmployee(teams.get(teams.size() - 1).getMember());
	}

	
	
	
	
	
	
	public void showMembers() {
		exhibit(toString());
	}
	
	public void viewAspirants() {
		((HR) currentDevHR).showAspirants(aspirants);// Down cast
	}

	public void showCurrents() {
		exhibit(currentBoss.toString());
		exhibit(currentPM.toString());
		exhibit(currentDevHR.toString());//
		exhibit(currentQAHR.toString());
	}

	public void showEmployeeById(int id) {
		exhibit(((PM) currentPM).searchById(teams, id).toString());
	}

	public void showAccounting() {
		exhibit("Sum of all budgets=" + ((Boss) currentBoss).countAllBudgets(teams));// Down cast
		exhibit("Sum of all Expens=" + ((Boss) currentBoss).countAllExpens(teams));// Down cast
		exhibit("Sum of all profit=" + ((Boss) currentBoss).countAllProfit(teams));// Down cast
	}

	
	
	
	
	
	private void setAllCurrentEmps() {
		setCurrentPM(currentPM.getId());
		setCurrentDevHR(currentDevHR.getId());
		setCurrentQAHR(currentQAHR.getId());
	}

	public void setCurrentPM(int idFromNewCurrentPM) {
		currentPM = ((PM) currentBoss).searchById(teams, idFromNewCurrentPM);// Down cast
	}

	public void setCurrentDevHR(int idFromNewCurrentDevHR) {
		currentDevHR = ((PM) currentBoss).searchById(teams, idFromNewCurrentDevHR);// Down cast
	}

	public void setCurrentQAHR(int idFromNewCurrentQAHR) {
		currentQAHR = ((PM) currentBoss).searchById(teams, idFromNewCurrentQAHR);// Down cast

	}

	
	
	
	
	
	
	
	public void moveEmployeeToOtherTeam(String newTeam, int id) {
		int TargetTeam = ((PM) currentPM).searchProjectTeamByName(teams, newTeam);// Down cast
		int currentTeam = ((PM) currentPM).searchTeamIndexById(teams, id);// Down cast
		int empNumber = ((PM) currentPM).searchEmpIndexById(teams.get(currentTeam).getMember(), id);// Down cast
		teams.get(TargetTeam).getMember().add(((PM) currentPM).searchById(teams, id));
		teams.get(currentTeam).getMember().remove(empNumber);
		setAllCurrentEmps();
	}

	public void dissolveProjectTeam(String name) {
		((Boss) currentBoss).dissolveTeam(currentBoss, currentPM, currentDevHR, currentQAHR, name, teams);
		setAllCurrentEmps();
	}

	public void fireEmployee(int id) {
		((Boss) currentBoss).fireMember(currentBoss, currentPM, currentDevHR, currentQAHR, id, teams);
		setAllCurrentEmps();
	}

	
	
	
	
	
	
	
	
	
	public void addDevsToAspirants(int n) {
		aspirants.addAll((Storable<Employee>) ((DevHR) currentDevHR).searchApplyers(n));// Down cast
	}

	public void addQAsToAspirants(int n) {
		aspirants.addAll((Storable<? extends Employee>) ((QAHR) currentQAHR).searchApplyers(n));// Down cast
	}

	public void addDevsToTeam(String name, int n) {
		int i = ((PM) currentPM).searchProjectTeamByName(teams, name);
		teams.get(i).getMember().addAll(((DevHR) currentDevHR).interview(n, aspirants));
		setIdToEmployee(teams.get(i).getMember());
		setPlaceOfWorkToEmployee(teams.get(i).getMember());
		setAllCurrentEmps();
	}

	public void addQAsToTeam(String name, int n) {
		int i = ((PM) currentPM).searchProjectTeamByName(teams, name);
		teams.get(i).getMember().addAll(((QAHR) currentQAHR).interview(n, aspirants));
		setIdToEmployee(teams.get(i).getMember());
		setPlaceOfWorkToEmployee(teams.get(i).getMember());
		setAllCurrentEmps();
	}

	
	
	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(reservedIds);
		result = prime * result + Arrays.hashCode(spareIds);
		result = prime * result + Objects.hash(aspirants, currentBoss, currentDevHR, currentPM, currentQAHR, teams);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ITCompany other = (ITCompany) obj;
		return Objects.equals(aspirants, other.aspirants) && Objects.equals(currentBoss, other.currentBoss)
				&& Objects.equals(currentDevHR, other.currentDevHR) && Objects.equals(currentPM, other.currentPM)
				&& Objects.equals(currentQAHR, other.currentQAHR) && Arrays.equals(reservedIds, other.reservedIds)
				&& Arrays.equals(spareIds, other.spareIds) && Objects.equals(teams, other.teams);
	}

	@Override
	public String toString() {
		String str = super.toString();
		for (int i = 0; i < teams.size(); i++) {
			str += teams.get(i).toString();
		}
		return str;
	}

}


// найти самую не/эффектиную команду
// найти самого не/эффектвного сотрудника
// К полям класса применимы модификаторы public, protected, private, static,
// final, transient, volatile.
