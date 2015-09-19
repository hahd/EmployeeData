//PartTimeEmployee class
//Store data for a part time employee
//Freid Tong, Hahd Khan
//November 28, 2011
package employeedatabase;



//The "PartTimeEmployee" class.
public class PartTimeEmployee extends Employee
{
	//fields
	protected float hourlyWage;
	protected float hrsPerWeek;
	protected int weeksPerYear;
	protected float deductionsRate;

	//constructors
	public PartTimeEmployee ()
	{
		firstName = " ";
		middleName = " ";
		lastName = " ";
	}


	//methods to get and set field values
	public float getHourlyWage ()
	{
		return hourlyWage;
	}


	public void setHourlyWage (float hourlyWage)
	{
		this.hourlyWage = hourlyWage;
	}


	public float getHrsPerWeek ()
	{
		return hrsPerWeek;
	}


	public void setHrsPerWeek (float hrsPerWeek)
	{
		this.hrsPerWeek = hrsPerWeek;
	}


	public int getWeeksPerYear ()
	{
		return weeksPerYear;
	}


	public void setWeeksPerYear (int weeksPerYear)
	{
		this.weeksPerYear = weeksPerYear;
	}


	public float getDeductionsRate ()
	{
		return deductionsRate;
	}


	public void setDeductionsRate (float deductionsRate)
	{
		this.deductionsRate = deductionsRate;
	}
} // PartTimeEmployee class
