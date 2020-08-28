class Solution extends SolBase {
    public int rand10() {
        int index;
        do {
            index = 7 * (rand7() - 1) + rand7();
        } while (index > 40);
        // return (index - 1) % 10 + 1;
        return index % 10 + 1;
    }
}