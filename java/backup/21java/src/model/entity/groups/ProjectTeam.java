package model.entity.groups;

import static model.logic.Utils.*;

import java.util.*;

import model.*;
import model.entity.Employee;
import model.entity.Workable;
import model.logic.MyArray;
import model.logic.Storable;

public class ProjectTeam extends Group implements Workable{
	private Storable<Employee> member = new MyArray();
	private int timeToDevProject;
	private int budget;

	public ProjectTeam(String name, int budget, int timeToDevProject, Storable<Employee> members) {
		super(name);
		this.budget = budget;
		this.timeToDevProject = timeToDevProject;
		member = members;
	}

	public ProjectTeam(Storable<Employee> members) {
		member = members;
	}

	public ProjectTeam(String name, int budget, int timeToDevProject) {
		super(name);
		this.budget = budget;
		this.timeToDevProject = timeToDevProject;
	}

	public Storable<Employee> getMember() {
		return member;
	}

	public void setMember(Storable<Employee> member) {
		this.member = member;
	}

	public int getTimeToDevProject() {
		return timeToDevProject;
	}

	public void setTimeToDevProject(int timeToDevProject) {
		this.timeToDevProject = timeToDevProject;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public void addMember(Employee ms) {
		member.add(ms);
	}

	public int countExps() {
		int sum = 0;
		for (int i = 0; i < member.size(); i++) {
			sum += member.get(i).getCost();
		}
		return sum * timeToDevProject;
	}

	public int countProfit() {
		return budget - countExps();
	}
	
	
	
	@Override
	public void work() {
		for(int i = 0; i< member.size(); i++) {
			member.get(i).work();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(budget, member, timeToDevProject);
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
		ProjectTeam other = (ProjectTeam) obj;
		return budget == other.budget && Objects.equals(member, other.member)
				&& timeToDevProject == other.timeToDevProject;
	}

	@Override
	public String toString() {
		String res = "\n" + getName() + "\n" + "Budget=" + budget + "\nTerm=" + timeToDevProject + "\n";

		for (int i = 0; i < member.size(); i++) {
			res += member.get(i).toString();
			res += "\n";
		}
		return res + "\n";
	}

}
