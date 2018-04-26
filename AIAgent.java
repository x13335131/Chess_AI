import java.util.*;

//decison around which move to make
public class AIAgent{
  Random rand;

  public AIAgent(){
    rand = new Random();
  }

/*
  The method randomMove takes as input a stack of potential moves that the AI agent
  can make. The agent uses a rondom number generator to randomly select a move from
  the inputted Stack and returns this to the calling agent.
*/

/* Agent 1: RANDOM MOVE
-fast
-gets all possible moves
-random
*/
  public Move randomMove(Stack possibilities){

    int moveID = rand.nextInt(possibilities.size());
    System.out.println("Agent randomly selected move : "+moveID);
    for(int i=1;i < (possibilities.size()-(moveID));i++){
      possibilities.pop();
    }
    Move selectedMove = (Move)possibilities.pop();
    return selectedMove;
  }

/*Agent 2: NEXT BEST MOVE
-not worried about what comes next after taking a move
-gets all possible moves then applies utility function (ie Pawn:1, Knight/Bishop:3, Rook:5, Queen:9, King=game) & takes piece thats worth the most
*/
  public Move nextBestMove(Stack whitePossibilities, Stack blackPossibilities){
    Stack white = (Stack) whitePossibilities.clone();
    Stack blackStack = (Stack) blackPossibilities.clone();
    Move whiteMove, normalMove, bestMove;
    Square positionBlack;
    double points = 0.0;
    double selectedPiece = 0.0;
    bestMove = null;

    while (!whitePossibilities.empty()) { //while stack is not empty
        whiteMove = (Move) whitePossibilities.pop(); //pop from stack
        normalMove = whiteMove; //normal move equals the white move popped from stack

        //center squares
        if ((normalMove.getStart().getYC() < normalMove.getLanding().getYC())
                && (normalMove.getLanding().getXC() == 3) && (normalMove.getLanding().getYC() == 3)
                || (normalMove.getLanding().getXC() == 4) && (normalMove.getLanding().getYC() == 3)
                || (normalMove.getLanding().getXC() == 3) && (normalMove.getLanding().getYC() == 4)
                || (normalMove.getLanding().getXC() == 4) && (normalMove.getLanding().getYC() == 4)) {
            points = 0.5;
            //assign best move
            if (points > selectedPiece) {//if points is greater than the selected piece
                selectedPiece = points;//assign the selected piece to the points
                bestMove = normalMove;//best move is now the normal move
            }
        }


        while (!blackStack.isEmpty()) {//while blackStack is not empty
            points = 0;//points is 0
            positionBlack = (Square) blackStack.pop();
            if ((normalMove.getLanding().getXC() == positionBlack.getXC()) &&
            (normalMove.getLanding().getYC() == positionBlack.getYC())) {
                //assigning points to pieces

                if (positionBlack.getName().equals("BlackPawn")) {//if the piece in blackStack position is the pawn
                    points = 1;//points=1
                }

                else if (positionBlack.getName().equals("BlackBishop") || positionBlack.getName().equals("BlackKnight")) { //if the piece in blackStack position is the bishop or knight
                    points = 3;//points =3
                }

                else if (positionBlack.getName().equals("BlackRook")) {//if the piece in blackStack position is the rook
                    points = 5;//assign 5 points
                }

                else if (positionBlack.getName().equals("BlackQueen")) {//if the piece in blackStack position is the queen
                    points = 9; //assign 9 points
                }

                else if (positionBlack.getName().equals("BlackKing")) {
                    points = 10;
                    System.out.println("you have won");
                }
            }
            //update bestmove
            if (points > selectedPiece) {
                selectedPiece = points;
                bestMove = normalMove;
            }
        }
        //reload blackStack squares
        blackStack = (Stack) blackPossibilities.clone();
    }
    // use best move if available or just go random
    if (selectedPiece > 0) {//return best move
        System.out.println("Best move: " + selectedPiece);
        return bestMove;
    }
    System.out.println("random move");
    return randomMove(white);//return random move

  }

/*Agent 3: TWO LEVELS DEEP
-extends agent above
-looks ahead to see consequence of taking a move
-capture potential movements of the players pieces
*/

  public Move twoLevelsDeep(Stack possibilities){
    Move selectedMove = new Move();
    return selectedMove;
  }
}
