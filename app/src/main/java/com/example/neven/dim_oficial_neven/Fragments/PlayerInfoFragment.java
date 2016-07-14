package com.example.neven.dim_oficial_neven.fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neven.dim_oficial_neven.R;
import com.example.neven.dim_oficial_neven.storage.SinglePlayer;
import com.nostra13.universalimageloader.core.ImageLoader;

import static java.lang.Thread.sleep;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerInfoFragment extends Fragment {


    private ImageLoader imageLoader = ImageLoader.getInstance();


    public PlayerInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_player_information, container, false);


        ImageView ivPlayerInfoLogo = (ImageView) v.findViewById(R.id.ivPlayerInfoLogoID);
        TextView tvPlayerInfoName = (TextView) v.findViewById(R.id.tvPlayerInfoPlayerNameID);
        tvPlayerInfoName.setTypeface(Typeface.DEFAULT_BOLD);
        TextView tvPlayerInfoNumber = (TextView) v.findViewById(R.id.tvPlayerInfoPlayerNumberID);
        tvPlayerInfoNumber.setTypeface(Typeface.DEFAULT_BOLD);
        TextView tvPlayerInfoNation = (TextView) v.findViewById(R.id.tvPlayerInfoNationValueID);
        TextView tvPlayerInfoAge = (TextView) v.findViewById(R.id.tvPlayerInfoPlayerAgeID);
        TextView tvPlayerInfoPosition = (TextView) v.findViewById(R.id.tvPlayerInfoPositionID);
        TextView tvPlayerInfoDominantHand = (TextView) v.findViewById(R.id.tvPlayerInfoDominantHandID);
        TextView tvHabilidades = (TextView) v.findViewById(R.id.tvHabilidadesID);
        tvHabilidades.setTypeface(Typeface.DEFAULT_BOLD);

        TextView tvNationMain = (TextView) v.findViewById(R.id.tvNationMain);
        tvNationMain.setTypeface(Typeface.DEFAULT_BOLD);

        TextView tvAgeMain = (TextView) v.findViewById(R.id.tvAgeMain);
        tvAgeMain.setTypeface(Typeface.DEFAULT_BOLD);
        TextView tvPositionMain = (TextView) v.findViewById(R.id.tvPositionMain);
        tvPositionMain.setTypeface(Typeface.DEFAULT_BOLD);

        TextView tvPiernaMain = (TextView) v.findViewById(R.id.tvPiernaMain);
        tvPiernaMain.setTypeface(Typeface.DEFAULT_BOLD);

        TextView tvDefensa = (TextView) v.findViewById(R.id.tvDefensaHeadline);
        TextView tvAttack = (TextView) v.findViewById(R.id.tvAtaqueHeadline);
        TextView tvSpeed = (TextView) v.findViewById(R.id.tvVelocidadheadline);
        TextView tvTechnique = (TextView) v.findViewById(R.id.tvTecnicaHeadline);
        TextView tvPunch = (TextView) v.findViewById(R.id.tvGolpeHeadlineID);
        TextView tvStrength = (TextView) v.findViewById(R.id.tvFuerzaHeadlineID);

        tvDefensa.setTextColor(Color.parseColor("#191970"));
        tvAttack.setTextColor(Color.parseColor("#191970"));
        tvSpeed.setTextColor(Color.parseColor("#191970"));
        tvTechnique.setTextColor(Color.parseColor("#191970"));
        tvPunch.setTextColor(Color.parseColor("#191970"));
        tvStrength.setTextColor(Color.parseColor("#191970"));


        TextView tvPlayerInfoSpeed = (TextView) v.findViewById(R.id.tvLightingID);
        TextView tvPlayerInfoAttack = (TextView) v.findViewById(R.id.tvAttackID);
        TextView tvPlayerInfoDefense = (TextView) v.findViewById(R.id.tvDefendID);
        TextView tvPlayerInfoTechnique = (TextView) v.findViewById(R.id.tvShoeID);
        TextView tvPlayerInfoStrenght = (TextView) v.findViewById(R.id.tvGymID);
        TextView tvPlayerInfoPunch = (TextView) v.findViewById(R.id.tvBallID);


        if (getArguments().getSerializable("dataleft") != null) {

            SinglePlayer getArgs = (SinglePlayer) getArguments().getSerializable("dataleft");


            tvPlayerInfoName.setText(getArgs.getPlayerName());
            tvPlayerInfoAge.setText(getArgs.getPlayerAge());
            tvPlayerInfoNumber.setText(getArgs.getPlayerNumber());
            tvPlayerInfoNation.setText(getArgs.getPlayerNation());
            tvPlayerInfoDominantHand.setText(getArgs.getPlayerDominantHand());
            tvPlayerInfoPosition.setText(getArgs.getPlayerPosition());
            imageLoader.displayImage(getArgs.getPlayerPicture(), ivPlayerInfoLogo);


            tvPlayerInfoSpeed.setText(getArgs.getPlayerSpeed());
            tvPlayerInfoAttack.setText(getArgs.getPlayerAttack());
            tvPlayerInfoDefense.setText(getArgs.getPlayerDefense());
            tvPlayerInfoTechnique.setText(getArgs.getPlayerTechnique());
            tvPlayerInfoStrenght.setText(getArgs.getPlayerStrength());
            tvPlayerInfoPunch.setText(getArgs.getPlayerPunch());


        } else if (getArguments().getSerializable("dataright") != null) {

            SinglePlayer getArgs = (SinglePlayer) getArguments().getSerializable("dataright");


            tvPlayerInfoName.setText(getArgs.getPlayerName());
            tvPlayerInfoAge.setText(getArgs.getPlayerAge());
            tvPlayerInfoNumber.setText(getArgs.getPlayerNumber());
            tvPlayerInfoNation.setText(getArgs.getPlayerNation());
            tvPlayerInfoDominantHand.setText(getArgs.getPlayerDominantHand());
            tvPlayerInfoPosition.setText(getArgs.getPlayerPosition());
            imageLoader.displayImage(getArgs.getPlayerPicture(), ivPlayerInfoLogo);


            tvPlayerInfoSpeed.setText(getArgs.getPlayerSpeed());
            tvPlayerInfoAttack.setText(getArgs.getPlayerAttack());
            tvPlayerInfoDefense.setText(getArgs.getPlayerDefense());
            tvPlayerInfoTechnique.setText(getArgs.getPlayerTechnique());
            tvPlayerInfoStrenght.setText(getArgs.getPlayerStrength());
            tvPlayerInfoPunch.setText(getArgs.getPlayerPunch());


        }


        return v;
    }


}
