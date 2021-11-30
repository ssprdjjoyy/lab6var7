import java.io.*;
import java.util.Scanner;

public class var7 {
    public static boolean checkStr(String word) {
        return (word.charAt(0)==word.charAt(word.length()-1));
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;

        OutputStream out = null;
        Writer wr = null;
        try{
            in = new FileInputStream("C:\\var7\\in.txt");
            file = new InputStreamReader(in, "cp1251");
            buf = new BufferedReader(file);
            File f2 = new File("C:\\var7\\out.txt");
            f2.createNewFile();
            out = new FileOutputStream(f2);
            wr = new OutputStreamWriter(out, "utf-8");
            if (f2.exists()){
                String line = " ";
                String[] words;
                while ((line = buf.readLine()) != null) {
                    words = line.split("");
                    for (int i = 0; i < words.length; i++) {
                        if (checkStr(words[i])){
                            System.out.println(words[i] + "");
                            wr.append(words[i] + "");
                        }
                    }
                    System.out.println();
                    wr.append("\n");
                }
            } else{
                System.out.println("Файл не создан");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            in.close();
            file.close();
            buf.close();
            wr.flush();
            wr.close();
            out.close();
        }
    }
}