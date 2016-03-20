package cs3500.music;

import cs3500.music.model.MusicModel;
import cs3500.music.util.GenericMusicModelBuilder;
import cs3500.music.util.MusicReader;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.ModelDisplayAdapterImpl;

import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MusicEditor {

  private static String
          mary = "res/mary-little-lamb.txt",
          myst1 = "res/mystery-1.txt",
          myst2 = "res/mystery-2.txt",
          myst3 = "res/mystery-3.txt";

  public static void main(String[] args) throws IOException, InvalidMidiDataException {
    GuiViewFrame view = new GuiViewFrame();
    //MidiView midiView = new MidiViewImpl();
    // You probably need to connect these views to your model, too...
    MusicModel model = MusicReader.parseFile(
            new FileReader(new File(myst1)),
            new GenericMusicModelBuilder());

    view.setModel(new ModelDisplayAdapterImpl(model));
    view.initialize();
  }

}
