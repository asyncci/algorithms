public class Bisection extends MathFunction{

    public Bisection(float a, float b, float step, Function function) {
        super(a, b, step, function);
    }

    @Override
    public double method() {

        while (true) {
            double L = b - a;
            double xm = (a + b)/2;
            double x1 = a + L/4;
            double x2 = b - L/4;

            double fxm = function.get(xm);
            double fx1 = function.get(x1);
            double fx2 = function.get(x2);

            if (fx1 < fxm) {
                b = xm;
                xm = x1;
            }
            else {
                if (fx2 < fxm) {
                    a = xm;
                    xm = x2;
                }
                else {
                    a = x1;
                    b = x2;
                }
            }

            L = Math.abs(x2 - x1);

            if (L <= eps) {
                return xm;
            }
        }

    }
}
