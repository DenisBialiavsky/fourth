package model.entity;

import model.entity.groups.ProjectTeam;
import model.logic.Storable;

import static model.logic.Utils.*;
import static view.Output.*;

import javafx.concurrent.Worker;

public class Boss extends PM {

	public Boss() {

	}

	public Boss(Boss boss) {
		super(boss);
	}

	public Boss(String name, int age, boolean isHasJob, int id, String placeOfWork, String calling, int cost) {
		super(name, age, isHasJob, id, placeOfWork, calling, cost);
		return;
	}

	public void compelToWork(Workable... ms) {
		for (int i = 0; i < ms.length; i++) {
			ms[i].work();
		}
		exhibit("\n");
	}
	
	public int countAllExpens(Storable<ProjectTeam> ms) {
		int res=0;
		for(int i =0; i< ms.size(); i++) {
			res+=ms.get(i).countExps();
		}
		return res;
	}
	
	public int countAllProfit(Storable<ProjectTeam> ms) {
		int res=0;
		for(int i =0; i< ms.size(); i++) {
			res+=ms.get(i).countProfit();
		}
		return res;
	}
	
	public int countAllBudgets(Storable<ProjectTeam> ms) {
		int res=0;
		for(int i =0; i< ms.size(); i++) {
			res+=ms.get(i).getBudget();
		}
		return res;
	}

	public void fireMember(Employee currentBoss, Employee currentPM, Employee currentDevHR, Employee currentQAHR,
			int id, Storable<ProjectTeam> teams) {
		if (isCommonId(id, currentBoss, currentPM, currentDevHR, currentQAHR)) {
			exhibit("You can't fire current employee!");
		} else {
			int teamNumber = searchTeamIndexById(teams, id);
			int empNumber = searchEmpIndexById(teams.get(teamNumber).getMember(), id);
			teams.get(teamNumber).getMember().remove(empNumber);
		}
	}

	public void dissolveTeam(Employee currentBoss, Employee currentPM, Employee currentDevHR, Employee currentQAHR,
			String name, Storable<ProjectTeam> teams) {
		int ProjectTeamNum = ((PM) currentPM).searchProjectTeamByName(teams, name);
		for (int i = 0; i < teams.get(ProjectTeamNum).getMember().size(); i++) {
			if (((PM) currentPM).isCommonId(((Employee) teams.get(ProjectTeamNum).getMember().get(i)).getId(),
					currentBoss, currentPM, currentDevHR, currentQAHR)) {
				exhibit("You can't dissolve team that contains current employees!");
				return;
			}
		}
		teams.remove(ProjectTeamNum);
	}


	@Override
	public int hashCode() {
		return super.hashCode();
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
		return true;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
