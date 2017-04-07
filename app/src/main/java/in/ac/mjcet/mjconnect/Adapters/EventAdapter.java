package in.ac.mjcet.mjconnect.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import in.ac.mjcet.mjconnect.Activity.LoginActivity;
import in.ac.mjcet.mjconnect.Activity.MenuActivity;
import in.ac.mjcet.mjconnect.Constants.StringConstants;
import in.ac.mjcet.mjconnect.EventDetail;
import in.ac.mjcet.mjconnect.Models.Events;
import in.ac.mjcet.mjconnect.Models.User;
import in.ac.mjcet.mjconnect.R;
import in.ac.mjcet.mjconnect.Utils.SharedPreferencesManager;

import org.parceler.Parcels;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by test on 10/03/17.
 */

public class EventAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;
    ImageView mLike,mFavourite;
    Long userCounterCheck;
    private boolean eventLiked=false;
    private boolean eventFavourite=false;

    //Databse references

    DatabaseReference mDatabseLike = FirebaseDatabase.getInstance().getReference().child("likes");
    DatabaseReference mDatabaseFavourites = FirebaseDatabase.getInstance().getReference().child("favourites");
    DatabaseReference mDatabseEvent = FirebaseDatabase.getInstance().getReference().child("events");
    DatabaseReference mDatabaseUsers = FirebaseDatabase.getInstance().getReference().child("users");

    //to chexk user is guest or facebook user
    SharedPreferences sharedPreferences = SharedPreferencesManager.getInstance(getApplicationContext());
    String logginCheck =sharedPreferences.getString(StringConstants.ID,"abc");


 // String provider= FirebaseAuth.getInstance().getCurrentUser().getProviderId();


    public EventAdapter(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
        mDatabseLike.keepSynced(true);
        mDatabseEvent.keepSynced(true);
        mDatabaseFavourites.keepSynced(true);
        mDatabaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userCounterCheck = (Long)dataSnapshot.child(logginCheck).child("counter").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /*  @Override
      public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row, null);
          RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view) {
              @Override
              public String toString() {
                  return super.toString();
              }
          };
          return viewHolder;
      }*/
    // set event details
    public void bindEve(final Events event) {

        final String keyValue = event.getKeyValue();
        final Long counterLikeValue = event.getVotes();
        final int counterFavouriteValue = event.getFavourite();

        ImageView mPosterImage = (ImageView) mView.findViewById(R.id.posterImage);
        TextView nameTextView = (TextView) mView.findViewById(R.id.eventName);
        TextView desc = (TextView) mView.findViewById(R.id.eventDesc);
        TextView mLikeCounter = (TextView) mView.findViewById(R.id.likeCounter);
        TextView mFavouriteCounter = (TextView) mView.findViewById(R.id.favouriteCounter);

        mLike = (ImageView) mView.findViewById(R.id.likeEvent);
        mFavourite = (ImageView) mView.findViewById(R.id.favouriteEvent);

        Glide
            .with(mContext)
            .load(event.getPosterURL())
            .placeholder(R.drawable.empty).into(mPosterImage);

        nameTextView.setText(event.getName());
        desc.setText(event.getDesc());
        mLikeCounter.setText(String.valueOf(counterLikeValue));
        mFavouriteCounter.setText(String.valueOf(counterFavouriteValue));
        //setting colors for like and favourite
        setLikeColor(keyValue);
        setFavouiteColor(keyValue);
        // Like button clik
       mLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logginCheck.equals("0")){
                    //guest user
                    //display alert dialog
                   final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
                    LayoutInflater mInflater = (LayoutInflater) mContext
                            .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                    View dialogView = mInflater.inflate(R.layout.layout_dialog, null);
                    dialogBuilder.setView(dialogView);
                    final Button btnLogin = (Button) dialogView.findViewById(R.id.btn_login);
                    final Button btnBack = (Button) dialogView.findViewById(R.id.btn_back);
                    final AlertDialog dialog = dialogBuilder.create();
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(mContext, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            mContext.startActivity(intent);
                        }
                    });
                    btnBack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }else {
                    //facebook user
                    if (userCounterCheck < 3 || eventLiked) {
                        mDatabseLike.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if (dataSnapshot.child(keyValue).hasChild(logginCheck)) {
                                    mDatabseLike.child(keyValue).child(logginCheck).removeValue();
                                    eventLiked = false;
                                    mDatabseEvent.child(keyValue).child("votes").setValue(counterLikeValue - 1);
                                    mDatabaseUsers.child(logginCheck).child("counter").setValue(userCounterCheck-1);
                                } else {
                                    mDatabseLike.child(keyValue).child(logginCheck).setValue("LIKED");
                                    eventLiked = false;
                                    mDatabseEvent.child(keyValue).child("votes").setValue(counterLikeValue + 1);
                                    mDatabaseUsers.child(logginCheck).child("counter").setValue(userCounterCheck+1);

                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }else{
                      //  Toast.makeText(getApplicationContext(), "Your Likes are finished",
                        //        Toast.LENGTH_LONG).show();
                        //enough likes
                        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
                        LayoutInflater mInflater = (LayoutInflater) mContext
                                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                        View dialogView = mInflater.inflate(R.layout.layout_image_pop, null);
                        dialogBuilder.setView(dialogView);
                        final ImageView mpopImage = (ImageView) dialogView.findViewById(R.id.popImage);
                       // Glide.with(mContext).load(mContext.getPosterURL()).into(mpopImage);
                        final TextView mFinishedLikes = (TextView) dialogView.findViewById(R.id.finishLikes);
                        mpopImage.setVisibility(View.GONE);
                        final AlertDialog dialog = dialogBuilder.create();
                        dialog.show();
                    }

                }
           /*     */

            }
        });

            // favourite is clicked
        mFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logginCheck.equals("0")){
                    //guest user
                    //display alert dialog
                    final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
                    LayoutInflater mInflater = (LayoutInflater) mContext
                            .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                    View dialogView = mInflater.inflate(R.layout.layout_dialog, null);
                    dialogBuilder.setView(dialogView);
                    final Button btnLogin = (Button) dialogView.findViewById(R.id.btn_login);
                    final Button btnBack = (Button) dialogView.findViewById(R.id.btn_back);
                    final AlertDialog dialog = dialogBuilder.create();
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(mContext, LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            mContext.startActivity(intent);
                        }
                    });
                    btnBack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }else {
                    //facebook user
                    eventFavourite =true;

                    mDatabaseFavourites.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (eventFavourite) {
                                if (dataSnapshot.child(keyValue).hasChild(logginCheck)) {
                                    mDatabaseFavourites.child(keyValue).child(logginCheck).removeValue();
                                    eventFavourite=false;
                                    mDatabseEvent.child(keyValue).child("favourite").setValue(counterFavouriteValue-1);
                                } else {
                                    mDatabaseFavourites.child(keyValue).child(logginCheck).setValue("FAVOURITE");
                                    eventFavourite=false;
                                    mDatabseEvent.child(keyValue).child("favourite").setValue(counterFavouriteValue+1);
                                }
                            }


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }
           /*     */

            }
        });

}




    private void setLikeColor(final String keyValue) {
        mDatabseLike.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(keyValue).hasChild(logginCheck)) {
                    mLike.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                    eventLiked = true;
                }else{
                    mLike.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorDivider));
                    eventLiked = false;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void setFavouiteColor(final String keyValue) {
        mDatabaseFavourites.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(keyValue).hasChild(logginCheck)) {
                    mFavourite.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                }else{
                    mFavourite.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorDivider));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onClick(View v) {

        final ArrayList<Events> eventlist = new ArrayList<>();
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("events");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    eventlist.add(snapshot.getValue(Events.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, EventDetail.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("events", Parcels.wrap(eventlist));

                mContext.startActivity(intent);
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}


