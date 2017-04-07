package in.ac.mjcet.mjconnect.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Comparator;

import in.ac.mjcet.mjconnect.R;
import in.ac.mjcet.mjconnect.Utils.TouchImageView;

public class PreviousPaperActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    public ArrayList<String> keyArrayList;
    public static StorageReference storageReference;
    public static DatabaseReference databaseReference;

    String path;
    int position;
    boolean isInitial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_paper);

        Intent intent = getIntent();
        path = intent.getStringExtra("path");
        position = intent.getIntExtra("position", 0);
        isInitial = true;
        keyArrayList = new ArrayList<>();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        storageReference = FirebaseStorage.getInstance().getReference().child("questionpapers").child(path);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("questionPapers").child(path);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                keyArrayList = new ArrayList<String>();
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    keyArrayList.add(dataSnapshot1.getKey());
                }
                mSectionsPagerAdapter.notifyDataSetChanged();
                if(isInitial){
                    mViewPager.setCurrentItem(position);
                    isInitial = false;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public int position;
        public ArrayList<String> keyArrayList;
        public PlaceholderFragment() {

        }

        public static PlaceholderFragment newInstance(int sectionNumber, ArrayList keyArrayList) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            fragment.position = sectionNumber;
            fragment.keyArrayList = keyArrayList;
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            String imageName = keyArrayList.get(position)+".jpg";
            View rootView = inflater.inflate(R.layout.previous_paper_full_screen, container, false);
            TouchImageView touchImageView = (TouchImageView) rootView.findViewById(R.id.image_view);
            final ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);

            Glide.with(rootView.getContext())
                    .using(new FirebaseImageLoader())
                    .load(storageReference.child(imageName))
                    .listener(new RequestListener<StorageReference, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, StorageReference model, Target<GlideDrawable> target, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getActivity() ,"Unable to load image", Toast.LENGTH_LONG).show();
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, StorageReference model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .placeholder(R.drawable.empty)
                    .error(R.drawable.empty)
                    .into(touchImageView);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position, keyArrayList);
        }

        @Override
        public int getCount() {
            return keyArrayList.size();
        }
    }
}
