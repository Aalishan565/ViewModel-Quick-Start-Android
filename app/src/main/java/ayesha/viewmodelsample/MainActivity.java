package ayesha.viewmodelsample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvNumber;
    private Button mbtnUpdate;
    MainActivityDataGenerator m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumber=findViewById(R.id.tvNumber);
        mbtnUpdate=findViewById(R.id.button);
        mbtnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.createRandomNumber();

            }
        });
         m = ViewModelProviders.of(this).get(MainActivityDataGenerator.class);
        MutableLiveData<String>number=m.getRandomNumber();
        number.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvNumber.setText(s);

            }
        });


    }

}
