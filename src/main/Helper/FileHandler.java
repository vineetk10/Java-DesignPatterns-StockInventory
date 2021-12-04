package Helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {

    Path path;
    Path outputPath;
    OutputFile outputFile;
    public FileHandler(String filePath, String outputFilePath)
    {
        path = Paths.get(filePath);
        outputPath = Paths.get(outputFilePath);
    }
    public void ReadFileContents(ArrayList<String> fileContent)
    {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path.toFile()));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
                fileContent.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeOutput(ArrayList<String> message, boolean isError) throws IOException
    {
        if(!isError)
            outputFile = new SuccessFile();
        else
            outputFile = new ErrorFile();
        outputFile.WriteFile(message);
        outputFile.SaveFile(outputPath);
    }
}
