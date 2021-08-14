package ultis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class FileManager {
    public static final String FILE_EXISTS = "File is exists!";
    public static final String FILE_NOT_EXISTS = "Error! File not exists!";
    public static final String FOLDER_EXISTS = "Folder is exists!";
    public static final String FOLDER_NOT_EXISTS = "Folder is not exists!";
    public static final String PATH_NOT_FOLDER = "Error! Path is not folder";
    public static final String SOURCE_FILE_NOT_EXISTS = "Source File is not exists!";
    public static final String DESTINATION_FILE_EXISTS = "Destination File is exists!";
    public static final String NEW_FILE_EXISTS = "Error! New File exists!";
    public static final String CREATE_FILE_FAIL = "create file fail!";
    public static final String CREATE_FILE_SUCCESS = "create file success!";
    public static final String DELETE_FILE_SUCCESS = "Delete file success!";
    public static final String DELETE_FILE_FAIL = "Delete file fail!";

    // dia chi: "C:\\Users\\ASUS\\OneDrive\\Máy tính\\newFile.txt"

    public static void isFileExists(String diaChi) {
        File pathFile = new File(diaChi);
        if (pathFile.exists()) {
            System.out.println("File is exists!");
        } else {
            System.out.println("File is not exists!");
        }
    }

    public static void createNewFile(String diaChi) throws Exception {
        File pathFile = new File(diaChi);
        if (pathFile.exists()) {
            throw new Exception("File is exists!");
        } else {
            if (pathFile.createNewFile()) {
                System.out.println("Create file success!");
            } else {
                System.out.println("Create file fail!");
            }
        }
    }

    public static void deleteFile(String diaChi) throws Exception {
        File pathFile = new File(diaChi);
        if (pathFile.exists()) {
            if (pathFile.delete()) {
                System.out.println("Delete file success!");
            } else {
                System.out.println("Delete file fail!");
            }
        } else {
            throw new Exception("Error! File not exists!");
        }
    }

    public static void checkFileOrFolder(String diaChi) throws Exception {
        File pathFile = new File(diaChi);
        if (pathFile.exists()) {
            if (pathFile.isDirectory()) {
                System.out.println("Path is Folder");
            } else {
                System.out.println("Path is File");
            }
        } else {
            throw new Exception("Error!");
        }
    }

    public static void getAllFileOfFolder(String diaChi) {
        File file = new File(diaChi);
        for (String fileName : file.list()) {
            System.out.println(fileName);
        }
    }

    public static void copyFile(String diaChi1, String diaChi2) throws Exception {
        File sourceFile = new File(diaChi1);
        File destinationFile = new File(diaChi2);
        if (!sourceFile.exists()) {
            throw new Exception("Error! Source File not exist");
        }
        if (destinationFile.exists()) {
            throw new Exception("Error! newPath has File same name");
        }
        Files.copy(sourceFile.toPath(), destinationFile.toPath());
    }

    public static void movingFile(String diaChi1, String diaChi2) throws Exception {
        File sourceFile = new File(diaChi1);
        File destinationFile = new File(diaChi2);
        if (!sourceFile.exists()) {
            throw new Exception("Error! Source File not exists");
        } else {
            Files.move(sourceFile.toPath(), destinationFile.toPath());
            System.out.println("moving successfully!");
        }
    }

    public static void renameFile(String diaChi, String newName) throws Exception {
        File pathFile = new File(diaChi);
        File rename = new File(newName);
        if (!pathFile.exists()) {
            throw new Exception("Error! File not exists");
        }
        if (rename.exists()) {
            throw new Exception("Error! New name exists");
        }
        pathFile.renameTo(rename);
    }

    public static void createNewFolder(String diaChi) throws Exception {
        File folder = new File(diaChi);
        if (folder.exists()) {
            throw new Exception("Error! Folder exists");
        } else {
            if (new File(diaChi).mkdir()) {
                System.out.println("Create Folder successfully!");
            } else {
                System.out.println("Create Foler fail");
            }

        }
    }

    public static void downloadFile(String fileLink, String folderSave) throws Exception {
        File folder = new File(folderSave);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new Exception("Folder not exists or not folder");
        }
        URL url = new URL(fileLink);
        URLConnection connection = url.openConnection();
        int size = connection.getContentLength();
        InputStream in = connection.getInputStream();
        FileOutputStream output = new FileOutputStream(folderSave);
        int byteDownloaded = 0;
        byte[] b = new byte[1024];
        int length = in.read(b);
        while (length != -1) {
            byteDownloaded += length;
            System.out.println(byteDownloaded * 100f / size + "%");
            output.write(b, 0, length);
            length = in.read(b);
        }
        output.close();
        in.close();
        System.out.println("DOWNLOAD_FILE_SUCCESS");
    }
}


