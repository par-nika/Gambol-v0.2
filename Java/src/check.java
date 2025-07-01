public class check{
    public static void factSet(long input) {
        check obj=new check();
        boolean found = false;
        {
            if (obj.palindrome(input)) {
                System.out.println("It's a Palindrome!");
                found = true;
            }

            if (obj.prime(input)) {
                System.out.println("It's a Prime number!");
                found = true;
            }

            if (obj.perfsq(input)) {
                System.out.println("It's a Perfect Square!");
                found = true;
            }

            if (obj.perfcb(input)) {
                System.out.println("It's a Perfect Cube!");
                found = true;
            }

            if (obj.fibonacci(input)) {
                System.out.println("It's a Fibonacci number!");
                found = true;
            }

            if (obj.factorial(input)) {
                System.out.println("It's a Factorial number!");
                found = true;
            }

            if (obj.mersenne(input)) {
                System.out.println("It's a Mersenne Prime!");
                found = true;
            }

            if (obj.triangular(input)) {
                System.out.println("It's a Triangular number!");
                found = true;
            }

            if (obj.armstrong(input)) {
                System.out.println("It's an Armstrong number!");
                found = true;
            }

            if (obj.harshad(input)) {
                System.out.println("It's a Harshad number!");
                found = true;
            }

            if (obj.kaprekar(input)) {
                System.out.println("It's a Kaprekar number!");
                found = true;
            }

            if (obj.taxicab(input)) {
                System.out.println("It's a Taxicab number!");
                found = true;
            }

        }
        if(!found) System.out.println("No fun fact about this number :(\n\n");
    }

    public boolean palindrome(long n){
        String num = ""+n;
        String temp="";
        for(int i=num.length()-1; i>=0; i--){
            temp += num.charAt(i);
        }
        return temp.equals(num);
    }

    public boolean prime(long n){
        for(long i=2; i<=n/2; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    public boolean perfsq(long n){
        long rt = (long) Math.sqrt(n);
        return (rt*rt == n);
    }

    public boolean perfcb(long n){
        long rt = (long) Math.cbrt(n);
        return (rt*rt*rt == n);
    }

    public boolean fibonacci(long n){
        if(n==0 || n==1) return true;

        long a=0, b=1;
        long c=a+b;
        while(c<=n){
            if(c==n) return true;

            a=b;
            b=c;
            c=a+b;
        }
        return false;
    }

    public boolean factorial(long n){
        if(n==0 || n==1) return true;
        long prod=1 ,i = 1;
        while(prod<n){
            prod*=i;
            i++;
        }
        return prod==n;
    }

    public boolean mersenne(long n){
        if(prime(n)){
            int i=1; long temp=0;
            while(temp<n){

                if(!prime(i)){
                    i++; continue;
                }
                temp = (long) Math.pow(2,i)-1;
                i++;
            }
            return temp==n;
        }
        return false;
    }

    public boolean triangular(long n){
        long i=1, sum=0;
        while(sum<n){
            sum=sum+i;
            i++;
        }
        return sum==n;
    }

    public boolean armstrong(long n){
        long temp=n, sum=0; int i=(n+"").length();
        while(temp!=0){
            long d=temp%10;
            temp=temp/10;
            sum+=(long)Math.pow(d,i);
        }
        return sum==n;
    }

    public boolean harshad(long n){
        long temp=n, sum=0;
        while(temp!=0){
            long d=temp%10;
            temp=temp/10;
            sum+=d;
        }
        return n%sum==0;
    }

    public boolean kaprekar(long n){
        long sq=n*n;
        int len=(sq+"").length();
        long l,f,sum;

        if(len%2==0) len=len/2;
        else len=len/2+1;

        l=(long)(sq % Math.pow(10,len));
        f=(long)(sq / Math.pow(10,len));
        sum=f+l;

        return sum==n;
    }

    public boolean taxicab(long n){
        return n==1729 || n==87539319;
    }

}
