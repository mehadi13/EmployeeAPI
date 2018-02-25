package com.bjit.training.employee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String bankAccount;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="home_address")
	private String homeAddress;

	@Column(name="identification_no")
	private String identificationNo;

	private String name;

	@Column(name="passport_no")
	private String passportNo;

	@Column(name="photo_url")
	private String photoUrl;

	@Column(name="work_address")
	private String workAddress;

	@Column(name="work_email")
	private String workEmail;

	@Column(name="work_location")
	private String workLocation;

	@Column(name="work_mobile")
	private String workMobile;

	@Column(name="work_phone")
	private String workPhone;

	//bi-directional many-to-one association to Gender
	@ManyToOne
	private Gender gender;

	//bi-directional many-to-one association to Maritialstatus
	@ManyToOne
	private MaritalStatus maritalStatus;

	//bi-directional many-to-one association to Nationality
	@ManyToOne
	private Nationality nationality;

	//bi-directional many-to-one association to Jobtitle
	@ManyToOne
	private JobTitle jobTitle;

	//bi-directional many-to-one association to Department
	@ManyToOne
	private Department department;

	//bi-directional many-to-one association to Jobtype
	@ManyToOne
	private JobType jobType;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee manager;

	/*//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employee1")
	private List<Employee> employees1;*/

	//bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee coach;

	/*//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employee2")
	private List<Employee> employees2;*/

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankaccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getIdentificationNo() {
		return this.identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getWorkEmail() {
		return this.workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getWorkLocation() {
		return this.workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getWorkMobile() {
		return this.workMobile;
	}

	public void setWorkMobile(String workMobile) {
		this.workMobile = workMobile;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritialstatus() {
		return this.maritalStatus;
	}

	public void setMaritialstatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Nationality getNationality() {
		return this.nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public JobTitle getJobtitle() {
		return this.jobTitle;
	}

	public void setJobtitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public JobType getJobtype() {
		return this.jobType;
	}

	public void setJobtype(JobType jobType) {
		this.jobType = jobType;
	}

	public Employee getManager() {
		return this.manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	/*public List<Employee> getEmployees1() {
		return this.employees1;
	}

	public void setEmployees1(List<Employee> employees1) {
		this.employees1 = employees1;
	}

	public Employee addEmployees1(Employee employees1) {
		getEmployees1().add(employees1);
		employees1.setEmployee1(this);

		return employees1;
	}

	public Employee removeEmployees1(Employee employees1) {
		getEmployees1().remove(employees1);
		employees1.setEmployee1(null);

		return employees1;
	}*/
	

	public Employee getCoach() {
		return this.coach;
	}

	public void setCoach(Employee coach) {
		this.coach = coach;
	}

	/*public List<Employee> getEmployees2() {
		return this.employees2;
	}

	public void setEmployees2(List<Employee> employees2) {
		this.employees2 = employees2;
	}

	public Employee addEmployees2(Employee employees2) {
		getEmployees2().add(employees2);
		employees2.setEmployee2(this);

		return employees2;
	}

	public Employee removeEmployees2(Employee employees2) {
		getEmployees2().remove(employees2);
		employees2.setEmployee2(null);

		return employees2;
	}*/

}