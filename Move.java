//extends square
class Move{
  Square start;
  Square landing;

/*include evaluation of moves here so dont need to create additional data structure for keeping track of scores of each of the movements
move takes in two different squares*/
  public Move(Square x, Square y){
    start = x;
    landing = y;
  }

  public Move(){

  }

//get starting square
  public Square getStart(){
    return start;
  }

//get landing square
  public Square getLanding(){
    return landing;
  }
}
