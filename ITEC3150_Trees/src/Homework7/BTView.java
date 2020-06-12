package Homework7;



import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class BTView<K extends Comparable<? super K>, V> extends Pane {
  private BSTMap<K, V> tree = new BSTMap<>();
  private double radius = 30; // Tree node radius
  private double vGap = 50; // Gap between two levels in a tree

  BTView(BSTMap<K, V> tree) {
    this.tree = tree;
    //setStatus("Tree is empty");
  }

  public void setStatus(String msg) {
    getChildren().add(new Text(20, 20, msg));
  }

  public void displayTree() {
    this.getChildren().clear(); // Clear the pane
    if (tree.getRoot() != null) {
      // Display tree recursively    
      displayTree(tree.getRoot(), getWidth() / 2, vGap,
        getWidth() / 4);
    }
  }

  /** Display a subtree rooted at position (x, y) */
  private void displayTree(BSTMapNode<K, V> root,
      double x, double y, double hGap) {
    if (root.getLeft() != null) {
      // Draw a line to the left node
      getChildren().add(new Line(x - hGap, y + vGap, x, y));
      // Draw the left subtree recursively
      displayTree(root.getLeft(), x - hGap, y + vGap, hGap / 2);
    }

    if (root.getRight() != null) {
      // Draw a line to the right node
      getChildren().add(new Line(x + hGap, y + vGap, x, y));
      // Draw the right subtree recursively
      displayTree(root.getRight(), x + hGap, y + vGap, hGap / 2);
    }
    
    // Display a node
    Circle circle = new Circle(x, y, radius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    getChildren().addAll(circle,
      new Text(x - 25, y + 4, root.getKey() + "(" + root.getValue() + ")"));
  }
}