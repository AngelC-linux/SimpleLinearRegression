/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handsOn8;

/**
 *
 * @author AngelC-Linux
 */
public class SLR {
     private final DataSet dataSetInstance;

    public SLR(DataSet dataSet) {
        this.dataSetInstance = dataSet;
    }
public DataSet getDataSetInstance() {
        return dataSetInstance;
    }

    public void analyzeData() {
        printDataSet();
        printBetas();
        printPredictions();
        printCorrelationAndDetermination();
    }

    private void printDataSet() {
        //int[][] data = dataSetInstance.getDataSet();
        System.out.println("");
    }

    private double mean(int columnIndex) {
        int columnLength = dataSetInstance.getColumnLength();
        double sum = dataSetInstance.getColumnSum(columnIndex);
        return sum / columnLength;
    }

    private double calculateSumOfProducts() {
        int[][] data = dataSetInstance.getDataSet();
        double sop = 0;

        for (int[] row : data) {
            sop += (row[0] - mean(0)) * (row[1] - mean(1));
        }

        return sop;
    }

    private double calculateSumOfSquares(int columnIndex) {
        int[][] data = dataSetInstance.getDataSet();
        double soq = 0;

        for (int[] row : data) {
            soq += Math.pow((row[columnIndex] - mean(columnIndex)), 2);
        }

        return soq;
    }

    private double calculateBeta0() {
        return mean(1) - calculateBeta1() * mean(0);
    }

    private double calculateBeta1() {
        return calculateSumOfProducts() / calculateSumOfSquares(0);
    }

    private void printBetas() {
        System.out.println("Beta1: " + calculateBeta1());
        System.out.println("Beta0: " + calculateBeta0());
        System.out.println("");
    }

    private void printPredictions() {
        int columnLength = dataSetInstance.getColumnLength();

        System.out.println("YHat = Beta1 = " + calculateBeta1() + " + beta0 = " + calculateBeta0() + " Xi");

        for (int i = 0; i < columnLength; i++) {
            double yPredict = calculateBeta0() + calculateBeta1() * dataSetInstance.getValue(i, 0);
            System.out.println((i + 1) + ": " + yPredict);
        }

        System.out.println("");
    }

    private double calculateCorrelationCoefficient() {
        int[][] data = dataSetInstance.getDataSet();
        double soqX = calculateSumOfSquares(0);
        double soqY = calculateSumOfSquares(1);
        return calculateSumOfProducts() / (Math.sqrt(soqX) * Math.sqrt(soqY));
    }

    private double calculateCoefficientOfDetermination() {
        double correlationCoefficient = calculateCorrelationCoefficient();
        return Math.pow(correlationCoefficient, 2);
    }

    private void printCorrelationAndDetermination() {
        System.out.println("r: " + calculateCorrelationCoefficient());
        System.out.println("r2: " + calculateCoefficientOfDetermination());
        System.out.println("");
    }
}