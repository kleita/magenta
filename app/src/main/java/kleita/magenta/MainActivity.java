package kleita.magenta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(adapter);
        findViewById(R.id.background).addOnLayoutChangeListener(new OnLayoutChangeListener(((LinearLayout) findViewById(R.id.above))));
    }
}
