package in.ac.mjcet.mjconnect.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.ac.mjcet.mjconnect.Constants.StringConstants;
import in.ac.mjcet.mjconnect.R;

public class SyllabusActivity extends AppCompatActivity {
    @BindView(R.id.branch_spinner)
    Spinner branchSpinner;

    @BindView(R.id.year_spinner)
    Spinner yearSpinner;

    @BindView(R.id.sem_spinner)
    Spinner semSpinner;

    @BindView(R.id.web_view)
    WebView webView;

    ArrayAdapter branchAdapter;
    ArrayAdapter semAdapter;
    ArrayAdapter yearAdapter;

    String selectedYear = "4";
    String selectedBranch = "cse";
    String selectedSem = "2-SEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ButterKnife.bind(this);


        branchAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, StringConstants.branches);
        branchAdapter.setDropDownViewResource(R.layout.spinner_row);

        semAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, StringConstants.sem);
        semAdapter.setDropDownViewResource(R.layout.spinner_row);

        yearAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, StringConstants.year);
        yearAdapter.setDropDownViewResource(R.layout.spinner_row);

        branchSpinner.setAdapter(branchAdapter);
        semSpinner.setAdapter(semAdapter);
        yearSpinner.setAdapter(yearAdapter);

        branchSpinner.setSelection(1);
        semSpinner.setSelection(1);
        yearSpinner.setSelection(3);

        initializeSpinnerListners();

        updateWebView();
    }

    @OnClick(R.id.back_image_button)
    public void backImageButtonClicked(View view){
        finish();
    }

    public void updateWebView(){
        String assestUrl = "file:///android_asset/syll/"+selectedBranch.toLowerCase()+"/"+selectedYear+"/"+selectedSem.toLowerCase()+"/txt.html";
        webView.loadUrl(assestUrl);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    public void initializeSpinnerListners(){
        branchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBranch = branchSpinner.getSelectedItem().toString();
                updateWebView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear = yearSpinner.getSelectedItem().toString();
                updateWebView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSem = semSpinner.getSelectedItem().toString();
                updateWebView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
