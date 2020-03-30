package model.entity;

import static view.Output.exhibitRed;

import java.util.*;

import model.logic.MyArray;
import model.logic.Storable;

import static model.logic.MyFactory.*;
import static model.logic.Utils.*;
import static view.Output.*;

public class DevHR extends HR {

	// биржа труда вакантные дожности
	// то что меньше платит меньше
	// рандом

	public DevHR() {
		
	}

	public DevHR(DevHR hr) {
		super(hr);
	}

	public DevHR(String name, int age, boolean isHasJob, int id, String placeOfWork, String calling, int cost) {
		super(name, age, isHasJob, id, placeOfWork, calling, cost);
	}

	public Storable<Employee> searchApplyers(int PreferableNmberOfCandidats) {
		return createDev(PreferableNmberOfCandidats, false);
	}

	public Storable<Employee> interview(int n, Storable<Employee> aspirants) {
		Storable<Employee> accepted = new MyArray();
		int counter = 0;
		for (int i = 0; i < aspirants.size(); i++) {
			if ((aspirants.get(i).getClass() == new JavaDev().getClass()
					|| aspirants.get(i).getClass() == new CSharpDev().getClass())
					&& ((Developer) aspirants.get(i)).getSkill() >= THRESHOLD) {
				aspirants.get(i).setIsHasJob(true);
				accepted.add(aspirants.get(i));
				aspirants.remove(i--);
				counter++;
			}
			if (counter == n) {
				break;
			}
		}
		if (counter < n) {
			exhibit("Very few Developer aspirants !");
		}
		return accepted;
	}

	@Override
	public void work() {
		exhibitRed("DevHR is working");
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
