class Solution {
    public int findLonelyPixel(char[][] picture) {
        int cnt = 0;
        
        int R = picture.length;
        int C = picture[0].length;

        int[] rows = new int[R];
        int[] cols = new int[C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (picture[r][c] == 'W') continue;
                rows[r]++;
                cols[c]++;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (picture[r][c] == 'W') continue;
                if (picture[r][c] == 'B' && rows[r] == 1 && cols[c] == 1) {
                    cnt++;
                } 
            }
        }

        return cnt;
    }
}
