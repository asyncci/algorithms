import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        float first = in.nextFloat();
        float second = in.nextFloat();
        float step = in.nextFloat();
        int n = in.nextInt();

        Function func = x -> (float) Math.pow(x - 2, 2.);

        Method bisection = new Bisection(first,second,step,func);
        float resultBisection = bisection.method();
        System.out.printf("bisection: %f\n",resultBisection);


        Method goldenRatio = new GoldenRatio(first,second,step,func);
        float resultGoldenRatio = goldenRatio.method();
        MinimumFunction gr = (MinimumFunction)goldenRatio;
        System.out.printf("golden ratio: %f | %f\n",resultGoldenRatio,gr.getR());

        Method fibonacci = new Fibonacci(first,second,step,func,n);
        float resultFibonacci = fibonacci.method();
        MinimumFunction fib = (MinimumFunction)fibonacci;
        System.out.printf("fibonacci: %f | %f\n",resultFibonacci,fib.getR());


    }
}