package com.example.pankaj.browsefile;

import android.widget.Button;

/**
 * Created by deepakr on 10/12/2015.
 */
public class FeedRow {
    Button apply,cancel;
    FeedRow(){}


    public Button getApply() {
        return apply;
    }

    public void setApply(Button apply) {
        this.apply = apply;
    }

    public Button getCancel() {
        return cancel;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }
}
