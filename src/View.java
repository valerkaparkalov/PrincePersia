import java.util.Scanner;

public class View {
    private  int H_LEVEL;
    private int M_LINE;
    private int N_COLUMN;

    public int getH_LEVEL() {
        return H_LEVEL;
    }

    public void setH_LEVEL(int h_LEVEL) {
        H_LEVEL = h_LEVEL;
    }

    public int getM_LINE() {
        return M_LINE;
    }

    public void setM_LINE(int m_LINE) {
        M_LINE = m_LINE;
    }

    public int getN_COLUMN() {
        return N_COLUMN;
    }

    public void setN_COLUMN(int n_COLUMN) {
        N_COLUMN = n_COLUMN;
    }

    public  void  view(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество уровней!");
        setH_LEVEL(scanner.nextInt());
        System.out.println("Введите количество строк!");
        setM_LINE(scanner.nextInt());
        System.out.println("Введите количеество столбцов!");
        setN_COLUMN(scanner.nextInt());
//отправляет нашу локацию в класс Move
Move move = new Move(getH_LEVEL(),getM_LINE(),getN_COLUMN());
move.move();
        }



    }








