package kleita.magenta;

import android.content.Context;
import android.util.AttributeSet;
import android.support.annotation.Nullable;

public class LinearLayout extends android.widget.LinearLayout
{
    public final float RATIO;

    private float ratio;

    private float getRatio()
    {
        String tmp[] = getTag().toString().split("/");
        return Integer.parseInt(tmp[0]) / Float.parseFloat(tmp[1]);
    }

    public void setRatio(float ratio)
    {
        this.ratio = ratio;
        requestLayout();
        invalidate();
    }

    public LinearLayout(Context context)
    {
        super(context);
        ratio = RATIO = getRatio();
    }

    public LinearLayout(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        ratio = RATIO = getRatio();
    }

    public LinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        ratio = RATIO = getRatio();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        this.setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), (int)(ratio * MeasureSpec.getSize(heightMeasureSpec)));
    }
}
