from checkingFact import CheckFact

class Upcoming:
    @staticmethod
    def upcomingFacts(Days, eventName):
        obj = CheckFact()

        print("\n__________________________________________________________________________")
        print("\t\tUpcoming Math Milestones Since Your " + eventName)
        print("__________________________________________________________________________\n")

        anyFound = False

        for i in range(1, 32):
            valueToAnalyze = Days + i
            facts = []

            if obj.palindrome(valueToAnalyze):
                facts.append("Palindrome number")
            if obj.prime(valueToAnalyze):
                facts.append("Prime number")
            if obj.perfsq(valueToAnalyze):
                facts.append("Perfect Square")
            if obj.perfcb(valueToAnalyze):
                facts.append("Perfect Cube")
            if obj.fibonacci(valueToAnalyze):
                facts.append("Fibonacci number")
            if obj.factorial(valueToAnalyze):
                facts.append("Factorial number")
            if obj.mersenne(valueToAnalyze):
                facts.append("Mersenne Prime")
            if obj.triangular(valueToAnalyze):
                facts.append("Triangular number")
            if obj.armstrong(valueToAnalyze):
                facts.append("Armstrong number")
            if obj.kaprekar(valueToAnalyze):
                facts.append("Kaprekar number")
            if obj.taxicab(valueToAnalyze):
                facts.append("Taxicab number")

            if len(facts) != 0:
                anyFound = True
                print("In " + str(i) + " days (" + str(Days + i) + " days total):")
                for fact in facts:
                    print("   -> " + fact)
                print()

        if not anyFound:
            print("No fun math facts coming up in the next 31 days... :(")

        print("________________________________________________________________\n")
