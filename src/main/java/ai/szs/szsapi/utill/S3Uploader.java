package ai.szs.szsapi.utill;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.google.gson.Gson;
import com.grapecity.documents.excel.G;
import com.grapecity.documents.excel.Workbook;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Slf4j
@RequiredArgsConstructor
@Component
public class S3Uploader {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    public String bucket;  // S3 버킷 이름

    public ResponseEntity<byte[]>  download(String awsKey) throws IOException{
        S3Object o = amazonS3Client.getObject(new GetObjectRequest(bucket, awsKey));
        S3ObjectInputStream objectInputStream = ((S3Object) o).getObjectContent();
        byte[] bytes = IOUtils.toByteArray(objectInputStream);

        String fileName = URLEncoder.encode(awsKey, "UTF-8").replaceAll("\\+", "%20");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentLength(bytes.length);
        httpHeaders.setContentDispositionFormData("attachment", fileName+".xlsx");

        return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);

    }



    public void deleteS3(String key) {
        try {
            //Delete 객체 생성
            DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucket, key);
            //Delete
            amazonS3Client.deleteObject(deleteObjectRequest);
            System.out.println(String.format("[%s] deletion complete", key));

        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

    public void upload(MultipartFile multipartFile, String fileKey) throws IOException {

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        metadata.setContentLength(multipartFile.getSize());
        amazonS3Client.putObject(
                new PutObjectRequest(bucket, fileKey , multipartFile.getInputStream() , metadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead)
        );
    }

}
