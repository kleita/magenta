package kleita.magenta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SpendingStatisticsFragment extends Fragment
{
    private View view;
    private LinearLayout above;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.spending_statistics, container,false);
        above = view.findViewById(R.id.above);
        return view;
    }

    @Override
    public void init()
    {
        if(view != null)
        {
            above.requestLayout();
            above.invalidate();
        }
    }

    @Override
    public void fini()
    {
        //
    }

    @Override
    public void onScroll(float offset, float nextRatio)
    {
        if(offset > 0)
        {
           above.setRatio((nextRatio - above.RATIO) * offset + above.RATIO);
        }
        else
        {
            above.setRatio((nextRatio - above.RATIO) * -offset + above.RATIO);
        }
    }

    @Override
    public float getRatio()
    {
        return above == null ? 0 : above.RATIO;
    }
}
