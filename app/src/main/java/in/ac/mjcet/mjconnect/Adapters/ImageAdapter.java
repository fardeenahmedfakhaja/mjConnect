package in.ac.mjcet.mjconnect.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import in.ac.mjcet.mjconnect.Utils.SquareImageView;

/**
 * Created by test on 09/03/17.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Uri> imageArrayList;

    public ImageAdapter(Context c, ArrayList imageArrayList) {
        mContext = c;
        this.imageArrayList = imageArrayList;

        if(imageArrayList == null){
            this.imageArrayList = new ArrayList(0);
        }
    }

    public int getCount() {
        return imageArrayList.size();
    }

    public Uri getItem(int position) {
        return imageArrayList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        SquareImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new SquareImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (SquareImageView) convertView;
        }

        imageView.setImageURI(getItem(position));
        return imageView;
    }
}
