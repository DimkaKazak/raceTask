package IO.writer;

import IO.exception.UnableToWriteException;
import IO.interfaces.Writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTextFileWriter implements Writer {

    @Override
    public void write(String path, String text) throws UnableToWriteException {
        File fileTo = new File(path);
        try(FileOutputStream fout = new FileOutputStream(fileTo.getAbsoluteFile())) {
            byte[] buffer = text.getBytes();
            fout.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToWriteException(String.format("Could not write %s!", path));
        }
    }

    @Override
    public void append(String path, String text) throws UnableToWriteException {
        File fileTo = new File(path);
        try(FileOutputStream fout = new FileOutputStream(fileTo.getAbsoluteFile(), true)) {
            byte[] buffer = text.getBytes();
            fout.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToWriteException(String.format("Could not write %s!", path));
        }
    }

}
