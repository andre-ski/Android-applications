package com.example.assignmentseven.assignmenteight;

import android.graphics.Paint;

public class GoalCircle extends SolidCircle {
    public GoalCircle(float x, float y, float radius) {
        super(x, y, radius, new Paint());
        m_paint.setColor(0xFF000000);  // All goal circles are transparent
        GoalFlag = false;
    }

    public boolean GoalFlag;
}
