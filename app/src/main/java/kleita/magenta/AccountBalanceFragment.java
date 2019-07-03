package kleita.magenta;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AccountBalanceFragment extends Fragment
{
    private View view;
    private LinearLayout above;

    private static final float[] attrs = { 13 / 24.0f };

    public AccountBalanceFragment()
    {
        super.attrs = AccountBalanceFragment.attrs;
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
        view = inflater.inflate(R.layout.account_balance, container,false);
        above = view.findViewById(R.id.above);
        above.RATIO = attrs[0];
        above.requestLayout();
        above.invalidate();
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
            above.setRatio((next[0] - attrs[0]) * offset + attrs[0]);
        }
        else
        {
            above.setRatio((next[0] - attrs[0]) * -offset + attrs[0]);
        }
    }
}
