import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage stage) {
        Group root = new Group();
        EditableTriangle triangle = new EditableTriangle(100.0, 100.0, 150.0, 50.0, 250.0, 150.0);
        EditableTriangle triangle2 = new EditableTriangle(300.0, 50.0, 300.0, 100.0, 400.0, 60.0);//The second triangle
        EditableRectangle rectangle = new EditableRectangle(100, 200, 300, 300);

        rectangle.addListener(new MyListener() {
            @Override
            public void update(MyObservable observable) {
                System.out.println("This rectangle has changed shape");
            }
        });


        root.getChildren().add(triangle);
        root.getChildren().add(triangle2);
        root.getChildren().add(rectangle);

        Scene scene = new Scene(root, 600, 500, Color.BISQUE);
        stage.setTitle("Assignment 4");
        stage.setScene(scene);


        stage.show();
    }
}


