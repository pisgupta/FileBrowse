package com.example.pankaj.browsefile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pankaj.afilechooser.utils.FileUtils;

import java.io.File;

/**
 * Created by deepakr on 10/12/2015.
 */
public class FragmentFirst extends Fragment {
    ListView lv;
    private static final int REQUEST_CHOOSER = 1234;
    FragmentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        lv = (ListView) v.findViewById(R.id.list);
        adapter = new FragmentAdapter(getActivity());
        lv.setAdapter(adapter);
        return v;

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case REQUEST_CHOOSER:
                if (resultCode == getActivity().RESULT_OK) {
                    final Uri uri = data.getData();
                    // Get the File path from the Uri
                    String path = FileUtils.getPath(getActivity(), uri);
                    // Alternatively, use FileUtils.getFile(Context, Uri)
                    if (path != null && FileUtils.isLocal(path)) {
                        File file = new File(path);
                        //txtpath.setText(file.getAbsolutePath());
                        Log.e("File Path",file.getAbsolutePath());
                    }
                }

                break;
        }
    }
}
