package com.revature.menu;

public class transactionMenu implements Menu {

	@Override
	public void display() {

		int choice = 0;
		do {
			System.out.println("=================     Transaction Menu     =================");
			System.out.println("                < 2. View Account Transactions >");
			System.out.println("                   < 3. Make a Deposit >");
			System.out.println("                  < 4. Make a Withdrawal >");
			System.out.println("                        < 1. Back >");
			System.out.println("============================================================");

			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (choice) {
			case 1:
				break;
			case 2:
				System.out.println("                   Enter Account Username");
				String un = sc.nextLine();
				un.toString();
				System.out.println(un);
				break;

				
				
				
				
				
				
				
			// DEPOSIT transaction ================================
			case 3:

				System.out.println("                   Enter Account Username");
				String un2 = sc.nextLine();
				un2.toString();

				while (choice != 1) {

					System.out.println("            How much do you want to DEPOSIT " + un2 + "?");
					double depo = 0;
					try {
						depo = sc.nextDouble();
						sc.nextLine();
					} catch (NumberFormatException e) {
					}
					
					// confirmation on DEPOSIT
					System.out.println("                  You want to DEPOSIT $" + depo + "?");
					System.out.println("                             < 2. YES >");
					System.out.println("                             < 3. NO >");
					System.out.println("                            < 1. Cancel >");

					choice = 0;

					try {
						choice = Integer.parseInt(sc.nextLine());
					} catch (NumberFormatException e) {
					}

					switch (choice) {
					case 1:
						break;
						
					// DEPOSIT transaction running
					case 2:
						System.out.println(choice);
						System.out.println(" running......");
						// code for sql query
						break;
					case 3:
						break;
					default:
						System.out.println("invalide choice");
					}
				}

				// end of DEPOSIT transaction ================================
				break;

				
				
				
				
				
				
				
				
				
				
			// Withdrawal transaction ================================
			case 4:
				System.out.println("                   Enter Account Username");
				String un3 = sc.nextLine();
				un3.toString();
				
				while (choice != 1) {
				System.out.println("                   How much do you want to WITHDRAWL " + un3 + "?");
				
				double depo = 0;
				try {
					depo = sc.nextDouble();
					sc.nextLine();
				} catch (NumberFormatException e) {
				}
				
				// confirmation on WITHDRAWAL
				System.out.println("                  You want to WITHDRAWAL $" + depo + "?");
				System.out.println("                             < 2. YES >");
				System.out.println("                             < 3. NO >");
				System.out.println("                            < 1. Cancel >");

				choice = 0;

				try {
					choice = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {
				}

				switch (choice) {
				case 1:
					break;
					
				// WITHDRAWAL transaction running
				case 2:
					System.out.println(choice);
					System.out.println(" running......");
					// code for sql query
					break;
				case 3:
					break;
				default:
					System.out.println("invalide choice");
				}
			}
			
				// end of Withdrawal transaction ================================
				break;

				
				
				
			default:
				System.out.println("                       Invalid Choice");
				break;
			}
		} while (choice != 1);

	}

}
