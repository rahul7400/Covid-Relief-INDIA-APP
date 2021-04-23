package in.macrocodes.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TwitterSearchActivity extends AppCompatActivity {

    CheckBox bed,icu,ventilators,tiffin,plasma,Tocilizumab,Favipiravir,Remdesivir,Fabiflu,oxygen;
    List<String> checked = new ArrayList<>();
    String url = "https://twitter.com/search?q=verified+";
    String b="false",i="false",v="false",t="false",p="false",To="false",F="false",Rem="false",Fab="false",ox="false";
    EditText city;
    ImageButton search;
    String checks="";
    String mainUrl = "";
    String veri = "+-\"not+verified\"+-\"unverified\"+-\"needed\"+-\"required\"&f=live";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_search);
        oxygen = (CheckBox) findViewById(R.id.oxygen);
        bed = (CheckBox) findViewById(R.id.bed);
        icu = (CheckBox) findViewById(R.id.icu);
        ventilators = (CheckBox) findViewById(R.id.ventilators);
        tiffin = (CheckBox) findViewById(R.id.tiffin);
        plasma = (CheckBox) findViewById(R.id.plasma);
        Tocilizumab = (CheckBox) findViewById(R.id.Tocilizumab);
        Favipiravir = (CheckBox) findViewById(R.id.Favipiravir);
        Remdesivir = (CheckBox) findViewById(R.id.remdesivir);
        Fabiflu = (CheckBox) findViewById(R.id.fabiflu);

        Listners();
        city = (EditText) findViewById(R.id.city);
        search = (ImageButton) findViewById(R.id.search2);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (city.getText().toString()==null){
                    Toast.makeText(TwitterSearchActivity.this, "Enter city name please", Toast.LENGTH_SHORT).show();
                }else{
                    generateLinks();
                    mainUrl = url+city.getText().toString()+checks+"+plasma"+veri;
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mainUrl));
                    startActivity(browserIntent);

                    checks = "";
                    mainUrl="";
                }

            }
        });



    }
    public void generateLinks(){
        if (ox.equalsIgnoreCase("true")){
            checks = checks.concat("+oxygen+OR");
        }
        if (b.equalsIgnoreCase("true")){
            checks = checks.concat("+bed+OR+beds+OR");
        }
        if (i.equalsIgnoreCase("true")){
            checks = checks.concat("+icu+OR");
        }
        if (v.equalsIgnoreCase("true")){
            checks = checks.concat("+ventilator+OR");
        }
        if (Fab.equalsIgnoreCase("true")){
            checks = checks.concat("+fabiflu+OR");
        }
        if (Rem.equalsIgnoreCase("true")){
            checks = checks.concat("+remdesivir+OR");
        }
        if (F.equalsIgnoreCase("true")){
            checks = checks.concat("+favipiravir+OR");
        }
        if (p.equalsIgnoreCase("true")){
            checks = checks.concat("+plasma+OR");
        }
        if (t.equalsIgnoreCase("true")){
            checks = checks.concat("+tiffin+OR");
        }
        if (To.equalsIgnoreCase("true")){
            checks = checks.concat("+tocilizumab+OR");
        }
    }
    public void Listners(){
        oxygen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ox = "true";
                }else{
                    ox = "false";
                }
            }
        });
        bed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    b = "true";
                }else{
                    b = "false";
                }
            }
        });
        tiffin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    t = "true";
                }else{
                    t = "false";
                }
            }
        });
        plasma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    p = "true";
                }else{
                    p = "false";
                }
            }
        });
        icu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    i = "true";
                }else{
                    i = "false";
                }
            }
        });
        ventilators.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    v = "true";
                }else{
                    v = "false";
                }
            }
        });
        Fabiflu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Fab = "true";
                }else{
                    Fab = "false";
                }
            }
        });
        Remdesivir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Rem = "true";
                }else{
                    Rem = "false";
                }
            }
        });
        Favipiravir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    F = "true";
                }else{
                    F = "false";
                }
            }
        });
        Tocilizumab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    To = "true";
                }else{
                    To = "false";
                }
            }
        });

    }
}