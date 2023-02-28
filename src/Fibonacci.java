public class Fibonacci extends MinimumFunction {
    private double n;
    public Fibonacci(double a, double b, double eps, Function function, double n) {
        super(a, b, eps, function);
        this.n = n;
    }

    @Override
    public double method() {

        double x0 = a;
        double x3 = b;
        double x1 = formula();
        double fx1 = function.get(x1);

        int k = 0 ;

        while (true) {
            double x2 = x0 - x1 + x3;
            double fx2 = function.get(x2);

            if (fx2 > fx1) {
                if (x2 > x1) {
                    x3 = x2;
                }
                else if (x2 < x1) {
                    x0 = x2;
                }
            }
            else if (fx2 < fx1) {
                if ( x1 > x2) {
                    x3 = x1;
                    x1 = x2;
                    fx1 = fx2;
                }
                else if (x1 < x2) {
                    x0 = x1;
                    x1 = x2;
                    fx1 = fx2;
                }
            }
            if (k < n) {
                double x = (x0 + x3)/2;
                return x;
            }
            k++;
        }
    }

    private double formula() {
        return (((b-a)*function.get(n - 1) + eps * Math.pow(-1,n))/function.get(n) + a);
    }
}
