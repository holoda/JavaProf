package com.bercut.holodkov;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.util.List;

public class HelloOtus {
    public void CallGuava(){
        List<String> list = Lists.newArrayList("H", "e", "l", "l","o");

        String result = Joiner.on("-").join(list);

        System.out.println(result);
    }
}
