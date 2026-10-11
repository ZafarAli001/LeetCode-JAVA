class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int round = 0;
        int square = 0;

        for (int student : students) {
            if (student == 0)
                round++;
            else
                square++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (round == 0)
                    return square;
                round--;
            } else {
                if (square == 0)
                    return round;
                square--;
            }
        }
        return 0;
    }
}