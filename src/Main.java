import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    // Display a home screen with a message explaining the program.
        System.out.println("This is a programme designed to calculate your dued tax.");
        System.out.println("This programmes include calculations for the five allowances and five deductions, taxes are calculated through the progressive tax rate.");
        System.out.println("All values will be displayed in HKD");

    // save all user information
        ArrayList<User> userInfo = new ArrayList<>();


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter q to quit, enter n to record a new user: ");
            String tag = sc.next();

            // quit
            if (tag.equals("q")) {
                break;
            }

            System.out.print("Please input your first name: ");
            String firstName = sc.next();

            System.out.print("Please input your last name: ");
            String lastName = sc.next();

            System.out.print("Please input your age: ");
            int age = sc.nextInt();

            User user = new User(firstName, lastName, age);

            System.out.print("How much is your income: ");
            int income = sc.nextInt();
            user.setIncome(income);

            System.out.print("Are you married (y or n): ");
            String married = sc.next();
            user.setMarried(married);

            System.out.print("How many children do you have: ");
            int children = sc.nextInt();
            user.setChildren(children);

            System.out.print("How many dependent brothers and sisters do you have: ");
            int brotherSister = sc.nextInt();
            user.setBrotherSister(brotherSister);

            System.out.print("Are you a single parent? (y or n): ");
            String singleParent = sc.next();
            user.setSingleParent(singleParent);

            System.out.print("Are you disabled? (y or n): ");
            String disability = sc.next();
            user.setDisability(disability);

            System.out.print("How much is your expense in self education: ");
            int education = sc.nextInt();
            user.setEducation(education);

            System.out.print("How much is your expense in Elderly Residential Care Expenses: ");
            int elderlyCare = sc.nextInt();
            user.setElderlyCare(elderlyCare);

            System.out.print("How much is your expense in Home Loan Interest: ");
            int loanInterest = sc.nextInt();
            user.setLoanInterest(loanInterest);

            System.out.print("How much is your expense in Home Mandatory Contributions to Recognized Retirement Schemes : ");
            int retirement = sc.nextInt();
            user.setRetirement(retirement);

            System.out.print("How much is your expense in Qualifying Annuity Premiums and Tax Deductible MPF Voluntary Contributions : ");
            int mpf = sc.nextInt();
            user.setMPF(mpf);

            // user input finish
            int nci = user.getNCI();
            int tax = Tax.getTax(nci);
            user.setTax(tax);
            System.out.println("the tax due is: " + tax);

            // save info in arraylist
            userInfo.add(user);
        }

        // save user information in file
        CsvFileUtil.saveInfoToCsv(userInfo);

    }
}