package model.entity;

import static view.Output.exhibitRed;

public class ManualQA extends QA {

	public ManualQA(String name, int age, boolean isHasJob, int id, String placeOfWork, String calling, int cost) {
		super(name, age, isHasJob, id, placeOfWork, calling, cost);
	}

	public ManualQA() {

	}

	@Override
	public void work() {
		exhibitRed(this.getName() + " is testing product!");
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
