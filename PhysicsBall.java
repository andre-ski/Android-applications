package com.example.assignmentseven.assignmenteight;

import android.graphics.Paint;

public class PhysicsBall extends SolidCircle {
    protected float m_vel[] = {0, 0};
    protected final float FRICTION_COEFFICIENT = 0.98f;
    protected static float GRAVITY = 3.0f;
    protected boolean flung = false;

    public PhysicsBall(float x, float y, float radius, Paint paint) {
        super(x, y, radius, paint);
    }

    public void advance() {
        m_x += m_vel[0];
        m_y += m_vel[1];
        m_vel[1] += GRAVITY;
        m_vel[0] *= FRICTION_COEFFICIENT;
        m_vel[1] *= FRICTION_COEFFICIENT;
         if (m_x+m_radius > s_screenWidth) {
            m_vel[0] *= -1;
            m_x = s_screenWidth - m_radius;
        }
        if (m_x < m_radius) {
            m_vel[0] *= -1;
            m_x = m_radius;
        }
        if (m_y+m_radius > s_screenHeight) {
            m_vel[1] *= -1;
            m_y = s_screenHeight - m_radius;
            flung = false;
        }
    }

    public void accelerate(float x, float y) {
        if (!flung) {
            m_vel[0] += x;
            m_vel[1] += y;
            flung = true;
        }
    }

    public void bounce(SolidCircle c) {
        // Get our normal vector and scale it so the magnitude is 1.0
        float deltaX = c.m_x - m_x;
        float deltaY = c.m_y - m_y;
        float distance = (float)Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
        float normal[] = {deltaX/distance, deltaY/distance};
        /* Do cool maths things (rv = v - 2n(v.n))
           Calculate reflected velocity based on the normal vector we have
         */
        float normalOnOriginal = (m_vel[0]*normal[0]) + (m_vel[1]*normal[1]); // v.n
        float reflectedVelocity[] = m_vel.clone();
        reflectedVelocity[0] = m_vel[0] - (2 * normal[0] * normalOnOriginal);
        reflectedVelocity[1] = m_vel[1] - (2 * normal[1] * normalOnOriginal);

        m_vel = reflectedVelocity;
    }

    public boolean collidesWith(SolidCircle c) {
        if (m_vel[0] < 10.0f || m_vel[1] < 10.0f) // Decide whether we should predict collision instead
            return super.collidesWith(c);
        else {
            double deltaX = Math.abs(c.m_x - m_x - m_vel[0]);
            double deltaY = Math.abs(c.m_y - m_y - m_vel[1]);
            double distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));

            return distance <= (m_radius+c.m_radius);
        }
    }
}
