package Helper;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.text.SimpleDateFormat;

public class ErrorFile implements OutputFile {
    private ArrayList<String> errors;

    @Override
    public void WriteFile(ArrayList<String> errorMessage)
    {
        errors = errorMessage;
    }

    @Override
    public void SaveFile(Path path) throws IOException
    {
        FileWriter errorFile = new FileWriter(path.toString()+"/ErrorFile-"+new Date()+".txt");
        for(String line : errors)
        {
            errorFile.write(line+"\n");
        }
        errorFile.close();
    }
}