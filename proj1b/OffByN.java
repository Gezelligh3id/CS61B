public class OffByN implements CharacterComparator {
    int N;
    public OffByN (int cnt) {
        N = cnt;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return (x - y == this.N) || (y - x == this.N);
    }
}
