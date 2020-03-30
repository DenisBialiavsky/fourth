package model.entity;

import static view.Output.*;

public class CSharpDev extends Developer {

	public CSharpDev() {

	}

	public CSharpDev(String name, int age, boolean isHasJob, int id, String placeOfWork, String calling, int cost,
			int skill) {
		super(name, age, isHasJob, id, placeOfWork, calling, cost, skill);
	}

	public CSharpDev(Developer dev) {
		super(dev);
	}

	@Override
	public void work() {
		exhibit(this.getName() + "\t is writing C# code!");
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
