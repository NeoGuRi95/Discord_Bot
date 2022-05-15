package Neoguri;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static JDA jda;

    public static void main(String[] args) throws LoginException {

        jda = JDABuilder.createDefault("OTc1MzcwOTQyMDYwNTkzMTUz.Grx5fw.39YeSNiThuknVdf2klMF2uP05m1Dxk1RhGrsoU").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("hi!"));

        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String prefix = "!";
        if (!event.getAuthor().isBot()){
            if (args[0].equals(prefix + "hi")) {
                //if (args.length == 1) event.getChannel().sendMessage("안녕").queue();
                if (args.length == 1) event.getChannel().sendMessage("hello world!").queue();
            }
            if (args[0].equals(prefix + "박규민")) {
                if (args.length == 1) event.getChannel().sendMessage("나이: 28\n직업: 무직").queue();
            }
            if (args[0].equals(prefix + "박시현")) {
                if (args.length == 1) event.getChannel().sendMessage("나이: 28\n몸무게: 91KG\n블랙피그 원툴").queue();
            }
        }
    }
}
