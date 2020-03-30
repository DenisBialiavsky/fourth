package model.entity;

import model.entity.groups.ITCompany;
import model.entity.groups.ProjectTeam;
import static view.Output.exhibit;;

public class Accountant extends Employee {

	public Accountant(String name, int age, boolean isHasJob, int id, ITCompany placeOfWork, ProjectTeam project,
			String calling, int cost) {
		super(name, age, isHasJob, id, placeOfWork, project, calling, cost);
	}

	public Accountant(Accountant pm) {
		super(pm);
	}
//the chippest...
	public int countExps() {
		int sum = 0;
		for (int i = 0; i < placeOfWork.getTeams().size(); i++) {
			sum += countExps(placeOfWork.getTeams().get(i));
		}
		return sum;
	}

	public int countProfit() {
		int sum = 0;
		for (int i = 0; i < placeOfWork.getTeams().size(); i++) {
			sum += countProfit(placeOfWork.getTeams().get(i));
		}
		return sum;
	}

	public int countExps(ProjectTeam project) {
		int sum = 0;
		for (int i = 0; i < project.getMember().size(); i++) {
			sum += project.getMember().get(i).getCost();
		}
		return sum * project.getTimeToDevProject();
	}

	public int countProfit(ProjectTeam project) {
		return project.getBudget() - countExps(project);
	}

	public int countAllBudgets() {
		int result = 0;
		for (int i = 0; i < placeOfWork.getTeams().size(); i++) {
			result += placeOfWork.getTeams().get(i).getBudget();
		}
		return result;
	}
	
	@Override
	public void work() {
		exhibit("Accountant is counting!");
	}

}
