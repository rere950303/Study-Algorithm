//
// Coding skills(ParkingBill)
// https://app.codility.com/programmers/trainings/5/parking_bill/
// Created by hyungwook on 2022/02/19.
//

public class Solution {

    public int solution(String E, String L) {
        String[] startTime = E.split(":");
        int startMin = Integer.valueOf(startTime[0]) * 60 + Integer.valueOf(startTime[1]);

        String[] endTime = L.split(":");
        int endMin = Integer.valueOf(endTime[0]) * 60 + Integer.valueOf(endTime[1]);

        double hour = Math.ceil((double) (endMin - startMin) / 60);

        return (int) (2 + 3 + (hour - 1) * 4);
    }
}
