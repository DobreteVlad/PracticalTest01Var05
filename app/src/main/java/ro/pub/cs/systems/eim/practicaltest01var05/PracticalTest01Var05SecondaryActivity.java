package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {
    private EditText textField;
    private Button verifyButton, cancelButton;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.practicBVerify:
                    setResult(1, null);
                    break;
                case R.id.practicBCancel:
                    setResult(0, null);
                    break;
            }
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        textField = (EditText) findViewById(R.id.practicE2);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.INDICATIONS)) {
            String indications = intent.getStringExtra(Constants.INDICATIONS);
            textField.setText(indications);
        }
        verifyButton = (Button)findViewById(R.id.practicBVerify);
        verifyButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.practicBCancel);
        cancelButton.setOnClickListener(buttonClickListener);
    }
}