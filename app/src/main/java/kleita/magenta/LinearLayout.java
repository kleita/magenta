package kleita.magenta;

import android.content.Context;
import android.util.AttributeSet;
import android.support.annotation.Nullable;

public class LinearLayout extends android.widget.LinearLayout
{
    public float RATIO;

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
        ratio = RATIO = 1.0f;
    }

    public LinearLayout(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        ratio = RATIO = 1.0f;
    }

    public LinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        ratio = RATIO = 1.0f;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        this.setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), (int)(ratio * MeasureSpec.getSize(heightMeasureSpec)));
    }
}
