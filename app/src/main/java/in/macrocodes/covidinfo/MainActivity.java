package in.macrocodes.covidinfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity  {

    WebView wb;
    EditText city;
    ImageButton search;
    String searchText;
    RelativeLayout layout;
    TextView chrome;
    FloatingActionButton up,down;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        up = (FloatingActionButton) findViewById(R.id.up);
        down = (FloatingActionButton) findViewById(R.id.down);
        city = (EditText) findViewById(R.id.city);
        chrome = (TextView) findViewById(R.id.chrome);
        search = (ImageButton) findViewById(R.id.search);
        layout = (RelativeLayout) findViewById(R.id.lay) ;
        wb=(WebView)findViewById(R.id.webView1);

        wb.getSettings().setLoadWithOverviewMode(true);

        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //return true load with system-default-browser or other browsers, false with your webView
                view.loadUrl(url);
                return false;
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
        });


        wb.loadUrl("https://docs.google.com/document/d/e/2PACX-1vQLa5IUS7JfyoxIOWY53QWKgwFKko542K6lJpWkEq7oZRM79Y1H92YZNUZTOrFhWK2n3P6admdwU8YH/pub");

        wb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv, String url) {

                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                    startActivity(intent);
                    return true;
                } else if( url.startsWith("http:") || url.startsWith("https:") ) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                } else if (url.startsWith("mailto:")) {
                    // TODO : handle mail url
                    return true;
                }

                return false;
            }
        });

        chrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://docs.google.com/document/d/e/2PACX-1vQLa5IUS7JfyoxIOWY53QWKgwFKko542K6lJpWkEq7oZRM79Y1H92YZNUZTOrFhWK2n3P6admdwU8YH/pub";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
                down.setVisibility(View.GONE);
                up.setVisibility(View.VISIBLE);
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
                down.setVisibility(View.VISIBLE);
                up.setVisibility(View.GONE);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText = city.getText().toString();
                if (searchText!=null){

                    wb.loadUrl("https://docs.google.com/document/d/e/2PACX-1vQLa5IUS7JfyoxIOWY53QWKgwFKko542K6lJpWkEq7oZRM79Y1H92YZNUZTOrFhWK2n3P6admdwU8YH/pub");
                    wb.findAllAsync(searchText);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(city.getWindowToken(), 0);
                    wb.setInitialScale(200);

                    layout.setVisibility(View.GONE);
                    down.setVisibility(View.GONE);
                    up.setVisibility(View.VISIBLE);
                    city.setText("");
                }

            }
        });

    }

    protected void exitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Yakin Ingin Keluar?");
        builder.setMessage("Ada banyak cerita yang belum kamu baca, yakin mau keluar?");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}