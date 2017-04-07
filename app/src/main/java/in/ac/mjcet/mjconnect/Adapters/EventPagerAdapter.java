package in.ac.mjcet.mjconnect.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import in.ac.mjcet.mjconnect.Activity.EventDetailFragment;
import in.ac.mjcet.mjconnect.Models.Events;

/**
 * Created by KHAJA FARDEEN AHMED on 3/13/2017.
 */

public class EventPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Events> mEventlist;

    public EventPagerAdapter(FragmentManager fm, ArrayList<Events> events) {
        super(fm);
        mEventlist = events;
    }

    @Override
    public Fragment getItem(int position) {
        return EventDetailFragment.newInstance(mEventlist.get(position));
    }

    @Override
    public int getCount() {
        return mEventlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mEventlist   .get(position).getName();
    }
}
