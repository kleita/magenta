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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return view = inflater.inflate(R.layout.spending_statistics, container,false);
    }

    @Override
    public void init()
    {
        if(view != null)
        {
            view.findViewById(R.id.above).requestLayout();
            view.findViewById(R.id.above).invalidate();
        }
    }

    @Override
    public void fini()
    {
        //
    }

    @Override
    public void onScroll(float offset)
    {
        //
    }
}
