public class Fibonacci extends MinimumFunction {
    private float n;
    public Fibonacci(float a, float b, float step, Function function,float n) {
        super(a, b, step, function);
        this.n = n;
    }

    @Override
    public float method() {

        float x0 = a;
        float x3 = b;
        float x1 = formula();
        float fx1 = function.get(x1);

        int k = 0 ;

        while (true) {
            float x2 = x0 - x1 + x3;
            float fx2 = function.get(x2);

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
                float x = (x0 + x3)/2;
                return x;
            }
            k++;
        }
    }

    private float formula() {
        return (float) (((b-a)*function.get(n - 1) + step * Math.pow(-1,n))/function.get(n) + a);
    }
}
