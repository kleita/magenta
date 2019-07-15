package kleita.magenta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private final int[] IDS = {
            R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btn_b, R.id.btn0, R.id.btn_n
    };

    private int value;
    private TextView price;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(adapter);
        OnLayoutChangeListener listener = new OnLayoutChangeListener(((LinearLayout) findViewById(R.id.above)));
        listener.ratio = 40f/111f;
        findViewById(R.id.background).addOnLayoutChangeListener(listener);
        price = findViewById(R.id.price);
        for(int id : IDS)
        {
            findViewById(id).setOnClickListener(this);
        }
    }

    private void setValue(int value)
    {
        if(value > 100000000)
        {
            Toast.makeText(this, "최대 1억입니다.", Toast.LENGTH_SHORT).show();
            value = 100000000;
        }
        this.value = value;
        price.setText(String.valueOf(value));
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn0:
                setValue(value * 10);
                break;
            case R.id.btn1:
                setValue(value * 10 + 1);
                break;
            case R.id.btn2:
                setValue(value * 10 + 2);
                break;
            case R.id.btn3:
                setValue(value * 10 + 3);
                break;
            case R.id.btn4:
                setValue(value * 10 + 4);
                break;
            case R.id.btn5:
                setValue(value * 10 + 5);
                break;
            case R.id.btn6:
                setValue(value * 10 + 6);
                break;
            case R.id.btn7:
                setValue(value * 10 + 7);
                break;
            case R.id.btn8:
                setValue(value * 10 + 8);
                break;
            case R.id.btn9:
                setValue(value * 10 + 9);
                break;
            case R.id.btn_b:
                setValue(value / 10);
                break;
        }
    }
}
