package solaire.utility;

import solaire.model.SolaireBean;

public class BeanFactory {
	
	public static SolaireBean getFactoryBean(String lastName, 
		String firstName, String position, 
		String department) {
		
		SolaireBean employee = new SolaireBean();
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setPosition(position);
		employee.setDepartment(department);
		return employee;
	}
}
