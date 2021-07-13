package com.example.http.annotation;

import androidx.annotation.IntDef;

import static com.example.http.annotation.RequestMethod.GET;
import static com.example.http.annotation.RequestMethod.POST;

@IntDef({GET,POST})
public @interface RequestMethod {
    int GET = 1;
    int POST = 2;
}
