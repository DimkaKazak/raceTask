package IO.reader;

import IO.base.BaseReader;
import IO.exception.UnableToReadException;
import IO.interfaces.Reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TextFileReader extends BaseReader implements Reader {
    public TextFileReader(File file) {
        super(file);
    }

    public TextFileReader(String path) {
        super(path);
    }

    @Override
    public String read() throws UnableToReadException {
        try(FileReader reader = new FileReader(this.file))
        {
            char[] buffer = new char[256];
            int charCounter;
            while((charCounter = reader.read(buffer)) > 0){

                if(charCounter < 256){
                    buffer = Arrays.copyOf(buffer, charCounter);
                }

            }
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToReadException("Cannot read from file");
        }
    }
}
