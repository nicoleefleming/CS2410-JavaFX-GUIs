package connect4;

public class Presenter
{
    connect4UI view;
    GameModel model;

    void attachView(connect4UI view) {
        this.view = view;
        model = new GameModel();
    }

    void enterPlayer(String name) {
        model.enterPlayer(name);
    }

    void changeTurn() {
        model.changeTurn();
    }

    String getTurn() {
        return model.getTurn();
    }

    void pushGridValues(int row, int column) {
        model.setGrid(row, column);
    }

    void updateModelGrid(int column){
        int row = model.updateGrid(column);
        if (row == -1){
            System.out.println("You can't use column anymore");
        }
        else {
            view.paintCircle(row, column);
        }
    }

    /**
     * Checks for a winner.
     * @return Player number of winner or 0 for no winner.
     */
    int checkWin(int winCondition) {
        return model.checkWin(winCondition);
    }
}
