package in.macrocodes.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    TextView txt4;
    Button share,search,credits,twitter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        twitter =  (Button) findViewById(R.id.searchTwitter);
        search =  (Button) findViewById(R.id.searchbtn);
        share = (Button) findViewById(R.id.share);
        credits = (Button) findViewById(R.id.credits) ;
        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,CreditsActivity.class);
                startActivity(intent);
            }
        });

        txt4 = (TextView) findViewById(R.id.txt4);
        txt4.setClickable(true);
        String text = "<a href='https://www.mygov.in/covid-19/'> MyGovt/Covid </a>";
        txt4.setText(Html.fromHtml(text));

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,TwitterSearchActivity.class);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/tiicovidresources/"));
                startActivity(browserIntent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Covid Relief INDIA");
                    String shareMessage= "\nIf you want any kind of information about beds,hospitals meals etc during covid situation then all the information is available on the app.\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });
    }
}