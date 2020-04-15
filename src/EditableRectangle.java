import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineJoin;

import java.util.ArrayList;
import java.util.List;

public class EditableRectangle extends Group implements MyObservable {

    private List<MyListener> listeners = new ArrayList<>();

    public EditableRectangle(double x1, double y1, double x2, double y2) {
        Rectangle rectangle = new Rectangle();//initial the rectangle
        rectangle.setStroke(Color.FORESTGREEN);
        rectangle.setStrokeWidth(12);
        rectangle.setStrokeLineJoin(StrokeLineJoin.ROUND);
        rectangle.setFill(Color.CORNSILK);

        rectangle.setX(x1);
        rectangle.setY(y1);
        rectangle.setWidth(x2 - x1);
        rectangle.setHeight(y2 - y1);
        getChildren().add(rectangle);

        Anchor anchor1 = new Anchor(x1, y1); //the first anchor
        Anchor anchor2 = new Anchor(x2, y2); // the second anchor

        anchor1.addListener(obs -> {
            Anchor anchor = (Anchor) obs;
            if (anchor1.getCenterX() < anchor2.getCenterX()) {
                rectangle.xProperty().set(anchor.getCenterX());
                rectangle.setWidth(anchor2.getCenterX() - anchor.getCenterX());
            } else {
                rectangle.setWidth(anchor.getCenterX() - anchor2.getCenterX());
            }
            if (anchor1.getCenterY() < anchor2.getCenterY()) {
                rectangle.yProperty().set(anchor.getCenterY());
                rectangle.setHeight(anchor2.getCenterY() - anchor.getCenterY());
            }else {
                rectangle.setHeight(anchor.getCenterY() - anchor2.getCenterY());
            }
            notifyListeners();
        });

        anchor2.addListener(obs -> {
            Anchor anchor = (Anchor) obs;
            if (anchor1.getCenterX() < anchor2.getCenterX()) {
                rectangle.setWidth(anchor.getCenterX() - anchor1.getCenterX());
            } else {
                rectangle.xProperty().set(anchor.getCenterX());
                rectangle.setWidth(anchor1.getCenterX() - anchor.getCenterX());
            }
            if (anchor1.getCenterY() < anchor2.getCenterY()) {

                rectangle.setHeight(anchor.getCenterY() - anchor1.getCenterY());
            }else {
                rectangle.yProperty().set(anchor.getCenterY());
                rectangle.setHeight(anchor1.getCenterY() - anchor.getCenterY());
            }
            notifyListeners();
        });

        getChildren().add(anchor1);
        getChildren().add(anchor2);
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
