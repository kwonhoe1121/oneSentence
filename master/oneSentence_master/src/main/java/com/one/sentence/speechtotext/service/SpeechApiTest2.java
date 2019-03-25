package com.one.sentence.speechtotext.service;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SpeechApiTest2 {
	public static void main(String[] args) {
		String filePath = "gs://myfiles-byjw/vr.flac";

		longRecognitionSpeech(filePath);
	}

	// 1분 이상의 오디오 파일일때, (** GCS에 올려서 이용해야 함)
	public static void longRecognitionSpeech(String filePath) {

		try {
			SpeechClient speech = SpeechClient.create();

			// 오디오 파일에 대한 설정부분
			RecognitionConfig config = RecognitionConfig.newBuilder().setEncoding(RecognitionConfig.AudioEncoding.FLAC)
					.setSampleRateHertz(16000).setLanguageCode("en-US").build();

			RecognitionAudio audio = getRecognitionAudio(filePath); // Audio 파일에 대한 RecognitionAudio 인스턴스 생성

			// Non-Blocking 으로 호출을 하며 긴 파일 일때는 LongRunningRecognizeResponse를 사용함
			OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> response = speech
					.longRunningRecognizeAsync(config, audio);

			while (!response.isDone()) {
				System.out.println("Waiting for response...");
				Thread.sleep(10000);
			}

			List<SpeechRecognitionResult> results = response.get().getResultsList();

			for (SpeechRecognitionResult result : results) {
				SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
				System.out.printf("Transcription: %s\n", alternative.getTranscript());
			}
			speech.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Local 이나 Remote이거나 구분해서 RecognitionAudio 만들어 주는 부분
	public static RecognitionAudio getRecognitionAudio(String filePath) throws IOException {
		RecognitionAudio recognitionAudio;

		// 파일이 GCS에 있는 경우
		if (filePath.startsWith("gs://")) {
			recognitionAudio = RecognitionAudio.newBuilder().setUri(filePath).build();
		} else { // 파일이 로컬에 있는 경우
			Path path = Paths.get(filePath);
			byte[] data = Files.readAllBytes(path);
			ByteString audioBytes = ByteString.copyFrom(data);

			recognitionAudio = RecognitionAudio.newBuilder().setContent(audioBytes).build();
		}

		return recognitionAudio;
	}

}
