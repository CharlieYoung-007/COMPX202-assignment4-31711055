import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineJoin;
import java.util.ArrayList;
import java.util.List;

public class EditableRectangle extends Group implements MyObservable {

    private List<MyListener> listeners = new ArrayList<>();
    private Rectangle rectangle;
    private Anchor[] anchors;

    public EditableRectangle(double x1, double y1, double x2, double y2) {
        rectangle = new Rectangle();
        rectangle.setStroke(Color.FORESTGREEN);
        rectangle.setStrokeWidth(12);
        rectangle.setStrokeLineJoin(StrokeLineJoin.ROUND);
        rectangle.setFill(Color.CORNSILK);

        rectangle.setX(x1);
        rectangle.setY(y1);
        rectangle.setWidth(x2 - x1);
        rectangle.setHeight(y2 - y1);
        getChildren().add(rectangle);

        anchors = new Anchor[4];
        anchors[0] = new Anchor(x1, y1);
        anchors[1] = new Anchor(x2, y2);
        anchors[2] = new Anchor(x1, y2);
        anchors[3] = new Anchor(x2, y1);

        MyListener myListener = new MyListener() {
            @Override
            public void update(MyObservable observable) {
                Anchor an = (Anchor) observable;
                if (an == anchors[0]) {
                    anchors[2].setCenterX(anchors[0].getCenterX());
                    anchors[3].setCenterY(anchors[0].getCenterY());
                } else if (an == anchors[1]) {
                    anchors[2].setCenterY(anchors[1].getCenterY());
                    anchors[3].setCenterX(anchors[1].getCenterX());

                } else if (an == anchors[2]) {
                    anchors[0].setCenterX(anchors[2].getCenterX());
                    anchors[1].setCenterY(anchors[2].getCenterY());

                } else if (an == anchors[3]) {
                    anchors[1].setCenterX(anchors[3].getCenterX());
                    anchors[0].setCenterY(anchors[3].getCenterY());
                }

                double x = Math.min(anchors[0].getCenterX(), anchors[1].getCenterX());
                double y = Math.min(anchors[0].getCenterY(), anchors[1].getCenterY());
                double width = Math.abs(anchors[0].getCenterX() - anchors[1].getCenterX());
                double height = Math.abs(anchors[0].getCenterY() - anchors[1].getCenterY());


                rectangle.setX(x);
                rectangle.setY(y);
                rectangle.setWidth(width);
                rectangle.setHeight(height);

                notifyListeners();
            }
        };

        anchors[0].addListener(myListener);
        anchors[1].addListener(myListener);
        anchors[2].addListener(myListener);
        anchors[3].addListener(myListener);

        getChildren().add(anchors[0]);
        getChildren().add(anchors[1]);
        getChildren().add(anchors[2]);
        getChildren().add(anchors[3]);
    }

    public double getWidth() {
        return Math.abs(anchors[0].getCenterX() - anchors[1].getCenterX());
    }

    public double getHeight() {
        return Math.abs(anchors[0].getCenterY() - anchors[1].getCenterY());
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
