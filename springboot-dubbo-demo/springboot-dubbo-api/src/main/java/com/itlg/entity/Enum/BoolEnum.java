package com.itlg.entity.Enum;

import lombok.Data;
import lombok.Getter;

public enum BoolEnum {
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
