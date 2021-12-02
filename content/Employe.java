package content;

import java.util.Date;

public abstract class Employe extends Person {
	protected String SerialId;
	protected double salary;
	
	public String getSerialId() {
		return SerialId;
	}
	public void setSerialId(String serialId) {
		SerialId = serialId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employe(String id, String fullName, Date bithDate, String serialId, double salary) {
		super(id, fullName, bithDate);
		SerialId = serialId;
		this.salary = salary;
	}
	
	public Employe() {
		super();
	}
	public Employe(String id, String fullName, Date bithDate) {
		super(id, fullName, bithDate);
	}
	public Employe(String id, String fullName) {
		super(id, fullName);
	}
	public Employe(String id) {
		super(id);
	}
	
	@Override
	public String toString() {
		return "\nSerialId=" + SerialId + "\nsalary=" + salary ;
	}

	
	

}
