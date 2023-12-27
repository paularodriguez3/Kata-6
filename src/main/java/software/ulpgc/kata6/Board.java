package software.ulpgc.kata6;

public class Board {

    private final String[][] state;

    public Board(String[][] state) {
        this.state = state;
    }

    public String[][] state() {
        return state;
    }

    public Board next() {
        return new Board(calculateNextState());
    }

    private String[][] calculateNextState() {
        String[][] result = new String[rows()][cols()];
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                result[i][j] = validateNextStateOfCell(i,j);
            }
        }
        return result;
    }

    private String validateNextStateOfCell(int rows, int cols) {
        return validatecell(rows, cols) ? "X" : ".";
    }

    private boolean validatecell(int rows, int cols) {
        int neighbors = countNeighborsOfCell(rows, cols);
        return isAlive(rows, cols) && neighbors >= 2 && neighbors <= 3 || neighbors == 3 && !isAlive(rows, cols);
    }

    private boolean isAlive(int rows, int cols) {
        return state[rows][cols].equals("X");
    }

    private int countNeighborsOfCell(int rows, int cols) {
        int cont = 0;
        if(validNeighbor(rows-1, cols-1)) cont++;
        if(validNeighbor(rows-1, cols+1)) cont++;
        if(validNeighbor(rows-1, cols)) cont++;
        if(validNeighbor(rows+1, cols-1)) cont++;
        if(validNeighbor(rows+1, cols+1)) cont++;
        if(validNeighbor(rows+1, cols)) cont++;
        if(validNeighbor(rows, cols+1)) cont++;
        if(validNeighbor(rows, cols-1)) cont++;
        return cont;
    }

    private boolean validNeighbor(int rows, int cols) {
        return isBounds(rows, cols) && state[rows][cols].equals("X");
    }

    private boolean isBounds(int rows, int cols) {
        return rows >= 0 && rows < rows() && cols >= 0 && cols < cols();
    }


    private int rows() {
        return state.length;
    }

    private int cols() {
        return state[0].length;
    }
}
