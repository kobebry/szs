package ai.szs.szsapi.utill;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;


@Slf4j
@RequiredArgsConstructor
@Component
public class AES256 {

    @Value("${aes.key}")
    public String aesKey;

    @Value("${aes.senderPwKey}")
    public String senderPwKey;

    public static String alg = "AES/CBC/PKCS5Padding";

    public String encrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(aesKey.substring(0, 16).getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(aesKey.substring(0, 16).getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));

        return Base64.encodeBase64URLSafeString(encrypted);
    }

    public String encryptSenderPw(String text) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(senderPwKey.substring(0, 16).getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(senderPwKey.substring(0, 16).getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));

        return Base64.encodeBase64URLSafeString(encrypted);
    }

    public String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(aesKey.substring(0, 16).getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(aesKey.substring(0, 16).getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        byte[] decodedBytes = Base64.decodeBase64URLSafe(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }


    /**
     * 복호화 전후 함수처리 로직
     * ex) checkSumEncode(36, 2, 63) = "41|2|63"
     * **/
    public String checkSumEncode(long wIdx, long mIdx, long shareIdx, String sheetName) {
        return Long.toString(wIdx + mIdx % 10 + shareIdx % 10) + "|" + Long.toString(mIdx) + "|" + Long.toString(shareIdx) + "|" + sheetName;
    }

    public String[] checkSumDecode(String checkSumString) {
        String[] arr = checkSumString.split("\\|");
        arr[0] = Long.toString(Long.parseLong(arr[0]) - Long.parseLong(arr[1]) %10 - Long.parseLong(arr[2]) %10);
        return arr;
    }

}
