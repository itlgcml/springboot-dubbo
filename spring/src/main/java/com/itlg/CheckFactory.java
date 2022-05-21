package com.itlg;

import java.util.HashMap;
import java.util.Map;

public final class CheckFactory {
    private static final Map<Integer, Check> checkMap = new HashMap();

    static {
        checkMap.put(100, new Customer());
        checkMap.put(8000, new Clue());
    }

    public static Check getCheck(Integer type) {
        return checkMap.get(type);
    }
}
