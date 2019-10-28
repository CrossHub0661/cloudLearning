package com.learning.first;

import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuying on 2019/10/28 9:31
 */
@RestController
public class LoopTest {

    public static void main(String[] args) {
        LoopTest loopTest = new LoopTest();
        int result = loopTest.addOneTo();
        System.out.println(result);
    }

    public int addOneTo() {
        int all = 0;
        for(int x = 1 ; x < 100 ; x++) {
            all += x;
        }
        return all;
    }
}
