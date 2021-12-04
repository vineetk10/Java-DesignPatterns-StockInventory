package Helper;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public interface OutputFile
{
    void WriteFile(ArrayList<String> input);
    void SaveFile(Path path) throws IOException;
}