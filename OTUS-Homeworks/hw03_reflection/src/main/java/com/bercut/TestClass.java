package com.bercut;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestClass {

    public int a;
    public int b;

    public int testMethod(){
        int i = a + b;
        return i;
    }
}
