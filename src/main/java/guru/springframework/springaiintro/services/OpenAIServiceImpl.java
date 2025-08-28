package guru.springframework.springaiintro.services;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by jt, Spring Framework Guru.
 */
@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatModel chatModel;

    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }


    // Returnerer et svar på et gitt spørsmål ved å bruke en ChatModel (f.eks. OpenAI).
    @Override
    public String getAnswer(String question) {
        // Lager en PromptTemplate basert på spørsmålet.
        PromptTemplate promptTemplate = new PromptTemplate(question);
        // Oppretter en Prompt fra malen.
        Prompt prompt = promptTemplate.create();

        // Sender prompten til chatmodellen og får et svar.
        ChatResponse response = chatModel.call(prompt);

        // Returnerer tekstsvaret fra modellen.
        return response.getResult().getOutput().getText();
    }
}






















