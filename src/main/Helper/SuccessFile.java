package Helper;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.text.SimpleDateFormat;

public class SuccessFile implements OutputFile {
    private ArrayList<String> successMessage;

    @Override
    public void WriteFile(ArrayList<String> successMessage)
    {
        this.successMessage = successMessage;
    }

    @Override
    public void SaveFile(Path path) throws IOException
    {
        FileWriter successFile = new FileWriter(path.toString()+"/successFile"+new Date()+".txt");
        for(String line : successMessage)
        {
            successFile.write(line+"\n");
        }
        successFile.close();
    }
}