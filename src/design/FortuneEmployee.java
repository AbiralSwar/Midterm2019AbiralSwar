package design;

public class FortuneEmployee {

	/**
	 * FortuneEmployee class has a main methods where you will be able to create Object from
	 * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible 
	 * to use with proper business work flow.Think as a Software Architect, Product Designer and 
	 * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
	 * more to design an application that will meet for fortune 500 Employee Information
	 * Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/
	public static void main(String[] args) {

		EmployeeInfo e1 = new EmployeeInfo("Prashant", 101);
		e1.setdeptName("Sales");
		e1.setSalary(50000.00);
		EmployeeInfo.calculateEmployeePension();
		System.out.println(e1.getnumberOfYears());
		EmployeeInfo.calculateEmployeeBonus(e1.getnumberOfYears(), e1.getSalary());



		EmployeeInfo e2 = new EmployeeInfo("Khadka", 101, "QA", 30000.00);

		EmployeeInfo.calculateEmployeePension();
		EmployeeInfo.calculateEmployeeBonus(e1.getnumberOfYears(), e2.getSalary());
		//EmployeeInfo.setCompanyName("PNT");


	}

}
