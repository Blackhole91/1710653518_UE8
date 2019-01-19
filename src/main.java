import javax.swing.*;
import java.io.*;


public class main {

    static File file2 = new File("C:\\Users\\ljasc\\OneDrive\\Desktop\\Neuer Ordner\\user.txt");
    static FileReader fileReader;
    static BufferedReader bufferedReader;

    static FileWriter fileWriter;
    static BufferedWriter bufferedWriter;
    static String zeilenUmbruch = System.lineSeparator();

    static boolean schleifenBedingung = false;
    static String user ,passwort ;
    static String userAbfrage;
    static String passAbfrage;

    public static void main(String[] args) throws IOException {

        int registrierungsAbfrage = JOptionPane.showConfirmDialog (null, "sind Sie bereits registriet?");


        if (registrierungsAbfrage == 0) {

            try {

                fileReader  = new FileReader(file2);
                bufferedReader = new BufferedReader(fileReader);

                user = bufferedReader.readLine();
                passwort = bufferedReader.readLine();

                System.out.println(user);
                System.out.println(passwort);

                while (!schleifenBedingung) {
                    userAbfrage = JOptionPane.showInputDialog("Username?");
                    passAbfrage = JOptionPane.showInputDialog("Passwort?");

                    if (userAbfrage.contains(user)&&passAbfrage.contains(passwort)){
                        JOptionPane.showMessageDialog(null,"ich bin dein Vater!");
                        schleifenBedingung = true;
                    }

                }

            } catch (IOException ex){
                System.err.println("fehler2");
            }finally {
                fileReader.close();
                bufferedReader.close();
            }

        } else {
            try {

                fileWriter = new FileWriter(file2);
                bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(JOptionPane.showInputDialog("geben Sie ihren Wunschnamen ein")+zeilenUmbruch+JOptionPane.showInputDialog("und nun ihr gewünschtes Passwort"));

            } catch (IOException ex) {
                System.err.println("fehler");
            } finally {
                bufferedWriter.close();
                fileWriter.close();
            }

        }
    }}
