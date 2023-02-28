import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float first = -2;
        float second = 20;
        float eps = 0.0000001f;

        System.out.println(eps);

        Function func = x -> (float) Math.pow((x - 1.), 2.);

        Method bisection = new Bisection(first,second,eps,func);
        double resultBisection = bisection.method();
        System.out.printf("bisection: %f\n",resultBisection);

//        Method goldenRatio = new GoldenRatio(first,second,step,func);
//        float resultGoldenRatio = goldenRatio.method();
//        MinimumFunction gr = (MinimumFunction)goldenRatio;
//        System.out.printf("golden ratio: %f | %f\n",resultGoldenRatio,gr.getR());
//
//        Method fibonacci = new Fibonacci(first,second,step,func,4);
//        float resultFibonacci = fibonacci.method();
//        MinimumFunction fib = (MinimumFunction)fibonacci;
//        System.out.printf("fibonacci: %f | %f\n",resultFibonacci,fib.getR());

    }
}