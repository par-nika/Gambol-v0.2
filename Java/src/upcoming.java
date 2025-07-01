import java.util.ArrayList;
import java.util.List;

public class upcoming {
    public static void upcomingFacts(long Days, String eventName) {
        check obj = new check();

        System.out.println("\n__________________________________________________________________________");
        System.out.println("\t\tUpcoming Math Milestones Since Your " + eventName);
        System.out.println("__________________________________________________________________________\n");

        boolean anyFound = false;

        for (int i = 1; i <= 31; i++) {
            long valueToAnalyze = Days + i;
            List<String> facts = new ArrayList<>();

            if (obj.palindrome(valueToAnalyze)) facts.add("Palindrome number");
            if (obj.prime(valueToAnalyze)) facts.add("Prime number");
            if (obj.perfsq(valueToAnalyze)) facts.add("Perfect Square");
            if (obj.perfcb(valueToAnalyze)) facts.add("Perfect Cube");
            if (obj.fibonacci(valueToAnalyze)) facts.add("Fibonacci number");
            if (obj.factorial(valueToAnalyze)) facts.add("Factorial number");
            if (obj.mersenne(valueToAnalyze)) facts.add("Mersenne Prime");
            if (obj.triangular(valueToAnalyze)) facts.add("Triangular number");
            if (obj.armstrong(valueToAnalyze)) facts.add("Armstrong number");
            if (obj.kaprekar(valueToAnalyze)) facts.add("Kaprekar number");
            if (obj.taxicab(valueToAnalyze)) facts.add("Taxicab number");

            if (!facts.isEmpty()) {
                anyFound = true;
                System.out.println("In " + i + " days (" + (Days + i)+ " days total):");
                for (String fact : facts) {
                    System.out.println("   -> " + fact);
                }
                System.out.println();
            }
        }

        if (!anyFound) {
            System.out.println("No fun math facts coming up in the next 31 days... :(");
        }

        System.out.println("________________________________________________________________\n");
    }
}
