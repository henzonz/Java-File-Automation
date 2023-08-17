import java.io.File;
import java.util.Scanner;
public class FileAutomation {
    private static String directory_pathname = "";
    static Scanner input = new Scanner(System.in);
            public static void main(String[] args) {

                try {
                    //enter pathname
                    System.out.print("Enter pathname: ");
                    directory_pathname = input.nextLine();
                }
                catch (Exception e){
                    System.out.println("Invalid pathname.");
                }
                Scanner command_input = new Scanner(System.in);
                System.out.println("What would you like to do?");
                System.out.println("1 - Look up ALL folder/file names within the directory");
                System.out.println("2 - Look up a specific file name within the directory");
                System.out.println("3 - Look up ALL file names containing a specific name within the directory");
                System.out.println("4 - Update a specific file name within the directory");
                System.out.println("5 - Rename a file in a directory");
                System.out.println("0 - exit");
                System.out.print("Enter: ");
                int command = command_input.nextInt();

                switch(command){
                    case 0:
                        return;
                    case 1: getFileName(directory_pathname+ "/");
                        break;
                    case 5: renameFile(directory_pathname+"/");
                        break;
                }

            }

            //utilizes File class
            public static void getFileName(String pathname){
                File folder = new File(pathname);
                //utilizes listFiles() method from File class to retrieve file names in a directory
                File[] files = folder.listFiles();


                //for each loop to iterate through individual elements
                for (File file: files) {
                    if (file.isFile() || file.isDirectory()) {
                        System.out.println(file.getName());
                    }
                }
            }

            public static void renameFile(String pathname){
                File folder = new File(pathname);
                //utilizes listFiles() method from File class to retrieve file names in a directory
                File[] files = folder.listFiles();


                System.out.println("Which file would you like to rename?");
                String file_name = input.nextLine();

                System.out.println("What would you like to name the file?");
                String newFileName = input.nextLine();
                //for each loop to iterate through individual elements
                for (File file : files) {
                    if (file.getName().equals(file_name)) {
                        File rename = new File(pathname+newFileName);
                        file.renameTo(rename);
                    }
                }
            }
        }


