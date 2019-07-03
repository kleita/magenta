package kleita.magenta;

public abstract class Fragment extends android.support.v4.app.Fragment
{
    public abstract void init();
    public abstract void fini();
    public abstract void onScroll(float offset, float[] next);

    public float[] attrs;

    public final float[] getAttributes()
    {
        return attrs;
    }
}
