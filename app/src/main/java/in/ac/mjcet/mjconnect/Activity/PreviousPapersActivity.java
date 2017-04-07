package in.ac.mjcet.mjconnect.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.ac.mjcet.mjconnect.Adapters.EventAdapter;
import in.ac.mjcet.mjconnect.Adapters.SubjectAdapter;
import in.ac.mjcet.mjconnect.Constants.StringConstants;
import in.ac.mjcet.mjconnect.Models.PreviousPaper;
import in.ac.mjcet.mjconnect.R;
import in.ac.mjcet.mjconnect.Utils.ExpandableHeightGridView;
import in.ac.mjcet.mjconnect.Utils.SquareImageView;
import in.ac.mjcet.mjconnect.Utils.Subject;

public class PreviousPapersActivity extends AppCompatActivity {
    private static final String TAG = "PreviousPapersActivity";

    @BindView(R.id.gridview)
    ExpandableHeightGridView gridView;

    @BindView(R.id.branch_spinner)
    Spinner branchSpinner;

    @BindView(R.id.year_spinner)
    Spinner yearSpinner;

    @BindView(R.id.sem_spinner)
    Spinner semSpinner;

    @BindView(R.id.sub_spinner)
    Spinner subSpinner;



    StorageReference storageReference;
    DatabaseReference databaseReference;

    ArrayAdapter branchAdapter;
    ArrayAdapter semAdapter;
    ArrayAdapter yearAdapter;
    SubjectAdapter subjectAdapter;

    String selectedYear = "4";
    String selectedBranch = "cse";
    String selectedSem = "2";



    HashMap<String, ArrayList<Subject>> subjectHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_papers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference().child("questionpapers");
        databaseReference = FirebaseDatabase.getInstance().getReference("questionPapers");
        databaseReference.keepSynced(true);

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

        subjectHashMap = Subject.getSubjectHashMap();

        subjectAdapter = new SubjectAdapter(this, android.R.layout.simple_spinner_item, subjectHashMap.get(getPath()));
        subSpinner.setAdapter(subjectAdapter);
        initializeSpinnerListners();
    }

    @OnClick(R.id.back_image_button)
    public void backImageButtonClicked(View view){
        finish();
    }

    public String getPath(){
        return selectedBranch+selectedYear+selectedSem;
    }

    public void updateSubjectAdapter(){
        String path = getPath();
        if(selectedYear.contentEquals("1")){
            path = "1";
        }
        subSpinner.setAdapter(new SubjectAdapter(this, android.R.layout.simple_spinner_item, subjectHashMap.get(getPath())));
        updateGridList();
    }

    public void updateGridList(){
        Subject subject = (Subject)subSpinner.getSelectedItem();
        final String subjectId = subject.getId().toLowerCase();
        DatabaseReference ref = databaseReference.child(subjectId);
        final StorageReference sref = storageReference.child(subjectId);
        FirebaseListAdapter firebaseListAdapter = new FirebaseListAdapter(this,Object.class,R.layout.previous_paper_row,ref) {
            @Override
            protected void populateView(View v, Object model, final int position) {
                String imageName = getRef(position).getKey()+".jpg";
                SquareImageView imageView = (SquareImageView)v.findViewById(R.id.SIV);
                Glide.with(v.getContext())
                        .using(new FirebaseImageLoader())
                        .load(sref.child(imageName))
                        .into(imageView);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PreviousPapersActivity.this, PreviousPaperActivity.class);
                        intent.putExtra("position", position);
                        intent.putExtra("path",subjectId);
                        startActivity(intent);
                    }
                });
            }
        };
        gridView.setAdapter(firebaseListAdapter);

    }

    public void initializeSpinnerListners(){
        branchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBranch = branchSpinner.getSelectedItem().toString().toLowerCase();
                updateSubjectAdapter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear = yearSpinner.getSelectedItem().toString();
                updateSubjectAdapter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    selectedSem = "1";
                }else{
                    selectedSem = "2";
                }
                updateSubjectAdapter();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        subSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateGridList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
