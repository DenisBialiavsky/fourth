package model.entity;

import static model.logic.Utils.*;
import static view.Output.*;

import java.util.*;

import model.entity.groups.ProjectTeam;
import model.logic.Storable;

public class PM extends Employee {

	public PM() {

	}

	public PM(String name, int age, boolean isHasJob, int id, String placeOfWork, String calling, int cost) {
		super(name, age, isHasJob, id, placeOfWork, calling, cost);
	}
	
	public PM(PM pm) {
		super(pm);	
	}
	
	/*
	 * ѕредопределЄнна€ аннотаци€ @Override используетс€ дл€ вы€влени€ логических ошибок на этапе компил€ции.
	 *  Ётой аннотацией желательно помечать каждый метод, который будет перекрывать метод из суперкласса 
	 *  или реализовывать метод из интерфейса. ≈сли в суперклассе или интерфейсе нет метода с такой же сигнатурой,
	 *   то возникнет ошибка компил€ции. Ёто позвол€ет легко вы€вл€ть ситуации,
	 *    когда в суперклассе или интерфейсе была удалена или изменена сигнатура перекрываемого метода.*/

	

	public boolean isCommonId(int id, Employee ... ms) {
		boolean res = false;
		for(int i=0; i<ms.length; i++) {
			if(ms[i].getId()==id) {
				res = true;
				break;
			}
		}
		return res;
	}

	public int searchProjectTeamByName(Storable<ProjectTeam> teams, String name) {
		int res = Integer.MAX_VALUE;
		for(int i = 0 ; i<teams.size(); i++) {
			if(teams.get(i).getName().equals(name)) {
				res = i;
			}
		}
		return res;
	}
	
	public Employee searchById(Storable<ProjectTeam> teams, int elem) {
		Employee res = null;
		for(int i = 0 ; i<teams.size(); i++) {
			if(search(teams.get(i).getMember(), elem) !=null) {
				res=search(teams.get(i).getMember(), elem);
				break;
			}
		}
		return res;
	}
	
	public int searchTeamIndexById(Storable<ProjectTeam> teams,int id) {
		int res = 0;
		for(int i = 0 ; i<teams.size(); i++) {
			if(search(teams.get(i).getMember(), id) != null) {
				res = i;
				break;
			}
		}
		return res;
	}
	
	public int searchEmpIndexById(Storable storable,int id) {
		int res=0;
		for(int i=0; i<storable.size(); i++) {
			if(((Employee) storable.get(i)).getId()==id) {
				res = i;
			}
		}
		return res;
	}
	


	public void showDevs(Developer[] ms) {
		for (int i = 0; i < ms.length; i++) {
			exhibit(ms[i].toString());
		}
	}

	/*public Developer[] sortList(Developer[] ms, String key) {
		// ms dev[]
		// no plural return
		switch (key) {
		case "age":
			return sortAge(ms);
		//case "skill":
			//return sortSkill(ms);
		case "name":
			return sortName(ms);
		default:
			return null;
		}
	}*/
	
	@Override
	public void work() {
		exhibitRed("Project manager is working!");
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
