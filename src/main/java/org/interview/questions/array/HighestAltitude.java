package org.interview.questions.array;

public class HighestAltitude {

    public static int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int highestAltitude = currentAltitude;

        for(int altitudeGain : gain){
            currentAltitude += altitudeGain;

            highestAltitude = Math.max(highestAltitude, currentAltitude);
        }
        return highestAltitude;
    }
}
