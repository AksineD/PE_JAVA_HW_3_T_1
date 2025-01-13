import java.util.Scanner;

    public class WorkersConditions {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int age, experiance;
            boolean highSchoolDiploma;
            String msg = "The applicant was not hired.";
            System.out.print("Pease enter your age: ");
            age = scanner.nextInt();
            System.out.print("Did you have high school diploma? ");
            highSchoolDiploma = scanner.nextBoolean();
            System.out.print("How many years of experience do you have? ");
            experiance = scanner.nextInt();

            if (age > 20) {
                if (highSchoolDiploma) {
                    if (experiance > 3) {
                        System.out.println("The applicant was hired.");
                    } else {
                        System.out.println(msg + "you need more experience");
                    }
                } else {
                    System.out.println(msg + "you need high school diploma");
                }
            } else {
                System.out.println(msg + "you need to be older than 20");
            }
        }
    }