package in.ac.mjcet.mjconnect.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import in.ac.mjcet.mjconnect.Holders.EventViewHolder;
import in.ac.mjcet.mjconnect.Models.Events;
import in.ac.mjcet.mjconnect.Utils.SharedPreferencesManager;

/**
 * Created by test on 16/03/17.
 */

public class FirebaseEventAdapter extends FirebaseRecyclerAdapter<Events, EventViewHolder> {

    Query query;
    DatabaseReference mDatabaseLike = FirebaseDatabase.getInstance().getReference().child("likes");
    DatabaseReference mDatabaseFavourites = FirebaseDatabase.getInstance().getReference().child("favourites");
    DatabaseReference mDatabseEvent = FirebaseDatabase.getInstance().getReference().child("events");
    DatabaseReference mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("users");


    public FirebaseEventAdapter(Class<Events> modelClass, int modelLayout, Class<EventViewHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.query = ref;
        mDatabaseLike.keepSynced(true);
    }

    @Override
    protected void populateViewHolder(EventViewHolder viewHolder, Events model, int position) {
        model.setKeyValue(getRef(position).getKey());
        viewHolder.onBindView(model, position);
    }

}
