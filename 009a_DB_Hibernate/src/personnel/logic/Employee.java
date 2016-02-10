package personnel.logic;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 5469876804914977062L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", unique = true, nullable = false)
	private Integer employeeId;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "age", nullable = false)
	private Integer age;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_account", joinColumns = {
			@JoinColumn(name = "employee_id", referencedColumnName = "employee_id") }, inverseJoinColumns = {
					@JoinColumn(name = "account_id", referencedColumnName = "account_id") })
	private Set<Account> accounts;
	
	public Employee() {
	}
	
	

	public Employee(String name, Integer age) {
		this.name = name;
		this.age = age;
	}



	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

}
