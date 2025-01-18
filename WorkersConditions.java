import java.util.Scanner;

    public class WorkersConditions {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int age = getValidInteger(scanner, "הכנס גיל (מספר שלם חיובי): ", 1, 120);
            int yearsOfExperience = getValidInteger(scanner, "הכנס מספר שנות ניסיון (מספר שלם חיובי): ", 0, 120);
            boolean hasBagrut = getYesNoAnswer(scanner, "האם יש לך תעודת בגרות? (כן/לא): ");

            printEligibility(age, yearsOfExperience, hasBagrut);
            scanner.close();
        }

        /**
         * קורא מהמשתמש מספר שלם ובודק שהוא בטווח הרצוי.
         *
         * @param scanner     אובייקט Scanner לקבלת קלט
         * @param prompt      טקסט שמוצג למשתמש
         * @param minValue    ערך תחתון מותר
         * @param maxValue    ערך עליון מותר
         * @return            מספר שלם תקין בטווח
         */
        private static int getValidInteger(Scanner scanner, String prompt, int minValue, int maxValue) {
            int value;
            while (true) {
                System.out.print(prompt);
                // בדיקה האם הקלט הוא מספר שלם
                if (scanner.hasNextInt()) {
                    value = scanner.nextInt();
                    scanner.nextLine(); // מנקה את התור (buffer) משאריות
                    // בדיקה שהערך בטווח הרצוי
                    if (value >= minValue && value <= maxValue) {
                        return value;
                    } else {
                        System.out.println("הערך חייב להיות בין " + minValue + " ל-" + maxValue + ".");
                    }
                } else {
                    // במידה והמשתמש לא הכניס מספר שלם
                    System.out.println("נא להזין מספר שלם בלבד.");
                    scanner.nextLine(); // מנקה את התור (buffer)
                }
            }
        }

        /**
         * קורא מהמשתמש תשובה לשאלה של כן/לא (בעברית "כן"/"לא").
         *
         * @param scanner אובייקט Scanner לקבלת קלט
         * @param prompt  טקסט שמוצג למשתמש
         * @return        true אם המשתמש ענה "כן", אחרת false
         */
        private static boolean getYesNoAnswer(Scanner scanner, String prompt) {
            while (true) {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("כן")) {
                    return true;
                } else if (input.equalsIgnoreCase("לא")) {
                    return false;
                } else {
                    System.out.println("נא להזין \"כן\" או \"לא\" בלבד.");
                }
            }
        }

        /**
         * מדפיס הודעה מתאימה בהתאם לדרישות הקבלה:
         *   - מעל גיל 20
         *   - יש תעודת בגרות
         *   - ניסיון של לפחות 3 שנים
         *
         * @param age               גיל המבקש
         * @param yearsOfExperience שנות הניסיון של המבקש
         * @param hasBagrut         האם למבקש יש תעודת בגרות
         */
        private static void printEligibility(int age, int yearsOfExperience, boolean hasBagrut) {
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
        }
    }