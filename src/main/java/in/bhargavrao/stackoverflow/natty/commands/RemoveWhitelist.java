package in.bhargavrao.stackoverflow.natty.commands;

import fr.tunaki.stackoverflow.chat.Message;
import fr.tunaki.stackoverflow.chat.Room;
import in.bhargavrao.stackoverflow.natty.model.ListType;
import in.bhargavrao.stackoverflow.natty.services.FileStorageService;
import in.bhargavrao.stackoverflow.natty.services.StorageService;
import in.bhargavrao.stackoverflow.natty.utils.CommandUtils;

/**
 * Created by bhargav.h on 30-Sep-16.
 */
public class RemoveWhitelist implements SpecialCommand {

    private Message message;

    public RemoveWhitelist(Message message) {
        this.message = message;
    }

    @Override
    public boolean validate() {

        return CommandUtils.checkForCommand(message.getPlainContent(),"rmwhitelist");
    }

    @Override
    public void execute(Room room) {
        String data = CommandUtils.extractData(message.getPlainContent());
        StorageService service = new FileStorageService();
        room.replyTo(message.getId(),service.unListWord(data, ListType.WHITELIST));
    }

    @Override
    public String description() {
        return "Removes the given statement from whitelist  ";
    }

    @Override
    public String name() {
        return "rmwhitelist";
    }
}
