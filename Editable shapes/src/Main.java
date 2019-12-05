import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage stage) {

        Group root = new Group();
        EditableTriangle triangle = new EditableTriangle(100.0, 100.0, 150.0, 50.0, 250.0, 150.0);
        root.getChildren().add(triangle);

        EditableTriangle triangle2 = new EditableTriangle(250.0, 250.0, 300.0, 100.0, 500.0, 300.0);
        root.getChildren().add(triangle2);

        EditableRectangle rectangle = new EditableRectangle(200,200,100,100);
        root.getChildren().add(rectangle);

        Text t = new Text();
        Text t2 = new Text();
        rectangle.addListener(obs -> {
            double area=rectangle.getRecHeight()*rectangle.getRecWidth();
            t.setText("Area: " +String.valueOf(area)+"px");
        });
        t.setFont(new Font(20));
        t.setX(5);
        t.setY(20);
        root.getChildren().add(t);

        rectangle.addListener(obs -> {
            double perimeter=(2 * (rectangle.getRecHeight() + rectangle.getRecWidth()));
            t2.setText("Perimeter: " +String.valueOf(perimeter)+"px");
        });
        t2.setFont(new Font(20));
        t2.setX(5);
        t2.setY(40);
        root.getChildren().add(t2);

        Scene scene = new Scene(root, 600, 500, Color.BISQUE);
        stage.setTitle("Assignment 4");
        stage.setScene(scene);

        stage.show();
    }
}

interface MyObservable {
    void addListener(MyListener listener);

    void removeListener(MyListener listener);
}

interface MyListener {
    void update(MyObservable observable);
}

class EditableRectangle extends Group implements MyObservable {
    private Rectangle rectangle;
    private Anchor[] anchors;
    private List<MyListener> listeners = new ArrayList<>();

    public double getRecWidth(){
        double w = rectangle.getWidth();
        return w;
    }
    public double getRecHeight(){
        double h= rectangle.getHeight();
        return h;
    }

    public EditableRectangle(double x, double y, double width, double height) {

        rectangle = new Rectangle();
        rectangle.setStroke(Color.FORESTGREEN);
        rectangle.setStrokeWidth(12);
        rectangle.setStrokeLineJoin(StrokeLineJoin.ROUND);
        rectangle.setFill(Color.CORNSILK);

        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);

        getChildren().add(rectangle);
        anchors = new Anchor[4];

        anchors[0] = new Anchor(x, y); // upper right
        anchors[1] = new Anchor(x + rectangle.getWidth(), y + rectangle.getHeight()); // lower right
        anchors[2] = new Anchor(x + rectangle.getWidth(), y); //upper left
        anchors[3] = new Anchor(x, y + rectangle.getHeight()); // lower left

