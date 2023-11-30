/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package handsOn8;

/**
 *
 * @author AngelC-Linux
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int[][] data = {
            {23, 651},
            {26, 762},
            {30, 856},
            {34, 1063},
            {43, 1190},
            {48, 1298},
            {52, 1421},
            {57, 1440},
            {58, 1518}
        };

        DataSet dataSet = new DataSet(data);

        SLR slr = new SLR(dataSet);

        slr.analyzeData();
    }
    
}
