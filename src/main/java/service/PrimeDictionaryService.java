package service;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.texttospeech.v1.*;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import dao.WordDaoImpl;
import models.Dictionary;
import models.Word;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

public class PrimeDictionaryService {

    private InputStream image;
    private Integer wordId;
    private HttpServletRequest req;
    public void parsePrimeDictionary(HttpServletRequest req) {
        this.req = req;
        List<FileItem> items;
        String wordText = "";
        String translation = "";
        String photoName = "";
        String voice_name = "";
        try {
            items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
            for (FileItem item:
                    items) {
                if (item.isFormField()) {
                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    if(fieldName.equals("word")) {
                        wordText = fieldValue;
                    } else if (fieldName.equals("translation")) {
                        translation = fieldValue;
                    }
                } else {
                    // Process form file field (input type="file").
                    String fieldName = item.getFieldName();
                    String fileName = FilenameUtils.getName(item.getName());
                    photoName = fileName;
                    this.image = item.getInputStream();
                    addPrimeWord(wordText, translation, photoName);
                }
            }
        } catch (FileUploadException | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void addPrimeWord(String wordText, String translation, String photoName) throws IOException {
        Dictionary dictionary = (Dictionary)this.req.getSession().getAttribute("dictionary");
        String[] path = photoName.split("\\.");
        String extension = path[path.length - 1];
        Word word = new Word();
        word.setWord(wordText);
        word.setTranslation(translation);
        WordDaoImpl wordDao = new WordDaoImpl();
        this.wordId = wordDao.savePrime(word, extension,dictionary.getId());
        saveImage(extension);
        saveSpeech(wordText);

    }

    public void saveImage(String extension) {
        try {
            File imageFile = new File("C:\\Projects\\project-2k1s\\src\\main\\webapp\\resources\\images\\prime_words\\" + this.wordId + "." +extension);
            OutputStream outputStream = new FileOutputStream(imageFile);
            byte[] buf = new byte[1024];
            int len;

            while ((len = image.read(buf)) > 0 ) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            image.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void saveSpeech(String word) throws IOException {
        authExplicit();
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            SynthesisInput input = SynthesisInput.newBuilder().setText(word).build();
            VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().setLanguageCode("en-US").setSsmlGender(SsmlVoiceGender.NEUTRAL).build();
            AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();
            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
            ByteString audioContents = response.getAudioContent();
            String speechPath = "C:\\Projects\\project-2k1s\\src\\main\\webapp\\resources\\speech\\" + wordId + ".mp3";
            try(OutputStream outputStream = new FileOutputStream(speechPath)) {
                outputStream.write(audioContents.toByteArray());

            }

        }
    }
    private static void authExplicit() throws IOException {
        String jsonPath = "C:\\Projects\\719c6646c0b2.json";
        // You can specify a credential file by providing a path to GoogleCredentials.
        // Otherwise credentials are read from the GOOGLE_APPLICATION_CREDENTIALS environment variable.
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath))
                .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

        System.out.println("Buckets:");
        Page<Bucket> buckets = storage.list();
        for (Bucket bucket : buckets.iterateAll()) {
            System.out.println(bucket.toString());
        }
    }
}
