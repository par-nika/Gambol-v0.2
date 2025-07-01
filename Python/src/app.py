from datetime import datetime
from datetime import timedelta
from checkingFact import CheckFact
from upcoming import Upcoming

class App:
    inputDateTime = None
    currDateTime = None
    Days = 0
    Weeks = 0
    Months = 0
    Years = 0
    Hours = 0
    Minutes = 0
    valueToAnalyze = 0
    eventName = ""

    def main(self):
        obj = App()
        obj.Menu()

        obj2 = CheckFact()
        obj2.factSet(App.valueToAnalyze)

    def display(self):
        print("\n\nEntered Date      :", App.inputDateTime.date())
        print("Current Date      :", App.currDateTime.date())
        print("\n___________________________________________")
        print("             Time Since That Day            ")
        print("___________________________________________")
        print("Days    : {:,}".format(App.Days))
        print("Weeks   : {:,}".format(App.Weeks))
        print("Months  : {:,}".format(App.Months))
        print("Years   : {:,}".format(App.Years))
        print("Hours   : {:,}".format(App.Hours))
        print("Minutes : {:,}".format(App.Minutes))
        print("___________________________________________\n")

        Upcoming.upcomingFacts(App.Days, App.eventName)

    def compute(self, strDate, formatter):
        inputDate = datetime.strptime(strDate, formatter)
        App.inputDateTime = inputDate
        App.currDateTime = datetime.now()

        delta = App.currDateTime - App.inputDateTime

        App.Days = delta.days
        App.Weeks = App.Days // 7
        App.Months = (App.currDateTime.year - App.inputDateTime.year) * 12 + (App.currDateTime.month - App.inputDateTime.month)
        App.Years = App.currDateTime.year - App.inputDateTime.year
        App.Hours = App.Days * 24
        App.Minutes = App.Hours * 60

    def Menu(self):
        sc = input
        print("Enter date in dd-MMM-yyyy format (e.g. 15-Jun-2005):")
        strDate = sc()
        formatter = "%d-%b-%Y"

        self.compute(strDate, formatter)

        print("Enter the name of the event:")
        App.eventName = sc()

        self.display()

        print("""
Which time unit would you like fun math facts for?
1. Total Days
2. Total Weeks
3. Total Months
4. Total Years
5. Total Hours
6. Total Minutes
Enter your choice:""")

        choice = int(sc())
        self.facts(choice)

    def facts(self, choice):
        App.valueToAnalyze = 0

        if choice == 1:
            App.valueToAnalyze = App.Days
        elif choice == 2:
            App.valueToAnalyze = App.Weeks
        elif choice == 3:
            App.valueToAnalyze = App.Months
        elif choice == 4:
            App.valueToAnalyze = App.Years
        elif choice == 5:
            App.valueToAnalyze = App.Hours
        elif choice == 6:
            App.valueTo

if __name__ == "__main__":
    obj = App()
    obj.main()
