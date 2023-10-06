package unsw.archaic_fs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import unsw.archaic_fs.exceptions.UNSWFileAlreadyExistsException;
import unsw.archaic_fs.exceptions.UNSWFileNotFoundException;
import unsw.archaic_fs.exceptions.UNSWNoSuchFileException;
import java.util.EnumSet;

public class ArchaicFsTest {
    @Test
    public void testCdInvalidDirectory() {
        ArchaicFileSystem fs = new ArchaicFileSystem();

        // Try to change directory to an invalid one
        assertThrows(UNSWNoSuchFileException.class, () -> {
            fs.cd("/usr/bin/cool-stuff");
        });
    }

    @Test
    public void testCdValidDirectory() {
        ArchaicFileSystem fs = new ArchaicFileSystem();

        assertDoesNotThrow(() -> {
            fs.mkdir("/usr/bin/cool-stuff", true, false);
            fs.cd("/usr/bin/cool-stuff");
        });
    }

    @Test
    public void testCdAroundPaths() {
        ArchaicFileSystem fs = new ArchaicFileSystem();

        assertDoesNotThrow(() -> {
            fs.mkdir("/usr/bin/cool-stuff", true, false);
            fs.cd("/usr/bin/cool-stuff");
            assertEquals("/usr/bin/cool-stuff", fs.cwd());
            fs.cd("..");
            assertEquals("/usr/bin", fs.cwd());
            fs.cd("../bin/..");
            assertEquals("/usr", fs.cwd());
        });
    }

    @Test
    public void testCreateFile() {
        ArchaicFileSystem fs = new ArchaicFileSystem();

        assertDoesNotThrow(() -> {
            fs.writeToFile("test.txt", "My Content", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            assertEquals("My Content", fs.readFromFile("test.txt"));
            fs.writeToFile("test.txt", "New Content", EnumSet.of(FileWriteOptions.TRUNCATE));
            assertEquals("New Content", fs.readFromFile("test.txt"));
        });
    }

    // Now write some more!
    // Some ideas to spark inspiration;
    // - File Writing/Reading with various options (appending for example)
    // - Cd'ing .. on the root most directory (shouldn't error should just remain on
    // root directory)
    // - many others...
    @Test
    public void testConinuityFiles() {
        ArchaicFileSystem fs = new ArchaicFileSystem();

        // File already exists
        assertThrows(UNSWFileAlreadyExistsException.class, () -> {
            fs.writeToFile("test.txt", "This is a test", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            fs.writeToFile("test.txt", "definitely a different file!", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
        });
    }

    @Test
    public void testNonExistentFiles() {
        ArchaicFileSystem fs = new ArchaicFileSystem();
        // File doesn't exist
        assertThrows(UNSWFileNotFoundException.class, () -> {
            fs.readFromFile("notHere.txt");
        });
    }
    
    @Test
    public void testAppendingToFiles() {
        ArchaicFileSystem fs = new ArchaicFileSystem();

        assertDoesNotThrow(() -> {
            fs.mkdir("/usr/bin/1/2/3/4/5/6/7/8/9/10", true, false);
            fs.writeToFile("usr/bin/1/2/3/4", "to zone 4!!", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            fs.cd("usr/bin/1/2/3/4/5/6/7/8/9/10");
            fs.mkdir("a/b/c", true, false);
            fs.mkdir("soup", true, false);
            fs.writeToFile("hello.txt", "testing", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            fs.writeToFile("hello1.txt", "testing1", EnumSet.of(FileWriteOptions.CREATE_IF_NOT_EXISTS, FileWriteOptions.TRUNCATE));
            fs.writeToFile("hello.txt", " once", EnumSet.of(FileWriteOptions.APPEND));
            assertEquals("testing once", fs.readFromFile("hello.txt"));
        });
    }

    @Test
    public void testMultiplFiles() {
        ArchaicFileSystem fs = new ArchaicFileSystem();

        assertDoesNotThrow(() -> {
            fs.writeToFile("test1.txt", "hello1", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            fs.writeToFile("test2.txt", "hello2", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            fs.writeToFile("test3.txt", "hello3", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            fs.writeToFile("test4.txt", "hello4", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            fs.writeToFile("test5.txt", "hello5", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            fs.writeToFile("test6.txt", "hello6", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            fs.writeToFile("test7.txt", "hello7", EnumSet.of(FileWriteOptions.CREATE, FileWriteOptions.TRUNCATE));
            assertEquals("hello5", fs.readFromFile("test5.txt"));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            fs.writeToFile("test.txt", "testing", EnumSet.of(FileWriteOptions.CREATE));
        });
    }
}
