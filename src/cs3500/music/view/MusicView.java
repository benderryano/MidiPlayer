package cs3500.music.view;

import cs3500.music.model.MusicModel;

/**
 * Created by Viviano on 3/18/2016.
 */
public interface MusicView {

  /**
   * Will be called in order to displaying or play the view
   *
   * Use this to initialize or reset any data that must be reset
   */
  void initialize();

  /**
   * Set the model which will include the content this view will show
   *
   * @param model new content of this view
   */
  void setModel(ModelDisplay model);
}
