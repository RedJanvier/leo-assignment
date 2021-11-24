package com.assignment.results;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PropertyListAdapter extends ArrayAdapter<Property> {
    private static final String TAG = "PropertyListAdapter";

    private Context mContext;
    private int mResources;
    private int lastIndex = -1;

    public PropertyListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Property> objects) {
        super(context, resource, objects);
        mContext = context;
        mResources = resource;
    }

    private static class ViewHolder {
        TextView propName;
        TextView propValue;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String value = getItem(position).getValue();

        Property prop = new Property(name, value);
        final View result;
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResources, parent, false);
            holder= new ViewHolder();
            holder.propName = (TextView) convertView.findViewById(R.id.property_name);
            holder.propValue = (TextView) convertView.findViewById(R.id.property_value);
            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


//        Animation animation = AnimationUtils.loadAnimation(mContext,
//                (position > lastPosition) ? R.a : R.anim.load_up_anim);
//        result.startAnimation(animation);
        lastIndex = position;

        holder.propName.setText(prop.getName());
        holder.propValue.setText(prop.getValue());

        return convertView;
    }
}
