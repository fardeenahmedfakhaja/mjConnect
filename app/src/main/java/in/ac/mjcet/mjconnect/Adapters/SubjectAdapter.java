package in.ac.mjcet.mjconnect.Adapters;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import in.ac.mjcet.mjconnect.Utils.Subject;

/**
 * Created by test on 15/03/17.
 */

public class SubjectAdapter extends ArrayAdapter<Subject> {

    List<Subject> subjectArrayList;

    public SubjectAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public SubjectAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @Override
    public int getCount() {
        return subjectArrayList.size();
    }

    public void setSubjectArrayList(List<Subject> subjectArrayList){
        this.subjectArrayList = subjectArrayList;
        if(subjectArrayList == null){
            this.subjectArrayList = new ArrayList<>();
        }
    }

    @Nullable
    @Override
    public Subject getItem(int position) {
        return subjectArrayList.get(position);
    }

    public SubjectAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Subject[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    public SubjectAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Subject[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public SubjectAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Subject> objects) {
        super(context, resource, objects);
        subjectArrayList = objects;
        if(subjectArrayList == null){
            subjectArrayList = new ArrayList<>(0);
        }
    }

    public SubjectAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Subject> objects) {
        super(context, resource, textViewResourceId, objects);
    }


}
