package org.example.generator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;

public class QrCode {

    public BufferedImage generate(final String codeText) throws Exception {
        final QRCodeWriter codeWriter = new QRCodeWriter();
        final BitMatrix bitMatrix = codeWriter.encode(codeText, BarcodeFormat.QR_CODE, 300, 300);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

}
