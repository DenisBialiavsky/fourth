package model.factory;

import static model.logic.Utils.rand;

import model.entity.Accountant;
import model.entity.Boss;
import model.entity.DevHR;
import model.entity.Developer;
import model.entity.Employee;
import model.entity.PM;
import model.entity.QA;
import model.entity.QAHR;
import model.logic.MyList;
import model.logic.Storable;

public class AnotherFactory {

	final static String[] names = { "Valera", "Ivan", "Oleg", "Max", "Sasha", "Piter", "Boris", "Ignat" };
	final static int MIN_AGE = 18;
	final static int MAX_AGE = 50;
	final static int MIN_COST = 1000;
	final static int MAX_COST = 2000;
	final static int DEFAULT_ID = 0;
	final static int MIN_SKILL = 10;
	final static int MAX_SKILL = 100;
	
	public AnotherFactory() {
		// TODO Auto-generated constructor stub
	}

	public Storable<Employee> getEmployee(String type, int amount) {
		if (type == null) {
			return null;
		}
		Storable<Employee> ms = new MyList();
		for (int i = 0; i < amount; i++) {
			switch (type.toLowerCase()) {
			case "devhr" :
				ms.add(new DevHR(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), true, DEFAULT_ID, null,null,
						"DevelHR", rand(MIN_COST, MAX_COST)));
				break;
			case "qahr" :
				ms.add(new QAHR(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), true, DEFAULT_ID, null,null, "QAHR",
						rand(MIN_COST, MAX_COST)));
				break;
			case "pm" :
				ms.add(new PM(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), true, DEFAULT_ID, null,null, "ProjMan",
						rand(MIN_COST, MAX_COST)));
				break;
			case "boss":
				ms.add(new Boss(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), true, DEFAULT_ID, null,null, "Boss",
						rand(MIN_COST, MAX_COST)));
				break;
			case "developer" :
				ms.add(new Developer(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), false, DEFAULT_ID, null,
						null, "Develop", rand(MIN_COST, MAX_COST), rand(MIN_SKILL, MAX_SKILL)));
				break;
			case "qa" :
				ms.add(new QA(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), false, DEFAULT_ID, null, null,
						"QA", rand(MIN_COST, MAX_COST)));
				break;
			case "accountant" :
				ms.add(new Accountant(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), true, DEFAULT_ID, null,null, "Accountant",
						rand(MIN_COST, MAX_COST)));
				break;
			}
		}
		return ms;
	}

}
