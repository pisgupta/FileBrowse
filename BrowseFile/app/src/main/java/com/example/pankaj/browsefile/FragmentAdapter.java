package com.example.pankaj.browsefile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.pankaj.afilechooser.utils.FileUtils;

/**
 * Created by deepakr on 10/12/2015.
 */
public class FragmentAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    private static final int PICKFILE_REQUEST_CODE = 100;
    private static final int REQUEST_CHOOSER = 1234;
    FragmentAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        convertView = inflater.inflate(R.layout.feed_row, parent, false);
        Button apply = (Button) convertView.findViewById(R.id.btnApply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_layout, parent, false);
                builder.setView(view);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                Button browse = (Button) view.findViewById(R.id.btnBrowse);
                browse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent getContentIntent = FileUtils.createGetContentIntent();
                        Intent intent = Intent.createChooser(getContentIntent, "Select a file");
                       ((Activity) context).startActivityForResult(intent, REQUEST_CHOOSER);

                    }
                });
            }
        });
        return convertView;
    }
}

