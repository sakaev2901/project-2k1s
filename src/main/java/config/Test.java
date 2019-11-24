package config;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.texttospeech.v1.*;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import dao.DictionaryDaoImpl;
import models.Dictionary;
import models.Question;
import models.Word;
import service.TestService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Test {
    public static void saveSpeech() throws IOException {
        authExplicit();
        try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
            SynthesisInput input = SynthesisInput.newBuilder().setText("Hello").build();
            VoiceSelectionParams voice = VoiceSelectionParams.newBuilder().setLanguageCode("en-US").setSsmlGender(SsmlVoiceGender.NEUTRAL).build();
            AudioConfig audioConfig = AudioConfig.newBuilder().setAudioEncoding(AudioEncoding.MP3).build();
            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);
            ByteString audioContents = response.getAudioContent();
            try(OutputStream outputStream = new FileOutputStream("output.mp3")) {
                outputStream.write(audioContents.toByteArray());

            }

        }
    }
    static void authExplicit() throws IOException {
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
    public static void main(String[] args) throws IOException {
        saveSpeech();

    }
}
