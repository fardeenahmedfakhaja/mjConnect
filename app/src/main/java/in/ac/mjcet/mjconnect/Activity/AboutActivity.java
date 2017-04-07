package in.ac.mjcet.mjconnect.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.ac.mjcet.mjconnect.R;

public class AboutActivity extends AppCompatActivity {
    StorageReference storageReference;

    @BindView(R.id.aleem)
    ImageView aleemImageView;

    @BindView(R.id.faiyaz)
    ImageView faiyazImageView;

    @BindView(R.id.zohaib)
    ImageView zohaibImageView;

    @BindView(R.id.aamir)
    ImageView aamirImageView;

    @BindView(R.id.rafi)
    ImageView rafiImageView;
    @BindView(R.id.fardeen)
    ImageView fardeenImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference().child("team");
        loadImages();
    }

    @OnClick(R.id.back_image_button)
    public void onBackImageButtonClicked(View view){
        finish();
    }

    public void loadImages(){
        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(storageReference.child("aleem.jpg"))
                .placeholder(R.drawable.empty)
                .into(aleemImageView);
        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(storageReference.child("faiyaz.jpg"))
                .placeholder(R.drawable.empty)
                .into(faiyazImageView);
        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(storageReference.child("fardeen.jpg"))
                .placeholder(R.drawable.empty)
                .into(fardeenImageView);
        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(storageReference.child("zohaib.jpg"))
                .placeholder(R.drawable.empty)
                .into(zohaibImageView);
        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(storageReference.child("aamir.jpg"))
                .placeholder(R.drawable.empty)
                .into(aamirImageView);
        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(storageReference.child("rafi.jpg"))
                .placeholder(R.drawable.empty)
                .into(rafiImageView);
    }
}
