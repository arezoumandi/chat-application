package chat.websocket;

public enum ChatCommand {
    REGISTER,
    MESSAGE_P2P,
    MESSAGE_BROADCAST,
    UNKNOWN;

    public static ChatCommand convertFromString(String command) {
        if (command.equals("REG")) {
            return ChatCommand.REGISTER;
        } else if (command.equals("P2P")) {
            return ChatCommand.MESSAGE_P2P;
        } else if (command.equals("MBC")) {
            return ChatCommand.MESSAGE_BROADCAST;
        }  else {
            return ChatCommand.UNKNOWN;
        }
    }
}
