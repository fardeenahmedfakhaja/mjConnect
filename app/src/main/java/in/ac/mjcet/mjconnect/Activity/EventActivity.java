package in.ac.mjcet.mjconnect.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.ac.mjcet.mjconnect.Models.Events;
import in.ac.mjcet.mjconnect.R;

public class EventActivity extends AppCompatActivity {


    @BindView(R.id.event_image_view)
    ImageView eventImageView;

    @BindView(R.id.locationTextView)
    TextView locationTextView;

    @BindView(R.id.feeTextView)
    TextView feeTextView;

    @BindView(R.id.rewardTextView)
    TextView rewardTextView;

    @BindView(R.id.contactPerson)
    TextView contactPersonTextView;

    @BindView(R.id.contactNumber)
    TextView contactNumberTextView;

    @BindView(R.id.desc_text_view)
    TextView descTextView;

    @BindView(R.id.likeTextView)
    TextView likeTextView;

    @BindView(R.id.favouriteTextView)
    TextView favouriteTextView;

    private Events events;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        events = (Events) Parcels.unwrap(getIntent().getParcelableExtra("events"));
        getSupportActionBar().setTitle(""+events.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ButterKnife.bind(this);
        Glide.with(this).load(events.getPosterURL()).into(eventImageView);

        descTextView.setText(""+events.getDesc());
        locationTextView.setText(""+events.getLocation());
        feeTextView.setText(""+events.getFee());
        rewardTextView.setText(""+events.getReward());
        contactPersonTextView.setText(""+events.getContactPerson());
        contactNumberTextView.setText(""+events.getContact());
        likeTextView.setText(""+events.getVotes());
        favouriteTextView.setText(""+events.getFavourite());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
