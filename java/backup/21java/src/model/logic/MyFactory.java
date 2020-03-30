package model.logic;

import static model.logic.Utils.*;

import model.entity.AutoQA;
import model.entity.Boss;
import model.entity.CSharpDev;
import model.entity.DevHR;
import model.entity.Employee;
import model.entity.HR;
import model.entity.JavaDev;
import model.entity.ManualQA;
import model.entity.PM;
import model.entity.QAHR;

public class MyFactory {
//—писок инициализации разрешаетс€ использовать или при объ€влении массива: String data[] = {"one", "two", "three"};
	//или при создании массива с помощью оператора new: data = new String[] {"one", "two", "three"};
	private final static String[] names = { "Valera", "Ivan", "Oleg", "Max", "Sasha", "Piter", "Boris", "Ignat" };
	private final static int MIN_AGE = 18;
	private final static int MAX_AGE = 50;
	private final static int MIN_SKILL = 10;
	private final static int MAX_SKILL = 100;
	private final static int MIN_COST = 1000;
	private final static int MAX_COST = 2000;
	private final static int DEFAULT_ID = 0;

	private MyFactory() {

	}

	public static Storable<Employee> createDev(int n, boolean flag) {		
		Storable<Employee> ms = new MyList();
		int minSkill;
		if (flag) {
			minSkill = HR.THRESHOLD;
		} else {
			minSkill = MIN_SKILL;
		}

		for (int i = 0; i < n; i++) {
			if (rand(1, 2) == 1) {//UP CAST
				ms.add(new JavaDev(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), flag, DEFAULT_ID, null,
						"JavaDev", rand(MIN_COST, MAX_COST), rand(minSkill, MAX_SKILL)));

			} else {
				ms.add(new CSharpDev(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), flag, DEFAULT_ID, null,
						"C#__Dev", rand(MIN_COST, MAX_COST), rand(minSkill, MAX_SKILL)));
			}

		}
		return ms;
	}

	public static Storable<Employee> createQA(int n, boolean flag) {
		Storable<Employee> ms = new MyList();
		for (int i = 0; i < n; i++) {
			if (rand(1, 2) == 1) {
				ms.add(new AutoQA(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), flag, DEFAULT_ID, null,
						"AutomQA", rand(MIN_COST, MAX_COST)));

			} else {
				ms.add(new ManualQA(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), flag, DEFAULT_ID, null,
						"Manl_QA", rand(MIN_COST, MAX_COST)));
			}

		}
		return ms;
	}

	public static Storable<Employee> createPM(int n) {
		Storable<Employee> ms = new MyList();
		for (int i = 0; i < n; i++) {
			ms.add(new PM(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), true, DEFAULT_ID, null, "ProjMan",
					rand(MIN_COST, MAX_COST)));
		}
		return ms;
	}

	public static Storable<Employee> createDevHR(int n) {
		Storable<Employee> ms = new MyList();
		for (int i = 0; i < n; i++) {
			ms.add(new DevHR(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), true, DEFAULT_ID, null,
					"DevelHR", rand(MIN_COST, MAX_COST)));
		}
		return ms;
	}

	public static Storable<Employee> createQAHR(int n) {
		Storable<Employee> ms = new MyList();
		for (int i = 0; i < n; i++) {
			ms.add(new QAHR(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), true, DEFAULT_ID, null, "QAHR",
					rand(MIN_COST, MAX_COST)));
		}
		return ms;
	}

	public static Boss createBoss() {
		return new Boss(names[rand(0, names.length - 1)], rand(MIN_AGE, MAX_AGE), true, DEFAULT_ID, null, "TheBoss",
				rand(MIN_COST, MAX_COST));
	}

}
