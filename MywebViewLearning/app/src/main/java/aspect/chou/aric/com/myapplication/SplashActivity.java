package aspect.chou.aric.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * aspect.chou.aric.com.myapplication
 * Created by Aric on 下午2:31.
 */

public class SplashActivity extends AppCompatActivity{
    private EditText mName;
    private EditText mVinCode;

    public static final String NAME="name";
    public static final String MVINCODE="mvincode";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mName= ((EditText) findViewById(R.id.et_name));

        mVinCode= ((EditText) findViewById(R.id.et_vincode));
    }


    public void enter(View view){

        String name = mName.getText().toString();

        String vincode = mVinCode.getText().toString();

        Intent intent = new Intent(SplashActivity.this,MainActivity.class);

        intent.putExtra(NAME,name);
        intent.putExtra(MVINCODE,vincode);

        startActivity(intent);

    }

}
