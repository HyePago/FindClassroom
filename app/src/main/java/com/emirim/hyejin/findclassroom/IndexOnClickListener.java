package com.emirim.hyejin.findclassroom;

import android.view.View;

public abstract class IndexOnClickListener implements View.OnClickListener {
    protected int index;

    public IndexOnClickListener(int index) {
        this.index = index;
    }
}
