public class GoldenRatio extends MinimumFunction{
    public GoldenRatio(float a, float b, float step, Function function) {
        super(a, b, step, function);
    }

    @Override
    public float method() {
        float ratio = (float) ((-1f + Math.sqrt(5))/2f);
        float t1 = 1 - ratio;
        float x0 = a;
        float x3 = b;
        float x1 = a + t1*(b-a);
        float x2 = x1;
        float fx1 = function.get(x1);
        float fx2 = function.get(x2);

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

            if (Math.abs(L) < step) {
                break;
            }
        }
        float x = (x0 + x3)/2;
        setR(function.get(x));
        return x;
    }



    public void printFunctionResult() {
        System.out.println(R);
    }
}
