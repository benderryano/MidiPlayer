package cs3500.music.view;

import javax.swing.*;
import java.awt.*;

/**
 * A skeleton Frame (i.e., a window) in Swing
 */
public class GuiViewFrame extends JFrame implements MusicView {

  private final NoteView noteView; // You may want to refine this to a subtype of JPanel

  /**
   * Creates new GuiView
   */
  public GuiViewFrame() {
    this.noteView = new NoteView();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    noteView.setLocation(100, 100);
    //getContentPane().setLayout();
    this.getContentPane().add(noteView);
    this.pack();
  }

  /**
   * Will be called before displaying or playing the view
   *
   * Use this to initialize or reset any data that must be reset
   */
  @Override
  public void initialize(){
    this.setVisible(true);
  }

  /**
   * Set the model which will include the content this view will show
   *
   * @param model new content of this view
   */
  @Override
  public void setModel(ModelDisplay model) {
    this.noteView.setModel(model);
  }

  @Override
  public Dimension getPreferredSize(){
    return new Dimension(1500, 500);
  }

}
