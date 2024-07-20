class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String [] dart = dartResult.split("");
        int [] score = new int[3];
        int index = -1;
        
        for(int i = 0; i < dart.length; i++) {
            if(dart[i].matches("[0-9]")) {
                index++;   
                score[index] = Integer.parseInt(dart[i]);
                if(dart[i+1].equals("0")) {
                    score[index] = 10;
                    i++;
                }
            }
            else if(dart[i].equals("D")) score[index] = (int)Math.pow(score[index], 2);
            else if(dart[i].equals("T")) score[index] = (int)Math.pow(score[index], 3);
            else if(dart[i].equals("#")) score[index] *= -1;
            else if(dart[i].equals("*")) {
                score[index] *= 2;
                if(index - 1 > -1) score[index - 1] *= 2;
            }
        }
        
        for(int i : score) answer += i;
        
        return answer;
    }
}