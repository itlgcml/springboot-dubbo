package com.itlg.entity.Enum;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

public enum BoolEnum implements Serializable {
    TRUE(true),
    FALSE(false);

    private boolean bool;

    BoolEnum(boolean bool) {
        this.bool = bool;
    }

    public boolean getBool() {
        return bool;
    }
}
