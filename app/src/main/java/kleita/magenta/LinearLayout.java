package kleita.magenta;

import android.content.Context;
import android.util.AttributeSet;
import android.support.annotation.Nullable;

public class LinearLayout extends android.widget.LinearLayout
{
    private float ratio;

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
        requestLayout();
        invalidate();
    }

    public LinearLayout(Context context)
    {
        super(context);
        ratio  = 1.0f;
    }

    public LinearLayout(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        ratio  = 1.0f;
    }

    public LinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        ratio  = 1.0f;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        final float RATIO_H = 16f, RATIO_W = 9f; // 디자인이 16:9 기준
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        float offset_x, offset_y, size_x, size_y;
        if(w * RATIO_H > h * RATIO_W)
        {
            offset_y = 0f;
            size_y = h;
            size_x = h / RATIO_H * RATIO_W;
            offset_x = (w - size_x) / 2;
        }
        else
        {
            offset_x = 0;
            size_x = w;
            size_y = w / RATIO_W * RATIO_H;
            offset_y = (h - size_y) / 2;
        }
        this.setMeasuredDimension(w, (int)(ratio * size_y + offset_y));
    }
}
