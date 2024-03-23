//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.io.TempDir;
//
//import java.io.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class CalculateTest {
//
//    @TempDir
//    static File tempDir;
//
//    private Calculate calculate;
//
//    @BeforeEach
//    public void setUp() {
//        calculate = new Calculate();
//    }
//
//    @Test
//    public void testMainWithValidArguments() throws IOException {
//        File inputFile = createInputFile("input.txt", "1426828011 9\n1426828028 350\n1426828037 25\n1426828056 231\n1426828058 109\n1426828066 111\n");
//        String[] args = {inputFile.getAbsolutePath(), "3"};
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//
//        calculate.main(args);
//
//        String actualOutput = outputStream.toString();
//
//
//        String expectedOutput = "1426828028\n1426828056\n1426828066\n";
//        assertEquals(expectedOutput, actualOutput);
//    }
//
//    @Test
//    public void testMainWithMissingXArgument() throws IOException {
//        File inputFile = createInputFile("input.txt", "1426828011 9\n1426828028 350\n1426828037 25\n1426828056 231\n1426828058 109\n1426828066 111\n");
//        String[] args = {inputFile.getAbsolutePath()};
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
//            calculate.main(args);
//        });
//
//        assertEquals("\n#################\nplease put number on item you want to show\n#################", exception.getMessage());
//    }
//
//    private File createInputFile(String fileName, String content) throws IOException {
//        File file = new File(tempDir, fileName);
//        FileWriter writer = new FileWriter(file);
//        writer.write(content);
//        writer.close();
//        return file;
//    }
//}
