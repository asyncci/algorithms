public abstract class MathFunction implements Method{
    protected double a;
    protected double b;
    protected double eps;
    protected Function function;

    public MathFunction(double a, double b, double eps, Function function) {
        this.a = a;
        this.b = b;
        this.eps = eps;
        this.function = function;
    }
}
