import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.imageio.ImageIO;

import java.io.IOException;

public class PixelEditing {
	
	public static String file = GUI.fileName;
	public static String codeFile;
	public static int[][] result;
	private static int height;
	private static int width;
	private static final String newLine = System.getProperty("line.separator");
	private static String lineOfCode;

    public static void main(String[] args) {
    	
    }
    
    public static void ImportConvert() {
    	File image = new File(GUI.fileName);
        try {
			BufferedImage imageToSearch = ImageIO.read(image);
			convertToArray(imageToSearch);
			System.out.println(height);
			System.out.println(width);
			int xPos;
			int yPos;
			FileWrite("'COMPILED BY PXLWRITER - JBERBEN" + newLine);
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (result[y][x] == 0) {
						xPos = x+1;
						yPos = y+1;
						lineOfCode = "PxlOn " + yPos + "," + xPos + "Ù";
						FileWrite(lineOfCode);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static void FileWrite(String s) {
        try {
        	//Change the file location to whatever suits your OS
            File fileLocation = new File(codeFile + "/" + "Output.txt");
            FileOutputStream fos = new FileOutputStream(fileLocation, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);    
            Writer w = new BufferedWriter(osw);
            if (!fileLocation.exists()) {
				fileLocation.createNewFile();
			}
            w.write(s + newLine);
            w.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static int[][] convertToArray(BufferedImage image)
    {

        if (image == null || image.getWidth() == 0 || image.getHeight() == 0)
            return null;

        // This returns bytes of data starting from the top left of the bitmap
        // image and goes down.
        // Top to bottom. Left to right.
        final byte[] pixels = ((DataBufferByte) image.getRaster()
                .getDataBuffer()).getData();

        width = image.getWidth();
        height = image.getHeight();

        //int[][] result = new int[height][width];
        result = new int[height][width];

        boolean done = false;
        boolean alreadyWentToNextByte = false;
        int byteIndex = 0;
        int row = 0;
        int col = 0;
        int numBits = 0;
        byte currentByte = pixels[byteIndex];
        while (!done)
        {
            alreadyWentToNextByte = false;

            result[row][col] = (currentByte & 0x80) >> 7;
            currentByte = (byte) (((int) currentByte) << 1);
            numBits++;

            if ((row == height - 1) && (col == width - 1))
            {
                done = true;
            }
            else
            {
                col++;

                if (numBits == 8)
                {
                    currentByte = pixels[++byteIndex];
                    numBits = 0;
                    alreadyWentToNextByte = true;
                }

                if (col == width)
                {
                    row++;
                    col = 0;

                    if (!alreadyWentToNextByte)
                    {
                        currentByte = pixels[++byteIndex];
                        numBits = 0;
                    }
                }
            }
        }

        return result;
    }  
    
}