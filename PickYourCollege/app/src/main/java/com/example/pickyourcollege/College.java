package com.example.pickyourcollege;

public class College {
    public String name;
    public String major;
    public String location;
    public int rank;
    public int livingCost;
    public int tuition;
    public int scholarship;
    public int distance;
    public int score;

    public College() {
        name = "";
        major = "";
        location = "";
        rank = 0;
        livingCost = 100; // https://www.expatistan.com/cost-of-living/index/north-america#price-index-explanation
        tuition = 0;
        scholarship = 0;
        distance = 0;
        score = 0;
    }

    public void computeScore(int[] weights) {
        int[] factors = {
                rank,
                100 - livingCost,
                -1 * tuition,
                scholarship,
                -1 * distance
        };

        score = 0;
        int totalWeight = 0;
        for (int i = 0; i < factors.length; i++) {
            score += weights[i] * factors[i];
            totalWeight += weights[i];
        }
        score /= totalWeight;
    }
}