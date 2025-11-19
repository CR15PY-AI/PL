import java.util.*;

public class BattleShip {
    public static final int SIZE = 10;
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("### Морской бой ###");

        char[][] field1 = createEmptyField();
        char[][] field2 = createEmptyField();

        Map<Integer, Integer> fleetTemplate = new LinkedHashMap<>();
        fleetTemplate.put(4, 1);
        fleetTemplate.put(3, 2);
        fleetTemplate.put(2, 3);
        fleetTemplate.put(1, 4);

        System.out.println("\nИгрок 1 — расстановка кораблей");
        manualFleetSetup(field1, fleetTemplate);

        clearScreenSimple();

        System.out.println("\nИгрок 2 — расстановка кораблей");
        manualFleetSetup(field2, fleetTemplate);

        clearScreenSimple();

        boolean player1Turn = true;
        while (true) {
            if (player1Turn) {
                System.out.println("Ход игрока 1");
                printMask(field2);
                if (makeShot(field2)) {
                    System.out.println("Игрок 1 выиграл!");
                    break;
                }
            } else {
                System.out.println("Ход игрока 2");
                printMask(field1);
                if (makeShot(field1)) {
                    System.out.println("Игрок 2 выиграл!");
                    break;
                }
            }
            System.out.println("Нажмите Enter, чтобы продолжить...");
            scanner.nextLine();
            clearScreenSimple();
            player1Turn = !player1Turn;
        }
    }


    static char[][] createEmptyField() {
        char[][] f = new char[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                f[r][c] = '.';
        return f;
    }


    static void manualFleetSetup(char[][] field, Map<Integer, Integer> template) {
        Map<Integer, Integer> remaining = new LinkedHashMap<>(template);

        while (!remaining.isEmpty()) {
            System.out.println("\nТекущее поле:");
            printFull(field);

            System.out.println("\nДоступные корабли для установки:");
            int idx = 1;
            List<Integer> sizes = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : remaining.entrySet()) {
                System.out.printf("%d) Длина %d — осталось %d\n", idx, e.getKey(), e.getValue());
                sizes.add(e.getKey());
                idx++;
            }
            System.out.print("Выберите корабль по номеру: ");
            String line = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (Exception ex) {
                System.out.println("Неверный ввод. Введите число.");
                continue;
            }
            if (choice < 1 || choice > sizes.size()) {
                System.out.println("Неверный номер.");
                continue;
            }
            int shipSize = sizes.get(choice - 1);
            System.out.println("Вы выбрали корабль длиной " + shipSize + ". Введите клетки по одной.");

            List<Coord> cells = new ArrayList<>();
            for (int i = 0; i < shipSize; i++) {
                System.out.printf("Клетка %d (пример A1): ", i + 1);
                String pos = scanner.nextLine().trim().toUpperCase();
                Coord co = parseCoord(pos);
                if (co == null) {
                    System.out.println("Неверная клетка. Попробуйте заново ставить этот корабль.");
                    cells.clear();
                    break;
                }
                if (isOccupied(field, co)) {
                    System.out.println("Эта клетка уже занята другим кораблём. Попробуйте заново ставить этот корабль.");
                    cells.clear();
                    break;
                }
                if (contains(cells, co)) {
                    System.out.println("Вы ввели дублирующуюся клетку. Попробуйте заново ставить этот корабль.");
                    cells.clear();
                    break;
                }
                cells.add(co);
            }

            if (cells.size() != shipSize) {
                // что-то пошло не так — повторяем выбор того же корабля
                continue;
            }

            if (!allInOneLine(cells)) {
                System.out.println("Клетки не в одной линии. Корабль должен быть в одной строке или столбце. Попробуйте заново.");
                continue;
            }
            if (!isConsecutive(cells)) {
                System.out.println("Клетки должны быть подряд без пропусков. Попробуйте заново.");
                continue;
            }

            // Проверка на касание/соседство с другими кораблями (включая диагонали)
            if (!isPlacementAllowed(field, cells)) {
                System.out.println("Клетки касаются другого корабля или находятся рядом с ним. Размещение запрещено. Попробуйте заново.");
                continue;
            }
            for (Coord co : cells) field[co.r][co.c] = 'O';
            // Уменьшаем счётчик в remaining
            int left = remaining.get(shipSize) - 1;
            if (left <= 0) remaining.remove(shipSize);
            else remaining.put(shipSize, left);

            System.out.println("Корабль длиной " + shipSize + " установлен.");
        }

        System.out.println("\nВсе корабли расставлены. Финальное поле:");
        printFull(field);
        System.out.println("Нажмите Enter, чтобы продолжить...");
        scanner.nextLine();
    }

    static Coord parseCoord(String s) {
        if (s == null || s.length() < 2) return null;
        char rch = s.charAt(0);
        if (rch < 'A' || rch > 'J') return null;
        String colStr = s.substring(1);
        int col;
        try {
            col = Integer.parseInt(colStr);
        } catch (Exception e) {
            return null;
        }
        if (col < 1 || col > SIZE) return null;
        int r = rch - 'A';
        int c = col - 1;
        return new Coord(r, c);
    }

    static boolean isOccupied(char[][] field, Coord co) {
        return field[co.r][co.c] == 'O';
    }

    static boolean contains(List<Coord> list, Coord c) {
        for (Coord x : list) if (x.equals(c)) return true;
        return false;
    }

    static boolean allInOneLine(List<Coord> list) {
        boolean sameRow = true;
        boolean sameCol = true;
        int r0 = list.get(0).r;
        int c0 = list.get(0).c;
        for (Coord co : list) {
            if (co.r != r0) sameRow = false;
            if (co.c != c0) sameCol = false;
        }
        return sameRow || sameCol;
    }

    static boolean isConsecutive(List<Coord> list) {
        boolean sameRow = true;
        int r0 = list.get(0).r;
        for (Coord co : list) if (co.r != r0) sameRow = false;

        if (sameRow) {
            List<Integer> cols = new ArrayList<>();
            for (Coord co : list) cols.add(co.c);
            Collections.sort(cols);
            for (int i = 1; i < cols.size(); i++)
                if (cols.get(i) != cols.get(i - 1) + 1) return false;
            return true;
        } else {
            // все в одном столбце
            List<Integer> rows = new ArrayList<>();
            for (Coord co : list) rows.add(co.r);
            Collections.sort(rows);
            for (int i = 1; i < rows.size(); i++)
                if (rows.get(i) != rows.get(i - 1) + 1) return false;
            return true;
        }
    }

    static boolean isPlacementAllowed(char[][] field, List<Coord> cells) {
        for (Coord c : cells) {
            for (int rr = c.r - 1; rr <= c.r + 1; rr++) {
                for (int cc = c.c - 1; cc <= c.c + 1; cc++) {
                    if (rr < 0 || rr >= SIZE || cc < 0 || cc >= SIZE) continue;
                    Coord neighbor = new Coord(rr, cc);
                    if (contains(cells, neighbor)) continue; // это часть нового корабля
                    if (field[rr][cc] == 'O') return false; // рядом есть чужой корабль
                }
            }
        }
        return true;
    }


    static void printFull(char[][] f) {
        System.out.print("   ");
        for (int i = 1; i <= SIZE; i++) System.out.print((i < 10 ? " " : "") + i + " ");
        System.out.println();
        for (int r = 0; r < SIZE; r++) {
            System.out.print((char) ('A' + r) + "  ");
            for (int c = 0; c < SIZE; c++) System.out.print(" " + f[r][c] + " ");
            System.out.println();
        }
    }

    static void printMask(char[][] f) {
        System.out.print("   ");
        for (int i = 1; i <= SIZE; i++) System.out.print((i < 10 ? " " : "") + i + " ");
        System.out.println();
        for (int r = 0; r < SIZE; r++) {
            System.out.print((char) ('A' + r) + "  ");
            for (int c = 0; c < SIZE; c++) {
                char ch = f[r][c];
                if (ch == 'X' || ch == '*') System.out.print(" " + ch + " ");
                else System.out.print(" . ");
            }
            System.out.println();
        }
    }

    static boolean makeShot(char[][] f) {
        while (true) {
            System.out.print("Куда стреляем (пример A1): ");
            String s = scanner.nextLine().trim().toUpperCase();
            Coord co = parseCoord(s);
            if (co == null) {
                System.out.println("нет такой клетки, переделывай");
                continue;
            }
            if (f[co.r][co.c] == 'X' || f[co.r][co.c] == '*') {
                System.out.println("Даун,уже стрелял");
                continue;
            }
            if (f[co.r][co.c] == 'O') {
                System.out.println("Попадание!");
                f[co.r][co.c] = 'X';
            } else {
                System.out.println("Мимо. ЛОХ");
                f[co.r][co.c] = '*';
            }
            return checkWin(f);
        }
    }

    static boolean checkWin(char[][] f) {
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                if (f[r][c] == 'O') return false;
        return true;
    }

    static void clearScreenSimple() {
        System.out.println("\n---------------------------\n");
    }

    //
    static class Coord {
        int r, c;
        Coord(int r, int c) { this.r = r; this.c = c; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coord)) return false;
            Coord other = (Coord) o;
            return r == other.r && c == other.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}

