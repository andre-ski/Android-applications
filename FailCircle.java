package com.example.assignmentseven.assignmenteight;

import android.graphics.Paint;

public class FailCircle extends SolidCircle {
    public FailCircle(float x, float y, float radius) {
        super(x, y, radius, new Paint());
        m_paint.setColor(0xFF000000);  // All fail circles are transparent
    }

    public boolean collidesWith(SolidCircle c) {
        // FailCircles can't collide with each other
        return !(c instanceof FailCircle) && super.collidesWith(c);
    }
}
