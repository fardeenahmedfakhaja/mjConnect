package in.ac.mjcet.mjconnect.Holders;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.ac.mjcet.mjconnect.Activity.EventActivity;
import in.ac.mjcet.mjconnect.Activity.EventsActivity;
import in.ac.mjcet.mjconnect.Activity.LoginActivity;
import in.ac.mjcet.mjconnect.Constants.StringConstants;
import in.ac.mjcet.mjconnect.EventDetail;
import in.ac.mjcet.mjconnect.Models.Events;
import in.ac.mjcet.mjconnect.R;
import in.ac.mjcet.mjconnect.Utils.SharedPreferencesManager;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by test on 16/03/17.
 */

public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = "EventsViewHolder";
    public static String userId;

    @BindView(R.id.posterImage)
        ImageView posterImageView;
    @BindView(R.id.eventName)
            TextView eventNameTextView;
    @BindView(R.id.eventDesc)
            TextView descTextView;
    @BindView(R.id.likeCounter)
            TextView likeCounterTextView;
    @BindView(R.id.favouriteCounter)
            TextView favouriteCounterTextView;

    @BindView(R.id.likeEvent)
    ImageButton likeImageButton;

    @BindView(R.id.favouriteEvent)
    ImageButton favouriteImageButton;


    View view;
    Context context;
    Events event;
    DatabaseReference mDatabaseLike;
    DatabaseReference mDatabaseFavourites;
    DatabaseReference mDatabseEvent;
    boolean eventLiked, eventFav;

    static long userCounterCheck;
    static DatabaseReference databaseUserCounter;

    public static void initializeEventViewHolder(Context context){
        userId = SharedPreferencesManager.getInstance(context).getString(StringConstants.ID, null);
        if(userId == null){
            userId = "0";
            return;
        }
        databaseUserCounter = FirebaseDatabase.getInstance().getReference().child("users").child(userId).child("counter");
        databaseUserCounter.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try{
                    //using try,catch for android kitkat versions
                    userCounterCheck = (Long)dataSnapshot.getValue();
                }catch (Exception e){
                    Log.d(TAG, e.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public EventViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        view = itemView;
        context = view.getContext();
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int currentEventPosition = getAdapterPosition();

        Intent intent = new Intent(context, EventActivity.class);
        intent.putExtra("events", Parcels.wrap(event));
        context.startActivity(intent);

    }

    public void onBindView(Events event, int postition){

        mDatabaseLike = FirebaseDatabase.getInstance().getReference().child("likes").child(event.getKeyValue()).child(userId);
        mDatabaseFavourites = FirebaseDatabase.getInstance().getReference().child("favourite").child(event.getKeyValue()).child(userId);
        mDatabseEvent = FirebaseDatabase.getInstance().getReference().child("events").child(event.getKeyValue());

        this.event = event;
        Glide.with(context).load(event.getPosterURL()).placeholder(R.drawable.empty).into(posterImageView);
        eventNameTextView.setText(event.getName());
        descTextView.setText(event.getDesc());
        likeCounterTextView.setText(String.valueOf(event.getVotes()));
        favouriteCounterTextView.setText(String.valueOf(event.getFavourite()));

        if(userId != null){
            setLikeColor();
            setFavouiteColor();
        }
    }

    private void setLikeColor() {
        mDatabaseLike.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    likeImageButton.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                    eventLiked = true;
                }else{
                    likeImageButton.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorDivider));
                    eventLiked = false;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void setFavouiteColor() {
        mDatabaseFavourites.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    favouriteImageButton.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                    eventFav = true;

                }else{
                    favouriteImageButton.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorDivider));
                    eventFav = false;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.likeEvent)
    public void onLikeClicked(ImageButton imageButton){
        if(userId.contentEquals("0")){
            showLoginDialog();
            return;
        }

        if(!eventLiked && userCounterCheck >= 3){
            Toast.makeText(context,"You can only Vote max 3 events",Toast.LENGTH_LONG).show();
            return;
        }

        if(eventLiked){
            mDatabaseLike.removeValue();
            eventLiked = false;
            mDatabseEvent.child("votes").setValue(event.getVotes() - 1);
            Toast.makeText(context,"You have "+(3 - userCounterCheck + 1)+" remaining votes",Toast.LENGTH_SHORT).show();
            databaseUserCounter.setValue(userCounterCheck-1);

        }else{
            mDatabaseLike.setValue("LIKED");
            eventLiked = true;
            mDatabseEvent.child("votes").setValue(event.getVotes() + 1);
            Toast.makeText(context,"You have "+(3 - userCounterCheck - 1)+" remaining votes",Toast.LENGTH_SHORT).show();
            databaseUserCounter.setValue(userCounterCheck + 1);
        }


    }

    @OnClick(R.id.favouriteEvent)
    public void onFavClicked(ImageButton imageButton){
        if(userId.contentEquals("0")){
            showLoginDialog();
            return;
        }

        if(eventFav){
            mDatabaseFavourites.removeValue();
            eventFav = false;
            mDatabseEvent.child("favourite").setValue(event.getFavourite() - 1);
            Toast.makeText(context,"Event Successfully Un-Registered ",Toast.LENGTH_SHORT).show();
        }else{
            mDatabaseFavourites.setValue("FAVORITE");
            eventFav = true;
            mDatabseEvent.child("favourite").setValue(event.getFavourite() + 1);
            Toast.makeText(context,"Event Successfully Registered",Toast.LENGTH_SHORT).show();
        }


    }

    public void showLoginDialog(){
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View dialogView = mInflater.inflate(R.layout.layout_dialog, null);
        dialogBuilder.setView(dialogView);
        final Button btnLogin = (Button) dialogView.findViewById(R.id.btn_login);
        final Button btnBack = (Button) dialogView.findViewById(R.id.btn_back);
        final AlertDialog dialog = dialogBuilder.create();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
