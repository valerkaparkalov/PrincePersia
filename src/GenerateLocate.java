import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GenerateLocate {
    Random random = new Random();
    private int H_LEVEL;
    private int M_LINE;
    private int N_COLUMN;

    public int getH_LEVEL() {
        return H_LEVEL;
    }


    public int getM_LINE() {
        return M_LINE;
    }


    public int getN_COLUMN() {
        return N_COLUMN;
    }


    public GenerateLocate(int H_LEVEL, int M_LINE, int N_COLUMN) {
        this.H_LEVEL = H_LEVEL;
        this.M_LINE = M_LINE;
        this.N_COLUMN = N_COLUMN;
    }

    public Map generateLocate() {
        Map map = new HashMap();

        for (int H = 1; H < getH_LEVEL() + 1; H++) {
            char[][] locats = new char[getM_LINE()][getN_COLUMN()];
            for (int i = 0; i < locats.length; i++) {
                for (int j = 0; j < locats[i].length; j++) {
                    locats[i][j] = '.';
                }
            }
//            todo нужно поработать с раскидкой столбиков
            int columnAmount = getH_LEVEL() * getM_LINE() / 3;
            for (int i = 0; i <= columnAmount; i++) {
                int columnLine = random.nextInt(getM_LINE());
                int columnColumn = random.nextInt(getN_COLUMN());
                locats[columnLine][columnColumn] = '0';
            }
            //добавление принца
            if (H == 1) {
                locats[0][0] = '1';
            }
            //добавление принцессы
            if (H == getH_LEVEL()) {
                locats[getM_LINE() - 1][getN_COLUMN() - 1] = '2';
            }
            map.put(H, locats);
        }


        return map;
    }
}

