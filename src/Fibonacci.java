import java.io.IOException;

public class Fibonacci extends MinimumFunction {
    private float n;
    public Fibonacci(float a, float b, float step, Function function,float n) {
        super(a, b, step, function);
        this.n = n;
    }

    @Override
        public float method() throws IOException {

            StringBuilder total = new StringBuilder();

            float x0 = a;
            float x3 = b;
            float x1 = formula();
            float fx1 = function.get(x1);

            int k = 0 ;

            float last_b = x3;
            float last_a = x0;

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

                String line = String.format("%f %f %f %f %f %f %f %f\n",x1,x2,fx1,fx2,x0,x3,x3-x0,(last_b - last_a)/ (x0 - x3));
                total.append(line);

                last_b = x3;
                last_a = x0;


                if (k < n) {
                    writeToFile("Fibonacci.txt",total.toString());
                    return (x0 + x3)/2;
                }
                k++;
            }
        }

    private float formula() {
        return (float) (((b-a)*function.get(n - 1) + step * Math.pow(-1,n))/function.get(n) + a);
    }
}
