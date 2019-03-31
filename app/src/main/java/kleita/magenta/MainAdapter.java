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
                return fragments[1] == null ? fragments[1] = new SpendingStatisticsFragment() : fragments[1];
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
        android.util.Log.d("TEST", position + " : " + positionOffset);
    }

    @Override
    public void onPageSelected(int position)
    {
        //
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {
        //
    }
}
