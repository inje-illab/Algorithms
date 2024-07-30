class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int temp = health;
        int cnt = 0;
        int idx = 0;
        
        for(int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if(i == attacks[idx][0]) {
                cnt = 0;
                temp -= attacks[idx][1];
                idx++;
                if(temp <= 0) return -1;
            }
            else  {
                temp += bandage[1];
                cnt++;
                if(cnt == bandage[0]) {
                    temp += bandage[2];
                    cnt = 0;
                }
                if(temp > health) temp = health;
            }
        }
        return temp;
    }
}