package tests;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import software.ulpgc.kata6.Board;
public class BoardTests {
    @Test
    public void return_an_empty_board_given_an_empty_board() {
        Board board = new Board(Cases.emptyBoard).next();
        assertThat(board.state()).isEqualTo(Cases.emptyBoard);
    }

    @Test
    public void return_a_dead_cell_given_a_dead_cell() {
        Board board = new Board(Cases.oneDeadCell).next();
        assertThat(board.state()).isEqualTo(Cases.oneDeadCell);
    }

    @Test
    public void return_a_dead_cell_given_an_alive_cell() {
        Board board = new Board(Cases.oneAliveCell).next();
        assertThat(board.state()).isEqualTo(Cases.oneDeadCell);
    }

    @Test
    public void return_2x2_all_dead_cells_given_2x2_all_dead_cells() {
        Board board = new Board(Cases.allDeadCells2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allDeadCells2x2);
    }

    @Test
    public void return_2x2_all_alive_cells_given_2x2_all_alive_cells() {
        Board board = new Board(Cases.allAliveCells2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allAliveCells2x2);
    }

    @Test
    public void return_2x2_all_alive_cells_given_2x2_triangle_structure_cells() {
        Board board = new Board(Cases.triangleStructure2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allAliveCells2x2);
    }

    @Test
    public void return_2x2_all_dead_cells_given_2x2_line_structure_cells() {
        Board board = new Board(Cases.lineStructure2x2).next();
        assertThat(board.state()).isEqualTo(Cases.allDeadCells2x2);
    }

    @Test
    public void return_3x3_square_structure_given_3x3_triangle_structure() {
        Board board = new Board(Cases.triangleStructure3x3).next();
        assertThat(board.state()).isEqualTo(Cases.squareStructure3x3);
    }

    public static class Cases {
        static final String[][] emptyBoard = {{}};
        static final String[][] oneDeadCell = {{"."}};
        static final String[][] oneAliveCell = {{"X"}};
        static final String[][] allDeadCells2x2 = {{".","."},
                                                    {".","."}};
        static final String[][] allAliveCells2x2 = {{"X","X"},
                                                    {"X","X"}};
        static final String[][] triangleStructure2x2 = {{".","X"},
                                                        {"X","X"}};

        static final String[][] lineStructure2x2 = {{".","."},
                                                    {"X","X"}};
        static final String[][] triangleStructure3x3 = {{".",".","X"},
                                                    {".","X","X"},
                                                    {".",".","."}};

        static final String[][] squareStructure3x3 = {{".","X","X"},
                                                    {".","X","X"},
                {                                   ".",".","."}};
    }

}
