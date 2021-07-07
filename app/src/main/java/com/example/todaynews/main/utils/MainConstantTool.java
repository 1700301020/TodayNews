package com.example.todaynews.main.utils;

import androidx.annotation.IntDef;

import static com.example.todaynews.main.utils.MainConstantTool.BEIJING;
import static com.example.todaynews.main.utils.MainConstantTool.HANGZHOU;
import static com.example.todaynews.main.utils.MainConstantTool.SHANGHAI;
import static com.example.todaynews.main.utils.MainConstantTool.SHENZHEN;

//注解的方式 代替魔法数
@IntDef({SHANGHAI,HANGZHOU,BEIJING,SHENZHEN})
public @interface MainConstantTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
