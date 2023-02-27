import java.io.*;

public abstract class MathFunction implements Method{
    protected float a , b, step;
    protected Function function;

    public MathFunction(float a, float b, float step, Function function) {
        this.a = a;
        this.b = b;
        this.step = step;
        this.function = function;
    }

    public static void writeToFile(String name, String data) throws IOException {
        String[] splitted = data.split(" ");

        for(int i=0;i <= splitted.length;i++){

        }
    }
}
