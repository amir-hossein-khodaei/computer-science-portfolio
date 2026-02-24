import java.io.*;
import java.util.*;

public class ExternalSort {

    // Size of each chunk that fits in memory (example size)
    private static final int CHUNK_SIZE = 1000;

    public static void main(String[] args) throws IOException {
        String inputFile = "largefile.txt";
        String outputFile = "sortedfile.txt";

        // Step 1: Split the input file into sorted chunks
        List<File> sortedChunks = createSortedChunks(inputFile);

        // Step 2: Merge the sorted chunks into a single sorted file
        mergeSortedChunks(sortedChunks, outputFile);
    }

    private static List<File> createSortedChunks(String inputFile) throws IOException {
        List<File> sortedChunks = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        List<String> chunk = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            chunk.add(line);
            if (chunk.size() >= CHUNK_SIZE) {
                sortedChunks.add(sortAndSaveChunk(chunk));
                chunk.clear();
            }
        }
        if (!chunk.isEmpty()) {
            sortedChunks.add(sortAndSaveChunk(chunk));
        }
        reader.close();
        return sortedChunks;
    }

    private static File sortAndSaveChunk(List<String> chunk) throws IOException {
        Collections.sort(chunk);
        File chunkFile = File.createTempFile("chunk", ".txt");
        chunkFile.deleteOnExit();
        BufferedWriter writer = new BufferedWriter(new FileWriter(chunkFile));
        for (String line : chunk) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
        return chunkFile;
    }

    private static void mergeSortedChunks(List<File> sortedChunks, String outputFile) throws IOException {
        PriorityQueue<ChunkReader> pq = new PriorityQueue<>(Comparator.comparing(ChunkReader::peek));
        for (File chunk : sortedChunks) {
            ChunkReader reader = new ChunkReader(chunk);
            if (reader.peek() != null) {
                pq.add(reader);
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        while (!pq.isEmpty()) {
            ChunkReader reader = pq.poll();
            writer.write(reader.poll());
            writer.newLine();
            if (reader.peek() != null) {
                pq.add(reader);
            } else {
                reader.close();
            }
        }
        writer.close();
    }
}

class ChunkReader {
    private final BufferedReader reader;
    private String currentLine;

    public ChunkReader(File file) throws IOException {
        this.reader = new BufferedReader(new FileReader(file));
        this.currentLine = reader.readLine();
    }

    public String peek() {
        return currentLine;
    }

    public String poll() throws IOException {
        String line = currentLine;
        currentLine = reader.readLine();
        return line;
    }

    public void close() throws IOException {
        reader.close();
    }
}
