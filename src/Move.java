import java.util.*;

public class Move {
    private final int H_LEVEL;
    private final int M_LINE;
    private final int N_COLUMN;
    private int counterValues;
    private char nextValue;
    private int levelLocate;
    private Map generateLocate;
    private boolean booleanWile;
    Random random = new Random();
    Heroes heroes = new Heroes();
    List numberStep = new ArrayList(2);


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
                numberStep.get(1).equals(numberStep.get(2)) && numberStep.get(2).equals(getCounterValues())) {
            booleanWile = false;
            System.out.println("минимально количество ходов = " + getCounterValues() * 5);
        }


    }

    public void move() {
        booleanWile = true;
        numberStep.add(0, 1000);
        numberStep.add(1, 1001);
        numberStep.add(2, 1002);
        GenerateLocate generateLocate = new GenerateLocate(H_LEVEL, M_LINE, N_COLUMN);
        setGenerateLocate(generateLocate.generateLocate());
        while (booleanWile) {
            setCounterValues(0);
            heroes.setLine(0);
            nextValue = '.';
            heroes.setColumn(0);
            levelLocate = 1;
            int counter = 0;
            for (int i = 0; nextValue != '2'; i++) {
                if (i < 50) {
                    int chance = random.nextInt(5) + 1;
                    if (chance == 1) {
                        char[][] mapForChance = (char[][]) getGenerateLocate().get(levelLocate);
                        if (heroes.getColumn() + 1 == mapForChance[heroes.getLine()].length ||
                                +mapForChance[heroes.getLine()][heroes.getColumn() + 1] == '0') {
                        } else {
                            int oldXValue = heroes.getLine();
                            int oldYValue = heroes.getColumn();
                            heroes.setColumn(heroes.getColumn() + 1);
                            nextValue = mapForChance[heroes.getLine()][heroes.getColumn()];
                            if (nextValue != '2') {
                                replaceHeroesPosition(oldXValue, oldYValue);
                            }
                            ++counter;
                        }
                    }
                    if (chance == 2) {
                        char[][] mapForChance = (char[][]) getGenerateLocate().get(levelLocate);
                        if (heroes.getColumn() - 1 < 0 ||
                                +mapForChance[heroes.getLine()][heroes.getColumn() - 1] == '0') {

                        } else {
                            int oldXValue = heroes.getLine();
                            int oldYValue = heroes.getColumn();
                            heroes.setColumn(heroes.getColumn() - 1);
                            nextValue = mapForChance[heroes.getLine()][heroes.getColumn()];
                            if (nextValue != '2') {
                                replaceHeroesPosition(oldXValue, oldYValue);
                            }
                            ++counter;
                        }
                    }
                    if (chance == 3) {
                        char[][] mapForChance = (char[][]) getGenerateLocate().get(levelLocate);
                        if (heroes.getLine() + 1 == mapForChance.length ||
                                +mapForChance[heroes.getLine() + 1][heroes.getColumn()] == '0') {

                        } else {
                            int oldXValue = heroes.getLine();
                            int oldYValue = heroes.getColumn();
                            heroes.setLine(heroes.getLine() + 1);
                            nextValue = mapForChance[heroes.getLine()][heroes.getColumn()];
                            if (nextValue != '2') {
                                replaceHeroesPosition(oldXValue, oldYValue);
                            }
                            ++counter;
                        }
                    }
                    if (chance == 4) {
                        char[][] mapForChance = (char[][]) getGenerateLocate().get(levelLocate);
                        if (heroes.getLine() - 1 < 0 ||
                                +mapForChance[heroes.getLine() - 1][heroes.getColumn()] == '0') {

                        } else {
                            int oldXValue = heroes.getLine();
                            int oldYValue = heroes.getColumn();
                            heroes.setLine(heroes.getLine() - 1);
                            nextValue = mapForChance[heroes.getLine()][heroes.getColumn()];
                            if (nextValue != '2') {
                                replaceHeroesPosition(oldXValue, oldYValue);
                            }
                            ++counter;
                        }
                    }
                    if (chance == 5) {
                        if (levelLocate + 1 <= getGenerateLocate().size()) {
                            char[][] mapForChance = (char[][]) getGenerateLocate().get(levelLocate + 1);
                            if (mapForChance[heroes.getLine()][heroes.getColumn()] == '0') {
                            }
                            if (mapForChance[heroes.getLine()][heroes.getColumn()] == '2') {
                                nextValue = '2';
                                ++counter;
                            } else {
                                char[][] locats = (char[][]) getGenerateLocate().get(levelLocate);
                                locats[heroes.getLine()][heroes.getColumn()] = '.';
                                levelLocate += 1;
                                ++counter;
                            }
                        }


                    }
                } else {
                    setGenerateLocate(generateLocate.generateLocate());
                    heroes.setLine(0);
                    heroes.setColumn(0);
                    levelLocate = 1;
                    i = 0;
                }
                if (nextValue == '2') {
                    break;
                }

            }
            setCounterValues(counter);
            System.out.println(getCounterValues());
            chekList();

        }
        System.out.println("минимально количество ходов = " + getCounterValues() * 5);
        for (int i = 0; i < getGenerateLocate().size(); i++) {
            char[][] arrayForMap = (char[][]) getGenerateLocate().get(i + 1);
            printLocat(arrayForMap);
            System.out.println("-----------");
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
