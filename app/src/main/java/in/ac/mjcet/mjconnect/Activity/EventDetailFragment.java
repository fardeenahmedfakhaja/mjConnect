package in.ac.mjcet.mjconnect.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.ac.mjcet.mjconnect.Models.Events;
import in.ac.mjcet.mjconnect.R;

/**
 * Created by KHAJA FARDEEN AHMED on 3/13/2017.
 */
public class EventDetailFragment extends Fragment implements View.OnClickListener {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;


    @BindView(R.id.posterImage)
    ImageView mPosterImage;
    @BindView(R.id.EventName) TextView mName;
    @BindView(R.id.rewardTextView) TextView mReward;
    @BindView(R.id.locationTextView) TextView mLocation;
    @BindView(R.id.studentBodyTextView) TextView mStudentBody;
    @BindView(R.id.feeTextView) TextView mFee;
    @BindView(R.id.descTextView)
    TextView mDesc;
    @BindView(R.id.contactPerson) TextView mPerson;
    @BindView(R.id.contactNumber) TextView mContactNo;


    private Events mEvent;
    String imageURL;

    public static EventDetailFragment newInstance(Events event) {
        EventDetailFragment eventDetailFragment = new EventDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("events", Parcels.wrap(event));
        eventDetailFragment.setArguments(args);
        return eventDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = Parcels.unwrap(getArguments().getParcelable("events"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail, container, false);
        ButterKnife.bind(this, view);
        imageURL=mEvent.getPosterURL();
        Glide.with(view.getContext())
                .load(mEvent.getPosterURL())
                .centerCrop()
                .into(mPosterImage);


        mName.setText(mEvent.getName());
        mLocation.setText(mEvent.getLocation());
        mStudentBody.setText(mEvent.getStudentBody());
        mReward.setText(mEvent.getReward());
        mFee.setText(mEvent.getFee());
        mDesc.setText(mEvent.getDesc());
        mPerson.setText(mEvent.getContactPerson());
        mContactNo.setText(mEvent.getContact());
        mPosterImage.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        if (v==mPosterImage){
            Context context=getContext();
            final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View dialogView = mInflater.inflate(R.layout.layout_image_pop, null);
            dialogBuilder.setView(dialogView);
            final ImageView mpopImage = (ImageView) dialogView.findViewById(R.id.popImage);
            Glide.with(context).load(mEvent.getPosterURL()).into(mpopImage);
            final TextView mFinishedLikes = (TextView) dialogView.findViewById(R.id.finishLikes);
            mFinishedLikes.setVisibility(View.GONE);
            final AlertDialog dialog = dialogBuilder.create();
            dialog.show();
        }
    }
}
