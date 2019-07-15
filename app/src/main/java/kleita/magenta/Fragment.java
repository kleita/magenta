package kleita.magenta;

import android.view.View;
import android.widget.LinearLayout;

public abstract class Fragment extends android.support.v4.app.Fragment implements View.OnLayoutChangeListener
{
    public abstract void init();
    public abstract void fini();
    public abstract void onScroll(float offset, float[] next);

    public float[] attrs;

    protected View view;
    protected LinearLayout above;

    private float ratio = 40f/111f;
    private int w, h;

    public final float[] getAttributes()
    {
        return attrs;
    }

    private void updateSize()
    {
        if(above != null)
        {
            final float RATIO_H = 16f, RATIO_W = 9f; // 디자인이 16:9 기준
            float offset_y, size_y;
            if (w * RATIO_H > h * RATIO_W)
            {
                offset_y = 0f;
                size_y = h;
            }
            else
            {
                size_y = w / RATIO_W * RATIO_H;
                offset_y = (h - size_y) / 2;
            }
            above.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) (offset_y + size_y * ratio)));
        }
    }

    private void updateSize(int w, int h)
    {
        this.w = w;
        this.h = h;
        updateSize();
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
        updateSize();
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom)
    {
        if(oldLeft != left || oldTop != top || oldRight != right || oldBottom != bottom)
            updateSize(right - left, bottom - top);
    }
}
