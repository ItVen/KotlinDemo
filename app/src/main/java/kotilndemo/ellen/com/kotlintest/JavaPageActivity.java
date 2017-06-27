package kotilndemo.ellen.com.kotlintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Aven on 2017/6/21.
 */

public class JavaPageActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tips;
    private Button jumb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_layout);
        initView();
    }

    private void initView() {
        tips = (TextView) findViewById(R.id.hello);
        jumb = (Button) findViewById(R.id.commit);

        tips.setText(getMessage()!=null?getMessage():"我是Java语言编写的");
        jumb.setText("回到Kotlin页面去 要带值哦 ");
        jumb.setOnClickListener(this);
    }
    private String getMessage(){
        return getIntent().getStringExtra("Java");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("Test","hi 我是来自Java的消息");
        startActivity(intent);
        finish();
    }
}
