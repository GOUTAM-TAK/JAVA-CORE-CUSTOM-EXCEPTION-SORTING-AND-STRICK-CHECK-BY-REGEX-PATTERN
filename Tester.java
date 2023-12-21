package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static utils.CustomerExceptionValidator.*;
import static utils.CustomerEntitiesValidator.*;
import static utils.RegexPatternCheck.*;

import core.Customer;
import core.ServicePlan;
import sortingCriteria.SorterForFirstName;
import sortingCriteria.SorterForServicePlan;




public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			List<Customer> custList = new ArrayList<>();
			boolean exit = true;

			//DEMO DATA
			custList.add(new Customer("Jayesh", "Murodiya", "jrmurodiya@gmail.com", "Jay@123", 12000, LocalDate.parse("2001-01-01"), ServicePlan.PLATINUM));
			custList.add(new Customer("Ayushi", "Lamghare", "ayushi@gmail.com", "Ayushi@123", 15000, LocalDate.parse("2001-01-01"), ServicePlan.PLATINUM));
			custList.add(new Customer("Pushkar", "Suke", "sukepushkar@gmail.com", "Pushkar@123", 8000, LocalDate.parse("2001-01-01"), ServicePlan.GOLD));
			custList.add(new Customer("Arpit", "Patidar", "aprit@gmail.com", "Arpit@123", 18000, LocalDate.parse("2001-01-01"), ServicePlan.SILVER));
			custList.add(new Customer("Mandeep", "Sharma", "mandeep@gmail.com", "Mandeep@123", 10000, LocalDate.parse("2001-01-01"), ServicePlan.GOLD));
			//DEMO DATA
			
			while (exit) {
				
				System.out.print( "+----------------------------------------+\n" 
								+ "|       Welcome to CMS Portal            |\n"
								+ "|                                        |\n"
								+ "| 1. Sign Up                             |\n"
								+ "| 2. Sign In                             |\n"
								+ "| 3. Change Password                     |\n"
								+ "| 4. UnSubscribe                         |\n"
								+ "| 5. Display All Customers               |\n"
								+ "| 6. Remove by Service Plan              |\n"
								+ "| 7. Sort by Email Id                    |\n"
								+ "| 8. Sort by First Name                  |\n"
								+ "| 9. Sort by Service Plans               |\n"
								+ "| 10. EXIT                               |\n"
								+ "+----------------------------------------+\n"
								+ " Choice: ");
				
				try {
					
					switch (sc.nextInt()) 
					{
					
					case 1:
						System.out.print("Enter Email: ");
						String mailCheckString = new String(checkEmailID(sc.next()));
						System.out.print("Enter Password: ");
						String passCheckString = new String(checkPassword(sc.next()));
						System.out.println("Enter Details [FirstName, LastName, Registration Amount, D.O.B [YYYY-MM-DD], ServicePlan");
						custList.add(validateAll(sc.next(), sc.next(), mailCheckString, passCheckString, sc.nextDouble(), sc.next(), sc.next(), custList));
						break;

					case 2:
						System.out.print("Enter Email: ");
						mailCheckString = new String(checkEmailID(sc.next()));
						System.out.print("Enter Password: ");
						passCheckString = new String(checkPassword(sc.next()));
						Customer customer = emailAndPasswordCheckExists(custList, mailCheckString, passCheckString);
						decoration(customer);
						break;	
						
					case 3:
						System.out.print("Enter Email: ");
						mailCheckString = new String(checkEmailID(sc.next()));
						System.out.print("Enter Password: ");
						passCheckString = new String(checkPassword(sc.next()));
						System.out.print("Enter Password: ");
						String passCheckString1 = new String(checkPassword(sc.next()));
						
						changePassword(custList, mailCheckString, passCheckString, passCheckString1);
						break;
	
					case 4:
						System.out.print("Enter Mail : ");
						unsubscribe(custList, sc.next());
						break;
					
						
					case 5:
						display(custList);
						break;
						
						
					case 6:
						System.out.print("\nEnter Plan to be Removed : ");
						ServicePlan plan = planCheck(sc.next());
						Iterator<Customer> itr = custList.iterator();
						while(itr.hasNext())
						{
							if(itr.next().getPlan()==plan)
							{
								itr.remove();
							}
						}
						System.out.println("Plan removed Successfully........!!!!");
						break;

						
					case 7:
						Collections.sort(custList);
						System.out.println("\n\n---------------------Sorted by Email---------------------\n");
						display(custList);
						break;
						

					case 8:
						Collections.sort(custList,new SorterForFirstName());
						System.out.println("\n\n---------------------Sorted by First Name---------------------\n");
						display(custList);
						break;
					
	
					case 9:
						Collections.sort(custList,new SorterForServicePlan());
						System.out.println("\n---------------------Sorted by Service Plan---------------------\n");
//						display(custList);
						break;
	
						
					case 10:
						exit=false;
						break;
						
	
					default:
						break;
					}
					

				} catch (Exception e) {
					System.err.println("\n"+e.getMessage());
					System.out.println("Try Again...!\n");
					sc.nextLine();
				}

			}

		}

	}

}
