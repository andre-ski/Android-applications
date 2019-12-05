package com.example.assignmentseven.assignmenteight;

import android.content.Context;
import android.content.Intent;
import android.gesture.Gesture;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.assignmentseven.assignmenteight.Scoring.Input;

import java.util.ArrayList;

public class GraphicsView extends View {
    protected ArrayList<SolidCircle> m_balls = new ArrayList<SolidCircle>();
    protected PhysicsBall m_controlledBall;
    protected GoalCircle m_goalCircle;
    protected int m_score = 0;


    public GraphicsView(Context c) {
        super(c);

        final GestureDetector gestureDetector = new GestureDetector(getContext(), new FlingGestureDetector());
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });

        Paint newPaint = new Paint();
        newPaint.setColor(0xFF000000);
        m_balls.add(new SolidCircle(300, 750, 25, newPaint));
        newPaint = new Paint();
        newPaint.setColor(0xFFFBA000);
        m_controlledBall = new PhysicsBall(800, 1500, 100, newPaint);
        m_balls.add(m_controlledBall);
        m_goalCircle = new GoalCircle(150, 850, 50);
        m_balls.add(m_goalCircle);
        for (int i = 0; i < 7; i++ )
            m_balls.add(new FailCircle(375.0f + (i*110), 800.0f, 5.0f));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (SolidCircle c : m_balls) {
            c.draw(canvas);
            if (c == m_controlledBall) {
                m_controlledBall.advance();
                for (SolidCircle d : m_balls) {
                    if (c.collidesWith(d) && c != d) {
                        if (d instanceof GoalCircle) {
                            if (!m_goalCircle.GoalFlag) {
                                ((GoalCircle) d).GoalFlag = true;
                                m_score += (m_controlledBall.m_vel[1] > 0) ? 1 : 0;
                                Log.i("SCORE", Integer.toString(m_score));
                            }
                        }
                        else if (d instanceof FailCircle) {
                            if (m_controlledBall.m_vel[1] > 0 && m_controlledBall.flung) {
                                Intent intent = new Intent(getContext(), Input.class);
                                intent.putExtra("SCORE", m_score);
                                getContext().startActivity(intent);
                                m_balls.remove(m_controlledBall);
                                Paint newPaint = new Paint();
                                newPaint.setColor(0xFFFBA000);
                                m_controlledBall = new PhysicsBall(800, 1500, 100, newPaint);
                                m_balls.add(m_controlledBall);
                                m_score = 0;
                                return;
                            }
                        }
                        else
                            m_controlledBall.bounce(d);
                    }
                }
            }
        }
        if (!m_controlledBall.collidesWith(m_goalCircle))
            m_goalCircle.GoalFlag = false;

        Paint textPaint = new Paint();
        textPaint.setColor(0xFF000000);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(96);
        canvas.drawText("Score: " + m_score, 0, 96, textPaint);

        invalidate();
    }

    class FlingGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            for (SolidCircle c : m_balls) {
                if (c instanceof PhysicsBall) {
                    ((PhysicsBall) c).accelerate(velocityX/120, velocityY/120);
                    break;
                }
            }
            return true;
        }
    }
}
