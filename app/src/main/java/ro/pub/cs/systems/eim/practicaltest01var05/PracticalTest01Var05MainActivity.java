package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    private Button buttonTL, buttonTR, buttonC, buttonBL, buttonBR, buttonNextActivity;
    private EditText textField;
    int totalClicks;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String aux;
            switch(view.getId()) {
                case R.id.practicB1:
                    aux = textField.getText().toString() + "Top Left, ";
                    textField.setText(aux);
                    totalClicks++;
                    break;
                case R.id.practicB2:
                    aux = textField.getText().toString() + "Top Right, ";
                    textField.setText(aux);
                    totalClicks++;
                    break;
                case R.id.practicB3:
                    aux = textField.getText().toString() + "Center, ";
                    textField.setText(aux);
                    totalClicks++;
                    break;
                case R.id.practicB4:
                    aux = textField.getText().toString() + "Bottom Left, ";
                    textField.setText(aux);
                    totalClicks++;
                    break;
                case R.id.practicB5:
                    aux = textField.getText().toString() + "Bottom Right, ";
                    textField.setText(aux);
                    totalClicks++;
                    break;
                case R.id.practicBNextActivity:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                    intent.putExtra(Constants.INDICATIONS, textField.getText().toString());
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
                // ...
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);

        totalClicks = 0;
        buttonTL = (Button)findViewById(R.id.practicB1);
        buttonTR = (Button)findViewById(R.id.practicB2);
        buttonC = (Button)findViewById(R.id.practicB3);
        buttonBL = (Button)findViewById(R.id.practicB4);
        buttonBR = (Button)findViewById(R.id.practicB5);
        buttonNextActivity = (Button)findViewById(R.id.practicBNextActivity);
        textField = (EditText) findViewById(R.id.practicE1);

        buttonTL.setOnClickListener(buttonClickListener);
        buttonTR.setOnClickListener(buttonClickListener);
        buttonC.setOnClickListener(buttonClickListener);
        buttonBL.setOnClickListener(buttonClickListener);
        buttonBR.setOnClickListener(buttonClickListener);
        buttonNextActivity.setOnClickListener(buttonClickListener);
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(Constants.NUMBER_OF_CLICKS, totalClicks);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.NUMBER_OF_CLICKS)) {
            totalClicks = savedInstanceState.getInt(Constants.NUMBER_OF_CLICKS);
        } else {
            totalClicks = 0;
        }
        Toast.makeText(this, "The total clicks are " + totalClicks, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}