/**
 * Algorithms
 * @author Viktors Soltums
 *
 */

package hanoi;

public class Hanoi {
    public static void main(String[] args) {
        solveHanoi(3, 'A', 'B', 'C');
    }

    public static void solveHanoi(int diskNum, char from, char middle, char to) {
        if (diskNum == 1) {
            System.out.printf("Disk 1 from %s to %s\n", from, to);
        } else {
            solveHanoi(diskNum - 1, from, to, middle);
            System.out.printf("Disk %d from %s to %s\n", diskNum, from, to);
            solveHanoi(diskNum - 1, middle, from, to);
        }
    }
}
