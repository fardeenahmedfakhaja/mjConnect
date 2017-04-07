package in.ac.mjcet.mjconnect.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import in.ac.mjcet.mjconnect.Holders.EventViewHolder;
import in.ac.mjcet.mjconnect.Models.Events;
import in.ac.mjcet.mjconnect.R;

/**
 * Created by test on 16/03/17.
 */

public class EventPlaceHolderFragment extends Fragment {



    public EventPlaceHolderFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        Query mEventReference2 = FirebaseDatabase.getInstance().getReference().child("events").orderByChild("favourite").equalTo(5);
//            mEventReference.keepSynced(true);

        return rootView;
    }
}
