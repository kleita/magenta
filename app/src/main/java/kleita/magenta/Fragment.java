package kleita.magenta;

import android.view.View;
import android.widget.LinearLayout;

public abstract class Fragment extends android.support.v4.app.Fragment
{
    protected View view;
    protected LinearLayout above;
    protected OnChangeListener listener;

    public abstract void init();
    public abstract void fini();
    public abstract void onScroll(float offset, float[] next);

    public float[] attrs;

    public final float[] getAttributes()
    {
        return attrs;
    }

    public void setRatio(float ratio)
    {
        if(listener != null)
            listener.setRatio(ratio);
    }
}
