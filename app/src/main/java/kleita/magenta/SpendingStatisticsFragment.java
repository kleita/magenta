package kleita.magenta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SpendingStatisticsFragment extends Fragment
{
    private static final float[] attrs = { 6.0f / 13, 0.0f };

    public SpendingStatisticsFragment()
    {
        super.attrs = SpendingStatisticsFragment.attrs;
    }

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
        setRatio(attrs[0]);
        view.addOnLayoutChangeListener(this);
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
    public void onScroll(float offset, float[] next)
    {
        if(offset > 0)
        {
           setRatio((next[0] - attrs[0]) * offset + attrs[0]);
        }
        else
        {
            setRatio((next[0] - attrs[0]) * -offset + attrs[0]);
        }
    }
}
