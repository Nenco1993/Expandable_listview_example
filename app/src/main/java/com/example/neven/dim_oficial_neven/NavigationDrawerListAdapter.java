package com.example.neven.dim_oficial_neven;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Neven on 29.6.2016..
 */
public class NavigationDrawerListAdapter extends BaseExpandableListAdapter {

    private List<String> listDataHeaders;
    private HashMap<String, List<String>> listDataChild;
    private Context context;
    private List<Integer> image;
    public static ImageView ivArrow;


    public NavigationDrawerListAdapter(Context context, List<Integer> image, HashMap<String, List<String>> listDataChild, List<String> listDataHeaders) {
        this.context = context;
        this.image = image;
        this.listDataChild = listDataChild;
        this.listDataHeaders = listDataHeaders;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(this.listDataHeaders.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public int getGroupCount() {
        return listDataHeaders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {


        return this.listDataChild.get(this.listDataHeaders.get(groupPosition))
                .size();


    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeaders.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.header_layout_for_mydrawer, parent,false);

        String headerText = (String) getGroup(groupPosition);


        ImageView ivLogo = (ImageView) v.findViewById(R.id.ivLogoID);
        TextView tvHeaderText = (TextView) v.findViewById(R.id.tvHeaderTextID);
         ivArrow = (ImageView) v.findViewById(R.id.ivArrowID);

        ivLogo.setFocusable(false);
        tvHeaderText.setFocusable(false);
        ivArrow.setFocusable(false);

        tvHeaderText.setText(headerText);
        ivLogo.setImageResource(image.get(groupPosition));




        switch (groupPosition) {

            case 0:

                ivArrow.setVisibility(View.INVISIBLE);


                break;

            case 1:

                ivArrow.setVisibility(View.INVISIBLE);

                break;

            case 2:

                ivArrow.setVisibility(View.INVISIBLE);

                break;


            case 3:

                ivArrow.setVisibility(View.INVISIBLE);

                break;

            case 4:

                ivArrow.setVisibility(View.INVISIBLE);

                break;

            case 5:

                ivArrow.setVisibility(View.INVISIBLE);

                break;

            case 6:


                ivArrow.setVisibility(View.VISIBLE);

                break;

            case 7:

                ivArrow.setVisibility(View.INVISIBLE);

                break;

            case 8:

                ivArrow.setVisibility(View.VISIBLE);

                break;

            case 9:

                ivArrow.setVisibility(View.VISIBLE);

                break;

            case 10:

                ivArrow.setVisibility(View.INVISIBLE);

                break;

            case 11:

                ivArrow.setVisibility(View.INVISIBLE);


                break;




        }


        return v;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.child_layout_for_mydrawer, parent, false);

        final String childText = (String) getChild(groupPosition, childPosition);


        TextView tvChildText = (TextView) v.findViewById(R.id.tvChildTextID);
        tvChildText.setFocusable(false);
        tvChildText.setText(childText);


        return v;


    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


}
