package com.example.neven.dim_oficial_neven.adapters;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.neven.dim_oficial_neven.storage.Multiplayer;
import com.example.neven.dim_oficial_neven.fragments.PlayerInfoFragment;
import com.example.neven.dim_oficial_neven.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Neven on 30.6.2016..
 */
public class EquipoListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeaders;
    private HashMap<String, List<Multiplayer>> listDataChild;
    private ImageLoader imageLoader = ImageLoader.getInstance();


    public EquipoListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<Multiplayer>> listChildData) {
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
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        final Multiplayer multiplayerObject = (Multiplayer) getChild(groupPosition, childPosition);


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_layout_for_equipo_fragment, null);


        }

        TextView tvPlayerNumberLeft = (TextView) convertView.findViewById(R.id.tvPlayerNumberID);
        TextView tvPlayerNameLeft = (TextView) convertView.findViewById(R.id.tvPlayerNameID);
        final ImageView ivPlayerPictureLeft = (ImageView) convertView.findViewById(R.id.tvPlayerPictureID);

        TextView tvPlayerNumberRight = (TextView) convertView.findViewById(R.id.tvPlayerNumber2ID);
        TextView tvPlayerNameRight = (TextView) convertView.findViewById(R.id.tvPlayerName2ID);
        final ImageView ivPlayerPictureRight = (ImageView) convertView.findViewById(R.id.tvPlayerPicture2ID);


        tvPlayerNumberLeft.setTypeface(Typeface.DEFAULT_BOLD);
        tvPlayerNameLeft.setTypeface(Typeface.DEFAULT_BOLD);
        tvPlayerNumberRight.setTypeface(Typeface.DEFAULT_BOLD);
        tvPlayerNameRight.setTypeface(Typeface.DEFAULT_BOLD);


        //________________________________LEFT_____________________________

        if (tvPlayerNumberLeft.equals("")) {

            tvPlayerNameLeft.setVisibility(View.INVISIBLE);
            tvPlayerNumberLeft.setVisibility(View.INVISIBLE);
            ivPlayerPictureLeft.setVisibility(View.INVISIBLE);
        } else {

            tvPlayerNameLeft.setText(multiplayerObject.getLeftPlayer().getPlayerName());
            tvPlayerNumberLeft.setText(multiplayerObject.getLeftPlayer().getPlayerNumber());
            imageLoader.displayImage(multiplayerObject.getLeftPlayer().getPlayerPicture(), ivPlayerPictureLeft);
            ivPlayerPictureLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Multiplayer mp = (Multiplayer) getChild(groupPosition, childPosition);
                    Bundle bundle = new Bundle();

                    bundle.putSerializable("dataleft", mp.getLeftPlayer());


                    PlayerInfoFragment playerInfoFragment = new PlayerInfoFragment();
                    playerInfoFragment.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, playerInfoFragment, "PlayerInfoFragment");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                }
            });


        }


        //______________________________________________________________________________


        //________________________________RIGHT_____________________________


        if (tvPlayerNumberRight.equals("")) {

            tvPlayerNameRight.setVisibility(View.INVISIBLE);
            tvPlayerNumberRight.setVisibility(View.INVISIBLE);
            ivPlayerPictureRight.setVisibility(View.INVISIBLE);


        } else {

            tvPlayerNameRight.setText(multiplayerObject.getRightPlayer().getPlayerName());
            tvPlayerNumberRight.setText(multiplayerObject.getRightPlayer().getPlayerNumber());
            imageLoader.displayImage(multiplayerObject.getRightPlayer().getPlayerPicture(), ivPlayerPictureRight);
            ivPlayerPictureRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Multiplayer mp = (Multiplayer) getChild(groupPosition, childPosition);

                    Bundle bundle = new Bundle();

                    bundle.putSerializable("dataright", mp.getRightPlayer());


                    PlayerInfoFragment playerInfoFragment = new PlayerInfoFragment();
                    playerInfoFragment.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, playerInfoFragment, "PlayerInfoFragment");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                }
            });

        }


        //______________________________________________________________________________


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


        } else if (groupPosition == 1) {

            ivLogo.setImageResource(R.drawable.icon_soccerfield_defenders_1x);


        } else if (groupPosition == 2) {

            ivLogo.setImageResource(R.drawable.icon_soccerfield_midfielders_1x);


        } else if (groupPosition == 3) {

            ivLogo.setImageResource(R.drawable.icon_soccerfield_attackers_1x);


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
