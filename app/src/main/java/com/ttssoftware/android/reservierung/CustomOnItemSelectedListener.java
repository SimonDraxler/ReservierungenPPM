package com.ttssoftware.android.reservierung;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Simon on 27.01.2016.
 */
public class CustomOnItemSelectedListener  implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,
                               long id) {
        Toast.makeText(parent.getContext(),"On Item Select : \n" + parent.getItemAtPosition(pos).toString(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}
