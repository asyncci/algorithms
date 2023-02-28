public class GoldenRatio extends MinimumFunction{
    public GoldenRatio(double a, double b, double eps, Function function) {
        super(a, b, eps, function);
    }

    @Override
    public double method() {
        double ratio = ((-1f + Math.sqrt(5))/2);
        double t1 = ((-1 + Math.sqrt(5))/2);
        double t2 = ((3 - Math.sqrt(5))/2);
        double x0 = a;
        double x3 = b;
        double x1 = a + t1*(b-a);
        double x2 = a + t2*(b-a);
        double fx1 = function.get(x1);
        double fx2 = function.get(x2);
        double L = x3 - x0;

        while (true) {
            if (fx1 > fx2){
                L = x3 - x1;
                x0 = x1;
                x1 = x2;
                x2 = x0 + t1 * L;
                fx1 = fx2;
                fx2 = function.get(x2);
            }
            else{
                L = x2 - x0;
                x3 = x2;
                x2 = x1;
                x1 = x0 + t1 * L;
                fx2 = fx1;
                fx1 = function.get(x1);
            }

            if (Math.abs(L) < eps) {
                break;
            }
        }
        double x = (x0 + x3)/2;
        setR(function.get(x));
        return x;
    }



    public void printFunctionResult() {
        System.out.println(R);
    }
}
