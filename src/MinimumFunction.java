public abstract class MinimumFunction extends MathFunction {
    protected float R;
    public MinimumFunction(float a, float b, float step, Function function) {
        super(a, b, step, function);
    }
    protected void setR(float r) {
        R = r;
    }

    public float getR() {
        return R;
    }
}
