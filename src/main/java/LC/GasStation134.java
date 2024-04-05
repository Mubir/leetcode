package LC;

public class GasStation134 {

    //https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int petrol = 0;
        int start = 0;
        int size = gas.length;
        int end = 1;
        petrol = gas[0] - cost[0];
        while (start != end || petrol < 0) {
            while ( petrol < 0 && start != end) {
                petrol = petrol - (gas[start] - cost[start]);
                start = (start + 1) % size;

                if (start == 0)
                    return -1;

            }
            petrol = petrol + (gas[end] - cost[end]);
            end = (end + 1) % size;
        }

        return start;
    }

    public static void main(String[] args) {
        GasStation134 obj = new GasStation134();
        System.out.println(obj.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
