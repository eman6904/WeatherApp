package com.example.presentation.utils;

import android.text.TextPaint;
import android.text.style.UnderlineSpan;

public class CustomUnderLineSpan extends UnderlineSpan {
    @Override
    public void updateDrawState(TextPaint ds) {
        // نلغي تأثير الـ underline
        ds.setUnderlineText(false);
    }
}
