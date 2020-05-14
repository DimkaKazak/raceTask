package IO.reader;

import IO.base.BaseReader;
import IO.exception.UnableToCloseException;
import IO.exception.UnableToReadException;
import IO.interfaces.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedTextFileReader extends BaseReader implements Reader {

    public BufferedTextFileReader(File file) {
        super(file);
    }

    public BufferedTextFileReader(String path) {
        super(path);
    }

    @Override
    public String read() throws UnableToReadException, UnableToCloseException {
        StringBuilder sb = new StringBuilder("");

        try (BufferedReader objReader = new BufferedReader(new FileReader(this.path))) {
            String strCurrentLine;

            while ((strCurrentLine = objReader.readLine()) != null){

                sb.append(strCurrentLine);

            }

            return sb.toString();
        } catch (IOException e){
            e.printStackTrace();
        }

        throw new UnableToReadException("Unable to read file");
    }
}
