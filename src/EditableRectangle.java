import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineJoin;

public class EditableRectangle extends Group {

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
            rectangle.xProperty().set(anchor.getCenterX());
            rectangle.yProperty().set(anchor.getCenterY());
            rectangle.setWidth(anchor2.getCenterX()-anchor1.getCenterX());
            rectangle.setHeight(anchor2.getCenterY()-anchor1.getCenterY());
        });

        anchor2.addListener(obs -> {
            Anchor anchor = (Anchor) obs;
            rectangle.setWidth(anchor.getCenterX()-anchor1.getCenterX());
            rectangle.setHeight(anchor.getCenterY()-anchor1.getCenterY());
        });

        getChildren().add(anchor1);
        getChildren().add(anchor2);
    }


}
