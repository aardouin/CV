package com.aardouin.cv.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.aardouin.cv.R;

/**
 * Created by alexisardouin on 01/02/14.
 */
public class LeftDrawerAdapter extends ArrayAdapter {

    public LeftDrawerAdapter(Context context) {
        super(context, R.layout.menu_item, R.id.menu_item_text, MenuItem.values());
    }

    public enum MenuItem {
        Presentation {
            @Override
            public String toString() {
                return "Présentation";
            }
        },
        Formation,
        Experiences {
            @Override
            public String toString() {
                return "Expériences";
            }

        },
        Competences {
            @Override
            public String toString() {
                return "Compétences";
            }
        },
        Loisirs,
        Portfolio,
        PDF,
        Contacts


    }
}
