public abstract class MinimumFunction extends MathFunction {
    protected double R;
    public MinimumFunction(double a, double b, double eps, Function function) {
        super(a, b, eps, function);
    }
    protected void setR(double r) {
        R = r;
    }

    public double getR() {
        return R;
    }
}
