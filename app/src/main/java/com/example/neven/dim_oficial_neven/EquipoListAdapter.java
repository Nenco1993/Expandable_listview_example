package com.example.neven.dim_oficial_neven;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Neven on 30.6.2016..
 */
public class EquipoListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeaders;
    private HashMap<String, List<String>> listDataChild;
    private MyApplication app = MyApplication.getInstance();
    private ImageLoader imageLoader = ImageLoader.getInstance();
    private List<String> pictures = new ArrayList<String>();
    SinglePlayer sp;

    private List<String> newlist = new ArrayList<String>();


    public EquipoListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listChildData) {
        this.context = context;
        this.listDataHeaders = listDataHeader;
        this.listDataChild = listChildData;

    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {


        return this.listDataChild.get(this.listDataHeaders.get(groupPosition)).get(childPosititon);


    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        String childText = (String) getChild(groupPosition, childPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_layout_for_equipo_fragment, null);


        }

        TextView tvPlayerNumber = (TextView) convertView.findViewById(R.id.tvPlayerNumberID);
        TextView tvPlayerName = (TextView) convertView.findViewById(R.id.tvPlayerNameID);
        ImageView ivPlayerPicture = (ImageView) convertView.findViewById(R.id.tvPlayerPictureID);


        tvPlayerName.setText(childText);


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeaders.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {


        return this.listDataHeaders.get(groupPosition);
    }


    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {


        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.header_layout_for_equipo_fragment, null);
        }

        ExpandableListView elv = (ExpandableListView) parent;
        elv.expandGroup(groupPosition);


        TextView tvText = (TextView) convertView.findViewById(R.id.tvHeaderTextID);
        ImageView ivLogo = (ImageView) convertView.findViewById(R.id.ivHeaderImageID);
        tvText.setText(headerTitle);

        if (groupPosition == 0) {


            ivLogo.setImageResource(R.drawable.icon_soccerfield_goalkeepers_1x);
            //tvText.setText("ARQUEROS");


        } else if (groupPosition == 1) {

            ivLogo.setImageResource(R.drawable.icon_soccerfield_defenders_1x);
            // tvText.setText("DEFENSAS");


        } else if (groupPosition == 2) {

            ivLogo.setImageResource(R.drawable.icon_soccerfield_midfielders_1x);
            //tvText.setText("MEDIOCAMPISTAS");


        } else if (groupPosition == 3) {

            ivLogo.setImageResource(R.drawable.icon_soccerfield_attackers_1x);
            // tvText.setText("DELANTEROS");


        }


        return convertView;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeaders.size();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return true;
    }


}