        // When the anchor changes, update the Rectangle's corresponding point
        anchors[0].addListener(obs -> {
            Anchor an = (Anchor) obs;
            rectangle.setX(an.getCenterX());
            rectangle.setY(an.getCenterY());

            rectangle.setWidth(anchors[1].getCenterX() - an.getCenterX());
            rectangle.setHeight(anchors[1].getCenterY() - an.getCenterY());

            anchors[2].setCenterY(an.getCenterY());
            anchors[3].setCenterX(an.getCenterX());

            if(an.getCenterX()>anchors[2].getCenterX()){
                rectangle.setX(anchors[2].getCenterX());
                rectangle.setWidth(an.getCenterX()-anchors[2].getCenterX());
            }
            if(an.getCenterY()>anchors[3].getCenterY()){
                rectangle.setY(anchors[3].getCenterY());
                rectangle.setHeight(an.getCenterY()-anchors[3].getCenterY());
            }


            notifyListeners();
        });
        // When the anchor changes, update the Rectangle's corresponding point
        anchors[1].addListener(obs -> {
            Anchor an = (Anchor) obs;
            rectangle.setWidth(an.getCenterX()-anchors[3].getCenterX());
            rectangle.setHeight(an.getCenterY()-anchors[2].getCenterY());

            anchors[2].setCenterX(an.getCenterX());
            anchors[3].setCenterY(an.getCenterY());

            if(an.getCenterX()<anchors[3].getCenterX()){
                rectangle.setX(an.getCenterX());
                rectangle.setWidth(anchors[3].getCenterX()-an.getCenterX());
            }
            if(an.getCenterY()<anchors[2].getCenterY()){
                rectangle.setY(an.getCenterY());
                rectangle.setHeight(anchors[2].getCenterY()-an.getCenterY());
            }

            notifyListeners();
        });
        // When the anchor changes, update the Rectangle's corresponding point
        anchors[2].addListener(obs -> {
            Anchor an = (Anchor) obs;
            rectangle.setWidth(an.getCenterX() - anchors[0].getCenterX());
            rectangle.setY(an.getCenterY());
            rectangle.setHeight(anchors[1].getCenterY()-an.getCenterY());

            anchors[0].setCenterY(an.getCenterY());
            anchors[1].setCenterX(an.getCenterX());

            if(an.getCenterX()<anchors[0].getCenterX()){
                rectangle.setX(an.getCenterX());
                rectangle.setWidth(anchors[0].getCenterX()-an.getCenterX());
            }
            if(an.getCenterY()>anchors[1].getCenterY()){
                rectangle.setY(anchors[1].getCenterY());
                rectangle.setHeight(an.getCenterY()-anchors[1].getCenterY());
            }

            notifyListeners();
        });
        // When the anchor changes, update the Rectangle's corresponding point
        anchors[3].addListener(obs -> {
            Anchor an = (Anchor) obs;
            rectangle.setX(an.getCenterX());
            rectangle.setWidth(anchors[1].getCenterX()-an.getCenterX());
            rectangle.setHeight(an.getCenterY() - anchors[0].getCenterY());

            anchors[0].setCenterX(an.getCenterX());
            anchors[1].setCenterY(an.getCenterY());

            if(an.getCenterX()>anchors[1].getCenterX()){
                rectangle.setX(anchors[1].getCenterX());
                rectangle.setWidth(an.getCenterX()-anchors[1].getCenterX());
            }
            if(an.getCenterY()<anchors[0].getCenterY()){
                rectangle.setY(an.getCenterY());
                rectangle.setHeight(anchors[0].getCenterY()-an.getCenterY());
            }

            notifyListeners();
        });

        getChildren().add(anchors[0]);
        getChildren().add(anchors[1]);
        getChildren().add(anchors[2]);
        getChildren().add(anchors[3]);

    }
    @Override
    public void addListener(MyListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(MyListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (MyListener listener : listeners) {
            listener.update(this);
        }
    }
}
class EditableTriangle extends Group {

    private Polygon triangle;
    private Anchor[] anchors;

    public EditableTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Create a Polygon with three sides (Triangle)
        triangle = new Polygon();
        triangle.setStroke(Color.FORESTGREEN);
        triangle.setStrokeWidth(12);
        triangle.setStrokeLineJoin(StrokeLineJoin.ROUND);
        triangle.setFill(Color.CORNSILK);

        // Get the ObservableList of points (x1, y1, x2, y2, ...)
        ObservableList<Double> points = triangle.getPoints();
        points.setAll(x1, y1, x2, y2, x3, y3);

        getChildren().add(triangle);

        // Create anchors (handles) for the three corners of the triangle
        anchors = new Anchor[3];
        for (int i = 0; i < 3; i++) {
            final int ifinal = i;
            double x = points.get(2 * i);
            double y = points.get(2 * i + 1);
            anchors[i] = new Anchor(x, y);
            // When the anchor changes, update the Polygon's corresponding point
            anchors[i].addListener(obs -> {
                Anchor an = (Anchor) obs;
                triangle.getPoints().set(2 * ifinal, an.getCenterX());
                triangle.getPoints().set(2 * ifinal + 1, an.getCenterY());
            });
            getChildren().add(anchors[i]);
        }
    }
}

class Anchor extends Circle implements MyObservable {

    private List<MyListener> listeners = new ArrayList<>();

    public Anchor(double x, double y) {
        super(x, y, 10);
        setFill(Color.RED.deriveColor(1, 1, 1, 0.5));
        setStroke(Color.RED);
        setStrokeWidth(2);
        setStrokeType(StrokeType.OUTSIDE);

        setOnMouseDragged(mev -> {
            setCenterX(mev.getX());
            setCenterY(mev.getY());
            notifyListeners();
        });
    }

    @Override
    public void addListener(MyListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(MyListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (MyListener listener : listeners) {
            listener.update(this);
        }
    }
}
