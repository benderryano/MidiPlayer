package cs3500.music.model;

/**
 * Created by Viviano on 2/29/2016.
 */
public class MusicConsoleView {


  public static void main(String[] args) {
    GenericMusicModel model = new GenericMusicModel();
    model.addNote(new MusicNote(0, 4, Pitch.A6));
    model.addNote(new MusicNote(0, 3, Pitch.C6));
    model.addNote(new MusicNote(5, 10, Pitch.GS6));
    model.addNote(new MusicNote(10, 5, Pitch.GS6));

    System.out.println(draw(model));


    MusicModel m = new GenericMusicModel();


  }

  public static String draw(MusicModel model) {
    StringBuilder sb = new StringBuilder();
    String l = "" + model.getLength();
    sb.append(String.format("%" + l.length() + "s", " "));
    sb.append(model.getRange() + "\n");

    for (int i = 0; i < model.getLength(); i++) {
      int c = l.length() - ("" + i).length();
      if (c > 0)
        sb.append(String.format("%d%" + c + "s", i, ""));
      else
        sb.append(i);

      if (model.hasNoteAt(i))//draw beat
        sb.append(model.getBeatAt(i).beatToString(model.getRange()));
      sb.append("\n");
    }
    return sb.toString();
  }
}
