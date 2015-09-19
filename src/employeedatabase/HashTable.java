//HashTable class
//Store multiple employee data into a hash table with 10 buckets
//Freid Tong, Hahd Khan
//November 28, 2011
package employeedatabase;
import java.util.*;
import java.io.*;

// The "HashTable" class.
public class HashTable 
{

	//Fields
	protected ArrayList[] list = new ArrayList[10];
	{
		//initialize each array
		list[0]=new ArrayList();
		list[1]=new ArrayList();
		list[2]=new ArrayList();
		list[3]=new ArrayList();
		list[4]=new ArrayList();
		list[5]=new ArrayList();
		list[6]=new ArrayList();
		list[7]=new ArrayList();
		list[8]=new ArrayList();
		list[9]=new ArrayList();
	}

	//arraylist to save all the employee numbers used to generate random employee numbers to ensure there is no repeats
	protected ArrayList<Integer> employeeNumbers = new ArrayList<Integer>();

	//Constructor
	public HashTable ()
	{
	}


	//methods

	//clears all the data stored in each of the arrays
	public void clear()
	{
		for (int i=0;i<10;i++)
		{
			list[i].clear();
		}
		employeeNumbers.clear();
	}

	//method to add full time employeee to database
	public void addFull (FullTimeEmployee employeeToAdd)
	{
		list [employeeToAdd.getEmpNumber () % 10].add (employeeToAdd);
		employeeNumbers.add((Integer)employeeToAdd.getEmpNumber());
	}

	//method to add part time employeee to database
	public void addPart (PartTimeEmployee employeeToAdd)
	{
		list [employeeToAdd.getEmpNumber () % 10].add (employeeToAdd);
		employeeNumbers.add((Integer)employeeToAdd.getEmpNumber());
	}


	//method to generate random employee numbers under 1000000
	public int generateEmpNumber ()
	{
		Random a= new Random();
		int newEmpNumber = 0;
		boolean exit = false;
		while(!exit)
		{
			exit=true;

			newEmpNumber = a.nextInt(1000000);
			for (int i=0;i<employeeNumbers.size();i++) //search to make sure it will not generate a repeated number
			{
				if (employeeNumbers.get(i)==newEmpNumber)
				{
					exit=false;
				}
			}
		}
		employeeNumbers.add(newEmpNumber);
		return newEmpNumber;
	}

	//method to remove an employee
	public void remove (int empNumber)
	{
		for (int i = 0 ; i < list [empNumber % 10].size () ; i++)
		{
			if (((Employee) list [empNumber % 10].get (i)).getEmpNumber () == empNumber)
			{
				list [empNumber % 10].remove (i);
				employeeNumbers.remove((Integer)empNumber);//remove number from employeeNumber list
				break;
			}
		}
	}

	//search for an employee in the database given the empNumber
	public Employee findEmployee (int empNumber)
	{
		for (int i = 0 ; i < list [empNumber % 10].size () ; i++)
		{
			if (((Employee) list [empNumber % 10].get (i)).getEmpNumber () == empNumber)
			{
				return ((Employee)list [empNumber % 10].get (i));
			}
		}
		return null;
	}

	//save the database into a text file called DATA.txt
	public void save() throws IOException
	{
		//using printwriter to output
		PrintWriter out = new PrintWriter (new FileWriter ("DATA.txt"));
		for (int i=0; i<10;i++)
		{
			//output from each bucket
			out.println(list[i].size());
			for (int k=0; k<list[i].size();k++)
			{
				//checks whether it is a full time employee
				if (list[i].get(k).getClass().getName().equals("employeedatabase.FullTimeEmployee"))
				{
					//output the data into text file
					out.println("Full");
					out.println(((Employee) list[i].get(k)).getEmpNumber());
					out.println(((Employee) list[i].get(k)).isSex());
					out.println(((Employee) list[i].get(k)).getFirstName());
					out.println(((Employee) list[i].get(k)).getMiddleName());
					out.println(((Employee) list[i].get(k)).getLastName());
					out.println(((Employee) list[i].get(k)).getWorkLocation());
					out.println(((FullTimeEmployee) list[i].get(k)).getSalary());
					out.println(((FullTimeEmployee) list[i].get(k)).getDeductionsRate());
					out.println(((FullTimeEmployee) list[i].get(k)).getYearsOfService());
					out.println(((FullTimeEmployee) list[i].get(k)).getDaysVacPerYear());
				}
				else if (list[i].get(k).getClass().getName().equals("employeedatabase.PartTimeEmployee"))
				{
					out.println("Part");
					out.println(((Employee) list[i].get(k)).getEmpNumber());
					out.println(((Employee) list[i].get(k)).isSex());
					out.println(((Employee) list[i].get(k)).getFirstName());
					out.println(((Employee) list[i].get(k)).getMiddleName());
					out.println(((Employee) list[i].get(k)).getLastName());
					out.println(((Employee) list[i].get(k)).getWorkLocation());
					out.println(((PartTimeEmployee) list[i].get(k)).getDeductionsRate());
					out.println(((PartTimeEmployee) list[i].get(k)).getWeeksPerYear());
					out.println(((PartTimeEmployee) list[i].get(k)).getHourlyWage());
					out.println(((PartTimeEmployee) list[i].get(k)).getHrsPerWeek());
				}
			}
		}
		out.close();

	}

	//load the database from a text file called DATA.txt
	public void load() throws IOException
	{
		//use bufferedreader for inputs
		BufferedReader in = new BufferedReader (new FileReader ("DATA.txt"));
		for (int i=0; i<10;i++)
		{
			int k=Integer.parseInt(in.readLine());
			for (int j=0;j<k;j++)
			{
				String tempString;
				tempString=in.readLine();
				//checks whether it is a full time employee
				if (tempString.equals("Full"))
				{
					//take in data from file
					FullTimeEmployee temp = new FullTimeEmployee();
					temp.setEmpNumber(Integer.parseInt(in.readLine()));
					String tempbo=in.readLine();
					if (tempbo.equals("true")){
						temp.setSex(true);
					}
					else{
						temp.setSex(false);
					}
					temp.setFirstName(in.readLine());
					temp.setMiddleName(in.readLine());
					temp.setLastName(in.readLine());
					temp.setWorkLocation(in.readLine());
					temp.setSalary(Integer.parseInt(in.readLine()));
					temp.setDeductionsRate(Float.parseFloat(in.readLine()));
					temp.setYearsOfService(Integer.parseInt(in.readLine()));
					temp.setDaysVacPerYear(Integer.parseInt(in.readLine()));
					addFull(temp);
				}
				else if (tempString.equals("Part"))
				{
					PartTimeEmployee temp = new PartTimeEmployee();
					temp.setEmpNumber(Integer.parseInt(in.readLine()));
					//temp.setSex(Boolean.getBoolean(in.readLine()));
					String tempbo=in.readLine();
					if (tempbo.equals("true")){
						temp.setSex(true);
					}
					else{
						temp.setSex(false);
					}

					temp.setFirstName(in.readLine());
					temp.setMiddleName(in.readLine());
					temp.setLastName(in.readLine());
					temp.setWorkLocation(in.readLine());
					temp.setDeductionsRate(Float.parseFloat(in.readLine()));
					temp.setWeeksPerYear(Integer.parseInt(in.readLine()));
					temp.setHourlyWage(Float.parseFloat(in.readLine()));
					temp.setHrsPerWeek(Float.parseFloat(in.readLine()));
					addPart(temp);
				}
			}
		}

	}

} // HashTable class


