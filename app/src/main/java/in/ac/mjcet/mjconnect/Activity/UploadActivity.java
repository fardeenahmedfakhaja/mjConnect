package in.ac.mjcet.mjconnect.Activity;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.jorgecastilloprz.FABProgressCircle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.ac.mjcet.mjconnect.Adapters.ImageAdapter;
import in.ac.mjcet.mjconnect.Constants.StringConstants;
import in.ac.mjcet.mjconnect.R;
import in.ac.mjcet.mjconnect.Utils.ExpandableHeightGridView;
import in.ac.mjcet.mjconnect.Utils.SharedPreferencesManager;

import static in.ac.mjcet.mjconnect.Constants.NumberConstants.PICK_IMAGE_MULTIPLE;

public class UploadActivity extends AppCompatActivity implements OnCompleteListener {
    private final static String TAG = "UploadActivity";
    private String imageEncoded;
    private List<String> imagesEncodedList;
    private ArrayList<Uri> uriArrayList;
    private ImageAdapter imageAdapter;

    @BindView(R.id.select_images_button)
    Button selectImagesButton;

    @BindView(R.id.image)
    ImageView imageView;

    @BindView(R.id.desc_edit_text)
    EditText descEditText;

    @BindView(R.id.gridview)
    ExpandableHeightGridView gridView;

    @BindView(R.id.upload_button)
    Button uploadButton;

    String userId;
    boolean isUploading = true;
    int uploadedImages;

    StorageReference storageReference;

    ProgressDialog progressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference().child("uploads");

        SharedPreferences sharedPreferences = SharedPreferencesManager.getInstance(getApplicationContext());
        userId = sharedPreferences.getString(StringConstants.ID, "Anonymous");

        isUploading = false;
        uploadedImages = 0;


        uriArrayList = new ArrayList<>();
        imageAdapter = new ImageAdapter(this, uriArrayList);
        gridView.setAdapter(imageAdapter);
        gridView.setExpanded(true);



    }

    @OnClick(R.id.select_images_button)
    public void onSelectImagesButtonClicked(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"), PICK_IMAGE_MULTIPLE);

    }

    @OnClick(R.id.upload_button)
    public void onUploadButtonClicked(View view){
        String description = descEditText.getText().toString();
        if(description.trim().isEmpty()){
            descEditText.setError("Description cannot be empty");
            return;
        }
        uploadedImages = 0;
        String childId = System.currentTimeMillis() + "";
        progressdialog = new ProgressDialog(UploadActivity.this);
        progressdialog.setMessage("Uploading your request....");
        progressdialog.setCancelable(false);
        progressdialog.show();
        description = "Uploaded by "+userId+" \n"+description;
        storageReference.child(childId).child(StringConstants.DESC_FILE_NAME).putBytes(description.getBytes(),new StorageMetadata()).addOnCompleteListener(this);
        for(int i=0,length=uriArrayList.size(); i< length; i++){
            Uri uri = uriArrayList.get(i);
            storageReference.child(childId).child(i+".jpg").putFile(uri,new StorageMetadata()).addOnCompleteListener(this);
        }
    }

    @OnClick(R.id.back_image_button)
    public void onBackImageButtonClicked(View view){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            // When an Image is picked

            if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data
                Log.d(TAG, "Done");
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                imagesEncodedList = new ArrayList<String>();
                if(data.getData()!=null){
                    Log.d(TAG, "here");
                    Uri mImageUri=data.getData();
                    uriArrayList.add(mImageUri);
                }else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        if (data.getClipData() != null) {
                            ClipData mClipData = data.getClipData();
                            for (int i = 0; i < mClipData.getItemCount(); i++) {
                                ClipData.Item item = mClipData.getItemAt(i);
                                Uri uri = item.getUri();
                                uriArrayList.add(uri);
                            }
                        }
                    }
                }
                imageAdapter.notifyDataSetChanged();

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
            e.printStackTrace();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onComplete(@NonNull Task task) {
        uploadedImages++;
        if(uploadedImages > uriArrayList.size()){
            progressdialog.dismiss();
            Toast.makeText(this, "Request successfully uploaded", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
