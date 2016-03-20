package cs3500.music.view;

import cs3500.music.model.Beat;
import cs3500.music.model.Pitch;
import cs3500.music.model.Range;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Viviano on 3/18/2016.
 */
public class NoteView extends JPanel {

  private ModelDisplay model;
  private int stepH = 20, stepW = 20;

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (model == null)
      return;

    Graphics2D g2d = (Graphics2D)g;

    int startY = getStartY(model);
    Range range = model.getRange();
    int rangeLen = range.length();


    for (int x = 0; x < model.getLength(); x++) {
      Beat b = model.getBeatAt(x);
      for (int y = 0; y < rangeLen; y++) {
        if (b != null) {
          switch (b.getStatusAt(Pitch.values()[range.min.ordinal() + y])) {
            default:
            case EMPTY:
              g2d.setColor(Color.BLACK);
              break;
            case HEAD:
              g2d.setColor(Color.BLUE);
              g2d.fillRect(x * stepW, startY + y * stepH, stepW, stepH);
              break;
            case TAIL:
              g2d.setColor(Color.GREEN);
              g2d.fillRect(x * stepW, startY + y * stepH, stepW, stepH);
              break;
          }
        }
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        int left = x * stepW, right = x * stepW + stepW;
        int top = startY + y * stepH, bottom = y * stepH + startY + stepH;
        g2d.drawLine(left, top, right, top);
        g2d.drawLine(left, bottom, right, bottom);
        if (x % 4 == 0) {
          g2d.drawLine(left, top, left, bottom);
        }
      }
    }
    //draw last line
    g2d.drawLine(model.getLength() * stepW, startY, model.getLength() * stepW, startY + rangeLen * stepH);
  }

  private int getStartY(ModelDisplay model) {
    int range = model.getRange().length();
    range *= stepH;
    return getHeight() / 2 - range / 2;
  }

  public void setModel(ModelDisplay model) {
    this.model = model;
  }
}