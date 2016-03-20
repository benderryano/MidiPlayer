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
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    this.noteView = new NoteView();
    noteView.setLocation(100, 100);
    JScrollPane scrollFrame = new JScrollPane(noteView);
    this.noteView.setAutoscrolls(true);
    scrollFrame.setPreferredSize(new Dimension(1500, 500));
    this.getContentPane().add(scrollFrame);
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
  public void setModel(ModelDisplayAdapter model) {
    this.noteView.setModel(model);
  }

  @Override
  public Dimension getPreferredSize(){
    return new Dimension(1500, 500);
  }

}
