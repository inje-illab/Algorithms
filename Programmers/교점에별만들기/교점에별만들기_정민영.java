import java.util.ArrayList;

class Solution {
    public ArrayList<long[]> point = new ArrayList<>();
    
    public void cal(long denominator, long bf, long ed, long ec, long af) {
        if ((bf - ed) % denominator == 0 && (ec - af) % denominator == 0) {
            long x = (bf - ed) / denominator;
            long y = (ec - af) / denominator;
            point.add(new long[] {x, y});
        }
    }
    
    public String[] solution(int[][] line) {
        long a, b, c, d, e, f;
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE, maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        
        for (int i = 0; i < line.length - 1; i++) {
            for (int k = i + 1; k < line.length; k++) {
                a = line[i][0];
                b = line[i][1];
                e = line[i][2];
                c = line[k][0];
                d = line[k][1];
                f = line[k][2];
            
                long denominator = (a * d) - (b * c);
                if (denominator != 0) {
                    cal(denominator, b * f, e * d, e * c, a * f);
                }
            }
        }
        
        for (long[] point : this.point) {
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
            maxX = Math.max(maxX, point[0]);
            maxY = Math.max(maxY, point[1]);
        }
        
        int w = (int)(maxX - minX) + 1;
        int h = (int)(maxY - minY) + 1;
        String[][] grid = new String[h][w];
        
        for(int i = 0; i < h; i++) {
            for(int k = 0; k < w ;k++) {
                grid[i][k] = ".";
            }
        }
        
        for(long[] p : point) {
            int x = (int)(p[0] - minX);
            int y = (int)(maxY - p[1]);
            grid[y][x] = "*";
        }
        
        String[] answer = new String[h];
        for (int i = 0; i < h; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < w; j++) {
                row.append(grid[i][j]);
            }
            answer[i] = row.toString();
        }
        return answer;
    }
}