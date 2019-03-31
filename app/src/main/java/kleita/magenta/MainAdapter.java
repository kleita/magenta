package kleita.magenta;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener
{
    private Fragment fragments[];

    public MainAdapter(FragmentManager fm)
    {
        super(fm);
        fragments = new Fragment[3];
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return fragments[0] == null ? fragments[0] = new AccountBalanceFragment() : fragments[0];
            case 1:
            case 2:
                return fragments[position] == null ? fragments[position] = new SpendingStatisticsFragment() : fragments[position];
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixel)
    {
        fragments[position].onScroll(positionOffset);
        if(position + 1 < fragments.length && fragments[position + 1] != null)
        {
            fragments[position + 1].onScroll(positionOffset - 1.0f);
        }
    }

    private int prevPosition;

    @Override
    public void onPageSelected(int position)
    {
        if(prevPosition != position)
        {
            fragments[prevPosition].fini();
        }
        fragments[prevPosition = position].init();
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {
    }
}
