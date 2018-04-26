class Square{
  public int xCoor;
  public int yCoor;
  public String pieceName;

//create square that takes in the x,y coordinates and name of square
  public Square(int x, int y, String name){
    xCoor = x;
    yCoor = y;
    pieceName = name;
  }

  public Square(int x, int y){
    xCoor = x;
    yCoor = y;
    pieceName = "";
  }

//get x coordinate back from square
  public int getXC(){
    return xCoor;
  }

//get white coordinate back from square
  public int getYC(){
    return yCoor;
  }

//get name if present on square
  public String getName(){
      return pieceName;
  }
}
