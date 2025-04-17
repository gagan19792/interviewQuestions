package org.interview.questions.array;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                boolean emptyL = (i == 0)|| (flowerbed[i-1] == 0);
                boolean emptyR = (i == flowerbed.length-1) || (flowerbed[i+1] == 0);
                if(emptyL && emptyR){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count>=n;
    }
}
