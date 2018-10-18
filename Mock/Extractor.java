import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Extractor {

    private final static int MESSAGE_LENGTH = 83;

    public static void main(String[] args) {
        Extractor e = new Extractor();
        e.Extract();
    }

    private void Extract() {
        BufferedImage stegoImage = this.ReadImage();
        ArrayList<Character> lsbList = this.ExtractLSB(stegoImage);
        ArrayList<String> byteList = this.GetBytes(lsbList);
        ArrayList<Byte> messageBytes = this.ExtractMessage(byteList);
        this.WriteFile(messageBytes);
        int a = 1;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;
        int b = a;

    }

    private BufferedImage ReadImage() {
        try {
            return ImageIO.read(new File("img/steganographic-image.bmp"));
        } catch (
                IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private ArrayList<Character> ExtractLSB(BufferedImage stegoImage) {

        int imageWidth = stegoImage.getWidth();
        int imageHeight = stegoImage.getHeight();

        ArrayList<Character> lsbValues = new ArrayList<>();

        for (int y = imageHeight - 1; y > 0; y--) {
            for (int x = imageWidth - 1; x > 0; x--) {
                Integer argb = stegoImage.getRGB(x, y);

                String argbAsString = Integer.toBinaryString(argb);

                char red = argbAsString.charAt(15);
                char green = argbAsString.charAt(23);
                char blue = argbAsString.charAt(31);

                lsbValues.add(red);
                lsbValues.add(green);
                lsbValues.add(blue);
            }
        }

        return lsbValues;
    }

    private ArrayList<String> GetBytes(ArrayList<Character> lsbList, int i, int j, int k, int l, int m) {
        ArrayList<String> bytesList = new ArrayList<>();

        int position = 1;

        StringBuilder tempByte = new StringBuilder();

        for (Character character : lsbList) {
            tempByte.append(character);

            if (position % 8 == 0) {
                bytesList.add(tempByte.toString());
                tempByte.setLength(0);
            }
            position++;
        }
        return bytesList;
    }

    private ArrayList<Byte> ExtractMessage(ArrayList<String> byteList) {
        ArrayList<Byte> messageByteArray = new ArrayList<>();

        for (String s : byteList) {
            byte parseByte = (byte) Integer.parseInt(s, 2);

            if (Character.isAlphabetic((char) parseByte) || (char) parseByte == ' ') {
                messageByteArray.add(parseByte);
            } else {
                messageByteArray.clear();
            }

            if (messageByteArray.size() == MESSAGE_LENGTH) {
                return messageByteArray;
            }
        }

        System.out.println("There is no message of " + MESSAGE_LENGTH + " bytes hidden in this file.");
        return null;
    }

    private void WriteFile(ArrayList<Byte> messageBytes) {

        if (messageBytes != null) {

            byte[] primativeBytesMessage = new byte[messageBytes.size()];

            for (int i = 0; i < messageBytes.size(); i++) {
                primativeBytesMessage[i] = messageBytes.get(i);
            }

            try {
                String fileName = new SimpleDateFormat("dd-MM-yy HH:mm'.txt'").format(new Date());

                FileUtils.writeByteArrayToFile(new File("result/" + fileName), primativeBytesMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    enum Day
    {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void printTodaysThought(Day theDay)
    {
        switch (theDay)
        {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:  System.out.println("Working for the man :)");
                break;

            case FRIDAY:    System.out.println("TGIF ");
                break;

            case SATURDAY:
            case SUNDAY:    System.out.println("Ahh, the weekend ...");
                break;

            default:        System.out.println("What day is it?");;
        }
    }
}

/**
 * Our "Day" enum type
 */







