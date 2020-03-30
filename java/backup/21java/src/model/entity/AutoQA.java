package model.entity;

import static view.Output.exhibitRed;

public class AutoQA extends QA {

	public AutoQA() {

	}

	public AutoQA(AutoQA qa) {
		super(qa);
	}

	public AutoQA(String name, int age, boolean isHasJob, int id, String placeOfWork, String calling, int cost) {
		super(name, age, isHasJob, id, placeOfWork, calling, cost);
	}

	@Override
	public void work() {
		exhibitRed(this.getName() + " is writing auto tests!");
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
