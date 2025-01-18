import java.util.Scanner;

public class WorkersConditions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = getValidInteger(scanner, "Enter age (positive integer): ", 1, 120);
        int yearsOfExperience = getValidInteger(scanner, "Enter years of experience (positive integer): ", 0, 120);
        boolean hasDiploma = getYesNoAnswer(scanner, "Do you have a high school diploma? (yes/no): ");

        printEligibility(age, yearsOfExperience, hasDiploma);
        scanner.close();
    }

    /**
     * Reads an integer from the user and verifies that it is within the acceptable range.
     *
     * @param scanner   Scanner object for reading input
     * @param prompt    Text to display to the user
     * @param minValue  Minimum allowed value
     * @param maxValue  Maximum allowed value
     * @return          A valid integer within the specified range
     */
    private static int getValidInteger(Scanner scanner, String prompt, int minValue, int maxValue) {
        int value;
        while (true) {
            System.out.print(prompt);
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                // Check if the value is within the valid range
                if (value >= minValue && value <= maxValue) {
                    return value;
                } else {
                    System.out.println("The value must be between " + minValue + " and " + maxValue + ".");
                }
            } else {
                // If the user input is not an integer
                System.out.println("Please enter a valid integer.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

    /**
     * Reads a yes/no response from the user.
     *
     * @param scanner Scanner object for reading input
     * @param prompt  Text to display to the user
     * @return        true if the user answered "yes", false otherwise
     */
    private static boolean getYesNoAnswer(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("yes")) {
                return true;
            } else if (input.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Please enter \"yes\" or \"no\" only.");
            }
        }
    }

    /**
     * Prints an appropriate message based on the eligibility requirements:
     *   - Over 20 years old
     *   - Possesses a high school diploma
     *   - At least 3 years of experience
     *
     * @param age               Applicant's age
     * @param yearsOfExperience Applicant's years of experience
     * @param hasDiploma        Whether the applicant has a high school diploma
     */
    private static void printEligibility(int age, int yearsOfExperience, boolean hasDiploma) {
        boolean meetsAgeReq = age > 20;
        boolean meetsDiplomaReq = hasDiploma;
        boolean meetsExperienceReq = yearsOfExperience >= 3;

        if (meetsAgeReq && meetsDiplomaReq && meetsExperienceReq) {
            // Applicant is accepted
            System.out.println("The applicant has been accepted for the job.");
        } else {
            // Applicant is not accepted - specify the reasons
            System.out.println("The applicant was not accepted for the job due to the following reasons:");
            if (!meetsAgeReq) {
                System.out.println("- The applicant is not over 20 years old.");
            }
            if (!meetsDiplomaReq) {
                System.out.println("- The applicant does not have a high school diploma.");
            }
            if (!meetsExperienceReq) {
                System.out.println("- The applicant has less than 3 years of experience.");
            }
        }
    }
}