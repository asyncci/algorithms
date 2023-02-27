import java.io.IOException;

public class GoldenRatio extends MinimumFunction{
    public GoldenRatio(float a, float b, float step, Function function) {
        super(a, b, step, function);
    }

    @Override
    public float method() throws IOException {
        StringBuilder total = new StringBuilder();
        float ratio = (float) ((-1f + Math.sqrt(5))/2f);
        float t1 = 1 - ratio;
        float x0 = a;
        float x3 = b;
        float x1 = a + t1*(b-a);
        float x2 = x1;
        float fx1 = function.get(x1);
        float fx2 = function.get(x2);

        float last_a = x0;
        float last_b = x3;

        float L = x3 - x0;

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

            String line = String.format("%f %f %f %f %f %f %f %f\n",x1,x2,fx1,fx2,x0,x3,x3-x0,(last_b - last_a)/ (x0 - x3));
            total.append(line);

            last_b = x3;
            last_a = x0;

            if (Math.abs(L) < step) {
                break;
            }
        }

        writeToFile("Golden Ration.txt",total.toString());

        float x = (x0 + x3)/2;
        setR(function.get(x));
        return x;
    }



    public void printFunctionResult() {
        System.out.println(R);
    }
}
