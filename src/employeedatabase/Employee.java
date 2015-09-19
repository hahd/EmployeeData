//Employee class
//Store data for an employee
//Freid Tong, Hahd Khan
//November 28, 2011
package employeedatabase;

public abstract class Employee
{
	//Fields
	protected int empNumber;
	protected boolean sex;
	protected String firstName;
	protected String middleName;
	protected String lastName;
	protected String workLocation;

	//constructor

	//methods to get and set field values
	public int getEmpNumber ()
	{
		return empNumber;
	}


	public void setEmpNumber (int empNumber)
	{
		this.empNumber = empNumber;
	}


	public boolean isSex ()
	{
		return sex;
	}


	public void setSex (boolean sex)
	{
		this.sex = sex;
	}


	public String getFirstName ()
	{
		return firstName;
	}


	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}


	public String getMiddleName ()
	{
		return middleName;
	}


	public void setMiddleName (String middleName)
	{
		this.middleName = middleName;
	}


	public String getLastName ()
	{
		return lastName;
	}


	public void setLastName (String lastName)
	{
		this.lastName = lastName;
	}


	public String getWorkLocation ()
	{
		return workLocation;
	}


	public void setWorkLocation (String workLocation)
	{
		this.workLocation = workLocation;
	}



} // Employee class



