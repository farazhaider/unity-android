package com.labs.leben.unitysimple;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.wrapp.floatlabelededittext.FloatLabeledEditText;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Haider on 11/8/2014.
 */
public class UnitAdapter extends BaseAdapter {

    private List<UnitModel> contactList;
    boolean flag = false;


    public UnitAdapter(List<UnitModel> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.contact_item, parent, false);

        final EditText vNumber = (EditText)itemView.findViewById(R.id.editText);
        vNumber.setHint(contactList.get(position).name);
        FloatLabeledEditText fled=(FloatLabeledEditText)itemView.findViewById(R.id.floatLabelEditText);
        fled.setHint(contactList.get(position).name);


        if(!flag){
            vNumber.setText(contactList.get(position).textfield);
        }
        vNumber.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    if(contactList.get(position).flag) {
                        double inp = Double.parseDouble(vNumber.getText().toString()) * contactList.get(position).factor;
                        for (UnitModel x : contactList) {
                            x.textfield = "" + inp / x.factor;
                        }
                    }
                    else{
                        double inp = Double.parseDouble(vNumber.getText().toString())/contactList.get(position).factor;
                        for (UnitModel x : contactList) {
                            x.textfield = "" +inp*x.factor;
                        }
                    }
                    //flag=true;
                    notifyDataSetChanged();
                    return true;
                }

                return false;
            }
        });
        return itemView;
    }
}
