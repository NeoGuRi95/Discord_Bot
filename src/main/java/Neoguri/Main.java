package Neoguri;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Random;

public class Main extends ListenerAdapter {
    public static JDA jda;

    public static void main(String[] args) throws LoginException {

        jda = JDABuilder.createDefault("OTc1MzcwOTQyMDYwNTkzMTUz.Grx5fw.39YeSNiThuknVdf2klMF2uP05m1Dxk1RhGrsoU").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("규민이랑 "));

        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String prefix = "!";

        if (!event.getAuthor().isBot()){
            //hi
            if (args[0].equals(prefix + "hi")) {
                //if (args.length == 1) event.getChannel().sendMessage("안녕").queue();
                if (args.length == 1) event.getChannel().sendMessage("hello world!").queue();
            }
            //member
            else if (args[0].equals(prefix + "박규민")) {
                if (args.length == 1) event.getChannel().sendMessage("나이: 28\n일간 베스트 회원").queue();
            }
            else if (args[0].equals(prefix + "박시현")) {
                if (args.length == 1) event.getChannel().sendMessage("나이: 28\n몸무게: 91KG").queue();
            }
            else if (args[0].equals(prefix + "한상우")) {
                if (args.length == 1) event.getChannel().sendMessage("나이: 28\n자동차: 아반떼(사고차)").queue();
            }
            else if (args[0].equals(prefix + "차유민")) {
                if (args.length == 1) event.getChannel().sendMessage("나이: 27\n???: 7cm").queue();
            }
            //random menu
            else if (args[0].equals(prefix + "메뉴")) {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());

                switch (random.nextInt(3)) {
                    case 0: event.getChannel().sendMessage("항아리 족발").queue();
                            break;
                    case 1: event.getChannel().sendMessage("블랙피그").queue();
                            break;
                    case 2: event.getChannel().sendMessage("앗싸곱창").queue();
                            break;
                    case 3: event.getChannel().sendMessage("앗싸곱창(상우차에서)").queue();
                            break;
                }
            }
        }
    }
}
