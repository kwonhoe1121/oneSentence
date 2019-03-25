package com.one.sentence.naturallanguage.service;

import java.util.List;
import java.util.Map;

import com.google.cloud.language.v1beta2.Entity;
import com.google.cloud.language.v1beta2.EntityMention;
import com.google.cloud.language.v1beta2.Sentiment;
import com.google.cloud.language.v1beta2.Token;

public class NLTest {

//	@Inject
//	private static NaturalLanguageService service;

	public static void main(String[] args) {

//		String text = "The easiest and recommended way for most users to use the Google Cloud Natural Language API is with our provided client libraries. They provide an optimized developer experience by using each supported language's natural conventions and styles. They also reduce the boilerplate code you have to write because they're designed to enable you to work with service metaphors in mind, rather than implementation details or service API concepts. You can find out more about client libraries for Cloud APIs in Client Libraries Explained.";
		String text = "참다운 행복이란, 당신으로부터 오는, 당신을 향한, 당신을 위한 기쁨이옵니다.";
//		String text = "죽어야할 인간일랑 어느 누구도 행복하다고 기리지 말라.";
		
		// Sentiment Test
		Sentiment sentiment = NaturalLanguageService.getInstance().analyzeSentiment(text);

		System.out.println("\n\n========== Sentiment ==========\n\n");

		System.out.println("getMagnitude() : " + sentiment.getMagnitude());
		System.out.println("getScore() : " + sentiment.getScore());

		// Entities Test
		List<Entity> entityList = NaturalLanguageService.getInstance().analyzeEntities(text);

		System.out.println("\n\n========== Entities ==========\n\n");

		for (Entity entity : entityList) {

			for (EntityMention mention : entity.getMentionsList()) {
				System.out.printf("Content: %s\n", mention.getText().getContent());
				System.out.printf("Begin offset: %d\n", mention.getText().getBeginOffset());
				System.out.printf("Type: %s\n", mention.getType());
			}

			System.out.printf("Entity: %s\n", entity.getName());
			System.out.printf("Salience: %.3f\n", entity.getSalience());
			System.out.println("Metadata: ");

			for (Map.Entry<String, String> entry : entity.getMetadataMap().entrySet()) {
				System.out.printf("%s : %s", entry.getKey(), entry.getValue());
			}

			System.out.println("\n\n-------------------\n\n");

		}

		// Syntax분석
		List<Token> tokenList = NaturalLanguageService.getInstance().analyzeSyntax(text);

		System.out.println("\n\n========== Syntax ==========\n\n");

		for (Token token : tokenList) {
			System.out.printf("\tText: %s\n", token.getText().getContent());
			System.out.printf("\tBeginOffset: %d\n", token.getText().getBeginOffset());
			System.out.println("\n-------------------\n");
			System.out.printf("Lemma: %s\n", token.getLemma());
			System.out.println("\n-------------------\n");
			System.out.printf("PartOfSpeechTag: %s\n", token.getPartOfSpeech().getTag());
			System.out.printf("\tAspect: %s\n", token.getPartOfSpeech().getAspect());
			System.out.printf("\tCase: %s\n", token.getPartOfSpeech().getCase());
			System.out.printf("\tForm: %s\n", token.getPartOfSpeech().getForm());
			System.out.printf("\tGender: %s\n", token.getPartOfSpeech().getGender());
			System.out.printf("\tMood: %s\n", token.getPartOfSpeech().getMood());
			System.out.printf("\tNumber: %s\n", token.getPartOfSpeech().getNumber());
			System.out.printf("\tPerson: %s\n", token.getPartOfSpeech().getPerson());
			System.out.printf("\tProper: %s\n", token.getPartOfSpeech().getProper());
			System.out.printf("\tReciprocity: %s\n", token.getPartOfSpeech().getReciprocity());
			System.out.printf("\tTense: %s\n", token.getPartOfSpeech().getTense());
			System.out.printf("\tVoice: %s\n", token.getPartOfSpeech().getVoice());
			System.out.println("\n-------------------\n");
			System.out.println("DependencyEdge");
			System.out.printf("\tHeadTokenIndex: %d\n", token.getDependencyEdge().getHeadTokenIndex());
			System.out.printf("\tLabel: %s\n\n", token.getDependencyEdge().getLabel());
		}
	}
}
