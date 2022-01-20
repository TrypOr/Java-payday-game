package Model.Tiles;

public abstract class Tiles {
   private int Tileposition;
   private String name;
   private  final String imgURL;
   /**
    * <b>constructor</b>:Constructs a new Position
    *
    * @param imgURL the image's url
    * @param Tileposition the position of the tile
    */
   public Tiles(String imgURL, int Tileposition) {
      this.imgURL = imgURL;
      this.Tileposition = Tileposition;
   }
   /**
    * <b>Accessor<b> Get the path of the tile's image
    * @return the path of the tile's image
    */
   public String getImage() {
      return imgURL;
   }
   /**
    * <b>Accessor</b> Gets name of the tile
    * @return name the name of the tile
    */
   public String getName() {
      return name;
   }
   /**
    * <b>Transformer<b>  Sets the name of the tile
    * @param name the name of the tile
    */
   public void setName(String name) {
      this.name = name;
   }

   /**
    * <b>Accessor</b> Gets the position of the tile
    * @return Tileposition the position of the tile
    */
   public int getTileposition() {
      return Tileposition;
   }
   /**
    * <b>Transformer<b> Sets the position of the tile
    * @param pos sets the position of the tile
    */

   public void setTileposition(int pos) {
      Tileposition = pos;
   }
   /**
    * <b>Observer </b>:Checks wheter its Synday if its sunday,it is football day
    * @return if Sunday true else flase
    */
   public boolean isSunday() {
      return name.equals("Sunday");
   }
   /**
    * <b>Observer </b>:Checks wheter its Thursday if its Thursday,it is rise in the value of cryptos day
    * @return if Thursday true else flase
    */
   public boolean isThursday() {
      return name.equals("Thursday");
   }
}
