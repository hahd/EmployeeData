//FullTimeEmployee class
//Store data for a full time employee
//Freid Tong, Hahd Khan
//November 28, 2011
package employeedatabase;


//The "FullTimeEmployee" class.
public class FullTimeEmployee extends Employee
{
	//Fields
	protected int salary;
	protected float deductionsRate;
	protected int yearsOfService;
	protected int daysVacPerYear;

	//constructor
	public FullTimeEmployee ()
	{
		firstName = " ";
		middleName = " ";
		lastName = " ";
	}


	//methods to get and set field values
	public int getSalary ()
	{
		return salary;
	}


	public void setSalary (int salary)
	{
		this.salary = salary;
	}


	public float getDeductionsRate ()
	{
		return deductionsRate;
	}


	public void setDeductionsRate (float deductionsRate)
	{
		this.deductionsRate = deductionsRate;
	}


	public int getYearsOfService ()
	{
		return yearsOfService;
	}


	public void setYearsOfService (int yearsOfService)
	{
		this.yearsOfService = yearsOfService;
	}


	public int getDaysVacPerYear ()
	{
		return daysVacPerYear;
	}


	public void setDaysVacPerYear (int daysVacPerYear)
	{
		this.daysVacPerYear = daysVacPerYear;
	}
} // FullTimeEmployee class
