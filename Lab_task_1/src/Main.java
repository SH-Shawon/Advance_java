import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Officer> officers = new Vector<Officer>(3);
        Vector<Staff> staffs = new Vector<Staff>(3);
        boolean flag = true;
        while (flag){
            Scanner sc = new Scanner(System.in);
        System.out.println("If you are officer please enter \"1\"");
        System.out.println("Enter \"2\" if you are staff");
        int choice = sc.nextInt();

            System.out.println("Enter your ID: ");
            Scanner sc2 = new Scanner(System.in);
            String id = sc2.nextLine();

            System.out.println("Enter your Name: ");
            Scanner sc1 = new Scanner(System.in);
            String name = sc1.nextLine();

            System.out.println("Enter your birth Year: ");
            Scanner sc3 = new Scanner(System.in);
            int year = sc3.nextInt();
            System.out.println("Enter your birth Month: ");
            Scanner sc4 = new Scanner(System.in);
            int month = sc4.nextInt();
            System.out.println("Enter your birth Date: ");
            Scanner sc5 = new Scanner(System.in);
            int date = sc5.nextInt();
            LocalDate dob = LocalDate.of(year,month,date);

            System.out.println("Enter your Email: ");
            Scanner sc6 = new Scanner(System.in);
            String email = sc6.nextLine();

            System.out.println("Enter your Joining Year: ");
            Scanner sc7 = new Scanner(System.in);
            int year1 = sc7.nextInt();
            System.out.println("Enter your Joining Month: ");
            Scanner sc8 = new Scanner(System.in);
            int month1 = sc8.nextInt();
            System.out.println("Enter your Joining Date: ");
            Scanner sc9 = new Scanner(System.in);
            int date1 = sc9.nextInt();
            LocalDate joiningDate = LocalDate.of(year1,month1,date1);

            //close loop
            System.out.println("Press '=' to stop input and See Details");
            Scanner exitInput = new Scanner(System.in);
            String input = exitInput.nextLine();
            if(input.equals("=")){
                flag = false;
            }

            switch (choice){
                case 1:
                {
                    Officer o = new Officer(id,name,dob,email,joiningDate);
                    officers.add(o);
                    break;
                }
                case 2:
                {
                    Staff s = new Staff(id,name,dob,email,joiningDate);
                    staffs.add(s);
                    break;
                }
                default:
                    break;
            }
        }
        if(!officers.isEmpty()){
            for (var i:officers){
                i.showDetails();
            }
        }
        if(!staffs.isEmpty()){
            for (var i:staffs){
                i.showDetails();
            }
        }
    }
}
