package com.one.sentence.speechtotext.service;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SpeechApiTest {
	public static void main(String[] args) {
		String filePath = "./444.raw";

		recognitionSpeech(filePath);
	}

	// 1분 미만의 오디오 파일일때
	public static void recognitionSpeech(String filePath) {

		try {
			SpeechClient speech = SpeechClient.create(); // Client 생성

			// 오디오 파일에 대한 설정부분
			RecognitionConfig config = RecognitionConfig.newBuilder()
					.setEncoding(RecognitionConfig.AudioEncoding.LINEAR16).setSampleRateHertz(16000)
					.setLanguageCode("ko_KR").build();

			RecognitionAudio audio = getRecognitionAudio(filePath); // Audio 파일에 대한 RecognitionAudio 인스턴스 생성
			RecognizeResponse response = speech.recognize(config, audio); // 요청에 대한 응답
			List<SpeechRecognitionResult> results = response.getResultsList(); // 응답 결과들

			for (SpeechRecognitionResult result : results) {
				SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
				System.out.printf("Transcription: %s%n", alternative.getTranscript());
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
