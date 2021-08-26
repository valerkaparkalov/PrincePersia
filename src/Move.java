import java.util.*;

public class Move {
    private final int H_LEVEL;
    private final int M_LINE;
    private final int N_COLUMN;
    private int counterValues;
    private char nextValue;
    private int levelLocate;
    private Map generateLocate;
    private int counter;
    private boolean booleanWile;
    private int partOneValue = 0;
    Random random = new Random();
    Heroes heroes = new Heroes();
    List numberStep = new ArrayList(2);

    public int getPartOneValue() {
        return partOneValue;
    }

    public void setPartOneValue(int partOneValue) {
        this.partOneValue = partOneValue;
    }

    public char getNextValue() {
        return nextValue;
    }

    public void setNextValue(char nextValue) {
        this.nextValue = nextValue;
    }

    public int getLevelLocate() {
        return levelLocate;
    }

    public void setLevelLocate(int levelLocate) {
        this.levelLocate = levelLocate;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Map getGenerateLocate() {
        return generateLocate;
    }

    public void setGenerateLocate(Map generateLocate) {
        this.generateLocate = generateLocate;
    }

    public int getCounterValues() {
        return counterValues;
    }

    public void setCounterValues(int counterValues) {
        this.counterValues = counterValues;
    }

    public Move(int H_LEVEL, int M_LINE, int N_COLUMN) {
        this.H_LEVEL = H_LEVEL;
        this.M_LINE = M_LINE;
        this.N_COLUMN = N_COLUMN;
    }

    private void chekList() {

        if (getCounterValues() == (int) numberStep.get(1)) {
            numberStep.set(0, getCounterValues());
        }
        if (getCounterValues() == (int) numberStep.get(2)) {
            numberStep.set(1, getCounterValues());

        }
        if (getCounterValues() < (int) numberStep.get(2)) {
            if (getCounterValues() < (int) numberStep.get(0)) {
                numberStep.set(2, getCounterValues());
            }
        }

        if (numberStep.get(0).equals(numberStep.get(1)) &&
                numberStep.get(1).equals(numberStep.get(2)) &&
                numberStep.get(2).equals(getCounterValues())) {
            if (getPartOneValue() == getCounterValues()) {
                booleanWile = false;
                System.out.println("минимально количество ходов = " + getCounterValues() * 5 + "секунд");
            }
            if (getCounterValues() < getPartOneValue()) {
                booleanWile = false;
                System.out.println("минимально количество ходов = " + getCounterValues() * 5 + "секунд");
            }
            if (getPartOneValue() < getCounterValues()) {
                setPartOneValue(getCounterValues());
            }
            setCounterValues(0);
        }
    }

    public void start() {
        booleanWile = true;
        numberStep.add(0, 1000);
        numberStep.add(1, 1001);
        numberStep.add(2, 1002);
        GenerateLocate generateLocate = new GenerateLocate(H_LEVEL, M_LINE, N_COLUMN);
        setGenerateLocate(generateLocate.generateLocate());
        for (int i = 0; i < getGenerateLocate().size(); i++) {
            char[][] arrayForMap = (char[][]) getGenerateLocate().get(i + 1);
            printLocat(arrayForMap);
            System.out.println("-----------");
        }
        setCounterValues(0);
        heroes.setLine(0);
        setNextValue('.');
        heroes.setColumn(0);
        setLevelLocate(1);
        setCounter(0);

    }


    public void move() {
        start();
        int oldXValue = heroes.getLine();
        int oldYValue = heroes.getColumn();
        while (booleanWile) {
            for (int i = 0; getNextValue() != '2'; i++) {
                if (i < 100) {
                    int chance = random.nextInt(5) + 1;
                    if (chance == 1) {
                        char[][] mapForChance = (char[][]) getGenerateLocate().get(getLevelLocate());
                        if (heroes.getColumn() + 1 == mapForChance[heroes.getLine()].length ||
                                +mapForChance[heroes.getLine()][heroes.getColumn() + 1] == '0') {
                        } else {
                            heroes.setColumn(heroes.getColumn() + 1);
                            setNextValue(mapForChance[heroes.getLine()][heroes.getColumn()]);
                            if (getNextValue() != '2') {
                                replaceHeroesPosition(oldXValue, oldYValue);
                            }
                            setCounter(getCounter() + 1);
                        }
                    }
                    if (chance == 2) {
                        char[][] mapForChance = (char[][]) getGenerateLocate().get(getLevelLocate());
                        if (heroes.getColumn() - 1 < 0 ||
                                +mapForChance[heroes.getLine()][heroes.getColumn() - 1] == '0') {

                        } else {
                            heroes.setColumn(heroes.getColumn() - 1);
                            setNextValue(mapForChance[heroes.getLine()][heroes.getColumn()]);
                            if (getNextValue() != '2') {
                                replaceHeroesPosition(oldXValue, oldYValue);
                            }
                            setCounter(getCounter() + 1);
                        }
                    }
                    if (chance == 3) {
                        char[][] mapForChance = (char[][]) getGenerateLocate().get(getLevelLocate());
                        if (heroes.getLine() + 1 == mapForChance.length ||
                                +mapForChance[heroes.getLine() + 1][heroes.getColumn()] == '0') {

                        } else {
                            heroes.setLine(heroes.getLine() + 1);
                            setNextValue(mapForChance[heroes.getLine()][heroes.getColumn()]);
                            if (getNextValue() != '2') {
                                replaceHeroesPosition(oldXValue, oldYValue);
                            }
                            setCounter(getCounter() + 1);
                        }
                    }
                    if (chance == 4) {
                        char[][] mapForChance = (char[][]) getGenerateLocate().get(getLevelLocate());
                        if (heroes.getLine() - 1 < 0 ||
                                +mapForChance[heroes.getLine() - 1][heroes.getColumn()] == '0') {

                        } else {
                            heroes.setLine(heroes.getLine() - 1);
                            setNextValue(mapForChance[heroes.getLine()][heroes.getColumn()]);
                            if (getNextValue() != '2') {
                                replaceHeroesPosition(oldXValue, oldYValue);
                            }
                            setCounter(getCounter() + 1);
                        }
                    }
                    if (chance == 5) {
                        if (getLevelLocate() + 1 <= getGenerateLocate().size()) {
                            char[][] mapForChance = (char[][]) getGenerateLocate().get(getLevelLocate() + 1);
                            if (mapForChance[heroes.getLine()][heroes.getColumn()] == '0') {
                            }
                            if (mapForChance[heroes.getLine()][heroes.getColumn()] == '2') {
                                setNextValue('2');
                                setCounter(getCounter() + 1);
                            } else {
                                char[][] locats = (char[][]) getGenerateLocate().get(getLevelLocate());
                                locats[heroes.getLine()][heroes.getColumn()] = '.';
                                setLevelLocate(getLevelLocate() + 1);
                                setCounter(getCounter() + 1);
                            }
                        }


                    }
                } else {
                    start();
                    i = 0;

                }
                if (nextValue == '2') {
                    break;
                }

            }
            setCounterValues(counter);
            chekList();

        }
    }

    public static void printLocat(char[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }

    }

    private void replaceHeroesPosition(int oldXValue, int oldYValue) {
        char[][] locats = (char[][]) getGenerateLocate().get(levelLocate);
        locats[heroes.getLine()][heroes.getColumn()] = '1';
        locats[oldXValue][oldYValue] = '.';


    }
}
