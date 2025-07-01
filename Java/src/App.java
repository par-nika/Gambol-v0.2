import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class App{
    static LocalDateTime inputDateTime;
    static LocalDateTime currDateTime;
    static long Days, Weeks, Months, Years, Hours, Minutes;
    static long valueToAnalyze;
    static String eventName;

    public static void main(String[] args) throws Exception {
        App obj = new App();
        obj.Menu();

        check.factSet(valueToAnalyze);
    }

    public void display(){
        System.out.println("\n\nEntered Date      : " + inputDateTime.toLocalDate());
        System.out.println("Current Date      : " + currDateTime.toLocalDate());
        System.out.println("\n___________________________________________");
        System.out.println("             Time Since That Day            ");
        System.out.println("___________________________________________");
        System.out.printf("Days    : %,d\n", Days);
        System.out.printf("Weeks   : %,d\n", Weeks);
        System.out.printf("Months  : %,d\n", Months);
        System.out.printf("Years   : %,d\n", Years);
        System.out.printf("Hours   : %,d\n", Hours);
        System.out.printf("Minutes : %,d\n", Minutes);
        System.out.println("___________________________________________\n");

        upcoming.upcomingFacts(Days, eventName);

    }

    public void compute(String strDate, DateTimeFormatter formatter){
        LocalDate inputDate = LocalDate.parse(strDate, formatter);
        inputDateTime = inputDate.atStartOfDay();
        currDateTime = LocalDateTime.now();

        Days = ChronoUnit.DAYS.between(inputDateTime, currDateTime);
        Weeks = ChronoUnit.WEEKS.between(inputDateTime, currDateTime);
        Months = ChronoUnit.MONTHS.between(inputDateTime, currDateTime);
        Years = ChronoUnit.YEARS.between(inputDateTime, currDateTime);
        Hours = ChronoUnit.HOURS.between(inputDateTime, currDateTime);
        Minutes = ChronoUnit.MINUTES.between(inputDateTime, currDateTime);

    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date in dd-MMM-yyyy format (e.g. 15-Jun-2005):");
        String strDate = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        compute(strDate, formatter);
        System.out.println("Enter the name of the event:");
        eventName = sc.nextLine();

        display();
        System.out.println("""
                           Which time unit would you like fun math facts for?\r
                           1. Total Days\r
                           2. Total Weeks\r
                           3. Total Months\r
                           4. Total Years\r
                           5. Total Hours\r
                           6. Total Minutes\r
                           Enter your choice:"""
        );

        int choice = sc.nextInt();
        facts(choice);


        sc.close();
    }

    public void facts(int choice){

        valueToAnalyze = 0;

        switch (choice) {
            case 1 -> valueToAnalyze = Days; //
            case 2 -> valueToAnalyze = Weeks;
            case 3 -> valueToAnalyze = Months;
            case 4 -> valueToAnalyze = Years;
            case 5 -> valueToAnalyze = Hours;
            case 6 -> valueToAnalyze = Minutes;
            default -> {
                System.out.println("Invalid choice.");
            }
        }


    }

}
