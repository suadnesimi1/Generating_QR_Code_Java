import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadQRCode {
    public static String ReadQRCode(String path, String charset, Map map) throws FileNotFoundException, IOException, NotFoundException{
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }

    public static void main(String[] args)throws WriterException,IOException,NotFoundException {
        String path="C:\\Users\\suadn\\Desktop\\qr.png";
        String charset="UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel>hintMap=new HashMap<EncodeHintType,ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
        System.out.println("Data stored into the QR code is: \n"+ReadQRCode(path,charset,hintMap));

    }
}
