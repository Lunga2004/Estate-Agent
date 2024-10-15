
package estateagent;

/**
 *
 * @author Private
 */
public class EstateAgent implements IEstateAgent {

    // Implement the method to calculate the total sales for each agent
    @Override
    public double EstateAgentSales(double[] propertySales) {
        double totalSales = 0;
        for (double sale : propertySales) {
            totalSales += sale;
        }
        return totalSales;
    }

    // Implement the method to calculate the commission (2% of sales)
    @Override
    public double EstateAgentCommission(double totalSales) {
        return totalSales * 0.02;
    }

    // Implement the method to determine the top-performing agent
    @Override
    public int TopEstateAgent(double[] totalSales) {
        int topAgentIndex = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topAgentIndex]) {
                topAgentIndex = i;
            }
        }
        return topAgentIndex;
    }

    // Main method to display the report
    public static void main(String[] args) {
        // 2D array for property sales (2 agents, 3 months)
        double[][] propertySales = {
            {800000, 1500000, 2000000},  // Joe Bloggs
            {700000, 1200000, 1600000}   // Jane Doe
        };
        
        String[] agents = {"Joe Bloggs", "Jane Doe"};
        EstateAgent estateAgent = new EstateAgent();
        
        double[] totalSales = new double[2];
        double[] commissions = new double[2];
        
        // Display header
        System.out.printf("%-15s %-10s %-10s %-10s\n", "ESTATE AGENTS", "JAN", "FEB", "MAR");
        System.out.println("---------------------------------------------");

        // Loop through each agent to calculate and display sales and commission
        for (int i = 0; i < propertySales.length; i++) {
            System.out.printf("%-15s R%-10.2f R%-10.2f R%-10.2f\n", agents[i], propertySales[i][0], propertySales[i][1], propertySales[i][2]);
            
            // Calculate total sales for each agent
            totalSales[i] = estateAgent.EstateAgentSales(propertySales[i]);
            // Calculate commission for each agent
            commissions[i] = estateAgent.EstateAgentCommission(totalSales[i]);
        }

        System.out.println();
        System.out.printf("Total property sales for %s = R%.2f\n", agents[0], totalSales[0]);
        System.out.printf("Total property sales for %s = R%.2f\n", agents[1], totalSales[1]);
        
        System.out.printf("Sales Commission for %s = R%.2f\n", agents[0], commissions[0]);
        System.out.printf("Sales Commission for %s = R%.2f\n", agents[1], commissions[1]);
        
        // Determine and display the top-performing agent
        int topAgent = estateAgent.TopEstateAgent(totalSales);
        System.out.printf("\nTop performing estate agent: %s\n", agents[topAgent]);
    }
}
