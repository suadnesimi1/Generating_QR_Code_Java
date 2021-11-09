import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class GenerateQR {
    public static void GenerateQR(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset),charset), BarcodeFormat.QR_CODE,w,h);
        MatrixToImageWriter.writeToFile(matrix,path.substring(path.lastIndexOf('.')+1),new File(path));
    }

    public static void main(String[] args) throws WriterException,IOException, NotFoundException {
        String string = "https://www.youtube.com/watch?v=piOIvNO2M8Q";
        String path="C:\\Users\\suadn\\Desktop\\qr.png";
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel>hashMap = new HashMap<EncodeHintType,ErrorCorrectionLevel>();
        hashMap.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
        GenerateQR(string,path,charset,hashMap,200,200);
        System.out.println("QR code created successfully");

    }
}
