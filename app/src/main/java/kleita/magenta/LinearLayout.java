package kleita.magenta;

import android.content.Context;
import android.util.AttributeSet;
import android.support.annotation.Nullable;

public class LinearLayout extends android.widget.LinearLayout
{
    public final float ratio;

    private float getRatio()
    {
        String tmp[] = getTag().toString().split("/");
        return Integer.parseInt(tmp[0]) / Float.parseFloat(tmp[1]);
    }

    public LinearLayout(Context context)
    {
        super(context);
        ratio = getRatio();
    }

    public LinearLayout(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        ratio = getRatio();
    }

    public LinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        ratio = getRatio();
    }

    private android.widget.LinearLayout.LayoutParams lp = new android.widget.LinearLayout.LayoutParams(0, 0);

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        lp.width = MeasureSpec.getSize(widthMeasureSpec);
        lp.height = (int)(ratio * MeasureSpec.getSize(heightMeasureSpec));
        this.setMeasuredDimension(lp.width, lp.height);
        this.setLayoutParams(lp);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
