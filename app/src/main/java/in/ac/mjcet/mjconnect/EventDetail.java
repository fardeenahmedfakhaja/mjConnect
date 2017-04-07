package in.ac.mjcet.mjconnect;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.ac.mjcet.mjconnect.Adapters.EventPagerAdapter;
import in.ac.mjcet.mjconnect.Models.Events;

public class EventDetail extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private EventPagerAdapter adapterViewPager;
    ArrayList<Events> EventList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);
        //link

        EventList.add((Events) Parcels.unwrap(getIntent().getParcelableExtra("events")));


//        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new EventPagerAdapter(getSupportFragmentManager(), EventList);
        mViewPager.setAdapter(adapterViewPager);
//        mViewPager.setCurrentItem(startingPosition);

    }
}
