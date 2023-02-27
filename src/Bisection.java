import java.io.IOException;

public class Bisection extends MathFunction{

    public Bisection(float a, float b, float step, Function function) {
        super(a, b, step, function);
    }

    @Override
    public float method() throws IOException {

        StringBuilder total = new StringBuilder();
        float last_a = b, last_b = b;

        while (true) {
            float L = b - a;
            float xm = (a + b)/2;
            float x1 = a + L/4;
            float x2 = b - L/4;

            float fxm = function.get(xm);
            float fx1 = function.get(x1);
            float fx2 = function.get(x2);

            if (fx1 < fxm) {
                b = xm;
                xm = x1;
            }

            if (fx1 > fxm) {
                if (fx2 < fxm) {
                    a = xm;
                    xm = x2;
                }
                else if (fx2 > fxm){
                    a = xm;
                    b = x2;
                }
            }
            System.out.println("writing");
            String line = String.format("%f %f %f %f %f %f %f %f\n",x1,x2,fx1,fx2,a,b,b-a,(last_b - last_a)/ (b - a));
            total.append(line);
            last_b = b;
            last_a = a;

            L = b - a;

            if (L < step) {
                writeToFile("Bisection.txt",total.toString());
                return xm;
            }
        }
    }
}
