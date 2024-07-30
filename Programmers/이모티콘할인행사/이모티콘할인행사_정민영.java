class Solution {
    int maxSub, maxBenefit;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int [] current = new int[emoticons.length];
        
        dfs(current, 0, users, emoticons);
        
        answer[0] = maxSub;
        answer[1] = maxBenefit;
        
        return answer;
    }
    
    public void dfs(int [] current, int index, int [][] users, int [] emoticons) {
        if(index == current.length) {
            cal(current, users, emoticons);
            return;
        }
        
        for(int i = 10; i <= 40; i += 10) {
            current[index] = i;
            dfs(current, index + 1, users, emoticons);
        }
    }
    
    public void cal(int [] current, int [][] users, int [] emoticons) {
        int sub = 0, benefit = 0;
            
        for(int [] u : users) {
            int discount = u[0];
            int price = u[1];
                
            int sum = 0;
            for(int i = 0; i < emoticons.length; i++) {
                if(current[i] >= discount) {
                    sum += emoticons[i] * (100 - current[i]) / 100;
                }
            }
                
            if(sum >= price) sub++;
            else benefit += sum;
        }
            
        if(sub > maxSub || (sub == maxSub && benefit > maxBenefit)) {
            maxSub = sub;
            maxBenefit = benefit;
        }
    }
}