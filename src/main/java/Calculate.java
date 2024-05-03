
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Calculate {
    public static void main(String[] args) {
        String filePath = null;
        int x = 0;

        if (args.length >= 1) {
            filePath = args[0];
        }

        if (args.length >= 2) {
            x = Integer.parseInt(args[1]);
        } else {
            throw new IllegalArgumentException("\n#################\nplease put number on item you want to show\n#################");
        }

        Map<String, Integer> recordValues = new HashMap<>();

        try {
            BufferedReader reader;
            if (filePath != null) {
                reader = new BufferedReader(new FileReader(filePath));
            } else {
                throw new FileNotFoundException();
            }
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String recordId = parts[0];
                    int value = Integer.parseInt(parts[1]);
                    recordValues.put(recordId, value);
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );
        maxHeap.addAll(recordValues.entrySet());

        for (int i = 0; i < x && !maxHeap.isEmpty(); i++) {
            Map.Entry<String, Integer> entry = maxHeap.poll();
            System.out.println(entry.getKey());
        }
    }
}
