package kleita.magenta;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainAdapter extends FragmentPagerAdapter
{
    public MainAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
            case 1:
            case 2:
                return new AccountBalanceFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}
