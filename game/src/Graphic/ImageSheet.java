package Graphic;import javafx.geometry.Rectangle2D;import javafx.scene.SnapshotParameters;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.paint.Color;import java.util.ArrayList;public class ImageSheet {//    private ArrayList<Image> imageSheet = new ArrayList<>();    public ArrayList<Image> imageSheet = new ArrayList<>();    public ImageSheet(){    }    public void loadImageViewSheet(String fileDestination){        Image imgSheet = new Image(fileDestination);        for (int i=0; i<13; i++){            for (int j=0; j<23; j++){                imageSheet.add(splitImage(imgSheet, j, i, 64, 64));            }        }    }    public Image splitImage(Image imgSheet, double minX, double minY, double width, double height){        ImageView imageView = new ImageView(imgSheet);        SnapshotParameters snapshotParameters = new SnapshotParameters();        snapshotParameters.setFill(Color.TRANSPARENT);        snapshotParameters.setViewport(new Rectangle2D(minX, minY, width, height));        return imageView.snapshot(snapshotParameters, null);    }    public void test(){        for (int i=0; i<imageSheet.size(); i++){            System.out.println(imageSheet.get(i));        }    }}