import math

class CheckFact:

    def factSet(self, input):
        obj = CheckFact()
        found = False

        if obj.palindrome(input):
            print("It's a Palindrome!")
            found = True

        if obj.prime(input):
            print("It's a Prime number!")
            found = True

        if obj.perfsq(input):
            print("It's a Perfect Square!")
            found = True

        if obj.perfcb(input):
            print("It's a Perfect Cube!")
            found = True

        if obj.fibonacci(input):
            print("It's a Fibonacci number!")
            found = True

        if obj.factorial(input):
            print("It's a Factorial number!")
            found = True

        if obj.mersenne(input):
            print("It's a Mersenne Prime!")
            found = True

        if obj.triangular(input):
            print("It's a Triangular number!")
            found = True

        if obj.armstrong(input):
            print("It's an Armstrong number!")
            found = True

        if obj.harshad(input):
            print("It's a Harshad number!")
            found = True

        if obj.kaprekar(input):
            print("It's a Kaprekar number!")
            found = True

        if obj.taxicab(input):
            print("It's a Taxicab number!")
            found = True

        if not found:
            print("No fun fact about this number :(\n\n")

    def palindrome(self, n):
        num = str(n)
        temp = ""
        for i in range(len(num) - 1, -1, -1):
            temp += num[i]
        return temp == num

    def prime(self, n):
        if n < 2:
            return False
        for i in range(2, int(n / 2) + 1):
            if n % i == 0:
                return False
        return True

    def perfsq(self, n):
        rt = int(math.sqrt(n))
        return rt * rt == n

    def perfcb(self, n):
        rt = int(round(n ** (1/3)))
        return rt * rt * rt == n

    def fibonacci(self, n):
        if n == 0 or n == 1:
            return True

        a = 0
        b = 1
        c = a + b
        while c <= n:
            if c == n:
                return True
            a = b
            b = c
            c = a + b
        return False

    def factorial(self, n):
        if n == 0 or n == 1:
            return True
        prod = 1
        i = 1
        while prod < n:
            prod *= i
            i += 1
        return prod == n

    def mersenne(self, n):
        if self.prime(n):
            i = 1
            temp = 0
            while temp < n:
                if not self.prime(i):
                    i += 1
                    continue
                temp = int(math.pow(2, i)) - 1
                i += 1
            return temp == n
        return False

    def triangular(self, n):
        i = 1
        sum_ = 0
        while sum_ < n:
            sum_ = sum_ + i
            i += 1
        return sum_ == n

    def armstrong(self, n):
        temp = n
        sum_ = 0
        i = len(str(n))
        while temp != 0:
            d = temp % 10
            temp = temp // 10
            sum_ += int(math.pow(d, i))
        return sum_ == n

    def harshad(self, n):
        temp = n
        sum_ = 0
        while temp != 0:
            d = temp % 10
            temp = temp // 10
            sum_ += d
        return n % sum_ == 0 if sum_ != 0 else False

    def kaprekar(self, n):
        sq = n * n
        len_sq = len(str(sq))
        if len_sq % 2 == 0:
            len_ = len_sq // 2
        else:
            len_ = len_sq // 2 + 1

        l = sq % int(math.pow(10, len_))
        f = sq // int(math.pow(10, len_))
        sum_ = f + l

        return sum_ == n

    def taxicab(self, n):
        return n == 1729 or n == 87539319
