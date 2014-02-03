package com.aardouin.cv.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aardouin.cv.R;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class ContactsFragment extends Fragment {

    public final static String TAG = "CONTACTS_FRAGMENT";
    private View mRootView;
    private TextView mPhone;
    private TextView mEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.contacts_container, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEmail = (TextView) mRootView.findViewById(R.id.email);
        mPhone = (TextView) mRootView.findViewById(R.id.phone);

        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.email)});
                startActivity(intent);
            }
        });

        mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + getResources().getString(R.string.phone).trim()));
                startActivity(intent);
            }
        });

    }
}
