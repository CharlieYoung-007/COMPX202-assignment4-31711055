import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage stage) {
        Group root = new Group();
        EditableTriangle triangle = new EditableTriangle(100.0, 100.0, 150.0, 50.0, 250.0, 150.0);
        EditableTriangle triangle2 = new EditableTriangle(200.0, 50.0, 300.0, 100.0, 400.0, 100.0);//The second triangle
        EditableRectangle rectangle = new EditableRectangle(100, 200, 300, 300);
        Text text = new Text();
        text.setX(400);
        text.setY(30);
        text.setFont(Font.font("Verdana", 20));
        text.setFill(Color.WHITE);


        rectangle.addListener(new MyListener() {
            @Override
            public void update(MyObservable observable) {
//                System.out.println("This rectangle has changed shape");
                text.setText(String.valueOf("Area: " + rectangle.getWidth()
                        * rectangle.getHeight())); //show the height and width of rectangle
            }
        });

        Text text2 = new Text();
        text2.setX(400);
        text2.setY(60);
        text2.setFont(Font.font("Verdana", 20));
        text2.setFill(Color.WHITE);


        rectangle.addListener(new MyListener() {
            @Override
            public void update(MyObservable observable) {
//                System.out.println("This rectangle has changed shape");
                text2.setText(String.valueOf("Perimeter: " + 2 * (rectangle.getWidth() +
                        rectangle.getHeight()))); //show the height and width of rectangle
            }
        });

        root.getChildren().add(triangle);
        root.getChildren().add(triangle2);
        root.getChildren().add(rectangle);
        root.getChildren().add(text);
        root.getChildren().add(text2);

        Scene scene = new Scene(root, 600, 500, Color.BISQUE);
        stage.setTitle("Assignment 4");
        stage.setScene(scene);


        stage.show();
    }
}


