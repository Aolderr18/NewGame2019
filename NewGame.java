public static final int size = 8;

int[][][] reach = new int[4][size][size];
char[][] cell_code = new int[size][size];
int x, y, i, j;
int dX = 0, dY = 0, dI = 0, dJ = 0;
int step, s;
int direction = 0;
while (direction < 4) {
    switch (direction) {
    case 0:
        dX = -1;
        break;
    case 1:
        dX = 1;
        break;
    case 2:
        dY = -1;
        break;
    case 3:
        dY = 1;
    }
    for (x = 0; x < size; x++)
        for (y = 0; y < size; y++) {
            step = 1;
            do
                reach[direction][(x + (step * dX)) % size][(y + (step * dY)) % size] = step++;
            while (cell_code[(x + ((step - 1) * dX)) % size][(y + ((step - 1) * dY)) % size] != 'r');
            for (char d : "NSWE".toCharArray()) {
                switch (d) {
                case 'N':
                    dI = -1;
                    break;
                case 'S':
                    dI = 1;
                    break;
                case 'W':
                    dJ = -1;
                    break;
                case 'E':
                    dJ = 1;
                }
                for (i = 0; i < size; i++)
                    for (j = 0; j < size; j++)
                        if (cell_code[i][j] == 'r' && reach[direction][i][j] >= 1) {
                            s = 1;
                            step = reach[direction][i][j] + 1;
                            if (reach[direction][(i + (dI * s)) % size][(j + (dJ * s)) % size] == -1
                                || reach[direction][(i + (dI * s)) % size][(j + (dJ * s)) % size] > step)
                                do {
                                    reach[direction][(i + (dI * s)) % size][(j + (dJ * s)) % size] = step;
                                    s++;
                                    step++;
                                } while (reach[direction][(i + dI * s)) % size][(j + (dJ * s)) % size] == -1
                                    || reach[direction][(i + dI * s)) % size][(j + (dJ * s)) % size] > step - 1);
                        }
            }
        }
    ++direction;
}
