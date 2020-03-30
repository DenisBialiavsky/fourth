package model.entity;

import model.logic.MyFactory;
import model.logic.Storable;

import static model.logic.Utils.*;
import static view.Output.*;

import java.util.*;

public abstract class HR extends Employee {

	public final static int THRESHOLD = 40;

	//public int field =4;//not compalsary final in abstract class 
	
	public HR() {

	}

	public HR(HR hr) {
		super(hr);
	}

	public HR(String name, int age, boolean isHasJob, int id, String placeOfWork, String calling, int cost) {
		super(name, age, isHasJob, id, placeOfWork, calling, cost);
	}

	
	public abstract Storable<Employee> searchApplyers(int PreferableNmberOfCandidats);

	public abstract Storable<Employee> interview(int n, Storable<Employee> employees);

	public void showAspirants(Storable<Employee> aspirants) {
		for (int i = 0; i < aspirants.size(); i++) {
			exhibit(aspirants.get(i).toString());
		}
	}

	@Override
	public void work() {
		exhibitRed("Human Resource is working!");
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
