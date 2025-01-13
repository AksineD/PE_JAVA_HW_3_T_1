import java.util.Scanner;

    public class WorkersConditions {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // קליטת נתוני המבקש
            System.out.print("הכנס גיל: ");
            int age = scanner.nextInt();

            System.out.print("הכנס מספר שנות ניסיון: ");
            int yearsOfExperience = scanner.nextInt();

            System.out.print("האם יש לך תעודת בגרות? (כן/לא): ");
            String bagrutInput = scanner.nextLine();

            // המרה לערך בוליאני
            boolean hasBagrut = bagrutInput.equalsIgnoreCase("כן");

            // בדיקה אם המבקש עומד בדרישות
            boolean meetsAgeReq = age > 20;
            boolean meetsBagrutReq = hasBagrut;
            boolean meetsExperienceReq = yearsOfExperience >= 3;

            if (meetsAgeReq && meetsBagrutReq && meetsExperienceReq) {
                // המבקש התקבל
                System.out.println("המבקש התקבל לעבודה.");
            } else {
                // המבקש לא התקבל - נפרט את הסיבות
                System.out.println("המבקש לא התקבל לעבודה בגלל הסיבות הבאות:");
                if (!meetsAgeReq) {
                    System.out.println("- המבקש אינו מעל גיל 20.");
                }
                if (!meetsBagrutReq) {
                    System.out.println("- למבקש אין תעודת בגרות.");
                }
                if (!meetsExperienceReq) {
                    System.out.println("- למבקש פחות מ-3 שנות ניסיון.");
                }
            }
            scanner.close();
        }
    }