package model.entity;

import static model.logic.MyFactory.createQA;
import static view.Output.*;

import model.logic.MyArray;
import model.logic.Storable;

public class QAHR extends HR {

	public QAHR() {

	}

	public QAHR(String name, int age, boolean isHasJob, int id, String placeOfWork, String calling, int cost) {
		super(name, age, isHasJob, id, placeOfWork, calling, cost);
	}

	public Storable<Employee> searchApplyers(int PreferableNmberOfCandidats) {
		return createQA(PreferableNmberOfCandidats, false);
	}

	public Storable<Employee> interview(int n, Storable<Employee> aspirants) {
		Storable<Employee> accepted = new MyArray();
		int counter = 0;
		for (int i = 0; i < aspirants.size(); i++) {
			if ((aspirants.get(i).getClass() == new AutoQA().getClass()
					|| aspirants.get(i).getClass() == new ManualQA().getClass())
					&& ((QA) aspirants.get(i)).getCost() <= 1300) {
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
			exhibit("Very few QA aspirants !");
		}
		return accepted;
	}

	@Override
	public void work() {
		exhibitRed("QAHR is working");
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
