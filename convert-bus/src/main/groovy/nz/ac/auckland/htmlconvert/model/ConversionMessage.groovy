package nz.ac.auckland.htmlconvert.model

/**
 *  Author: Marnix
 *
 *  A description of something that happened during the conversion process
 */
class ConversionMessage {

    enum MessageType {
        Info,
        Error
    }

    /**
     * Type of message
     */
    MessageType type = MessageType.Info;

    /**
     * What caused this message?
     */
    String from;

    /**
     * Message
     */
    String message;

}
