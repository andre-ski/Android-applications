package com.example.assignmentseven.assignmenteight;

import android.graphics.Canvas;
import android.graphics.Paint;

public class SolidCircle {
    protected static int s_screenWidth, s_screenHeight;
    protected float m_x, m_y, m_radius;
    protected Paint m_paint;

    public SolidCircle(float x, float y, float radius, Paint paint) {
        m_x = x;
        m_y = y;
        m_radius = radius;
        m_paint = paint;
    }

    public void setPaint(Paint paint) {
        m_paint = paint;
    }

    public boolean collidesWith(SolidCircle c) {
        double deltaX = Math.abs(c.m_x - m_x);
        double deltaY = Math.abs(c.m_y - m_y);
        double distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));

        return distance <= (m_radius+c.m_radius);
    }

    public void draw(Canvas c) {
        c.drawCircle(m_x, m_y, m_radius, m_paint);
    }

    public static void SetScreenBounds(int width, int height) {
        s_screenWidth = width;
        s_screenHeight = height;
    }
}
