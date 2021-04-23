package in.macrocodes.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.TextView;

public class CreditsActivity extends AppCompatActivity {
    TextView txt4,txt5,txt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);


        txt4 = (TextView) findViewById(R.id.txt4);
        txt5 = (TextView) findViewById(R.id.txt5);
        txt6 = (TextView) findViewById(R.id.txt6);

        txt4.setClickable(true);
        txt5.setClickable(true);
        txt6.setClickable(true);


        String text = "<a href='https://www.mygov.in/covid-19/'> MyGovt/Covid </a>";
        txt4.setText(Html.fromHtml(text));

        String text2 = "<a href=\"https://www.instagram.com/tiicovidresources/\">TIICovidResources instagram account</a>";
        txt5.setText(Html.fromHtml(text2));

        String text3 = "<a href=\"https://www.instagram.com/8bit_goldy/?hl=en\">Lokesh Jain instagram account</a>";
        txt6.setText(Html.fromHtml(text3));


        txt4.setMovementMethod(LinkMovementMethod.getInstance());
        txt5.setMovementMethod(LinkMovementMethod.getInstance());
        txt6.setMovementMethod(LinkMovementMethod.getInstance());


    }
}