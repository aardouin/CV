package com.aardouin.cv.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.aardouin.cv.R;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class ActionBar extends FrameLayout {

    ActionBarListener listener;
    private TextView title;
    private View menuButton;

    public ActionBar(Context context) {
        this(context, null);
    }

    public ActionBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.action_bar, this);
        bind();
    }

    public void setListener(ActionBarListener listener) {
        this.listener = listener;
    }

    protected void bind() {
        title = (TextView) findViewById(R.id.title);

        menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onMenuButtonClicked();
                }
            }
        });


    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    public void setTitle(String title) {
        this.title.setText(title);
    }

    public interface ActionBarListener {
        void onMenuButtonClicked();
    }
}
