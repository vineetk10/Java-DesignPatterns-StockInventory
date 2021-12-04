package Iterator;

import java.util.ArrayList;

public class FileRepository implements Container{

    ArrayList<String> fileContent;

    public FileRepository(ArrayList<String> fileContent)
    {
        this.fileContent = fileContent;
    }
    @Override
    public Iterator getIterator() {
        return new FileIterator();
    }

    private class FileIterator implements  Iterator
    {
        int index;

        @Override
        public boolean hasNext() {
            return index < fileContent.size();
        }

        @Override
        public Object next() {
            if(this.hasNext())
            {
                return fileContent.get(index++);
            }
            return null;
        }
    }
}
